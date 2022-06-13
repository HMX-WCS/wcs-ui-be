package com.hmx.prog.hdelpg.controller;

import com.hmx.prog.hdelpg.domain.MOVE;
import com.hmx.prog.hdelpg.RestfulApiResponse.WCSApiResponse;
import com.hmx.prog.hdelpg.service.InboundService;
import com.hmx.prog.hdelpg.service.SerialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@Api(value = "입고", tags = "inbound")
@RestController
@RequiredArgsConstructor
@RequestMapping("/inbound")
public class InboundController {
    private final InboundService inboundService;

    @GetMapping("/findAll")
    @ApiOperation(value = "입고예약 조회")
    public WCSApiResponse findAll() {
        WCSApiResponse war;
        try {
            List<MOVE> data = inboundService.findAll();
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
            MOVE data = inboundService.findByData(key, value);
            war = new WCSApiResponse(data, null);
        } catch (Exception e) {
            List err = new ArrayList<String>();
            err.add(e.getMessage());
            war = new WCSApiResponse(new Object(), err);
        }
        return war;
    }

    @PostMapping("/saveInbound/{type}/{frsttn}/{tosttn}/{pltsiz}/{userid}/{lomx}")
    @ApiOperation(value = "입고")
    public WCSApiResponse saveInbound(
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
                result = inboundService.saveInbound(type, frsttn, tosttn, pltsiz, userid, lomx);
            war = new WCSApiResponse(result, null);
        } catch (Exception e) {
            List err = new ArrayList<String>();
            err.add(e.getMessage());
            war = new WCSApiResponse(new Object(), err);
        }
        return war;
    }
}