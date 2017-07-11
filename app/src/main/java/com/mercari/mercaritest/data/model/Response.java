package com.mercari.mercaritest.data.model;

import java.util.ArrayList;

public class Response {

    public final String result;
    public final ArrayList<Item> data;

    public Response(String result, ArrayList<Item> data) {
        this.result = result;
        this.data = data;
    }

    public ArrayList<Item> getItems() {
        return data;
    }

}