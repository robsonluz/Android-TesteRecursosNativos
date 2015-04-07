package fae.edu.testerecursosnativos;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.content.Context;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class NotificacoesActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notificacoes);
	
		
		Button btnNovaNotificacao = (Button) findViewById(R.id.btnNovaNotificacao);
		btnNovaNotificacao.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				novaNotificacao();
			}
		});
		
		
	}
	
	private void novaNotificacao() {
		NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
			.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)
			.setSmallIcon(R.drawable.ic_launcher)
			.setTicker("Notifica��o")
			.setContentTitle("titulo")
			.setContentText("texto")
			.setContentInfo("info")
			.setWhen(System.currentTimeMillis());
		
		//Som padr�o de notifica��o
		builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));

		
		Notification notification = builder.build();
		//Um id para identifica��o da notifica��o
		int notifyID = 12312;	
		
		manager.notify(notifyID, notification);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.notificacoes, menu);
		return true;
	}

}
