package com.platega.angel.diarodeviaxe;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


/* ACTIVIDADES
 * 	* ANIMACIÓNS
 *  * MULTIMEDIA => CARGAR MEDIAPLAYER DE FORMA RÁPIDA
 *  		=> LIBERACION DE RECURSOS
 *  
 */ 
public class Presentacion extends Activity {

	private  MediaPlayer mediaPlayer;
	private Animation voarAvion;
	
	private void cargarAnimacions() {

		View view = (View) findViewById(R.id.layout_presentacion_LinearLayout1);
		Animation fundido = AnimationUtils.loadAnimation(this,
				R.anim.anim_presentacion_fundido);
		view.startAnimation(fundido);

		voarAvion = AnimationUtils.loadAnimation(this,
				R.anim.anim_presentacion_avion);
		view = (View) findViewById(R.id.image_presentacion_avion);
		view.startAnimation(voarAvion);

	}

	private void cargarMusica() {
		mediaPlayer = MediaPlayer.create(this, R.raw.musica);
		mediaPlayer.start();

	}
	private void liberarRecursos(){
		if (mediaPlayer.isPlaying()) mediaPlayer.stop();
		mediaPlayer.release();
		mediaPlayer = null;
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		if (mediaPlayer.isPlaying()){
			mediaPlayer.stop();
		}
		voarAvion.cancel();
		voarAvion.reset();
		voarAvion.start();
	}
	
	@Override
	protected void onResume(){
		super.onResume();

		if (!mediaPlayer.isPlaying()){
			try {
				mediaPlayer.prepare();
				mediaPlayer.start();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		voarAvion.start();
	}
	
	@Override
	protected void onDestroy(){
		super.onDestroy();
		liberarRecursos();
	}
	
	private void xestionarEventos(){
		Button btn = (Button)findViewById(R.id.button_presentacion_aceptar);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intento = new Intent(Presentacion.this,Principal.class);
				startActivity(intento);
				finish();
			}
		});
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_presentacion);
        
        cargarAnimacions();
        cargarMusica();
        xestionarEventos();
    }
}
