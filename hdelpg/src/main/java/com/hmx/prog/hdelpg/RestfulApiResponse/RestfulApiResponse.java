package com.hmx.prog.hdelpg.RestfulApiResponse;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public abstract class RestfulApiResponse<T> {
    @NonNull
    private T data;
    private List<String> errors;
}
