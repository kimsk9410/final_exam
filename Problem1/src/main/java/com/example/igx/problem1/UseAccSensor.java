package com.example.igx.problem1;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by lsn94 on 2016-12-13.
 */

public class UseAccSensor implements SensorEventListener {

    Context mContext;
    int count = 0;
    double x, y, z;
    int up=0, down=0;
    double acceleration;
    TextView tv;

    UseAccSensor(Context mContext, TextView tv){
        this.mContext = mContext;
        this.tv = tv;
    }

    public void getAcc(){
        SensorManager mSensorManager = (SensorManager)mContext.getSystemService(Context.SENSOR_SERVICE);
        Sensor accSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, accSensor, Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x = event.values[0];
        y = event.values[1];
        z = event.values[2];

        acceleration = Math.sqrt(x*x + y*y + z*z);

        if(acceleration - 9.8 > 5){
            up = 1;
        }
        if(up == 1 && 9.8 - acceleration > 5){
            down = 1;
        }
        if(down == 1){
            count++;
            up = 0;
            down = 0;
            tv.setText(count+"걸음");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
