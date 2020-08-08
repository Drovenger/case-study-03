package main.java.model;

import main.java.model.product.Product;

import java.util.LinkedList;
import java.util.List;

public class Brand {
    private int id;
    private int brandCode;
    private String name;
    private String description;
    private String status;
    private List<Product> productList;

    public Brand() {
        productList = new LinkedList<>();
    }

    public Brand(int id, int brandCode, String name) {
        this.id = id;
        this.brandCode = brandCode;
        this.name = name;
    }

    public Brand(int id, int brandCode, String name, String description, String status, List<Product> productList) {
        this.id = id;
        this.brandCode = brandCode;
        this.name = name;
        this.description = description;
        this.status = status;
        this.productList = productList;
    }


    public Brand(int id, int brandCode, String name, String description, String status) {
        this.id = id;
        productList = new LinkedList<>();
        this.brandCode = brandCode;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public int getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(int brandCode) {
        this.brandCode = brandCode;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProductToBrand(Product product) {
        productList.add(product);
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }
        Brand brand = (Brand) obj;
        return brand.getName().equals(this.name) || brand.getId() == this.id;
    }
}