package com.farm.ngo.farm.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.farm.ngo.farm.Holder.UsingSQLiteHelper;
import com.farm.ngo.farm.Model.Pwalyone;
import com.farm.ngo.farm.R;
import com.farm.ngo.farm.pwalyone;

import java.io.IOException;
import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwalyone);
        RecyclerView rc=(RecyclerView)findViewById(R.id.pr);
        ArrayList<Pwalyone> pp=new ArrayList<>();
        try {
            pp=new UsingSQLiteHelper(this).getPwalyoneList("farmshop");
        } catch (IOException e) {
            e.printStackTrace();
        }
        com.farm.ngo.farm.Adapter.addressAdapter adapter=new com.farm.ngo.farm.Adapter.addressAdapter(this,pp);
        rc.setAdapter(adapter);
        LinearLayoutManager k=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        rc.setLayoutManager(k);

    }
}