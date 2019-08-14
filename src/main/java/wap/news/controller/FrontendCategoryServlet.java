package wap.news.controller;

import wap.news.dao.ArticleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "FrontendCategoryServlet", value = "/aCategory")
public class FrontendCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArticleDao dao = new ArticleDao();
        HttpSession session = request.getSession();
        session.setAttribute("categoryArticles", dao.getArticlesByCategoryId(request.getParameter("id")).values().toArray());

        request.getSession().setAttribute("ContentURL", "articleCategory.jsp");
        request.getRequestDispatcher("MasterPage.jsp").forward(request, response);
    }
}
