package com.hmx.prog.hdelpg.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashMap;

@Entity
@Setter
@Getter
public class ApiResult extends HashMap {
    @Id
    int id;

    int V_RESULT;
    String V_ERRMSG;
}
