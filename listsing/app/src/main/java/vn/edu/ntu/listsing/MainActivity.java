package vn.edu.ntu.listsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

        ListView list;

        String[] maintitle = {"tên bài hát"};

        String[] subtitle = {"ca sĩ"};

        Integer[] imgid = {R.drawable.download};


        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            MyListAdapter adapter = new MyListAdapter(this, maintitle, subtitle, imgid);
            list = (ListView) findViewById(R.id.list);
            list.setAdapter(adapter);


            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // TODO Auto-generated method stub
                    if (position == 0) {
                        //code specific to first list item
                        Toast.makeText(getApplicationContext(), "Place Your First Option Code", Toast.LENGTH_SHORT).show();
                    } else if (position == 1) ;

                }
            });

        }
    }