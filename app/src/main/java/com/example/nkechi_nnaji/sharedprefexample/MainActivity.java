package com.example.nkechi_nnaji.sharedprefexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
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

        //Adding a page color switch listener
        pageColorSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                //Creating a local/  activity level SP for changing page color
                SharedPreferences sharedPreference = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreference.edit();
                //Key = green, Value = isChecked which is a boolean checking if the switch is checked or not
                editor.putBoolean("green",isChecked);
                editor.apply();
                //Add a tenary expression to choose pagelayout background color
                pageLayout.setBackgroundColor(isChecked? Color.GREEN: Color.WHITE);
            }
        });
    }

    //Creating & saving content to SP file @ Application level
    public void saveAccountData(View view) {
        //Create SP object
        SharedPreferences sharedPreference = getSharedPreferences(getPackageName()+ Constants.PREF_FILE_NAME, Context.MODE_PRIVATE);
        //Add editor interface to enable editting data in the SP file
        SharedPreferences.Editor editor = sharedPreference.edit();
        //Store values in the editor
        editor.putString(Constants.KEY_NAME, etName.getText().toString());
        editor.putString(Constants.KEY_PROFESSION, etProfession.getText().toString());
        editor.putInt(Constants.KEY_PROF_ID, 287);
        //Apply changes to SP file
        editor.apply();// Changes are made asynchronously i.e in the background
        //editor.commit(); Changes are made synchronously NOTE: Either apply or commit can be used

    }
    //Retrieving contents of saved SP file & loading in same activity
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

    public void openSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }
}
