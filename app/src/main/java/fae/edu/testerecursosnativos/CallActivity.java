package fae.edu.testerecursosnativos;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class CallActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_call);
		
		Button btnTelefone = (Button) findViewById(R.id.btnTelefone);
		btnTelefone.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				abrirDiscador();
			}
		});
		
		Button btnSms = (Button) findViewById(R.id.btnSms);
		btnSms.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				abrirSms();
			}
		});
		
		Button btnEmail = (Button) findViewById(R.id.btnEmail);
		btnEmail.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				abrirEmail();
			}
		});
		
	}
	
	private void abrirDiscador() {
		Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9999-9999"));
		startActivity(intent);
	}
	
	private void abrirSms() {
		Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:9999-9999"));
		intent.putExtra("sms_body", "Texto do SMS");
		startActivity(intent);		
	}
	
	private void abrirEmail() {
		Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:rrr@email.com"));
		startActivity(intent);		
	}	
	
}
