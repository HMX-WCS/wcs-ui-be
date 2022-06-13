package com.hmx.prog.hdelpg.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MOVE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MOVE {
    @Id
    @Column(name = "MV_SERIAL", nullable = false, length = 4)
    private String serial;

    @Column(name = "MV_LOADID", nullable = true, length = 12)
    private String loadid;

    @Column(name = "MV_SAISLE", nullable = true, length = 2)
    private String saisle;

    @Column(name = "MV_LOCATN", nullable = true, length = 7)
    private String locatn;

    @Column(name = "MV_STATUS", nullable = true, length = 8)
    private String status;

    @Column(name = "MV_WRKTYP", nullable = true, length = 4)
    private String wrktyp;

    @Column(name = "MV_ORDTYP", nullable = true, length = 4)
    private String ordtyp;

    @Column(name = "MV_FRSTTN", nullable = true, length = 4)
    private String frsttn;

    @Column(name = "MV_TOSTTN", nullable = true, length = 4)
    private String tosttn;

    @Column(name = "MV_USERID", nullable = true, length = 8)
    private String userid;

    @Column(name = "MV_SETDAT", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date setdat;

    @Column(name = "MV_JOBTYP", nullable = true, length = 4)
    private String jobtyp;

    @Column(name = "MV_PRIOTY", nullable = true, length = 1)
    private String prioty;

    @Column(name = "MV_SEQCHK", nullable = true, length = 1)
    private String seqchk;

    @Column(name = "MV_OUTIDX", nullable = true, length = 100)
    private String outidx;

    @Column(name = "MV_LSTIDX", nullable = true, length = 100)
    private String lstidx;

    @Column(name = "MV_PLTSIZ", nullable = true, length = 100)
    private String pltsiz;

    @Column(name = "MV_CHKST", nullable = true, length = 20)
    private String chkst;

    //@OneToOne(fetch = FetchType.EAGER) //사용시점에 조회가 됨
    //@JoinColumn(name = "ld_loadid") //move 에 지정되어 있는 FK ld_loadid 기준으로 load 조회
    //private Load load;

}