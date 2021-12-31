package com.jspassigment2.jsp_assigment2.controller.Food;

import com.jspassigment2.jsp_assigment2.entity.Food;
import com.jspassigment2.jsp_assigment2.repository.JpaRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetFoodDetailServlet extends HttpServlet {
    private JpaRepository<Food> repository = new JpaRepository<>(Food.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(req.getParameter("id"));
            Food food = repository.findById(id);
            if (food == null){
                resp.getWriter().println("Product not found");
            }
            else {
                req.setAttribute("food",food);
                req.getRequestDispatcher("/admin/Food/FoodDetail.jsp").forward(req,resp);
            }
        }catch (Exception ex){
            resp.getWriter().println("Bad request");
        }

    }
}
