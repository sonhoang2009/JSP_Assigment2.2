package com.jspassigment2.jsp_assigment2.controller.Food;

import com.jspassigment2.jsp_assigment2.entity.Food;
import com.jspassigment2.jsp_assigment2.repository.JpaRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteFoodServlet extends HttpServlet {
    private JpaRepository<Food> productJpaRepository = new JpaRepository<>(Food.class);

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Food product = productJpaRepository.findById(id);
            if (product == null){
                resp.getWriter().println("Product not found");
            }else {
                productJpaRepository.delete(id);
                resp.getWriter().println("xóa thành công");
            }
        }catch (Exception e){
            resp.getWriter().println("Bad request");
        }
    }
}
