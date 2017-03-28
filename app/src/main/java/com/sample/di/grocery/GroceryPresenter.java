package com.sample.di.grocery;


import com.sample.di.data.GroceryItem;
import com.sample.di.data.Repository;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class GroceryPresenter implements GroceryContact.UserActionsListener {

    private GroceryContact.View mView;
    private Repository mRepository;

    public GroceryPresenter(GroceryContact.View view, Repository repository) {
        mView = view;
        mRepository = repository;
    }

    @Override
    public void loadGroceryItem(boolean forceUpdate) {
        if(forceUpdate) {
            mRepository.refreshData();
        }

        mRepository.getAllItems(new Repository.LoadItemsCallback() {
            @Override
            public void onLoaded(List<GroceryItem> items) {
                mView.showGroceryItems(items);
            }
        });
    }

    @Override
    public void randomItem() {
        mRepository.getAllItems(new Repository.LoadItemsCallback() {
            @Override
            public void onLoaded(List<GroceryItem> items) {
                if(items.size() >= 0) {
                    mView.showGroceryItem(items.get(new Random().nextInt(items.size())));
                } else {
                    mView.showToast("No grocery item");
                }
            }
        });
    }

    @Override
    public void autoAddItem() {
        String id = UUID.randomUUID().toString();
        GroceryItem item = new GroceryItem(id, "auto add item", 0);
        mRepository.addItem(item);
        mView.showToast("Added!");
    }
}
