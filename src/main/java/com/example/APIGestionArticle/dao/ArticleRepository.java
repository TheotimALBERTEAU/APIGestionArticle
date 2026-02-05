package com.example.APIGestionArticle.dao;

import com.example.APIGestionArticle.bo.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
