package com.jspassigment2.jsp_assigment2.controller.Category;

import com.jspassigment2.jsp_assigment2.entity.Category;
import com.jspassigment2.jsp_assigment2.repository.JpaRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

public class UpdateCategory extends HttpServlet {
    JpaRepository<Category> jpaRepository = new JpaRepository<>(Category.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = jpaRepository.findById(id);
        req.setAttribute("category",category);
        req.getRequestDispatcher("/admin/Category/UpdateCategory.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = jpaRepository.findById(id);
        try{
            if (category == null){
                resp.getWriter().println("not found");
            }else{
                String name = String.valueOf(req.getParameter("name"));
                category.setName(name);
                jpaRepository.update(category);
                resp.sendRedirect("/admin/list-category");
            }

        }
        catch (Exception ex){
            resp.getWriter().println("Bad request");
        }
    }
}
