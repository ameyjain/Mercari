package com.mercari.mercaritest.data.model;

public class Item {

    private String id;
    private String name;
    private Status status;
    private int numLikes;
    private int numComments;
    private double price;
    private String photo;

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public int getNumComments() {
        return numComments;
    }

    public double getPrice() {
        return price;
    }

    public String getPhoto() {
        return photo;
    }

}
