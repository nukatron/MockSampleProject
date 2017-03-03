package com.sample.di.data;

import java.util.List;

public interface ServiceApi {

    interface ServiceCallback<T> {
        void onLoaded(T item);
    }

    void getAllItems(ServiceCallback<List<GroceryItem>> callback);
    void getItem(String id, ServiceCallback<GroceryItem> callback);
    void addItem(GroceryItem item);
}
