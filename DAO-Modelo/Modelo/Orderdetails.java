/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author black
 */
public class Orderdetails {
    private int IdOrderDetails;
    private Double UnitPrice;
    private int Quantity;
    private Double Discount;
    private Orders OrderID;
    private Products ProductID;

    public Orderdetails() {
    }

    public int getIdOrderDetails() {
        return IdOrderDetails;
    }

    public void setIdOrderDetails(int IdOrderDetails) {
        this.IdOrderDetails = IdOrderDetails;
    }

    public Double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(Double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public Double getDiscount() {
        return Discount;
    }

    public void setDiscount(Double Discount) {
        this.Discount = Discount;
    }

    public int getOrderID() {
        return OrderID.getOrderID();
    }

    public void setOrderID(Orders OrderID) {
        this.OrderID.setOrderID(OrderID.getOrderID());
    }

    public int getProductID() {
        return ProductID.getProductID();
    }

    public void setProductID(Products ProductID) {
        this.ProductID.setProductID(ProductID.getProductID());
    }
    
    
}
