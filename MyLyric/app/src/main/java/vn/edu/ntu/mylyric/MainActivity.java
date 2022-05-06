package vn.edu.ntu.mylyric;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data
        ArrayList<String> listSong = new ArrayList<String>();
        listSong.add("uoc_gi");
        listSong.add("mong_uoc");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
         ListView lv = (ListView)findViewById(R.id.listview_cac_bi_hat);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // do sth
                // cần làm lấy về tên bài hát
                String tenBaiHat = listSong.get(i);
                // chueyern Activity
                Intent intenBH = new Intent(MainActivity.this,ShowlyricActivity.class);
                // gói tên vào
                intenBH.putExtra("tenBH", tenBaiHat);
                // đẩy sang
                startActivity(intenBH);

            }
        });
    }


}