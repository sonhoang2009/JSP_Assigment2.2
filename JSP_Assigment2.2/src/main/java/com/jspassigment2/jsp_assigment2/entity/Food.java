package com.jspassigment2.jsp_assigment2.entity;

import com.jspassigment2.jsp_assigment2.annotation.Column;
import com.jspassigment2.jsp_assigment2.annotation.Entity;
import com.jspassigment2.jsp_assigment2.annotation.ForeignKey;
import com.jspassigment2.jsp_assigment2.annotation.Id;
import com.jspassigment2.jsp_assigment2.util.SQLDataTypes;
import com.jspassigment2.jsp_assigment2.util.ValidationUtil;

import java.util.Date;
import java.util.HashMap;

@Entity(tableName = "food")
public class Food {
    @Id(autoIncrement = true)
    @Column(name = "id", type = SQLDataTypes.INTEGER)
    private int id;
    @Column(name = "food_name", type = SQLDataTypes.VARCHAR255)
    private String name;
    @Column(name = "price", type = SQLDataTypes.DOUBLE)
    private double price;
    @Column(name = "description", type = SQLDataTypes.TEXT)
    private String description;
    @Column(name = "thumbnail", type = SQLDataTypes.VARCHAR255)
    private String thumbnail;
    @Column(name = "status", type = SQLDataTypes.INTEGER)
    private int status;
    @Column(name = "created_at", type = SQLDataTypes.DATE)
    private Date created_at;
    @Column(name = "updated_at", type = SQLDataTypes.DATE)
    private Date updated_at;

    @Column(name = "categoryId", type = SQLDataTypes.INTEGER)
    @ForeignKey(referenceColumn = "id", referenceTable = "categories")
    private int categoryId;

    public Food() {
        this.name = "";
        this.price = 0;
        this.description = "";
        this.thumbnail = "";
    }

    public Food(int id, String name, double price, String description, String thumbnail, int status, Date created_at, Date updated_at, int categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.thumbnail = thumbnail;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.categoryId = categoryId;
    }

    public Food(String name, double price, String description, String thumbnail, int status, Date created_at, int categoryId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.thumbnail = thumbnail;
        this.status = status;
        this.created_at = created_at;
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", status=" + status +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", categoryId=" + categoryId +
                '}';
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isValid() {
        return getError().size() == 0;
    }

    public HashMap<String, String> getError(){
        HashMap<String, String> errors = new HashMap<>();
        if (name == null || name.length() ==0   ){
            errors.put("name","T??n s???n ph???m kh??ng ???????c tr???ng");
        }else if (name.length() < 7){
            errors.put("name","T??n s???n ph???m ph???i nhi???u h??n 7 k?? t???");
        }if (price == 0){
            errors.put("price","Vui l??ng ??i???n gi?? s???n ph???m");
        }
        if (description == null || description.length() == 0){
            errors.put("description", "Vui l??ng th??m m?? t??? cho s???n ph???m");
        }
        if (status == 0){
            errors.put("status","Vui l??ng th??m tr???ng th??i cho s???n ph???m");
        }
        if (thumbnail == null || thumbnail.length() == 0 ){
            errors.put("thumbnail","Vui l??ng th??m ???nh cho s???n ph???m");
        } else if (!ValidationUtil.checkUrl(thumbnail)){
            errors.put("thumbnail","???nh sai ?????nh d???ng vui l??ng nh???p 1 ???????ng link");
        }
        if (categoryId == 0 ){
            errors.put("category","Vui l??ng ch???n danh m???c cho s???n ph???m");
        }

        return errors;
    }
}
