package com.hmx.prog.hdelpg.service;

import com.hmx.prog.hdelpg.repository.SerialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;

@Service
@RequiredArgsConstructor
public class SerialService {
    private final SerialRepository serialRepository;

    public String findSerial() {
        return serialFilter(serialRepository.findSerial());
    }

    public String findLoadid() {
        return loadidFilter(serialRepository.findLoadid());
    }

    @Transactional
    public String updateSerial(String serial) {
        serialRepository.changeSerial(serial);
        return serialRepository.findSerial();
    }

    @Transactional
    public String updateLoadid(String loadid) {
        serialRepository.changeLoadid(loadid);
        return serialRepository.findLoadid();
    }

    String serialFilter(String serial) {
        if (Integer.parseInt(serial) < 1000 || Integer.parseInt(serial) == 9999) {
            serial = "999";
            serialRepository.changeSerial(serial);
        }
        return serial;
    }

    String loadidFilter(String loadid) {
        if (String.valueOf(loadid).length() < 12) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String time = sdf.format(System.currentTimeMillis());
            loadid = time.concat("0000");
            serialRepository.changeLoadid(loadid);
        }
        return loadid;
    }
}
