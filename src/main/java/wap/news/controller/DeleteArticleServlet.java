package wap.news.controller;

import wap.news.dao.ArticleDao;
import wap.news.dao.CategoryDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteArticleServlet",value = "/delete-article")
public class DeleteArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArticleDao dao = new ArticleDao();
        dao.deleteArticle(request.getParameter("id"));
        RequestDispatcher rd = request.getRequestDispatcher("article");
        rd.forward(request,response);
    }
}
