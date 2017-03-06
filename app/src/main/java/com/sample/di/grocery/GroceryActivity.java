package com.sample.di.grocery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.sample.di.Injection;
import com.sample.di.R;
import com.sample.di.data.GroceryItem;

import java.util.List;

public class GroceryActivity extends AppCompatActivity implements GroceryContact.View {
    
    private GroceryContact.UserActionsListener mPresenter;
    private TextView mMainTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery);
        
        //create presenter 
        mPresenter = new GroceryPresenter(this, Injection.provideRepository());

        initView();
    }

    private void initView() {
        mMainTextView = (TextView) findViewById(R.id.mainTextView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //load all view
        mPresenter.loadGroceryItem(false);
    }

    @Override
    public void showToast(String txt) {
        Toast.makeText(this, txt, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showGroceryItems(List<GroceryItem> items) {
        StringBuilder strBuilder = new StringBuilder();
        for(GroceryItem item : items) {
            strBuilder.append(item.id).append("\n");
        }
        mMainTextView.setText(strBuilder.toString());
    }

    @Override
    public void showGroceryItem(GroceryItem item) {
        mMainTextView.setText(item.id);
    }
}
