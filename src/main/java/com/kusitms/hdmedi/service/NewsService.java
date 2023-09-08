package com.kusitms.hdmedi.service;


import com.kusitms.hdmedi.domain.News;
import com.kusitms.hdmedi.domain.dto.response.NewsResponseDto;
import com.kusitms.hdmedi.exception.utilException.NewsException;
import com.kusitms.hdmedi.repository.NewsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class NewsService {

    private final NewsRepository newsRepository;


    public List<NewsResponseDto> getNews() throws NewsException {
        List<News> newsArr = newsRepository.findAllByOrderByDatetimeDesc();
        List<NewsResponseDto> newsResponseDtoList = new ArrayList<>();
        newsArr.forEach(news -> newsResponseDtoList.add(createNewsRes(news)));
        return newsResponseDtoList;
    }

    private NewsResponseDto createNewsRes(News news){
        return NewsResponseDto.builder()
                .title(news.getTitle())
                .dateTime(news.getDatetime())
                .photoUrl(news.getPhotoUrl())
                .link(news.getLink())
                .build();
    }
}
