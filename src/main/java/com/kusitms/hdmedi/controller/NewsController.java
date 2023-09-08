package com.kusitms.hdmedi.controller;


import com.kusitms.hdmedi.config.BaseResponse;
import com.kusitms.hdmedi.domain.dto.response.NewsResponseDto;
import com.kusitms.hdmedi.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/news")
    public ResponseEntity<BaseResponse<List<NewsResponseDto>>> getNewsAll(){
        return ResponseEntity.ok(new BaseResponse<>(this.newsService.getNews()));
    }
}
