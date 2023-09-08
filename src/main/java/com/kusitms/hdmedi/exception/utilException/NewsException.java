package com.kusitms.hdmedi.exception.utilException;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NewsException extends RuntimeException {

    private String message;
}
