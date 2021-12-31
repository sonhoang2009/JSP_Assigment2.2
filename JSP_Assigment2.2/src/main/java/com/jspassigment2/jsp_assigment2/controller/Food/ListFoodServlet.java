package com.jspassigment2.jsp_assigment2.controller.Food;

import com.jspassigment2.jsp_assigment2.entity.Category;
import com.jspassigment2.jsp_assigment2.entity.Food;
import com.jspassigment2.jsp_assigment2.repository.JpaRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListFoodServlet extends HttpServlet {
    private JpaRepository<Food> repository = new JpaRepository<>(Food.class);
    private JpaRepository<Category> categoryJpaRepository = new JpaRepository<>(Category.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int limit = 5;
        if (req.getParameter("page") != null && req.getParameter("page") != ""){
            page = Integer.parseInt(req.getParameter("page"));
        }
        int totalRecord = repository.countData();
        int totalPage = (int) Math.ceil((float)totalRecord / limit);
        List<Food> list = repository.paginate(limit,page);

        req.setAttribute("product", list);
        req.setAttribute("totalPage",totalPage);
        req.setAttribute("page",page);

        req.getRequestDispatcher("/admin/Food/ListFood.jsp").forward(req,resp);
    }
}
