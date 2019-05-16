package se.juneday.systemetappbasic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button Button2;
    private Button button1;
    private Button buttonsubmit;
    private RatingBar rating_b;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onButtonClickListener();


        Button2 = (Button) findViewById(R.id.button2);
        button1 = (Button) findViewById(R.id.button1);
        rating_b =(RatingBar) findViewById(R.id.ratingbar);

    }

    public void onResume() {
        super.onResume();
        addListenerOnButton();
    }

    public void addListenerOnButton(){
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((Button) v).isClickable()) {
                    setContentView(R.layout.second_activity);
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(i);
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((Button) v).isClickable()) {
                    setContentView(R.layout.third_activity);
                    Intent i = new Intent(MainActivity.this, ThirdActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    public void onButtonClickListener() {
        rating_b = (RatingBar) findViewById(R.id.ratingbar);
        buttonsubmit = (Button) findViewById(R.id.button3);

        buttonsubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, getString(R.string.thanksToast), Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
