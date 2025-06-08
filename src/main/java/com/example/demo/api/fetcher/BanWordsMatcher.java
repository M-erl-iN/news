package com.example.demo.api.fetcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class BanWordsMatcher {

    private final ObjectMapper objectMapper;

    @Value("${app.banword-api.url}")
    private String apiUrl;

    @Value("${app.banword-api.api-key}")
    private String apiKey;

    @Value("${app.banword-api.ban-words-count-field}")
    private String banWordsCountField;

    @Value("${app.banword-api.enabled}")
    private boolean enabled;

    public boolean match(String text) {
        if (!enabled) {
            return true;
        }

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(text, mediaType);
        Request request = new Request.Builder()
                .url(apiUrl)
                .addHeader("apikey", apiKey)
                .method("POST", body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.body() == null) {
                log.error("API returned empty response");
                throw new RuntimeException("API returned empty response");
            }
            String responseBody = response.body().string();
            log.info("Bad Words Matcher Response: {}", responseBody);
            Map<String, Object> result = objectMapper.readValue(responseBody, Map.class);
            Integer badWords = (Integer) result.get(banWordsCountField);
            return badWords == 0;
        } catch (IOException e) {
            log.error("API returned empty response", e);
            return true;
        }
    }
}
