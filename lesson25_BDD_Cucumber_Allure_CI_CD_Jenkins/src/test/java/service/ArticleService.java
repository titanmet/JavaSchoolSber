package service;

import model.ArticlePojo;

import java.util.List;

public interface ArticleService {
    List<ArticlePojo> getArticles(String url);
}
