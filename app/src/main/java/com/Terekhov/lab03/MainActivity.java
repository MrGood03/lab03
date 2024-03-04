package com.Terekhov.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.lab03.R;

public class MainActivity extends AppCompatActivity {
Spinner toSpin;
Spinner fromSpin;
EditText fromEnter;
TextView toTv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromSpin=findViewById(R.id.FromSp);
        toSpin=findViewById(R.id.ToSp);
        fromEnter=findViewById(R.id.FromEnter);
        toTv=findViewById(R.id.ToTv);

        ArrayAdapter <String> adp = new <String> ArrayAdapter (this, android.R.layout.simple_list_item_1);

        adp.add("mm");
        adp.add("cm");
        adp.add("m");
        adp.add("km");
        fromSpin.setAdapter(adp);
        toSpin.setAdapter(adp);
    }
    public void on_convert(View v)
    {
        try {


            double from = Float.parseFloat(fromEnter.getText().toString());

            String sFrom = (String) fromSpin.getSelectedItem();
            String sTo = (String) toSpin.getSelectedItem();
            double to = 0.0d;
            double m = 0.0d;

                        if (sFrom.equals("mm"))m=from/1000.0d;
                        if (sFrom.equals("cm"))m=from/1000.0d;
                        if (sFrom.equals("m"))m=from/1.0d;
                        if (sFrom.equals("km"))m=from*1000.0d;

                        if (sTo.equals("mm")) to = m * 1000.0d;
                        if (sTo.equals("cm")) to = m * 100.0d;
                        if (sTo.equals("m")) to = m * 1.0d;
                        if (sTo.equals("km")) to = m / 1000.0d;
                        toTv.setText(String.format("%.10f",to));




        }
        catch(Exception ignored)

        {
            toTv.setText("Error");

        }




    }

}