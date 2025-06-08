package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {

    private int code;

    private String message;

    @Builder.Default
    private String timestamp = Instant.now().toString();

    private String url;

}
