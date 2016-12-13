package com.example.igx.problem1;

import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity /* implements Something1, Something2 */ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_getLocation = (Button) findViewById(R.id.btn_getLocation);
        Button btn_getSensors = (Button) findViewById(R.id.btn_getSensors);
        Button btn_sendMessage = (Button) findViewById(R.id.btn_sendMessage);

        final TextView text_selectedData = (TextView) findViewById(R.id.text_selectedData);
        final TextView text_selectedType = (TextView) findViewById(R.id.text_selectedType);
        final EditText edit_phoneNumber = (EditText) findViewById(R.id.edit_phoneNumber);

        btn_getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UseGPS gps = new UseGPS(v.getContext());
                gps.getGPS();

                text_selectedType.setText("LOCATION");
                text_selectedData.setText(gps.lati + ", " + gps.longi);
            }
        });

        btn_getSensors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UseAccSensor accsensor = new UseAccSensor(v.getContext(), text_selectedData);
                accsensor.getAcc();
                UseGyroSensor gyrosensor = new UseGyroSensor(v.getContext());
                gyrosensor.getGyro();

                text_selectedType.setText("SENSOR");
                text_selectedData.setText("0걸음");
                //text_selectedData.setText("Acceleration :" + accsensor.x + ", " + accsensor.y + ", " + accsensor.z + "\nGyro :" + gyrosensor.x + ", " + gyrosensor.y + ", " + gyrosensor.z);
            }
        });

        btn_sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SENDTO);

            }
        });
    }
}
