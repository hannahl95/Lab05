package edu.calvin.hel7.lab5;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by hannahludema on 10/7/16.
 */
public class SettingsFragment extends PreferenceFragment {

    /**
     * Create part of the settings page
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

}
