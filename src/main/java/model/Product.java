package model;

import java.math.BigDecimal;

public class Product{
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private String category;

    public Product() {
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getDescription(){
        return description;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
