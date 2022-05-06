package vn.edu.ntu.chuyendocsangdof;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText pt1, pt2;
    Button button, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pt1 = (EditText) findViewById(R.id.pt1);
        pt2 = (EditText) findViewById(R.id.pt2);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

    }
        public void xulychuyndoiCsangF(View v){
            String C= button.getText().toString();
            int c = Integer.parseInt(C);
            int doiF = c * (9/5) +32;
            String chuoiDoi= String.valueOf(doiF);
            pt1.setText(chuoiDoi);
        }


        public void xulychuyndoiFsangC(View v){
            String F= button2.getText().toString();
            int f = Integer.parseInt(F);
            int doiC =(f-32) * (5/9);
            String chuoiDoi= String.valueOf(doiC);
            pt2.setText(chuoiDoi);


        }
}