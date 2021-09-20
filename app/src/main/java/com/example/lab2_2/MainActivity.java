package com.example.lab2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1;
    EditText num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
    }

    public void add (View view) {
        int n1 = parseNum(num1);
        int n2 = parseNum(num2);
        sendResult(n1 + n2);
        //Log.i("Info", Integer.toString(n1+n2));
    }

    public void sub (View view) {
        int n1 = parseNum(num1);
        int n2 = parseNum(num2);
        sendResult(n1 - n2);
        //Log.i("Info", Integer.toString(n1-n2));
    }

    public void mult (View view) {
        int n1 = parseNum(num1);
        int n2 = parseNum(num2);
        sendResult(n1 * n2);
        //Log.i("Info", Integer.toString(n1*n2));
    }

    public void div (View view) {
        int n1 = parseNum(num1);
        int n2 = parseNum(num2);
        sendResult(n1 / n2);
        //Log.i("Info", Integer.toString(n1/n2));
    }

    public int parseNum(TextView text) {
        try {
            return Integer.valueOf(text.getText().toString());
        }
        catch (Exception ex){
            Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("result", "Invalid Input");
            startActivity(intent);
            return 0;
        }
    }

    public void sendResult(int result) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("result", Integer.toString(result));
        startActivity(intent);
    }

}