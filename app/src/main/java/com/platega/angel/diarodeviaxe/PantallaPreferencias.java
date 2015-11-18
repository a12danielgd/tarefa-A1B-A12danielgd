package com.platega.angel.diarodeviaxe;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceFragment;

public class PantallaPreferencias extends Activity {

    private static class SettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.pantalla_preferencias);
        }
    }
   
    @Override
     public void onCreate(Bundle savedInstanceState) {
      // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
             
              getFragmentManager().beginTransaction().replace(android.R.id.content,
                            new SettingsFragment()).commit();
    }
}
