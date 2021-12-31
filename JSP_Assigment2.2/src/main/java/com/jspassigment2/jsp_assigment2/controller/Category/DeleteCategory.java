package com.jspassigment2.jsp_assigment2.controller.Category;

import com.jspassigment2.jsp_assigment2.entity.Category;
import com.jspassigment2.jsp_assigment2.entity.Food;
import com.jspassigment2.jsp_assigment2.repository.JpaRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCategory extends HttpServlet {
    private JpaRepository<Category> JpaRepository = new JpaRepository<>(Category.class);

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Category category = JpaRepository.findById(id);
            if (category == null){
                resp.getWriter().println("Product not found");
            }else {
                JpaRepository.delete(id);
                resp.getWriter().println("xóa thành công");
            }
        }catch (Exception e){
            resp.getWriter().println("Bad request");
        }
    }
}
