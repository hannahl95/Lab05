package edu.calvin.hel7.lab5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private boolean preference = false;

    /**
     * Create an instance of the main page with the default settings
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        showPreferences();
    }

    /**
     *  Sets the preference text views value depending on the setting
     */
    private void showPreferences() {
        TextView preferenceTextView = (TextView) findViewById(R.id.preferenceTextView);
        preferenceTextView.setText( "Preference: " + prefs.getBoolean("preference", false));
    }

    /**
     * On pause, save your preferences
     */
    @Override
    public void onPause() {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("preference", preference);
        editor.commit();
        super.onPause();
    }

    /**
     * On resume, get your previous preference
     */
    @Override
    public void onResume(){
        super.onResume();
        preference = prefs.getBoolean("preference", false);
        showPreferences();
    }

    /**
     * Create the options menu
     *
     * @param menu
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    /**
     * When an option is selected from the menu, go to the respective page
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_settings:
                startActivity( new Intent( getApplicationContext(), SettingsActivity.class));
                return true;
            case R.id.menu_about:
                startActivity( new Intent( getApplicationContext(), AboutActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
