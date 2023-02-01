package com.example.generatingcats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.generatingcats.databinding.ActivityCatBinding;
import com.example.generatingcats.databinding.CatBinding;

import java.util.ArrayList;
import java.util.List;

public class CatActivity extends AppCompatActivity {

    ActivityCatBinding binding;
    int catsNum=1;
    List<CatBinding> catBindings=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent=getIntent();
        catsNum=intent.getIntExtra("CATS_NUMBER",1)+1;
        createCats();

        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void createCats(){
        int[] Ids=new int[catsNum];
        for(int i=0;i<catsNum;i++){
            catBindings.add(CatBinding.inflate(getLayoutInflater()));
            catBindings.get(i).getRoot().setId(View.generateViewId());
            binding.getRoot().addView(catBindings.get(i).getRoot());
            Ids[i]=catBindings.get(i).getRoot().getId();
        }
        binding.flow.setReferencedIds(Ids);
    }
}