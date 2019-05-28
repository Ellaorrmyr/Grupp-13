package se.juneday.systemetappbasic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;

public class MainActivity extends AppCompatActivity {
    private Button Over20;
    private Button Under20;



    //added
    // these two variables will be used by SharedPreferences
    private static final String FILE_NAME = "file_lang"; // preference file name
    private static final String KEY_LANG = "key_lang"; // preference key
    // added

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // load language after super and before setContentView
        loadLanguage();
        setContentView(R.layout.activity_main);



        Over20 = findViewById(R.id.button2);
        Under20 = findViewById(R.id.button1);




    }

    private void saveLanguage(String lang) {
        // we can use this method to save language
        // SharedPreferences are used to store data (as key-value pair) about which language the user chose
        // when he/she accessed the app last time
        SharedPreferences preferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_LANG, lang);
        editor.apply();
        // we have saved
        // recreate activity after saving to load the new language, this is the same
        // as refreshing activity to load new language

        recreate();

    }
    private void loadLanguage() {
        // a method to load language
        // this method should be called before setContentView() method of the onCreate method
        // language preference data comes from a tutorial
        Locale locale = new Locale(getLangCode());
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }
    // the method is used to get the language code (default value is "en" as in English
    private String getLangCode() {
        SharedPreferences preferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        String langCode = preferences.getString(KEY_LANG, "en");
        // save english 'en' as the default language
        return langCode;
    }
    // for creating a visible menu in the Activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.language_menu, menu);
        return true;
    }
    // depending on which option of the menu is selected, call saveLanguage method with the chosen language
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_english:
                saveLanguage("en");
                break;

            case R.id.action_swedish:
                saveLanguage("sv");
                break;


        }
        return true;
    }


    public void onResume() {
        super.onResume();
        addListenerOnButton();
    }

    public void addListenerOnButton(){
        Over20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.isClickable()) {
                    setContentView(R.layout.second_activity);
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(i);
                }
            }
        });

        Under20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.isClickable()) {
                    setContentView(R.layout.third_activity);
                    Intent i = new Intent(MainActivity.this, ThirdActivity.class);
                    startActivity(i);
                }
            }
        });
    }


}
