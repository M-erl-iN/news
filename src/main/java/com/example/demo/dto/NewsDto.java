package com.example.demo.dto;


import com.example.demo.validation.BanWordsValidation;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BanWordsValidation
public class NewsDto {

    @Schema(description = "Заголовок новости", example = "Повышение рождаемости")
    @NotNull
    private String title;

    @Schema(description = "Описание новости", example = "В Казани родился 1_000_000-ный ребенок ")
    private String content;

}
