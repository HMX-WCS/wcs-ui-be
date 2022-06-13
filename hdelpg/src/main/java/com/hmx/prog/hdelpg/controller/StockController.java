package com.hmx.prog.hdelpg.controller;

import com.hmx.prog.hdelpg.RestfulApiResponse.WCSApiResponse;
import com.hmx.prog.hdelpg.domain.LOAD;
import com.hmx.prog.hdelpg.domain.LOCN;
import com.hmx.prog.hdelpg.service.OutboundService;
import com.hmx.prog.hdelpg.service.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@Api(value = "재고관리", tags = "stock")
@RestController
@RequiredArgsConstructor
@RequestMapping("/stock")
public class StockController {
    private final OutboundService outboundService;
    private final StockService stockService;

    @GetMapping("/findAll")
    @ApiOperation(value = "재고 조회")
    public WCSApiResponse findAll() {
        WCSApiResponse war;
        try {
            List<LOCN> data = stockService.findAll();
            war = new WCSApiResponse(data, null);
        } catch (Exception e) {
            List err = new ArrayList<String>();
            err.add(e.getMessage());
            war = new WCSApiResponse(new Object(), err);
        }
        return war;
    }

    @GetMapping("/createData/{saisle}/{locatn}/{loadst}/{status}/{locked}/{pdtcod}/{pdtqty}")
    @ApiOperation(value = "재고 생성")
    public WCSApiResponse createData(@PathVariable(value = "saisle")
                                             String saisle,
                                     @PathVariable(value = "locatn")
                                             String locatn,
                                     @PathVariable(value = "loadst")
                                             String loadst,
                                     @PathVariable(value = "status")
                                             String status,
                                     @PathVariable(value = "locked")
                                             String locked,
                                     @PathVariable(value = "pdtcod")
                                             String pdtcod,
                                     @PathVariable(value = "pdtqty")
                                             String pdtqty,
                                     @PathVariable(value = "lomx")
                                             String[][] lomx) {
        WCSApiResponse war;
        try {
            stockService.createData(saisle, locatn, loadst, status, locked, pdtcod, pdtqty, lomx);
            war = new WCSApiResponse(0, null);
        } catch (Exception e) {
            List err = new ArrayList<String>();
            err.add(e.getMessage());
            war = new WCSApiResponse(new Object(), err);
        }
        return war;
    }

    @GetMapping("/updateData/{loadid}/{loadst}/{status}/{locked}/{lomx}")
    @ApiOperation(value = "재고 수정")
    public WCSApiResponse updateData(@PathVariable(value = "loadid")
                                             String loadid,
                                     @PathVariable(value = "loadst")
                                             String loadst,
                                     @PathVariable(value = "status")
                                             String status,
                                     @PathVariable(value = "locked")
                                             String locked,
                                     @PathVariable(value = "lomx")
                                             String[][] lomx) {
        WCSApiResponse war;
        try {
            stockService.updateData(loadid, loadst, status, locked, lomx);
            war = new WCSApiResponse(0, null);
        } catch (Exception e) {
            List err = new ArrayList<String>();
            err.add(e.getMessage());
            war = new WCSApiResponse(new Object(), err);
        }
        return war;
    }

    @GetMapping("/deleteData/{loadid}/{locatn}")
    @ApiOperation(value = "재고 삭제")
    public WCSApiResponse deleteData(@PathVariable(value = "loadid")
                                             String loadid) {
        WCSApiResponse war;
        try {
            stockService.deleteData(loadid);
            war = new WCSApiResponse(0, null);
        } catch (Exception e) {
            List err = new ArrayList<String>();
            err.add(e.getMessage());
            war = new WCSApiResponse(new Object(), err);
        }
        return war;
    }
}
