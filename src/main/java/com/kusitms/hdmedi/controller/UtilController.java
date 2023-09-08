package com.kusitms.hdmedi.controller;

import com.kusitms.hdmedi.domain.dto.request.ContactMailRequestDto;
import com.kusitms.hdmedi.service.UtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UtilController {

    private final UtilService utilService;

    @GetMapping("/test")
    public String basicApiTest() {
        return "test success";
    }

    @PostMapping("/contact")
    public void sendMail(@RequestBody ContactMailRequestDto dto) {
        utilService.sendMail(dto);
    }
}
