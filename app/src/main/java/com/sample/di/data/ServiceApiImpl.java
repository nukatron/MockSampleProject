package com.sample.di.data;

import java.util.List;

public class ServiceApiImpl implements ServiceApi {

    @Override
    public void getAllItems(ServiceCallback<List<GroceryItem>> callback) {
        //TODO: get all items from server or database
    }

    @Override
    public void getItem(String id, ServiceCallback<GroceryItem> callback) {
        //TODO: get specific item from server or database
    }

    @Override
    public void addItem(GroceryItem item) {
        //TODO: add item to server or database
    }
}
