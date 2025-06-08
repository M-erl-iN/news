package com.example.demo.mapper;

import com.example.demo.dto.NewsDto;
import com.example.demo.model.News;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface NewsMapper {

    @Mapping(target = "id", ignore = true)
    News mapToEntity(NewsDto request);

    NewsDto mapToDto(News request);

}
