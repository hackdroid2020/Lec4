package edu.tomerbu.lec4;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

//refactor -> rename the activity (shift + f6)
//Mac: fn + shift + f6
public class LoginActivity extends AppCompatActivity {

    //properties:
    private EditText etName;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //find Views: + on***Listeners

        etName = findViewById(R.id.edit_name);
        btnNext = findViewById(R.id.button_next);

        btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(this, PizzaSizeActivity.class);

            //put extras:
            String name = etName.getText().toString(); //Editable

            if (name.isEmpty() || name.length() < 2) {
                etName.setError("Name is required");
            } else {
                intent.putExtra(Constants.EXTRA_USER_NAME,  name);
                startActivity(intent);
            }

        });
    }

    //menu creation and on item selected code
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
