package com.example.igx.problem1;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

/**
 * Created by lsn94 on 2016-12-13.
 */

public class UseGyroSensor implements SensorEventListener {
    Context mContext;
    double x,y,z;

    UseGyroSensor(Context mContext){
        this.mContext = mContext;
    }

    public void getGyro(){
        SensorManager mSensorManager = (SensorManager)mContext.getSystemService(Context.SENSOR_SERVICE);
        Sensor accSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        mSensorManager.registerListener(this, accSensor, Sensor.TYPE_GYROSCOPE);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x = event.values[0];
        y = event.values[1];
        z = event.values[2];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
