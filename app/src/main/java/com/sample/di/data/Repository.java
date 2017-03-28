package com.sample.di.data;

import android.support.annotation.NonNull;
import java.util.List;

public interface Repository {

    interface LoadItemsCallback {
        void onLoaded(List<GroceryItem> items);
    }

    interface LoadItemCallback {
        void onLoaded(GroceryItem item);
    }

    void getAllItems(@NonNull LoadItemsCallback callback);
    void getItem(@NonNull String id, @NonNull LoadItemCallback callback);
    void addItem(@NonNull GroceryItem item);

    // in case you want to clear cache
    void refreshData();
}
