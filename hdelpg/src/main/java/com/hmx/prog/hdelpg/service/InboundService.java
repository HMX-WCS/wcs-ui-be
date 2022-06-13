package com.hmx.prog.hdelpg.service;

import com.hmx.prog.hdelpg.domain.MOVE;
import com.hmx.prog.hdelpg.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InboundService {
    private final MoveRepository moveRepository;
    private final LoadRepository loadRepository;
    private final LomxRepository lomxRepository;
    private final SerialService serialService;

    public List<MOVE> findAll() {
        return moveRepository.findByWrktypAndStatus("입고", "작업예약");
    }

    public MOVE findByData(String key, String value) {
        MOVE result = null;
        if (key.equals("loadid")) result = moveRepository.findByLoadid(value);
        else if (key.equals("serial")) result = moveRepository.findBySerial(value);
        return result;
    }

    @Transactional
    public int saveInbound(String type, String frsttn, String tosttn, String pltsiz, String userid, String[][] lomx) {
        String loadid = String.valueOf(Long.valueOf(serialService.findLoadid()) + 1);
        String serial = String.valueOf(Integer.valueOf(serialService.findSerial()) + 1);
        String status = "작업예약";
        String wrktyp = "입고";
        String ordtyp = "자동";
        String loadst = "정상";
        if (type.equals("line") || type.equals("lineEmpty")) {
            status = "C/V 반송";
        }
        loadRepository.saveInbound(loadid, serial, loadid, wrktyp, loadst, pltsiz);
        moveRepository.insertWork(loadid, serial, wrktyp, status, ordtyp, frsttn, "", pltsiz, userid);

        if (type.equals("auto")|| type.equals("manual") || type.equals("line")) {
            for (int i = 0; i < lomx.length; i++) {
                String lomxnum = String.format("%2d", i);
                lomxRepository.insertData(loadid, lomx[i], lomxnum);
            }
        }

        serialService.updateSerial(serial);
        serialService.updateLoadid(loadid);
        return 0;
    }


}