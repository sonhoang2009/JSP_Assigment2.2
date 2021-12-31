package com.jspassigment2.jsp_assigment2.controller.Food;

import com.jspassigment2.jsp_assigment2.entity.Category;
import com.jspassigment2.jsp_assigment2.entity.Food;
import com.jspassigment2.jsp_assigment2.repository.JpaRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class UpdateFoodServlet extends HttpServlet {

    private JpaRepository<Food> repository = new JpaRepository<>(Food.class);
    private JpaRepository<Category> categoryJpaRepository = new JpaRepository<>(Category.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(req.getParameter("id"));
            Food food = repository.findById(id);
            List<Category> categories = categoryJpaRepository.findAll();

            if (food == null){
                resp.getWriter().println("Product not found");
            }
            else {
                req.setAttribute("food",food);
                req.setAttribute("categories", categories);
                req.getRequestDispatcher("/admin/Food/UpdateFood.jsp").forward(req,resp);
            }
        }catch (Exception ex){
            resp.getWriter().println("Bad request");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            req.setCharacterEncoding("UTF-8");
            int id = Integer.parseInt(req.getParameter("id"));
            Food food = repository.findById(id);
            if (food == null){
                resp.getWriter().println("Product not found");
            }else {
                String name = String.valueOf(req.getParameter("name"));
                double price = Double.parseDouble(req.getParameter("price"));
                String thumbnail = String.valueOf(req.getParameter("thumbnail"));
                int status = Integer.parseInt(req.getParameter("status"));
                Date updated_at = new Date();
                String description = String.valueOf(req.getParameter("description"));
                int categoryId = Integer.parseInt(req.getParameter("category"));
                food.setName(name);
                food.setPrice(price);
                food.setDescription(description);
                food.setThumbnail(thumbnail);
                food.setCategoryId(categoryId);
                food.setUpdated_at(updated_at);
                food.setStatus(status);
                repository.update(food);
                resp.sendRedirect("/admin/list");
            }

        }catch (Exception ex){
            resp.getWriter().println("Bad request");
        }
    }
}
