package wap.news.controller;

import wap.news.dao.CategoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UpdateCategoryServlet", value = "/update-category")
public class UpdateCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error = "";

        CategoryDao dao = new CategoryDao();
        HttpSession session = request.getSession();

        String id = request.getParameter("id");
        String name = request.getParameter("name");

        boolean isActive = false;
        if (request.getParameter("isActive") != null) {
            isActive = true;
        }

        if (name == null || name.equals("")) {

            error += "Name is required and cannot be empty <br/>";
        }

        if (error == "") {
            session.removeAttribute("categoryError");
            session.setAttribute("catErrorDispaly", "none");
            dao.updateCategory(id, name, isActive);
        } else {
            session.setAttribute("categoryError", error);
            session.setAttribute("catErrorDispaly", "block");
        }
        response.sendRedirect("category");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDao dao = new CategoryDao();
        HttpSession session = request.getSession();
        session.setAttribute("categoryById", dao.getCategoryById(request.getParameter("id")));
        response.sendRedirect("backend/category.jsp?update=true");

    }
}
