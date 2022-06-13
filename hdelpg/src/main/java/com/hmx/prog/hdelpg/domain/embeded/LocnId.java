package com.hmx.prog.hdelpg.domain.embeded;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
public class LocnId implements Serializable {
    @Column(name = "LO_LOCROW", nullable = true, length = 2)
    private String locrow;

    @Column(name = "LO_LOCBAY", nullable = true, length = 3)
    private String locbay;

    @Column(name = "LO_LOCLEV", nullable = false, length = 2)
    private String loclev;

    @Column(name = "LO_SAISLE", nullable = true, length = 2)
    private String saisle;

    protected LocnId() {

    }

    public LocnId(String locrow, String locbay, String loclev, String saisle) {
        this.locrow = locrow;
        this.locbay = locbay;
        this.loclev = loclev;
        this.saisle = saisle;
    }
}
