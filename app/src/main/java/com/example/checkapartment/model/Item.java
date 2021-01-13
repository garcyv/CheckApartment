package com.example.checkapartment.model;

public class Item {
    private String itemDescription;
    private String urlImage;

    public Item(){

    }
    public Item(String itemDescription, String urlImage) {
        this.itemDescription = itemDescription;
        this.urlImage = urlImage;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

}
