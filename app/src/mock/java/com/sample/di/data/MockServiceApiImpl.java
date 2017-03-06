package com.sample.di.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MockServiceApiImpl implements ServiceApi {

    private HashMap<String, GroceryItem> mMockData = new HashMap<>();

    public MockServiceApiImpl() {
        initMockData();
    }

    private void initMockData() {
        //you can initial mock data here.
        //you might assign them from json or any data source that you want.
        mMockData.put("id-1", new GroceryItem("id-1", "MockItem1", 10));
        mMockData.put("id-2", new GroceryItem("id-2", "MockItem2", 20));
        mMockData.put("id-3", new GroceryItem("id-3", "MockItem3", 30));
    }

    @Override
    public void getAllItems(ServiceCallback<List<GroceryItem>> callback) {
        callback.onLoaded(new ArrayList<>(mMockData.values()));
    }

    @Override
    public void getItem(String id, ServiceCallback<GroceryItem> callback) {
        callback.onLoaded(mMockData.get(id));
    }

    @Override
    public void addItem(GroceryItem item) {
        mMockData.put(item.id, item);
    }
}
