package com.hmx.prog.hdelpg.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SERL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SERL {
    @Id
    @Column(name = "SL_TBLNAM", nullable = false, length = 4)
    private String tblnam;

    @Column(name = "SL_SERIAL", nullable = false, length = 12)
    private String serial;
}
