package edu.tomerbu.lec4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ToppingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppings);

        findViewById(R.id.button_tomatoes).setOnClickListener(this::gotoSummary);
        findViewById(R.id.button_onions).setOnClickListener(this::gotoSummary);
        findViewById(R.id.button_olives).setOnClickListener(this::gotoSummary);
    }

    private void gotoSummary(View v) {
        Button btn = (Button) v;
        String topping = btn.getText().toString();

        Intent intent = new Intent(this, SummaryActivity.class);

        intent.putExtra(Constants.EXTRA_TOPPINGS, topping);

        //get the size and name from the previous screen:
        String size = getIntent().getStringExtra(Constants.EXTRA_PIZZA_SIZE);
        String userName = getIntent().getStringExtra(Constants.EXTRA_USER_NAME);

        //pass the size and name as well:
        intent.putExtra(Constants.EXTRA_PIZZA_SIZE, size);
        intent.putExtra(Constants.EXTRA_USER_NAME, userName);

        //start the next activity:
        startActivity(intent);
    }
}
