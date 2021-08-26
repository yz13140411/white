package com.evan.wj.result;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
    private int code;

    public Result(int code) {
        this.code = code;
    }

    private String message;
    private Object result;

}
