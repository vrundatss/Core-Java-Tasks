package com.tss.OrderStreamAssign;

public class Order {
    private Integer orderId;
    private String coustomerName;
    private String productCategory;
    private Integer quantity;
    private Double pricePerUnit;
    private String status;

    public Order(Integer orderId, String coustomerName, String productCategory, Integer quantity, Double pricePerUnit, String status) {
        this.orderId = orderId;
        this.coustomerName = coustomerName;
        this.productCategory = productCategory;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.status = status;
    }

    @Override
    public String toString() {
        return
                "OrderId=" + orderId +
                ", Coustomer Name='" + coustomerName + '\'' +
                ", Product Category='" + productCategory + '\'' +
                ", Quantity=" + quantity +
                ", Price Per Unit=" + pricePerUnit +
                ", Status='" + status + '\'';
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCoustomerName() {
        return coustomerName;
    }

    public void setCoustomerName(String coustomerName) {
        this.coustomerName = coustomerName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
