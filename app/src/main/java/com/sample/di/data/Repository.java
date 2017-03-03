package com.sample.di.data;

import android.support.annotation.NonNull;

import java.util.List;

public interface Repository {

    interface LoadItemCallback {
        void onLoaded(List<GroceryItem> items);
    }

    interface GetItemCallback {
        void onLoaded(GroceryItem item);
    }

    void getAllItems(@NonNull LoadItemCallback callback);
    void getItem(@NonNull String id, @NonNull GetItemCallback callback);
    void addItem(@NonNull GroceryItem item);

    // in case you want to clear cache
    void refreshData();
}
