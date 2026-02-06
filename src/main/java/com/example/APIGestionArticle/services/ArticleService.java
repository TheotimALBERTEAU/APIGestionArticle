package com.example.APIGestionArticle.services;

import com.example.APIGestionArticle.bo.Article;
import com.example.APIGestionArticle.bo.ResponseCode;
import com.example.APIGestionArticle.dao.ArticleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ResponseCode<List<Article>> getArticles() {
        List<Article> articles = (List<Article>) articleRepository.findAll();
        return new ResponseCode<List<Article>>("202", "getAll request succesfully achieved", articles);
    }

    public ResponseCode<Article> getArticleById(@PathVariable("id") Long id) {
        Article article = articleRepository.findById(id).orElseGet(null);
        if (article == null){
            return new ResponseCode<Article>("703", "Msg getArticle not found", null);
        }

        return new ResponseCode<Article>("202", "Msg getArticle success", article);
    }

    public ResponseCode<Boolean> deleteArticleById(@PathVariable("id") long id) {
        boolean exist = articleRepository.existsById(id);
        if (exist) {
            articleRepository.deleteById(id);
            return new ResponseCode<Boolean>("202", "Msg deleted successfull", exist);
        }
        return new ResponseCode<Boolean>("703", "Msg deleted error", exist);

    }

    public ResponseCode<Article> SaveArticle(Article article) {
        if (article.getId() == null){
            return new ResponseCode<Article>("202", "Article created", articleRepository.save(article));
        }

        // UPDATE → vérifier existence
        boolean exist = articleRepository.existsById(article.getId());
        if (!exist) {
            return new ResponseCode<>("404", "Article not found", null);
        }

        Article saved = articleRepository.save(article);
        return new ResponseCode<>("203", "Article modified", saved);
    }
}
