package vn.edu.ntu.tinhcv_dt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText edtd,edtch, edta, edtb;
    TextView tvd, tvch, tva, tvb, tvkq;
    Button btncv, btndt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtch= (EditText) findViewById(R.id.edtch);
        edtd= (EditText) findViewById(R.id.edtd);
        edta= (EditText) findViewById(R.id.edta);
        edtb= (EditText) findViewById(R.id.edtb);
        tvd= (TextView) findViewById(R.id.tvd);
        tva= (TextView) findViewById(R.id.tva);
        tvb= (TextView) findViewById(R.id.tvb);
        tvkq= (TextView) findViewById(R.id.tvkq);
        tvch= (TextView) findViewById(R.id.tvch);
        btncv=(Button) findViewById(R.id.btncv);
        btndt=(Button) findViewById(R.id.btndt);


    }
    public void xulytinhchuvi(View v) {
        String sa = edta.getText().toString();
        String sb = edtb.getText().toString();
        int a = Integer.parseInt(sa);
        int b = Integer.parseInt(sb);
        int tinh = 2 * (a + b);
        String chuvi = String.valueOf(tinh);
        tvkq.setText("tổng là:" + chuvi);
    }
    public void xulytinhdientich(View v) {
        String ch = edtch.getText().toString();
        String day = edtd.getText().toString();
        int c = Integer.parseInt(ch);
        int d = Integer.parseInt(day);
        int tinh = c * d;
        String dientich = String.valueOf(tinh);
        tvkq.setText("tổng là:" + dientich);
    }
}