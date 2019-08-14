package wap.news.controller;

import com.google.gson.Gson;
import wap.news.dao.ArticleDao;
import wap.news.dao.CategoryDao;
import wap.news.model.Article;
import wap.news.model.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ArticleScroll", value = "/articleScroll")
public class ArticleScroll extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArticleDao articleDao = new ArticleDao();
        PrintWriter out = response.getWriter();
        List<Article> articleList = new ArrayList<>();
        articleDao.getNavigationArticles().forEach((k, v) -> {
            articleList.add(new Article(v.getId(),v.getTitle(), v.getBody(), v.getCategoryId(), v.getMainImage(), v.getIsNaveBar(), v.getIsRotating(), v.getIsActive()));
        });

        String JsonArticle;
        JsonArticle = new Gson().toJson(articleList);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.write(JsonArticle);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArticleDao articleDao = new ArticleDao();
        PrintWriter out = response.getWriter();
        List<Article> articleList = new ArrayList<>();
        articleDao.getNavigationArticles().forEach((k, v) -> {
            articleList.add(new Article(v.getId(),v.getTitle(), v.getBody(), v.getCategoryId(), v.getMainImage(), v.getIsNaveBar(), v.getIsRotating(), v.getIsActive()));
        });

        String JsonArticle;
        JsonArticle = new Gson().toJson(articleList);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.write(JsonArticle);
    }
}
