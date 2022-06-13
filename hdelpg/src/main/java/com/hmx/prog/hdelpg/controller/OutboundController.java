package com.hmx.prog.hdelpg.controller;

import com.hmx.prog.hdelpg.RestfulApiResponse.WCSApiResponse;
import com.hmx.prog.hdelpg.domain.LOAD;
import com.hmx.prog.hdelpg.domain.MOVE;
import com.hmx.prog.hdelpg.service.OutboundService;
import com.hmx.prog.hdelpg.service.SerialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@Api(value = "출고", tags = "outbound")
@RestController
@RequiredArgsConstructor
@RequestMapping("/outbound")
public class OutboundController {
    private final OutboundService outboundService;
    private final SerialService serialService;


    @GetMapping("/findAll")
    @ApiOperation(value = "출고예약 조회")
    public WCSApiResponse findAll() {
        WCSApiResponse war;
        try {
            List<MOVE> data = outboundService.findAll();
            war = new WCSApiResponse(data, null);
        } catch (Exception e) {
            List err = new ArrayList<String>();
            err.add(e.getMessage());
            war = new WCSApiResponse(new Object(), err);
        }
        return war;
    }

    @GetMapping("/findByData/{key}/{data}")
    @ApiOperation(value = "일련번호 조회")
    public WCSApiResponse findByData(
            @PathVariable(value = "key") String key,
            @PathVariable(value = "data") String value
    ) {
        WCSApiResponse war;
        try {
            MOVE data = outboundService.findByData(key, value);
            war = new WCSApiResponse(data, null);
        } catch (Exception e) {
            List err = new ArrayList<String>();
            err.add(e.getMessage());
            war = new WCSApiResponse(new Object(), err);
        }
        return war;
    }

    @PostMapping("/saveOutbound/{type}/{frsttn}/{tosttn}/{pltsiz}/{userid}/{lomx}")
    @ApiOperation(value = "출고")
    public WCSApiResponse saveOutbound(
            @PathVariable(value = "type") String type,
            @PathVariable(value = "frsttn") String frsttn,
            @PathVariable(value = "tosttn") String tosttn,
            @PathVariable(value = "pltsiz") String pltsiz,
            @PathVariable(value = "userid") String userid,
            @PathVariable(value = "lomx") String[][] lomx
    ) {
        WCSApiResponse war;
        int result = 0;
        try {
            if (type == "empty")
                result = outboundService.saveOutbound(type, frsttn, tosttn, pltsiz, userid, lomx);
            war = new WCSApiResponse(result, null);
        } catch (Exception e) {
            List err = new ArrayList<String>();
            err.add(e.getMessage());
            war = new WCSApiResponse(new Object(), err);
        }
        return war;
    }
}