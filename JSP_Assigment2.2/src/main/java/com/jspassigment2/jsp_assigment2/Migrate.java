package com.jspassigment2.jsp_assigment2;

import com.jspassigment2.jsp_assigment2.annotation.*;
import com.jspassigment2.jsp_assigment2.entity.Food;
import com.jspassigment2.jsp_assigment2.repository.JpaRepository;
import com.jspassigment2.jsp_assigment2.util.ConnectionHelper;
import com.jspassigment2.jsp_assigment2.util.SQLConstant;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.*;

public class Migrate {
    public static void main(String[] args) {
        Reflections reflections =new Reflections("com.jspassigment2.jsp_assigment2");
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Entity.class);

        for (Class<?> clazz : annotated) {
            // thực hiện migrate cho class đó.
            doMigrate(clazz);
        }
        for (Class<?> clazz : annotated) {
            // thực hiện migrate cho class đó.
            addForeignKey(clazz);
        }

    }

    static void doMigrate(Class clazz) {
        StringBuilder stringBuilder = new StringBuilder();
        // lấy tên class
        System.out.println("Migrating class " + clazz.getName());
        if (!clazz.isAnnotationPresent(Entity.class)) {
            System.err.println("Class không được đánh dấu là table trong database. Bỏ qua.");
            return;
        }
        // chắc chắc class đã được đánh dấu annotation là @Table
        // @Table
        // lấy thông tin annotation ra.
        String tableName = clazz.getSimpleName().toLowerCase() + "s";
        Entity annotationTable = (Entity) clazz.getAnnotation(Entity.class);
        String annotationTableName = annotationTable.tableName();
        if (annotationTableName != null && annotationTableName.length() > 0) {
            tableName = annotationTableName;
        }
        stringBuilder.append(SQLConstant.CREATE_TABLE);
        stringBuilder.append(SQLConstant.SPACE);
        stringBuilder.append(tableName);
        stringBuilder.append(SQLConstant.SPACE);
        stringBuilder.append(SQLConstant.OPEN_PARENTHESES);
        // trả về danh sách các thuộc tính.
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName(); // tên trường
            String fieldType = fields[i].getType().getName(); // kiểu giá trị của trường.
            if (fields[i].isAnnotationPresent(Column.class)) {
                Column annotationColumn = fields[i].getAnnotation(Column.class);
                if (annotationColumn.name().length() > 0) {
                    fieldName = annotationColumn.name();
                }
                if (annotationColumn.type().length() > 0) {
                    fieldType = annotationColumn.type();
                }
            }
            stringBuilder.append(fieldName);
            stringBuilder.append(SQLConstant.SPACE);
            stringBuilder.append(fieldType);
            // Check xem trường có phải là khoá chính hay không?
            if (fields[i].isAnnotationPresent(Id.class)) {
                stringBuilder.append(SQLConstant.SPACE);
                stringBuilder.append(SQLConstant.PRIMARY_KEY);
                Id annotationId = fields[i].getAnnotation(Id.class); // lấy ra thông tin annotation
                // để check thuộc tính auto_increment.
                if (annotationId.autoIncrement()) {
                    stringBuilder.append(SQLConstant.SPACE);
                    stringBuilder.append(SQLConstant.AUTO_INCREMENT);
                }
            }
            stringBuilder.append(SQLConstant.COMMA);
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        stringBuilder.append(SQLConstant.CLOSE_PARENTHESES);

        Connection cnn = null;
        try {
            cnn = ConnectionHelper.getConnection();
            Statement stt = cnn.createStatement();
            try {
                System.out.println("Try to drop table '" + tableName + "' before recreate.");
                stt.execute(SQLConstant.DROP_TABLE + SQLConstant.SPACE + tableName);
                System.out.println("Drop table '" + tableName + "' success!");
            } catch (Exception ex) {
                System.err.println("Drop table fails, error: " + ex.getMessage());
            }
            System.out.println("Try to execute statement: '" + stringBuilder.toString() + "'");
            stt.execute(stringBuilder.toString());
            System.out.println("Create table success!");
        } catch (SQLException e) {
            System.err.println("Create table fails, error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    static void addForeignKey(Class clazz) {
        StringBuilder stringBuilder = new StringBuilder();
        String tableName = clazz.getSimpleName();
        Entity annotationTable = (Entity) clazz.getAnnotation(Entity.class);
        String annotationTableName = annotationTable.tableName();
        if (annotationTableName != null && annotationTableName.length() > 0) {
            tableName = annotationTableName;
        }
        stringBuilder.append(SQLConstant.ALTER_TABLE);
        stringBuilder.append(SQLConstant.SPACE);
        stringBuilder.append(tableName);
        stringBuilder.append(SQLConstant.SPACE);
        stringBuilder.append(SQLConstant.ADD);
        stringBuilder.append(SQLConstant.SPACE);
        stringBuilder.append(SQLConstant.FOREIGN_KEY);
        stringBuilder.append(SQLConstant.SPACE);
        // trả về danh sách các thuộc tính.
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++){
            String fieldName = fields[i].getName();
            if (fields[i].isAnnotationPresent(ForeignKey.class)){
                stringBuilder.append(SQLConstant.OPEN_PARENTHESES);
                stringBuilder.append(fieldName);
                stringBuilder.append(SQLConstant.CLOSE_PARENTHESES);
                stringBuilder.append(SQLConstant.SPACE);
                stringBuilder.append(SQLConstant.REFERENCES);
                stringBuilder.append(SQLConstant.SPACE);
                ForeignKey foreignKey = fields[i].getAnnotation(ForeignKey.class);
                stringBuilder.append(foreignKey.referenceTable());
                stringBuilder.append(SQLConstant.OPEN_PARENTHESES);
                stringBuilder.append(foreignKey.referenceColumn());
                stringBuilder.append(SQLConstant.CLOSE_PARENTHESES);
            }
        }
        System.out.println(stringBuilder.toString());
        Connection cnn = null;
        try {
            cnn = ConnectionHelper.getConnection();
            Statement stt = cnn.createStatement();
            System.out.println("Try to execute statement: '" + stringBuilder.toString() + "'");
            stt.execute(stringBuilder.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
