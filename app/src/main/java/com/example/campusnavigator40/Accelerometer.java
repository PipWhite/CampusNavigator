package com.example.campusnavigator40;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

class Accelerometer {

    private double[] translation = {0, 0, 0};

    // This method can be called to get the current translation values.
    public double[] getTranslation() {
        return translation;
    }

    public interface Listener{

        void onTranslation(double tx, double ty, double tz);
    }

    private Listener listener;

    void setListener(Listener l){
        listener = l;
    }

    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorEventListener sensorEventListener;

    Accelerometer(Context context){
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);

        //TYPE_LINEAR_ACCELERATION takes the acceleration force excluding gravity
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {


                if(listener != null){
                    translation[0] = sensorEvent.values[0];
                    translation[1] = sensorEvent.values[1];
                    translation[2] = sensorEvent.values[2];
                    //[0] is acceleration along the x axis, [1] is acceleration along the y axis, [2] is acceleration along the z axis
                    // all recorded in m/s^2
                    listener.onTranslation(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]);
                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }

    public void register(){
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void unregister(){
        sensorManager.unregisterListener(sensorEventListener);
    }



}
