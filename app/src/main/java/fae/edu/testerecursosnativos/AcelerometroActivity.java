package fae.edu.testerecursosnativos;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class AcelerometroActivity extends ActionBarActivity implements SensorEventListener {

	private SensorManager sensorManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_acelerometro);
		//Acessamos os sensores do dispositivo a partir deste objeto
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	}

	
	//Chamado quando o usu�rio entra desta tela
	@Override
	protected void onResume() {
		super.onResume();
		//Registrando o listener para o aceler�metro
		Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		if(accelerometer!=null) {//Verifica se existe este sensor no dispositivo
			sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
		}
		
		//Registrando o listener para o gyrosc�pio
		Sensor gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
		if(gyro!=null) {//Verifica se existe este sensor no dispositivo
			sensorManager.registerListener(this, gyro, SensorManager.SENSOR_DELAY_NORMAL);
		}		
	}

	//Chamado quando o usu�rio sai desta tela
	@Override
	protected void onPause() {
		//Remove o listener dos sensores
		sensorManager.unregisterListener(this);
		super.onPause();
	}



	@Override
	public void onSensorChanged(SensorEvent event) {
		float values[] = event.values;
		float xaxis = values[0];
		float yaxis = values[1];
		float zaxis = values[2];
		
		String text = "x: " + xaxis + "\n";
		text 	   += "y: " + yaxis + "\n";
		text       += "z: " + zaxis + "\n";
		
		if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER) {
			TextView textViewAccelerometer = (TextView) findViewById(R.id.textViewAccelerometer);
			textViewAccelerometer.setText(text);
		}
		if(event.sensor.getType()==Sensor.TYPE_GYROSCOPE) {
			TextView textViewGyro = (TextView) findViewById(R.id.textViewGyro);
			textViewGyro.setText(text);
		}
	}
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}
	

}
