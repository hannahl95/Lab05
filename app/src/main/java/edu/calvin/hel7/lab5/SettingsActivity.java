package edu.calvin.hel7.lab5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hannahludema on 10/7/16.
 */
public class SettingsActivity extends AppCompatActivity {

    /**
     * Create the settings page
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
    }
}
