package com.example.sherryliciacs125app;


public class OneLipstick {
    private String brand;
    private String name;
    private double price;
    private String priceSign;
    private String currency;
    private String imagelink;
    private String description;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public String getPriceSign() {
        return priceSign;
    }

    public void setPriceSign(String priceSign) {
        this.priceSign = priceSign;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getImagelink() {
        return imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    //1. create json object that contains all json content from url
//2. use dot method to say like String name = jsonobjname.get("name").getAsString;
// 3. put all this json individual values inside a function, and connect it to our layout
// 4. inflate chunks * make recycler

}


