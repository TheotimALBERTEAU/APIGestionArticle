package com.example.APIGestionArticle.services;

import com.example.APIGestionArticle.bo.Article;
import com.example.APIGestionArticle.dao.ArticleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getArticles() {
        return (List<Article>) this.articleRepository.findAll();
    }

    public Article getArticleById(@PathVariable("id") long id) {
        Optional<Article> article = this.articleRepository.findById(id);
        if (article.isPresent()) {
            return article.get();
        } else {
            throw new EntityNotFoundException("Article with id " + id + " not found");
        }
    }

    public String deleteArticleById(@PathVariable("id") long id) {
        if  (this.articleRepository.findById(id).isPresent()) {
            this.articleRepository.deleteById(id);
            return "Delete of article " + id + " succesfully achieved";
        } else {
            return "Delete of article " + id + " failed | Article not found";
        }

    }

    public Article SaveArticle(Article article) {
        return articleRepository.save(article);
    }
}
