package com.hmx.prog.hdelpg.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "LOMX")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class LOMX {
    @Id
    @Column(name = "LX_LOMXID", nullable = false, length = 14)
    private String lomxid;

    //@ManyToOne//(fetch = FetchType.LAZY)
    @Column(name = "LX_LOADID", nullable = true, length = 12)
    private String loadid;

    @Column(name = "LX_PDTCOD", nullable = true, length = 20)
    private String pdtcod;

    @Column(name = "LX_NUM", nullable = true, length = 300)
    private String num;

    @Column(name = "LX_PDTNAM", nullable = true, length = 100)
    private String pdtnam;

    @Column(name = "LX_SITENAME", nullable = true, length = 300)
    private String sitename;

    @Column(name = "LX_PDTQTY", nullable = true, length = 10)
    private String pdtqty;

    @Column(name = "LX_OUTDATE", nullable = true, length = 20)
    private String outdate;

    @Column(name = "LX_OAN", nullable = true, length = 300)
    private String oan;

    @Column(name = "LX_KINDS", nullable = true, length = 20)
    private String kinds;

    @Column(name = "LX_X", nullable = true, length = 100)
    private String x;

    @Column(name = "LX_Y", nullable = true, length = 100)
    private String y;

    @Column(name = "LX_Z", nullable = true, length = 100)
    private String z;

    @Column(name = "LX_PATTERN", nullable = true, length = 300)
    private String pattern;

    @Column(name = "LX_XPOS", nullable = true, length = 10)
    private String xpos;

    @Column(name = "LX_YPOS", nullable = true, length = 10)
    private String ypos;

    @Column(name = "LX_PDTLOT", nullable = true, length = 20)
    private String pdtlot;

    @Column(name = "LX_PDTUNT", nullable = true, length = 10)
    private String pdtunt;

    @Column(name = "lx_setdat", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date setdat;

    @Column(name = "LX_PDTPRJ", nullable = true, length = 20)
    private String pdtprj;

    @Column(name = "LX_XDIM", nullable = true, length = 10)
    private String xdim;

    @Column(name = "LX_WDIM", nullable = true, length = 10)
    private String wdim;

    @Column(name = "LX_FLOOR", nullable = true, length = 100)
    private String floor;

    @Column(name = "LX_PRJNAM", nullable = true, length = 100)
    private String prjnam;

    @Column(name = "LX_DDIM", nullable = true, length = 100)
    private String ddim;

    @Column(name = "LX_WEIGHT", nullable = true, length = 100)
    private String weight;

    @Column(name = "LX_THICK", nullable = true, length = 100)
    private String thick;

    @Column(name = "LX_ID", nullable = true, length = 38)
    private String id;

    @Column(name = "LX_QRCODE", nullable = true, length = 4000)
    private String qrcode;

    @Column(name = "LX_TYPE", nullable = true, length = 30)
    private String type;

    @Column(name = "LX_TAG_TYPE", nullable = true, length = 30)
    private String tag_type;

    @Column(name = "LX_QR_NUM", nullable = true, length = 60)
    private String qr_num;

    @Column(name = "LX_MATNR", nullable = true, length = 60)
    private String matnr;

    @Column(name = "LX_MATNR_NM", nullable = true, length = 180)
    private String matnr_nm;

    @Column(name = "LX_SPEC", nullable = true, length = 360)
    private String spec;

    @Column(name = "LX_ITEM_SIZE", nullable = true, length = 360)
    private String item_size;

    @Column(name = "LX_SERIAL", nullable = true, length = 180)
    private String serial;

    @Column(name = "LX_POSID", nullable = true, length = 150)
    private String posid;

    @Column(name = "LX_CONSNAM", nullable = true, length = 600)
    private String consnam;

    @Column(name = "LX_MENGE", nullable = true, length = 25)
    private String menge;

    @Column(name = "LX_MATNR_ITN", nullable = true, length = 4000)
    private String matnr_itn;

    @Column(name = "LX_INST_DATE", nullable = true, length = 30)
    private String inst_date;

    @Column(name = "LX_INVNR", nullable = true, length = 60)
    private String invnr;

    @Column(name = "LX_PLAN_NO", nullable = true, length = 360)
    private String plan_no;

    @Column(name = "LX_PARTNER_COM", nullable = true, length = 90)
    private String partner_com;

    @Column(name = "LX_INVITEM", nullable = true, length = 90)
    private String invitem;

    @Column(name = "LX_D_ID", nullable = true, length = 38)
    private String d_id;

    @Column(name = "LX_D_ID_DE", nullable = true, length = 38)
    private String d_id_de;

    @Column(name = "LX_D_ID_M", nullable = true, length = 38)
    private String d_id_m;

    @Column(name = "LX_D_TYPE", nullable = true, length = 30)
    private String d_type;

    @Column(name = "LX_D_TAG_TYPE", nullable = true, length = 30)
    private String d_tag_type;

    @Column(name = "LX_D_QR_NUM", nullable = true, length = 60)
    private String d_qr_num;

    @Column(name = "LX_D_QR_NUM_M", nullable = true, length = 60)
    private String d_qr_num_m;

    @Column(name = "LX_D_CONSNAM", nullable = true, length = 600)
    private String d_consnam;

    @Column(name = "LX_D_POSID", nullable = true, length = 60)
    private String d_posid;

    @Column(name = "LX_D_MATNR", nullable = true, length = 60)
    private String d_matnr;

    @Column(name = "LX_D_MATNR_NM", nullable = true, length = 150)
    private String d_matnr_nm;

    @Column(name = "LX_D_SERIAL", nullable = true, length = 60)
    private String d_serial;

    @Column(name = "LX_D_MENGE", nullable = true, length = 10)
    private String d_menge;

    @Column(name = "LX_D_MATNR_ITN", nullable = true, length = 4000)
    private String d_matnr_itn;

    @Column(name = "LX_D_INST_DATE", nullable = true, length = 30)
    private String d_inst_date;

    @Column(name = "LX_D_PARTNER_COM", nullable = true, length = 30)
    private String d_partner_com;

    @Column(name = "LX_D_CRT_LIFNR", nullable = true, length = 30)
    private String d_crt_lifnr;

    @Column(name = "LX_CRT_LIFNR_NM", nullable = true, length = 15)
    private String crt_lifnr_nm;

    @Column(name = "LX_D_SPEC", nullable = true, length = 100)
    private String d_spec;

    @Column(name = "LX_D_ITEM_SIZE", nullable = true, length = 100)
    private String d_item_size;

    @Column(name = "LX_LOMXNUM", nullable = true, length = 100)
    private String lomxnum;

    @Column(name = "LX_LOCATN", nullable = true, length = 100)
    private String locatn;

//    @ManyToOne
//    @JoinColumn(name = "ld_loadid", nullable = false)
//    private Load load;

}
