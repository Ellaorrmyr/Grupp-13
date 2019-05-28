package se.juneday.systemetappbasic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.EditText;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import se.juneday.systemetappbasic.domain.Product;


public class ProductActivity extends AppCompatActivity implements OnClickListener {

    private static final String LOG_TAG = ProductActivity.class.getSimpleName();

    ToggleButton toggle;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_activity);
        SharedPreferences preferences;
        ToggleButton toggle = (ToggleButton) findViewById(R.id.button_favorite);

        // extract the Product pass in the bundle
        Bundle extras = getIntent().getExtras();
        Product p = (Product) extras.get("product");
        // display the product
        displayProduct(p);


        // Set a checked change listener for toggle button
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // if toggle button is enabled/on

                    // Make a toast to display "function"
                    Toast.makeText(getApplicationContext(),
                            "Added to favorite", Toast.LENGTH_SHORT).show();
                } else {
                    // If toggle button is disabled/off

                    // Make a toast to display "function"
                    Toast.makeText(getApplicationContext(),
                            "Removed from favorite", Toast.LENGTH_SHORT).show();
                }
            }
        });
    };

    private void savePreferences(String key, boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    private void savePreferences(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }


    public void onClick(View v) {

        savePreferences("CheckBox_Value", toggle.isChecked());
        if (toggle.isChecked())
            savePreferences("storedName", editText.getText().toString());

        finish();
    }

    private void setViewText(int viewId, String label, String text) {
      TextView tv = findViewById(viewId);
      tv.setText(Html.fromHtml("<b>"+label+"</b>: " + text));
      Log.d(LOG_TAG, " * " + label + " | " + text);
    }

    private void displayProduct(Product product) {
      setViewText(R.id.product_name, getString(R.string.name), product.name());
      setViewText(R.id.product_volume, getString(R.string.volume), String.valueOf(product.volume()));
      setViewText(R.id.product_alcohol, getString(R.string.alcohol), String.valueOf(product.alcohol()));
      setViewText(R.id.product_price, getString(R.string.price), String.valueOf(product.price()));
      setViewText(R.id.product_group, getString(R.string.productGroup), String.valueOf(product.productGroup()));
    }

  }

