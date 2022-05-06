package vn.edu.ntu.autocompleteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private AutoCompleteTextView auto1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         String[] NATIONS = new String[]
                {
                "Viet Nam", "Australia", "england", "Albania", "USA", "Algeria"
        };

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,NATIONS);

        AutoCompleteTextView autoTV = (AutoCompleteTextView) findViewById(R.id.auto1);
        autoTV.setAdapter(adapter);

    }
}