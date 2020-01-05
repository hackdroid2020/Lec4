package edu.tomerbu.lec4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    //property:
    private TextView tvSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        tvSummary = findViewById(R.id.text_summary);

        String size = getIntent().getStringExtra(Constants.EXTRA_PIZZA_SIZE);
        String topping = getIntent().getStringExtra(Constants.EXTRA_TOPPINGS);
        String userName = getIntent().getStringExtra(Constants.EXTRA_USER_NAME);

        tvSummary.setText("Pizza size: " + size + "\n" +
                          "Toppings: " + topping + "\n" +
                          "Name: " + userName );
    }
}
