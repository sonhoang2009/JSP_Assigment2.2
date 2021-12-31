package com.jspassigment2.jsp_assigment2.controller.Category;

import com.jspassigment2.jsp_assigment2.entity.Category;
import com.jspassigment2.jsp_assigment2.repository.JpaRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateCategory extends HttpServlet {
    JpaRepository<Category> repository = new JpaRepository<>(Category.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/Category/CreateCategory.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            String name = String.valueOf(req.getParameter("name"));
            Category category = new Category(name);
            repository.save(category);
            resp.sendRedirect("/admin/list-category");
        }catch (Exception ex){
            resp.getWriter().println("Bad request");
        }
    }
}
