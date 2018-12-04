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
public class Products {
    private int ProductID;
    private String ProductName;
    private String QuantityPerUnit;
    private Double UnitPrice;
    private int UnitsInStock;
    private int UnitsOnOrder;
    private int ReorderLevel;
    private int Discontinued;
    private Suppliers SupplierID;
    private Categories CategoryID;

    public Products() {
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getQuantityPerUnit() {
        return QuantityPerUnit;
    }

    public void setQuantityPerUnit(String QuantityPerUnit) {
        this.QuantityPerUnit = QuantityPerUnit;
    }

    public Double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(Double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public int getUnitsInStock() {
        return UnitsInStock;
    }

    public void setUnitsInStock(int UnitsInStock) {
        this.UnitsInStock = UnitsInStock;
    }

    public int getUnitsOnOrder() {
        return UnitsOnOrder;
    }

    public void setUnitsOnOrder(int UnitsOnOrder) {
        this.UnitsOnOrder = UnitsOnOrder;
    }

    public int getReorderLevel() {
        return ReorderLevel;
    }

    public void setReorderLevel(int ReorderLevel) {
        this.ReorderLevel = ReorderLevel;
    }

    public int getDiscontinued() {
        return Discontinued;
    }

    public void setDiscontinued(int Discontinued) {
        this.Discontinued = Discontinued;
    }

    public int getSupplierID() {
        return SupplierID.getSupplierID();
    }

    public void setSupplierID(Suppliers SupplierID) {
        this.SupplierID.setSupplierID(SupplierID.getSupplierID());
    }

    public int getCategoryID() {
        return CategoryID.getCategoryID();
    }

    public void setCategoryID(Categories CategoryID) {
        this.CategoryID.setCategoryID(CategoryID.getCategoryID());
    }
    
    
}
