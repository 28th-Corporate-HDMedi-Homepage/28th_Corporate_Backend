package com.kusitms.hdmedi.controller;

import com.kusitms.hdmedi.service.UtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class Util2Controller {

    private final UtilService utilService;

    @GetMapping("/test2")
    public String basicApiTest() {
        return "mailform";
    }
}
