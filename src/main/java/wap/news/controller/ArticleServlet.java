package wap.news.controller;

import wap.news.dao.ArticleDao;
import wap.news.dao.CategoryDao;
import wap.news.model.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ArticleServlet", value = "/article")
public class ArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArticleDao Article = new ArticleDao();
        HttpSession session = request.getSession();
        session.setAttribute("articleList", Article.getAllArticles());
        List<Category> listCatagory = new ArrayList<>(new CategoryDao().getActiveCategories().values());
        session.setAttribute("categoryList", listCatagory);
        response.sendRedirect("backend/article.jsp");
    }
}
