package com.hmx.prog.hdelpg.domain.status;

public enum Status {
    /* 작업 진행 상태: LD_STATUS, LO_STATUS */
    정상,
    입고,  // 해당 CELL 입고 진행 중
    출고,  // 해당 CELL 출고 진행 중
    이동,  // 해당 CELL 이동 진행 중
    이중,  // 해당 CELL 이중 입고 에러 발생
    공출,  // 해당 CELL 공   출고 에러 발생
    확인   // 해당 CELL 에러 발생. (데이터 동기화 필요를 위해 "확인"으로 표기)
}
