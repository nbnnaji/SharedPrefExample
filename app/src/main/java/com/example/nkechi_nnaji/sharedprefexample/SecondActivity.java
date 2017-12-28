package com.example.nkechi_nnaji.sharedprefexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by nkechi_nnaji on 12/27/17.
 */

public class SecondActivity extends AppCompatActivity {

    private TextView txvName, txvProfession;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txvName = (TextView) findViewById(R.id.txvName);
        txvProfession = (TextView) findViewById(R.id.txvProfession);

    }

    public void loadAccountData(View view) {
        //Create SP object
        SharedPreferences sharedPreference = getSharedPreferences(getPackageName()+ Constants.PREF_FILE_NAME, Context.MODE_PRIVATE);
        //Retrieve/extract values from the SP file
        String name = sharedPreference.getString(Constants.KEY_NAME, "N/A");
        String profession = sharedPreference.getString(Constants.KEY_PROFESSION,"N/A");
        int profId = sharedPreference.getInt(Constants.KEY_PROF_ID,0);

        txvName.setText(name);
        String profStr = profession + " - " + profId;
        txvProfession.setText(profStr);
    }

    public void clearAccountData(View view) {
    }

    public void removeProfessionKey(View view) {
    }
}
