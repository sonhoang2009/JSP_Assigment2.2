package com.jspassigment2.jsp_assigment2.controller.Category;

import com.jspassigment2.jsp_assigment2.entity.Category;
import com.jspassigment2.jsp_assigment2.repository.JpaRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListCategory extends HttpServlet {
    JpaRepository<Category> repository = new JpaRepository<>(Category.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = repository.findAll();
        req.setAttribute("categories",categories);
        req.getRequestDispatcher("/admin/Category/ListCategory.jsp").forward(req, resp);
    }
}
