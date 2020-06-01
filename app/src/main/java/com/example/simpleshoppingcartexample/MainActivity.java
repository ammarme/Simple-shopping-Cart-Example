package com.example.simpleshoppingcartexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.bumptech.glide.load.model.ByteArrayLoader;
import com.example.simpleshoppingcartexample.Adapter.ProductAdapter;
import com.example.simpleshoppingcartexample.Model.ProductModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ProductAdapter.HomeCallBack {

    public static ArrayList<ProductModel> arrayList = new ArrayList<>();
    public static int cart_count = 0;
    ProductAdapter productAdapter;
    RecyclerView productRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addProduct();
        productAdapter = new ProductAdapter(arrayList, this, this);
        productRecyclerView = findViewById(R.id.product_recycler_view);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false);

//                GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        productRecyclerView.setLayoutManager(gridLayoutManager);
        productRecyclerView.setAdapter(productAdapter);

    }


    private void addProduct() {

        ProductModel productModel = new ProductModel("Screen iphone 6/6s white/black lcd touch glass on chassis with tools + glass", "10", "20", R.drawable.item_example);
        arrayList.add(productModel);

        ProductModel productModel1 = new ProductModel("Notebook battery for Acer. Compatible replacement battery, not an original battery from the manufacturer! Refer to the device and battery numbers", "20", "10", R.drawable.item_ex2);
        arrayList.add(productModel1);

        ProductModel productModel2 = new ProductModel("Amazon.com Samsung Chromebook Pro Convertible Touch Screen Laptop, 12.3 (XE510C24-K01US)", "30", "10", R.drawable.item_ex3);
        arrayList.add(productModel2);

        ProductModel productModel3 = new ProductModel("Amazon.com HP 15.6\" HD 2019 New Touch-Screen Laptop Notebook Computer, Intel Pentium Quad-Core N5000 (up to 2.7 GHz)", "40", "20", R.drawable.item_ex1);
        arrayList.add(productModel3);

        ProductModel productModel12 = new ProductModel("Kingston DDR4 4G 8G 16G Laptop Memory RAM 2133 2400 Memoria DRAM Stick for Notebook 100% Original", "50", "10", R.drawable.item_ex11);
        arrayList.add(productModel12);

        ProductModel productModel23 = new ProductModel("pecification: Battery type: Li-ion Voltage: 14.8V(Compatible with 14.4V)", "60", "10", R.drawable.item_ex5);
        arrayList.add(productModel23);

        ProductModel productModel4 = new ProductModel("Amazon.com ASUS UL80Vt-A1 14-Inch Thin and Light Black Laptop (11.5 Hours of Battery Life", "70", "20", R.drawable.item_example);
        arrayList.add(productModel4);

        ProductModel productModel14 = new ProductModel("Snapdeal Dell Genuine Original Box Pack Battery for Dell Vostro 1015 1015N 1088 1088N A840", "80", "10", R.drawable.item_ex4);
        arrayList.add(productModel14);

        ProductModel productModel25 = new ProductModel("Snapdeal Dell Genuine Original Box Pack Battery for Dell Vostro 1015 1015N 1088 1088N A840", "90", "10", R.drawable.item_ex3);
        arrayList.add(productModel25);

        ProductModel productModel5 = new ProductModel("Amazon.com JIAZIJIA L15M3PB0 Laptop Battery Replacement for Lenovo Flex", "100", "20", R.drawable.item_ex2);
        arrayList.add(productModel5);

        ProductModel productModel16 = new ProductModel("Gomarty WDX0R Laptop Battery for Dell Inspiron A replacement Dell battery costs $125, Or I could find a 3rd-party battery in the $20-30 range. Are these cheap batteries", "200", "10", R.drawable.item_example);
        arrayList.add(productModel16);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.cart_action);
        menuItem.setIcon(Converter.convertLayoutToImage(MainActivity.this, cart_count, R.drawable.ic_shopping_cart_white_24dp));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.cart_action:
                if (cart_count < 1) {
                    Toast.makeText(this, "there is no item in cart", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(this, CartActivity.class));
                }
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }


    @Override
    protected void onStart() {
        super.onStart();
        invalidateOptionsMenu();
    }

    @Override
    public void updateCartCount(Context context) {
        invalidateOptionsMenu();
    }
}
