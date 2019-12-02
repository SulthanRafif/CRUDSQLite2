package com.example.crudsqlite2.Model;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.crudsqlite2.R;


public class Menu extends Activity implements OnClickListener {

    private Button bTambah;
    private Button bLihat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        bTambah = (Button) findViewById(R.id.button_tambah);
        bTambah.setOnClickListener(this);
        bLihat = (Button) findViewById(R.id.button_view);
        bLihat.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        // TODO Auto-generated method stub

        switch (view.getId()){
            case R.id.button_tambah :
                Intent i = new Intent(this, CreateData.class);
                startActivity(i);
                break;
            case R.id.button_view :
                Intent i2 = new Intent(this, ViewData.class);
                startActivity(i2);
                break;

        }
    }
}
