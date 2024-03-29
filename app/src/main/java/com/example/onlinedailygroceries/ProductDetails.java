package com.example.onlinedailygroceries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {
    ImageView img,back;
    TextView proName,proPrice,proDesc;
    int image;
    String name,price,desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Intent i =getIntent();

         name = i.getStringExtra("name");
         image = i.getIntExtra("image",R.drawable.b1);
         price = i.getStringExtra("price");
         desc = i.getStringExtra("desc");

         proName=findViewById(R.id.productName);
         proDesc=findViewById(R.id.pro);
         proPrice=findViewById(R.id.proPrice);
         img=findViewById(R.id.big_image);
         back=findViewById(R.id.back2);

         proName.setText(name);
         proPrice.setText(price);
         proDesc.setText(desc);
        img.setImageResource(image);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProductDetails.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}