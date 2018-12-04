package Entidad;

import java.awt.image.BufferedImage;

public class Categories {
    private int CategoryID;
    private String CategoryName;
    private String Description;
    private BufferedImage Picture;

    public Categories() {
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public BufferedImage getPicture() {
        return Picture;
    }

    public void setPicture(BufferedImage Picture) {
        this.Picture = Picture;
    }
     
     
}
