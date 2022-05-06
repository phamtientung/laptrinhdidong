package vn.edu.ntu.lamlai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String arr[] = {"tèo","tý","bin","bo"};
        ListView lv = (ListView) findViewById(R.id.lvperson);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, arr);
        lv.setAdapter(adapter);
        final Texview txt = (Texview) findViewById(R.id.txtselection);
    }
}