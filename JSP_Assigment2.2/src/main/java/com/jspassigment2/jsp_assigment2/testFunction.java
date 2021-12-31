package com.jspassigment2.jsp_assigment2;

import com.jspassigment2.jsp_assigment2.entity.Food;
import com.jspassigment2.jsp_assigment2.repository.JpaRepository;

public class testFunction {
    public static void main(String[] args) {
        JpaRepository<Food> foodJpaRepository = new JpaRepository<>(Food.class);
        int totalRecord = foodJpaRepository.countData();
        int limit = 5;
        int totalPage = (int) Math.ceil((float)totalRecord / (float) limit);
        System.out.println("total record: " + totalRecord);
        System.out.println("limit: " + limit);
        System.out.println("total pages: " + totalPage);
    }
}
