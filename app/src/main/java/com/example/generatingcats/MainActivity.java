package com.example.generatingcats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.generatingcats.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    int maxCatsNumber=60;

    String[] cats_array=new String[maxCatsNumber];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSpinner();

        binding.exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.generateCatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),CatActivity.class);
                intent.putExtra("CATS_NUMBER",binding.Spinner.getSelectedItemPosition());
                startActivity(intent);
            }
        });

    }

    private void setSpinner(){
        for(int i=0;i<maxCatsNumber;i++){
            if(i==0) cats_array[i]=(i+1)+" cat";
            else cats_array[i]=(i+1)+" cats";
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.row, R.id.number_cat,cats_array);
        binding.Spinner.setAdapter(adapter);
    }
}