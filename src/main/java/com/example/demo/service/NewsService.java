package com.example.demo.service;

import com.example.demo.dto.NewsDto;

import java.util.List;

public interface NewsService {

    List<NewsDto> getAll();

    void create(NewsDto request);

}
