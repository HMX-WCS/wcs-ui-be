package com.hmx.prog.hdelpg.domain.status;

public enum Locked {
    /* 로케이션 상태: LO_LOCKED */
    정상,
    허가,  // 로케이션 CELL 이용 가능
    금지   // 로케이션 CELL 이용 금지
}
