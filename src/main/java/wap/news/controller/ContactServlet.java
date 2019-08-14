package wap.news.controller;

import wap.news.dao.ContactUsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ContactServlet",value = "/contact")
public class ContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        ContactUsDao dao = new ContactUsDao();
        dao.addContact(name, email, message);


        request.getSession().setAttribute("ContentURL", "contact.jsp");

        request.getRequestDispatcher("MasterPage.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("ContentURL", "contact.jsp");

        request.getRequestDispatcher("MasterPage.jsp").forward(request, response);
    }
}
