package com.example.APIGestionArticle.rest;

import com.example.APIGestionArticle.bo.Article;
import com.example.APIGestionArticle.dao.ArticleRepository;
import com.example.APIGestionArticle.services.ArticleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/getAll")
    public List<Article> getAll() {
        return (List<Article>) this.articleService.getArticles();
    }

    @GetMapping("/getId/{id}")
    public Article getArticleById(@PathVariable("id") long id) {
        return this.articleService.getArticleById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteArticleById(@PathVariable("id") long id) {
        return this.articleService.deleteArticleById(id);
    }

    @PostMapping("/save")
    public Article saveArticle(@RequestBody Article article) {
        return articleService.SaveArticle(article);
    }
}
