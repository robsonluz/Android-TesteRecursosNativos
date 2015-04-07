package fae.edu.testerecursosnativos;

import edu.fae.util.Utils;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * 
 * @author Robson
 *
 */
public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Utils.startActivityOnClickButton(this, R.id.btnCamera, CameraActivity.class);
		Utils.startActivityOnClickButton(this, R.id.btnAcelerometro, AcelerometroActivity.class);
		Utils.startActivityOnClickButton(this, R.id.btnGps, GPSActivity.class);
		Utils.startActivityOnClickButton(this, R.id.btnNotificacoes, NotificacoesActivity.class);
		
		Utils.startActivityOnClickButton(this, R.id.btnGForceMeter, ForceMeter.class);
		
		Utils.startActivityOnClickButton(this, R.id.btnChamadas, CallActivity.class);
	}

}
