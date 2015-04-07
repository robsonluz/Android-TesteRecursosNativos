package fae.edu.testerecursosnativos;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class CameraActivity extends ActionBarActivity {

	private static final int TAKE_PICTURE = 0;

	private Uri outputFileUri;
	private ImageView imageView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);
		imageView = (ImageView) findViewById(R.id.imageView1);

		Button btnFullPicture = (Button) findViewById(R.id.btnFullPicture);
		btnFullPicture.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				// Arquivo onde ser� armazenada a foto.
				File file = new File(Environment.getExternalStorageDirectory(), "test.jpg");
				outputFileUri = Uri.fromFile(file);

				// Gera um intent para abrir a activity de camera padr�o do android.
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);

				// Inicia a activity de camera padr�o do android.
				startActivityForResult(intent, TAKE_PICTURE);
			}
		});

		Button btnPicture = (Button) findViewById(R.id.btnPicture);
		btnPicture.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivityForResult(new Intent(
						MediaStore.ACTION_IMAGE_CAPTURE), TAKE_PICTURE);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == TAKE_PICTURE) {
			
			if (data != null) { //Thumb da imagem
				if (data.hasExtra("data")) {
					Bitmap thumbnail = data.getParcelableExtra("data");
					imageView.setImageBitmap(thumbnail);
				}
			} else {//Imagem full
				// Redimensiona a imagem para o tamanho da imageView.
				int width = imageView.getWidth();
				int height = imageView.getHeight();
				BitmapFactory.Options factoryOptions = new BitmapFactory.Options();
				factoryOptions.inJustDecodeBounds = true;
				BitmapFactory.decodeFile(outputFileUri.getPath(),
						factoryOptions);
				int imageWidth = factoryOptions.outWidth;
				int imageHeight = factoryOptions.outHeight;
				int scaleFactor = Math.min(imageWidth / width, imageHeight
						/ height);
				factoryOptions.inJustDecodeBounds = false;
				factoryOptions.inSampleSize = scaleFactor;
				factoryOptions.inPurgeable = true;
				
				//Pega o bitmap do arquivo que foi salva a foto
				Bitmap bitmap = BitmapFactory.decodeFile(
						outputFileUri.getPath(), factoryOptions);

				imageView.setImageBitmap(bitmap);
			}
		}
	}

}
