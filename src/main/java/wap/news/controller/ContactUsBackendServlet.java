package wap.news.controller;

import wap.news.dao.ContactUsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ContactUsBackendServlet",value = "/contactbackend")
public class ContactUsBackendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ContactUsDao contact = new ContactUsDao();
        HttpSession session = request.getSession();
        session.setAttribute("contactList", contact.getAllContacts());
        response.sendRedirect("backend/contactus.jsp");
    }
}
