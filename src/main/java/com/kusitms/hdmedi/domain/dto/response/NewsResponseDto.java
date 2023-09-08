package com.kusitms.hdmedi.domain.dto.response;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NewsResponseDto {

    private String title;

    private LocalDateTime dateTime;

    private String photoUrl;

    private String link;
}
