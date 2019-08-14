package wap.news.controller;

import com.google.gson.Gson;
import wap.news.dao.CategoryDao;
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

@WebServlet(name = "MenuServlet", value = "/menu")
public class MenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDao category = new CategoryDao();
        PrintWriter out = response.getWriter();
        List<Category> categoryList = new ArrayList<>();
        category.getAllCategories().forEach((k, v) -> {
            categoryList.add(new Category(k, v.getName(), v.getIsActive()));
        });

        String JSONcategory;
        JSONcategory = new Gson().toJson(categoryList);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.write(JSONcategory);
    }
}
