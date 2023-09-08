package com.kusitms.hdmedi.repository;

import com.kusitms.hdmedi.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News,String> {

    List<News> findAllByOrderByDatetimeDesc();
}
