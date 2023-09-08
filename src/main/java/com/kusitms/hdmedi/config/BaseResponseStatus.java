package com.kusitms.hdmedi.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum BaseResponseStatus {
    SUCCESS(true, HttpStatus.OK, 200, "요청에 성공하였습니다.");

    private final boolean isSuccess;
    @JsonIgnore
    private final HttpStatus httpStatus;
    private final int code;
    private final String message;

    BaseResponseStatus(boolean isSuccess, HttpStatus httpStatus, int code, String message) {
        this.isSuccess = isSuccess;
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}