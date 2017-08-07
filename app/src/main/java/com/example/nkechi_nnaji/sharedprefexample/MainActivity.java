package com.example.nkechi_nnaji.sharedprefexample;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button redButton, greenButton, yellowButton, purpleButton, blueButton, blackButton, orangeButton;
    Toolbar mToolbar;
    SharedPreferences toolbarColor;
    SharedPreferences.Editor meditor;
    int selectedColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar =(Toolbar) findViewById(R.id.toolbar);
        redButton=(Button)findViewById(R.id.redBtn);
        greenButton=(Button)findViewById(R.id.greenBtn);
        yellowButton=(Button)findViewById(R.id.yellowBtn);
        purpleButton=(Button)findViewById(R.id.purpleBtn);
        blueButton=(Button)findViewById(R.id.blueBtn);
        blackButton=(Button)findViewById(R.id.blackBtn);
        orangeButton=(Button)findViewById(R.id.orangeBtn);

        mToolbar.setTitle(getResources().getString(R.string.app_name));
        if(getColor() != getResources().getColor(R.color.colorPrimary)){
            mToolbar.setBackgroundColor(getColor());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                getWindow().setStatusBarColor(getColor());
            }
        }

        redButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                mToolbar.setBackgroundColor(getResources().getColor(R.color.red));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.red));
                }
                setToolbarColor(getResources().getColor(R.color.red));
            }
        });

        greenButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                mToolbar.setBackgroundColor(getResources().getColor(R.color.green));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.green));
                }
                setToolbarColor(getResources().getColor(R.color.green));
            }

        });

        yellowButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                mToolbar.setBackgroundColor(getResources().getColor(R.color.yellow));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.yellow));
                }
                setToolbarColor(getResources().getColor(R.color.yellow));
            }

        });

        purpleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                mToolbar.setBackgroundColor(getResources().getColor(R.color.purple));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.purple));
                }
                setToolbarColor(getResources().getColor(R.color.purple));
            }
        });

        blueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                mToolbar.setBackgroundColor(getResources().getColor(R.color.blue));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.blue));
                }
                setToolbarColor(getResources().getColor(R.color.blue));
            }
        });

        blackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {

                mToolbar.setBackgroundColor(getResources().getColor(R.color.black));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.black));
                }
                setToolbarColor(getResources().getColor(R.color.black));
            }
        });

        orangeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {

                mToolbar.setBackgroundColor(getResources().getColor(R.color.orange));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.orange));
                }
                setToolbarColor(getResources().getColor(R.color.orange));
            }
        });

    }

    private void setToolbarColor(int color)
    {
        toolbarColor =getSharedPreferences("ToolbarColor", MODE_PRIVATE);
        meditor =toolbarColor.edit();
        meditor.putInt("color", color);
        meditor.apply();
    }

    private int getColor(){
        toolbarColor =getSharedPreferences("ToolbarColor", MODE_PRIVATE);
        selectedColor=toolbarColor.getInt("color", getResources().getColor(R.color.colorPrimary));  //Default color if no color choosen
        return selectedColor;
    }
}
