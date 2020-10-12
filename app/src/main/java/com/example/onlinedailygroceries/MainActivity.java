package com.example.onlinedailygroceries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.example.onlinedailygroceries.adapter.CategoryAdapter;
import com.example.onlinedailygroceries.adapter.DiscountedProductAdapter;

import com.example.onlinedailygroceries.adapter.RecentlyViewedAdapter;
import com.example.onlinedailygroceries.model.Category;
import com.example.onlinedailygroceries.model.DiscountedProducts;
import com.example.onlinedailygroceries.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView discountRecylerView,categoryRecylerView,recentlyViewedRecycler;
    DiscountedProductAdapter discountedProductAdapter;
    List<DiscountedProducts> discountedProductsList;
    CategoryAdapter categoryAdapter;
    List<Category> categoryList;
    ImageView allCategory;
    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountRecylerView=findViewById(R.id.discountedRecyler);
        categoryRecylerView=findViewById(R.id.categoryRecycler);
        allCategory=findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler=findViewById(R.id.recently_item);

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AllCategory.class);
                startActivity(i);
            }
        });

        discountedProductsList=new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1,R.drawable.discountberry));
        discountedProductsList.add(new DiscountedProducts(2,R.drawable.discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(3,R.drawable.discountmeat));
        discountedProductsList.add(new DiscountedProducts(4,R.drawable.discountberry));
        discountedProductsList.add(new DiscountedProducts(5,R.drawable.discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(6,R.drawable.discountmeat));

        categoryList=new ArrayList<>();
        categoryList.add(new Category(1,R.drawable.discountberry));
        categoryList.add(new Category(2,R.drawable.discountbrocoli));
        categoryList.add(new Category(3,R.drawable.discountmeat));
        categoryList.add(new Category(4,R.drawable.discountberry));
        categoryList.add(new Category(5,R.drawable.discountmeat));

        recentlyViewedList=new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Watermelon", "Watermelon has high water content and also provides some fiber.", "80৳","1","KG",R.drawable.card4,R.drawable.b4));
        recentlyViewedList.add(new RecentlyViewed("Papaya", "Watermelon has high water content and also provides some fiber.", "85৳","1","KG",R.drawable.card3,R.drawable.b3));
        recentlyViewedList.add(new RecentlyViewed("Strawberry", "Watermelon has high water content and also provides some fiber.", "30৳","1","KG",R.drawable.card2,R.drawable.b2));
        recentlyViewedList.add(new RecentlyViewed("Kiwi", "Watermelon has high water content and also provides some fiber.", "30৳","1","KG",R.drawable.card1,R.drawable.b1));

        setDiscountedRecyler(discountedProductsList);
        setCategoryRecyler(categoryList);
        setRecentlyViewedRecyler(recentlyViewedList);
    }

    private void setRecentlyViewedRecyler(List<RecentlyViewed> recentlyViewedList) {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);

    }

    private void setCategoryRecyler(List<Category> categorydataList) {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        categoryRecylerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categorydataList);
        categoryRecylerView.setAdapter(categoryAdapter);
    }

    private void setDiscountedRecyler(List<DiscountedProducts>dataList) {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        discountRecylerView.setLayoutManager(layoutManager);
        discountedProductAdapter = new DiscountedProductAdapter(this,dataList);
        discountRecylerView.setAdapter(discountedProductAdapter);
    }
}