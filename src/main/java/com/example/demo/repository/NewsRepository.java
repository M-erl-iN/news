package com.example.demo.repository;

import com.example.demo.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    @Query("""
            select n from News n
            order by n.id desc
            limit :i
            """)
    List<News> getLastNews(int i);
}
