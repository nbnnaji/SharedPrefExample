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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView txvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvDisplay =(TextView) findViewById(R.id.txvDisplay);
    }


    public void saveObjectType(View view) {

        Employee employee = getEmployeeObject();

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //Serialization using GSON library
        Gson gson = new Gson();
        //Convert non-primitive data (Employee object) to a Json String (primitive data)
        String jsonString = gson.toJson(employee, Employee.class);
        Log.i(TAG+ "Save", jsonString);
        editor.putString("employee_key", jsonString);
        editor.apply();



    }

    public void loadObjectType(View view) {
        //Extract Json string being stored in SP file
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String jsonString = sharedPreferences.getString("employee_key","N/A");
        Log.i(TAG+ "Load", jsonString);

        //Deserialization
        Gson gson = new Gson();
       Employee employee =  gson.fromJson(jsonString, Employee.class);

        displayText(employee);
    }



    public void saveGenericType(View view) {
        Employee employee = getEmployeeObject();
        Foo<Employee> foo = new Foo<>();
        foo.setObject(employee);

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //Serialization using GSON library
        Gson gson = new Gson();
        Type type = new TypeToken<Foo<Employee>>(){}.getType();

        //Convert non-primitive data (Employee object) to a Json String (primitive data)
        //Due to java type erasure, generic type data is lost so Foo.class won't work
        String jsonString = gson.toJson(foo, type);
        Log.i(TAG+ "Save", jsonString);
        editor.putString("foo_key", jsonString);
        editor.apply();


    }

    public void loadGenericType(View view) {

        //Extract Json string being stored in SP file
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String jsonString = sharedPreferences.getString("foo_key","N/A");
        Log.i(TAG+ "Load", jsonString);

        //Deserialization
        Gson gson = new Gson();
        Type type = new TypeToken<Foo<Employee>>(){}.getType();
        Foo<Employee> employeefoo =  gson.fromJson(jsonString, type);
        Employee employee = employeefoo.getObject();

        displayText(employee);

    }

    private Employee getEmployeeObject(){

        Employee employee = new Employee();
        employee.setName("Nkechi Nnaji");
        employee.setProfession("Software Engineer");
        employee.setProfId(287);
        employee.setRoles(Arrays.asList("Developer", "Admin"));

        return employee;
    }

    private void displayText(Employee employee) {

        //Add if statement incase the employee object is null
        if(employee == null)
            return;
       String displayTxt = employee.getName()
               + "\n" + employee.getProfession()
               + "\n" + employee.getProfId()
               + "\n" + employee.getRoles().toString();

        txvDisplay.setText(displayTxt);

    }
}
