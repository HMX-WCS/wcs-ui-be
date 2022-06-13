package com.hmx.prog.hdelpg.repository;

import com.hmx.prog.hdelpg.domain.LOMX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface LomxRepository extends JpaRepository<LOMX, String> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value =
            "insert into lomx"
                    + "(" +
                    "LX_LOMXID, " + "LX_PDTCOD, " + "LX_NUM, " + "LX_PDTNAM, " + "LX_SITENAME, "
                    + "LX_PDTQTY, " + "LX_OUTDATE, " + "LX_OAN, " + "LX_KINDS, " + "LX_X, "
                    + "LX_Y, " + "LX_Z, " + "LX_PATTERN, " + "LX_XPOS, " + "LX_YPOS, "
                    + "LX_PDTLOT, " + "LX_PDTUNT, " + "lx_setdat, " + "LX_PDTPRJ, " + "LX_XDIM, "
                    + "LX_WDIM, " + "LX_FLOOR, " + "LX_PRJNAM, " + "LX_DDIM, " + "LX_WEIGHT, "
                    + "LX_THICK, " + "LX_ID, " + "LX_QRCODE, " + "LX_TYPE, " + "LX_TAG_TYPE, "
                    + "LX_QR_NUM, " + "LX_MATNR, " + "LX_MATNR_NM, " + "LX_SPEC, " + "LX_ITEM_SIZE, "
                    + "LX_SERIAL, " + "LX_POSID, " + "LX_CONSNAM, " + "LX_MENGE, " + "LX_MATNR_ITN, "
                    + "LX_INST_DATE, " + "LX_INVNR, " + "LX_PLAN_NO, " + "LX_PARTNER_COM, " + "LX_INVITEM, "
                    + "LX_D_ID, " + "LX_D_ID_DE, " + "LX_D_ID_M, " + "LX_D_TYPE, " + "LX_D_TAG_TYPE, "
                    + "LX_D_QR_NUM, " + "LX_D_QR_NUM_M, " + "LX_D_CONSNAM, " + "LX_D_POSID, " + "LX_D_MATNR, "
                    + "LX_D_MATNR_NM, " + "LX_D_SERIAL, " + "LX_D_MENGE, " + "LX_D_MATNR_ITN, " + "LX_D_INST_DATE, "
                    + "LX_D_PARTNER_COM, " + "LX_D_CRT_LIFNR, " + "LX_CRT_LIFNR_NM, " + "LX_D_SPEC, " + "LX_D_ITEM_SIZE, "
                    + "LX_LOMXNUM, " + "LX_LOCATN "
                    + ")"
                    + "values"
                    + "("
                    + ":loadid + :num" + ":lomx[1], " + ":lomx[2], " + ":lomx[3], " + ":lomx[4], "
                    + ":lomx[5], " + ":lomx[6], " + ":lomx[7], " + ":lomx[8], " + ":lomx[9], "
                    + ":lomx[10], " + ":lomx[11], " + ":lomx[12], " + ":lomx[13], " + ":lomx[14], "
                    + ":lomx[15], " + ":lomx[16], " + ":lomx[17], " + ":lomx[18], " + ":lomx[19], "
                    + ":lomx[20], " + ":lomx[21], " + ":lomx[22], " + ":lomx[23], " + ":lomx[24], "
                    + ":lomx[25], " + ":lomx[26], " + ":lomx[27], " + ":lomx[28], " + ":lomx[29], "
                    + ":lomx[30], " + ":lomx[31], " + ":lomx[32], " + ":lomx[33], " + ":lomx[34], "
                    + ":lomx[35], " + ":lomx[36], " + ":lomx[37], " + ":lomx[38], " + ":lomx[39], "
                    + ":lomx[40], " + ":lomx[41], " + ":lomx[42], " + ":lomx[43], " + ":lomx[44], "
                    + ":lomx[45], " + ":lomx[46], " + ":lomx[47], " + ":lomx[48], " + ":lomx[49], "
                    + ":lomx[50], " + ":lomx[51], " + ":lomx[52], " + ":lomx[53], " + ":lomx[54], "
                    + ":lomx[55], " + ":lomx[56], " + ":lomx[57], " + ":lomx[58], " + ":lomx[59], "
                    + ":lomx[60], " + ":lomx[61], " + ":lomx[62], " + ":lomx[63], " + ":lomx[64], "
                    + ":lomx[65], " + ":lomx[66] "
                    + ")"
    )
    int insertData(String loadid, String[] lomx, String num);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update LOMX set "
            + "LX_LOMXID = :loadid+:num," + "LX_PDTCOD = :lomx[1]," + "LX_NUM = :lomx[2]," + "LX_PDTNAM = :lomx[3]," + "LX_SITENAME = :lomx[4], "
            + "LX_PDTQTY = :lomx[5]," + "LX_OUTDATE = :lomx[6]," + "LX_OAN = :lomx[7]," + "LX_KINDS = :lomx[8]," + "LX_X = :lomx[9], "
            + "LX_Y = :lomx[10]," + "LX_Z = :lomx[11]," + "LX_PATTERN = :lomx[12]," + "LX_XPOS = :lomx[13]," + "LX_YPOS = :lomx[14], "
            + "LX_PDTLOT = :lomx[15]," + "LX_PDTUNT = :lomx[16]," + "lx_setdat = :lomx[17]," + "LX_PDTPRJ = :lomx[18]," + "LX_XDIM = :lomx[19], "
            + "LX_WDIM = :lomx[20]," + "LX_FLOOR = :lomx[21]," + "LX_PRJNAM = :lomx[22]," + "LX_DDIM = :lomx[23]," + "LX_WEIGHT = :lomx[24], "
            + "LX_THICK = :lomx[25]," + "LX_ID = :lomx[26]," + "LX_QRCODE = :lomx[27]," + "LX_TYPE = :lomx[28]," + "LX_TAG_TYPE = :lomx[29], "
            + "LX_QR_NUM = :lomx[30]," + "LX_MATNR = :lomx[31]," + "LX_MATNR_NM = :lomx[32]," + "LX_SPEC = :lomx[33]," + "LX_ITEM_SIZE = :lomx[34], "
            + "LX_SERIAL = :lomx[35]," + "LX_POSID = :lomx[36]," + "LX_CONSNAM = :lomx[37]," + "LX_MENGE = :lomx[38]," + "LX_MATNR_ITN = :lomx[39], "
            + "LX_INST_DATE = :lomx[40]," + "LX_INVNR = :lomx[41]," + "LX_PLAN_NO = :lomx[42]," + "LX_PARTNER_COM = :lomx[43]," + "LX_INVITEM = :lomx[44], "
            + "LX_D_ID = :lomx[45]," + "LX_D_ID_DE = :lomx[46]," + "LX_D_ID_M = :lomx[47]," + "LX_D_TYPE = :lomx[48]," + "LX_D_TAG_TYPE = :lomx[49], "
            + "LX_D_QR_NUM = :lomx[50]," + "LX_D_QR_NUM_M = :lomx[51]," + "LX_D_CONSNAM = :lomx[52]," + "LX_D_POSID = :lomx[53]," + "LX_D_MATNR = :lomx[54], "
            + "LX_D_MATNR_NM = :lomx[55]," + "LX_D_SERIAL = :lomx[56]," + "LX_D_MENGE = :lomx[57]," + "LX_D_MATNR_ITN = :lomx[58]," + "LX_D_INST_DATE = :lomx[59], "
            + "LX_D_PARTNER_COM = :lomx[60]," + "LX_D_CRT_LIFNR = :lomx[61]," + "LX_CRT_LIFNR_NM = :lomx[62]," + "LX_D_SPEC = :lomx[63]," + "LX_D_ITEM_SIZE = :lomx[64] "
            + "LX_LOMXNUM = :lomx[65]," + "LX_LOCATN = :lomx[66] ")
    int updateData(@Param("loadid") String loadid, @Param("lomx") String[] lomx, @Param("num") String num);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "delete from LOMX where lx_loadid  = :loadid")
    void deleteData(@Param("loadid") String loadid);
}
