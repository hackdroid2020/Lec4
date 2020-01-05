package edu.tomerbu.lec4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PizzaSizeActivity extends AppCompatActivity {

    //properties:
    private Button btnSmall;
    private Button btnMedium;
    private Button btnLarge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_size);
        //find views:
        btnSmall = findViewById(R.id.button_small);
        btnMedium = findViewById(R.id.button_medium);
        btnLarge = findViewById(R.id.button_large);

        //set On click: method reference:
        btnSmall.setOnClickListener(this::gotoToppings);
        btnMedium.setOnClickListener(this::gotoToppings);
        btnLarge.setOnClickListener(this::gotoToppings);
    }

    //View is the base class for all android widgets
    private void gotoToppings(View v) {
        Button btn = (Button) v;

        //get the userName from the intent
        String userName = getIntent().getStringExtra(Constants.EXTRA_USER_NAME);
        Intent intent = new Intent(this, ToppingsActivity.class);

        //we know that the view is a Button

        //now we can get it's Text
        String size = btn.getText().toString();
        intent.putExtra(Constants.EXTRA_PIZZA_SIZE, size);
        intent.putExtra(Constants.EXTRA_USER_NAME, userName);
        startActivity(intent);
    }
}
