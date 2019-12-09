package com.example.sherryliciacs125app;


public class OneLipstick {
    private String brand;
    private String name;
    private String price;
    private String description;
    private String imageURL;

    //empty constructor. called in lipstick adapter
    public OneLipstick() {

    }

    //full constructor (5 arguments)
    public OneLipstick(String brand, String name, String price, String description, String imageURL) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageURL = imageURL;
    }

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }


    //1. create json object that contains all json content from url
//2. use dot method to say like String name = jsonobjname.get("name").getAsString;
// 3. put all this json individual values inside a function, and connect it to our layout
// 4. inflate chunks & make recyclerview

}


