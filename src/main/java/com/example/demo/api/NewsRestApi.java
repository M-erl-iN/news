package com.example.demo.api;

import com.example.demo.dto.NewsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "News Api", description = "API новостей")
@RequestMapping("/api/v1/news")
public interface NewsRestApi {

    @Operation(summary = "Получить список новостей", description = "Возвращает последние 10 новостей")
    @GetMapping
    ResponseEntity<List<NewsDto>> getAllNews();

    @Operation(summary = "Отправить данные для создания новости",
            description = "POST-запрос для создания новости",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Request на создание новости",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = NewsDto.class)
                    )
            )
    )
    @PostMapping
    ResponseEntity<Void> createNews(@RequestBody NewsDto request);
}
