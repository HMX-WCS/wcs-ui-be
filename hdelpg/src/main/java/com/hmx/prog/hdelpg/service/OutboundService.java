package com.hmx.prog.hdelpg.service;

import com.hmx.prog.hdelpg.domain.LOAD;
import com.hmx.prog.hdelpg.domain.MOVE;
import com.hmx.prog.hdelpg.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OutboundService {
    private final MoveRepository moveRepository;
    private final LoadRepository loadRepository;
    private final LomxRepository lomxRepository;
    private final SerialService serialService;

    public List<MOVE> findAll() {
        return moveRepository.findByWrktypAndStatus("출고", "작업예약");
    }

    public MOVE findByData(String key, String value) {
        MOVE result = null;
        if (key.equals("loadid")) result = moveRepository.findByLoadid(value);
        else if (key.equals("serial")) result = moveRepository.findBySerial(value);
        return result;
    }

    @Transactional
    public int saveOutbound(String type, String frsttn, String tosttn, String pltsiz, String userid, String[][] lomx) {
        String loadid = String.valueOf(Long.valueOf(serialService.findLoadid()) + 1);
        String serial = String.valueOf(Integer.valueOf(serialService.findSerial()) + 1);
        String status = "작업예약";
        String wrktyp = "출고";
        String ordtyp = "자동";
        String loadst = "정상";

        loadRepository.updateData(loadid, wrktyp, loadst);
        moveRepository.insertWork(loadid, serial, wrktyp, status, ordtyp, frsttn, tosttn, pltsiz, userid);

        serialService.updateSerial(serial);
        serialService.updateLoadid(loadid);
        return 0;
    }


}