package com.example.demo.service.impl;

import com.example.demo.dto.NewsDto;
import com.example.demo.mapper.NewsMapper;
import com.example.demo.model.News;
import com.example.demo.repository.NewsRepository;
import com.example.demo.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;

    @Value("${app.news.count}")
    private int newsCount;

    @Override
    public List<NewsDto> getAll() {
        return newsRepository.getLastNews(newsCount).stream()
                .map(newsMapper::mapToDto)
                .toList();
    }

    @Override
    public void create(NewsDto request) {
        News news = newsMapper.mapToEntity(request);
        newsRepository.save(news);
    }
}
