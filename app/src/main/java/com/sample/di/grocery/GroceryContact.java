package com.sample.di.grocery;

import com.sample.di.data.GroceryItem;
import java.util.List;

public interface GroceryContact {

    interface View {
        void showToast(String txt);
        void showGroceryItems(List<GroceryItem> items);
        void showGroceryItem(GroceryItem item);
    }

    interface UserActionsListener {
        void loadGroceryItem(boolean forceUpdate);
        void randomItem();
        void autoAddItem();
    }
}
