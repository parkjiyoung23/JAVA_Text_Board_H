package com.pjy.exam.board.service;

import com.pjy.exam.board.dto.Article;
import com.pjy.exam.board.repository.ArticleRepository;

import java.util.List;

public class ArticleService {
  private ArticleRepository articleRepository;

  public ArticleService() {
    articleRepository = new ArticleRepository();
  }
  public void makeTestData() {
    for (int i = 0; i < 100; i++) {
      String title = "제목" + (i + 1);
      String body = "내용" + (i + 1);
      write(title, body);
    }
  }
  public int write(String title, String body) {
    return articleRepository.write(title, body);
  }

  public void deleteArticleById(int id) {
    articleRepository.deleteArticleById(id);
  }

  public List<Article> getArticles() {
    return articleRepository.getArticles();
  }
  public Article getArticleById(int id) {
    return articleRepository.getArticleById(id);
  }
}
