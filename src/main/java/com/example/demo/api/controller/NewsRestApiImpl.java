package com.example.demo.api.controller;

import com.example.demo.api.NewsRestApi;
import com.example.demo.dto.NewsDto;
import com.example.demo.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NewsRestApiImpl implements NewsRestApi {

    private final NewsService newsService;

    @Override
    public ResponseEntity<List<NewsDto>> getAllNews() {
        return ResponseEntity.ok(newsService.getAll());
    }

    @Override
    public ResponseEntity<Void> createNews(NewsDto request) {
        newsService.create(request);
        return ResponseEntity.ok().build();
    }
}
