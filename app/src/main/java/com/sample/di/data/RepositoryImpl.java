package com.sample.di.data;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements Repository {

    private ServiceApi mService;
    private List<GroceryItem> mCacheItems;

    public RepositoryImpl(ServiceApi service) {
        mService = service;
        mCacheItems = new ArrayList<>();
    }

    @Override
    public void getAllItems(@NonNull final LoadItemCallback callback) {
        if(mCacheItems.isEmpty()) {
            mService.getAllItems(new ServiceApi.ServiceCallback<List<GroceryItem>>() {
                @Override
                public void onLoaded(List<GroceryItem> items) {
                    callback.onLoaded(items);
                }
            });
        } else {
            callback.onLoaded(mCacheItems);
        }

    }

    @Override
    public void getItem(@NonNull String id, @NonNull final GetItemCallback callback) {
        mService.getItem(id, new ServiceApi.ServiceCallback<GroceryItem>() {
            @Override
            public void onLoaded(GroceryItem item) {
                callback.onLoaded(item);
            }
        });
    }

    @Override
    public void addItem(@NonNull GroceryItem item) {
        mService.addItem(item);
    }

    @Override
    public void refreshData() {
        mCacheItems.clear();
    }
}
