package model;

import java.math.BigDecimal;

public class Product{
    private int id;
    private String name;
    private String description;
    private BigDecimal price;

    public Product(int id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
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
}
