package se.juneday.systemetappbasic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {
    private Button back;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((Button) v).isClickable()) {
                    setContentView(R.layout.third_activity);
                    Intent i = new Intent(ThirdActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}