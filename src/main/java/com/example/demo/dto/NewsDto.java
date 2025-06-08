package com.example.demo.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {

    @Schema(description = "Заголовок новости", example = "Повышение рождаемости")
    private String title;

    @Schema(description = "Описание новости", example = "В Казани родился 1_000_000-ный ребенок ")
    private String content;

}
