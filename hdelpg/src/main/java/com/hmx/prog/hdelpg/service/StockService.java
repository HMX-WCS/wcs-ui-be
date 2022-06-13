package com.hmx.prog.hdelpg.service;

import com.hmx.prog.hdelpg.domain.LOCN;
import com.hmx.prog.hdelpg.domain.status.Locked;
import com.hmx.prog.hdelpg.domain.status.Status;
import com.hmx.prog.hdelpg.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.hmx.prog.hdelpg.domain.status.Locked.허가;
import static com.hmx.prog.hdelpg.domain.status.Status.정상;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StockService {
    private final MoveRepository moveRepository;
    private final LoadRepository loadRepository;
    private final LomxRepository lomxRepository;
    private final LocnRepository locnRepository;
    private final SerialService serialService;

    public List<LOCN> findAll() {
        return locnRepository.findAll();
    }

    @Transactional
    public int createData(String saisle, String locatn, String loadst, String status, String locked, String pdtcod, String pdtqty, String[][] lomx) {
        String loadid = String.valueOf(Long.valueOf(serialService.findLoadid()) + 1);
        String bcrdat = loadid;
        String locrow = locatn.substring(0, 2),
                locbay = locatn.substring(2, 5),
                loclev = locatn.substring(5, 7);

        if (loadRepository.findDataByLocatn(locatn).size() == 0) {
            loadRepository.createData(loadid, status, loadst, locatn);
            locnRepository.createData(loadid, status, locked, locrow, locbay, loclev, saisle);

            for (int i = 0; i < lomx.length; i++) {
                String lomxnum = String.format("%2d", i);
                lomxRepository.insertData(loadid, lomx[i], lomxnum);
            }

            serialService.updateLoadid(loadid);
            return 0;
        } else {
            return -1;
        }
    }

    @Transactional
    public int updateData(String loadid, String loadst, String status, String locked, String[][] lomx) {
        String bcrdat = loadid;
        locnRepository.updateData(loadid, status, locked);
        loadRepository.updateData(loadid, status, loadst);

        for (int i = 0; i < lomx.length; i++) {
            String lomxnum = String.format("%2d", i);
            lomxRepository.updateData(loadid, lomx[i], lomxnum);
        }
        return 0;
    }

    @Transactional
    public int deleteData(String loadid) {
        String status = "정상";
        String locked = "허가";
        lomxRepository.deleteData(loadid);
        locnRepository.deleteData(loadid, status, locked);
        loadRepository.deleteData(loadid);
        return 0;
    }

}