package wap.news.controller;

import wap.news.dao.CategoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AddCategoryServlet", value = "/add-category")
public class AddCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error = "";

        String name = request.getParameter("name");
        boolean isActive = false;
        if (request.getParameter("isActive") != null) {
            isActive = true;
        }
        if (name == null || name.equals("")) {
            error += "Name is required and cannot be empty <br/>";
        }

        CategoryDao dao = new CategoryDao();
        HttpSession session = request.getSession();
        if (error == "") {
            session.removeAttribute("categoryError");
            session.setAttribute("catErrorDispaly", "none");
            dao.addCategory(name, isActive);
        }
        else
        {
            session.setAttribute("categoryError", error);
            session.setAttribute("catErrorDispaly", "block");
        }

        session.setAttribute("categoryList", dao.getAllCategories());
        response.sendRedirect("backend/category.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
