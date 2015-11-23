package com.platega.angel.diarodeviaxe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.platega.angel.diariodeviaxe.utiles.Constantes;
import com.platega.angel.diarioviaxe.almacenamento.XestionBD;

import java.io.File;
import java.io.IOException;

public class Principal extends Activity {


    // VERIFICAMOS QUE GOOGLE PLAY SERVICES ESTA INSTALADO. SE NON NON TEMOS LOCALIZACION

    private void comprobarGooglePlayServices() {
    }


    // Creamos o cartafol onde se vai gardar toda a información /SD_CARD/DIARIO_DE_VIAXE/. Está definido na clase Constantes
    private void prepararCartafois() {
        File sdCard = Environment.getExternalStorageDirectory();
        File diarioViaxe = new File(sdCard.getAbsolutePath() + "/" + Constantes.CARTAFOL_GARDAR_DATOS);
        diarioViaxe.mkdir();


    }

    public void eventoClick(View view) {


        Intent intento;
        switch (view.getId()) {
            case R.id.button_principal_engadirLugar:

                intento = new Intent(this, AltaLugar.class);
                startActivity(intento);
                break;
            case R.id.button_principal_verLugares:
                intento = new Intent(this, ListaLugares.class);
                startActivity(intento);
                break;
            case R.id.button_principal_sair:
                finish();
                break;
        }


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();
        if (id == R.id.menu_principal_preferencias) {
            Intent intent = new Intent(getApplicationContext(), PantallaPreferencias.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.menu_principal_descargar) {
//            	DescargarArquivoInternet descargar = new DescargarArquivoInternet(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Copia a base de datos dende /assets/ ó cartafol /data/data/com.platega.angel.diarodeviaxe/databases/ en caso de que non exista.
    private void copiarBD() {
        try {
            XestionBD.copiarBaseDatos(getApplicationContext(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menuprincipal, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_principal);


        comprobarGooglePlayServices();
        prepararCartafois();
        copiarBD();
    }
}
