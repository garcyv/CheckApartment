package com.example.checkapartment.model;

public class Item {
    private String itemnombre;
    private String itemproy;
    private String itemunidad;
    private String itemdirecc;
    private String itemurlimg;


    public Item(String pnombre, String pproy,String punidad, String pdirecc, String purlimg) {
        this.itemnombre = pnombre;
        this.itemproy = pproy;
        this.itemunidad = punidad;
        this.itemdirecc = pdirecc;
        this.itemurlimg = purlimg;
    }

    public String getItemnombre() {
        return itemnombre;
    }
    public String getItemproy() {
        return itemproy;
    }
    public String getItemunidad() {
        return itemunidad;
    }
    public String getItemdirecc() {
        return itemdirecc;
    }
    public String getItemurlimg() {
        return itemurlimg;
    }

    public void setItemnombre(String pnombre) {
        this.itemnombre = pnombre;
    }
    public void setItemproy(String pproy) {
        this.itemproy = pproy;
    }
    public void setItemunidad(String punidad) {
        this.itemunidad = punidad;
    }
    public void setItemdirecc(String pdirecc) {
        this.itemdirecc = pdirecc;
    }
    public void setItemurlimg(String purlimg) {
        this.itemurlimg = purlimg;
    }






}
