package com.example.nkechi_nnaji.sharedprefexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etProfession;
    private TextView txvName, txvProfession;
    private Switch pageColorSwitch;
    private LinearLayout pageLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etProfession = (EditText) findViewById(R.id.etProfession);

        txvName = (TextView) findViewById(R.id.txvName);
        txvProfession = (TextView) findViewById(R.id.txvProfession);

        pageLayout = (LinearLayout) findViewById(R.id.pageLayout);
        pageColorSwitch = (Switch) findViewById(R.id.pageColorSwitch);
    }

    //Creating & saving content to SP file @ Activity level
    public void saveAccountData(View view) {
        //Create SP object
        SharedPreferences sharedPreference = getPreferences(Context.MODE_PRIVATE);
        //Add editor interface to enable editting data in the SP file
        SharedPreferences.Editor editor = sharedPreference.edit();
        //Store values in the editor
        editor.putString("name", etName.getText().toString());
        editor.putString("profession", etProfession.getText().toString());
        editor.putInt("prof_id", 287);
        //Apply changes to SP file
        editor.apply();// Changes are made asynchronously i.e in the background
        //editor.commit(); Changes are made synchronously NOTE: Either apply or commit can be used

    }
    //Retrieving contents of saved SP file & loading in same activity
    public void loadAccountData(View view) {
        //Create SP object
        SharedPreferences sharedPreference = getPreferences(Context.MODE_PRIVATE);
        //Retrieve/extract values from the SP file
        String name = sharedPreference.getString("name", "N/A");
        String profession = sharedPreference.getString("profession","N/A");
        int profId = sharedPreference.getInt("prof_id",0);

        txvName.setText(name);
        String profStr = profession + " - " + profId;
        txvProfession.setText(profStr);
    }

    public void openSecondActivity(View view) {
    }
}
