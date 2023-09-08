package com.kusitms.hdmedi.domain.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class MailFormRequestDto {

    @NotBlank
    private String name;

    @Email
    private String email;
}

