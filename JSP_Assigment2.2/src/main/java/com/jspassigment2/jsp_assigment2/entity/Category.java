package com.jspassigment2.jsp_assigment2.entity;

import com.jspassigment2.jsp_assigment2.annotation.Column;
import com.jspassigment2.jsp_assigment2.annotation.Entity;
import com.jspassigment2.jsp_assigment2.annotation.Id;
import com.jspassigment2.jsp_assigment2.util.SQLDataTypes;

@Entity(tableName = "categories")
public class Category {
    @Id(autoIncrement = true)
    @Column(name = "id", type = SQLDataTypes.INTEGER)
    private int id;
    @Column(name = "category_name", type = SQLDataTypes.VARCHAR50)
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
