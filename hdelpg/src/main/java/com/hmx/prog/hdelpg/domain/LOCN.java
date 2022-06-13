package com.hmx.prog.hdelpg.domain;

import com.hmx.prog.hdelpg.domain.embeded.LocnId;
import com.hmx.prog.hdelpg.domain.status.Locked;
import com.hmx.prog.hdelpg.domain.status.Status;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "LOCN")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class LOCN {
    @EmbeddedId
    private LocnId locnId;

    @Enumerated(EnumType.STRING)
    @Column(name = "LO_LOCKED", nullable = true, length = 4)
    private Locked locked;

    @Enumerated(EnumType.STRING)
    @Column(name = "LO_STATUS", nullable = true, length = 4)
    private Status status;

    @Column(name = "LO_SETDAT", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date setdat;

    @OneToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "LO_LOADID", nullable = true)
    private LOAD load;
}
