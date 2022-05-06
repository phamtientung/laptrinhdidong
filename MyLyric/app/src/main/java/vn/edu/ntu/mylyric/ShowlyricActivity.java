package vn.edu.ntu.mylyric;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ShowlyricActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showlyric);
        //
        Intent BH = getIntent();
        // lấy ra tên bài hát ==> tên file là : tenBH.txt
        String tenBai = BH.getStringExtra("tenBH");

    }
}