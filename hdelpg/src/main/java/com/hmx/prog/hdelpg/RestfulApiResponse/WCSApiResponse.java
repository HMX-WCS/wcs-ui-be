package com.hmx.prog.hdelpg.RestfulApiResponse;

import com.hmx.prog.hdelpg.RestfulApiResponse.RestfulApiResponse;

import java.util.List;

public class WCSApiResponse extends RestfulApiResponse {
    public WCSApiResponse(Object data, List<String> errors) {
        super(data);
        this.setErrors(errors);
    }
}
