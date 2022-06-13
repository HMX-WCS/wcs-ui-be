package com.hmx.prog.hdelpg.domain;

import com.hmx.prog.hdelpg.domain.status.Loadst;
import com.hmx.prog.hdelpg.domain.status.Status;
import com.hmx.prog.hdelpg.domain.status.Testst;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

@Entity
@Table(name = "LOAD")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class LOAD {
    @Id
    @Column(name = "LD_LOADID", nullable = false, length = 12)
    private String loadid;

    @Column(name = "LD_SERIAL", nullable = true, length = 8)
    private String serial;

    @Column(name = "LD_SAISLE", nullable = true, length = 2)
    private String saisle;

    @Column(name = "LD_LOCATN", nullable = true, length = 7)
    private String locatn;

    @Enumerated(EnumType.STRING)
    @Column(name = "LD_STATUS", nullable = true, length = 4)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "LD_LOADST", nullable = true, length = 4)
    private Loadst loadst;

    @Column(name = "LD_PLTID", nullable = true, length = 30)
    private String pltid;

    @Column(name = "LD_SETDAT", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date setdat;

    @Column(name = "LD_REMARK", nullable = true, length = 20)
    private String remark;

    @Column(name = "LD_PLTSIZ", nullable = true, length = 8)
    private String pltsiz;

    @Column(name = "LD_OUTDATE", nullable = true, length = 100)
    private String outdate;

    @Column(name = "LD_FLOOR", nullable = true, length = 100)
    private String floor;


    @OneToMany//(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "load")
    @JoinColumn(name = "LX_LOADID") //move 에 지정되어 있는 FK ld_loadid 기준으로 load 조회
    private List<LOMX> lomx = new ArrayList<>();
}
