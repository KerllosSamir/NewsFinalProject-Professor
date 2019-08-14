package wap.news.controller;

import wap.news.dao.UserDao;
import wap.news.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDao userdao = new UserDao();
        request.getSession().removeAttribute("User_ID");

        userdao.getUserByUserNameAndPass(username, password).forEach((k, v) -> {
            request.getSession().setAttribute("User_ID", k);
        });

        if (request.getSession().getAttribute("User_ID") != null) {
            request.getSession().removeAttribute("logErrorMessage");
            response.sendRedirect("backend/index.jsp");
        } else {
            request.getSession().setAttribute("logErrorMessage", "Wrong credentials! Can't find username & password");
            response.sendRedirect("backend/login.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("backend/login.jsp");
    }
}
