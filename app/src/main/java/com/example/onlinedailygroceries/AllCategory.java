package com.example.onlinedailygroceries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.onlinedailygroceries.adapter.AllCategoryAdapter;
import com.example.onlinedailygroceries.adapter.CategoryAdapter;
import com.example.onlinedailygroceries.model.AllCategoryModel;
import com.example.onlinedailygroceries.model.AllCategoryModel;
import com.example.onlinedailygroceries.model.Category;

import java.util.ArrayList;
import java.util.List;

public class AllCategory extends AppCompatActivity {
        RecyclerView allCategoryRecycler;
        AllCategoryAdapter allCategoryAdapter;
        List<AllCategoryModel> categoryModelList;
        ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);

        allCategoryRecycler=findViewById(R.id.allCategory);
        back=findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(AllCategory.this,MainActivity.class);
                startActivity(back);
                finish();
            }
        });

        categoryModelList=new ArrayList<>();
        categoryModelList.add(new AllCategoryModel(1,R.drawable.discountberry));
        categoryModelList.add(new AllCategoryModel(2,R.drawable.discountbrocoli));
        categoryModelList.add(new AllCategoryModel(3,R.drawable.discountmeat));
        categoryModelList.add(new AllCategoryModel(4,R.drawable.discountberry));
        categoryModelList.add(new AllCategoryModel(5,R.drawable.discountmeat));
        categoryModelList.add(new AllCategoryModel(6,R.drawable.discountbrocoli));
        categoryModelList.add(new AllCategoryModel(7,R.drawable.discountmeat));
        categoryModelList.add(new AllCategoryModel(8,R.drawable.discountberry));
        categoryModelList.add(new AllCategoryModel(9,R.drawable.discountmeat));

        
        setallCategoryRecyler(categoryModelList);
    }
    private void setallCategoryRecyler(List<AllCategoryModel> allCategoryModelList) {
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this,3);
        allCategoryRecycler.setLayoutManager(layoutManager);
        allCategoryAdapter = new AllCategoryAdapter(this,allCategoryModelList);
        allCategoryRecycler.setAdapter(allCategoryAdapter);
    }
}