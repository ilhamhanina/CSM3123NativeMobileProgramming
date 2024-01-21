package com.example.task2lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager senseMan;
    Sensor lightSensor;
    TextView textview;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview=(TextView) findViewById(R.id.textview);
        senseMan =(SensorManager) getSystemService(SENSOR_SERVICE);
        lightSensor = senseMan.getDefaultSensor(Sensor.TYPE_LIGHT);

        if (lightSensor != null){
            Toast.makeText(this, "Light Sensor Found", Toast.LENGTH_LONG).show();
            senseMan.registerListener(this, lightSensor,SensorManager.SENSOR_DELAY_NORMAL);
        }else{
           Toast.makeText(this, "Light Sensor not Fount in device", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        textview.setText(Float.toString(sensorEvent.values[0]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        senseMan.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        senseMan.registerListener(this, lightSensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
}


