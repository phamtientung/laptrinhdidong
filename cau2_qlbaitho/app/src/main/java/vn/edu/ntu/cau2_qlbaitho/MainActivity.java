package vn.edu.ntu.cau2_qlbaitho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase databaseBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // tạo mới / mở CSDL
        //data/data/ntu.bookman
        databaseBook =  SQLiteDatabase.openOrCreateDatabase("/data/data/vn.edu.ntu.cau2_qlbaitho/Mybook.db", null);
        // ta che hàm sau lại, ở những lần chạy sau
        // vì ta ko muốn tạo csdl lại từ đầu
        //TaoBangVaThemDuLieu();
        // themmoisach(10,"mang may tinh",50,10,"sach ve mang");
        // capnhat(2,"lập trình A đây rồi ", 100, 100, "sách quý");
        NapthovaolistView();

        Button nutThem = (Button) findViewById(R.id.btnthem);
        Button nutSua = (Button) findViewById(R.id.btnsua);
        Button nutXoa = (Button) findViewById(R.id.btnxoa);
        EditText edChon = (EditText) findViewById(R.id.edtMaChon);
        //xử lý
        nutXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String maTho = edChon.getText().toString();
                int ma = Integer.parseInt(maTho);

                xoatho(ma);

            }
        });
        nutSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // lấy mã sách vừa chọn
                String maSach = edChon.getText().toString();
                // tạo intent
                Intent intentsua = new Intent();
                // gói dữ liệu
                intentsua.putExtra("masach", maSach);
                // khỏi động SuaACtivyti
                startActivity(intentsua);
            }
        });
        nutThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentThem = new Intent();
                startActivity(intentThem);
            }
        });
    }
    void themmoitho(int ma, String ten, int sotrang,float gia,String mota )
    {
        String sqlThem = "INSERT INTO BOOKS VALUES(" + ma + "," +
                " '" + ten + " ', "+
                sotrang + ","+
                gia + " , " +
                "' " + mota + " ')";

        databaseBook.execSQL(sqlThem);

        ContentValues row = new ContentValues();
        // put (key, value); key = tên cột , value = giá trị
        row.put("BookID", ma);
        row.put("BookName", ten);
        row.put("Pase", sotrang);
        row.put("Price", gia);
        row.put("Description", mota);
        long kq = databaseBook.insert("Books", null, row);
        if(kq == -1)
            Toast.makeText(this, "không thêm được", Toast.LENGTH_LONG).show();
        else
        {
            Toast.makeText(this, "đã thêm thành công", Toast.LENGTH_LONG).show();
        }

    }
    void  xoatho(int ma)
    {
        String[] thamSoTruyen = {String.valueOf(ma)};
        int kq = databaseBook.delete("BOOkS", "BooKID = ?", thamSoTruyen);
        if(kq == 0)
            Toast.makeText(this, "không xóa được", Toast.LENGTH_LONG).show();
        else
        {
            Toast.makeText(this, "xóa thành công", Toast.LENGTH_LONG).show();
        }
    }
    void capnhat(int maGoc, String tenMoi, int sotrangMoi,float giaMoi , String motaMoi)
    {
        String[] thamSoTruyen = {String.valueOf(maGoc)};
        ContentValues row = new ContentValues();
        // put (key, value); key = tên cột , value = giá trị
        row.put("BookName", tenMoi);
        row.put("Pase", sotrangMoi);
        row.put("Price", giaMoi);
        row.put("Description", motaMoi);
        //
        int kq = databaseBook.update("BOOkS", row, "BOOKID", thamSoTruyen);
        if(kq == 0)
            Toast.makeText(this, "không cập nhật được", Toast.LENGTH_LONG).show();
        else
        {
            Toast.makeText(this, "cập nhật thành công", Toast.LENGTH_LONG).show();
        }
    }
    void NapthovaolistView()
    {
        // 1. lấy tham chiếu đến ListView trong Layout
        ListView listView = (ListView) findViewById(R.id.lvSAHC);
        // 2. nguồn dữ liệu
        // mỗi phần tử là 1 Strng , gồm: mã + tên + giá
        ArrayList<String> dsSach = new ArrayList<String>();
        // mở DB, select dữ liệu, đưa vào ArrayList
        //------------------------
        Cursor cs =  databaseBook.rawQuery("SELECT * FROM BOOKS", null );
        cs.moveToFirst();
        // duyệt tùng dòng ( bản ghi), tính toán
        while(true)
        {
            if (cs.isAfterLast() == true) break;
            // lấy mã sách
            int ms = cs.getInt(0); // cột 0, ở dòng hiện tại
            // lấy tên sách
            String tensach = cs.getString(1);
            // lấy giá bán
            Float gia = cs.getFloat(3);
            // nối lại , để ddauw vào arrayList
            String dong = String.valueOf(ms) + "--" + tensach + "--" + String.valueOf(gia);
            // đưa vào arraylist
            dsSach.add(dong);
            // sang dòng ( bản ghi tiếp)
            cs.moveToNext();
        }
        //------------------------
        // 3. Adapter
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,dsSach);
        // gắn vào LisView
        listView.setAdapter(adapter);
        // bắt và xử lý sự kiện
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // có dạng: 8 -- tên sách -- ...
                // xử lý tach lấy phần mã
                String dongChon = dsSach.get(i);// tìm vị trí xuất hiện đầu tiên của khoảng trắng
                int k = dongChon.indexOf(" ");
                String ma = dongChon.substring(0, k);// trích lấy phần mã
                // test thử bằng cách gán lên textview chọn
                TextView edChon = (TextView) findViewById(R.id.edtMaChon);
                edChon.setText(ma);
            }
        });
    }

    void TaoBangVaThemDuLieu()
    {
        // lệnh tạo bảng
        // sqlXoaBang nếu đã có
        String sqlXoaBang = "DROP TABLE IF EXISTS BOOKS";
        databaseBook.execSQL(sqlXoaBang);

        String sqlTaoBang = "CREATE TABLE BOOKS( BookID integer PRIMARY KEY," +
                " BookName text," +
                " Page integer," +
                " Price Float, " +
                " Description text)";
        databaseBook.execSQL(sqlTaoBang);
        // thêm bản ghi
        String sqlThem1 = "INSERT INTO BOOKS VALUES(1, 'quê huong', 100, 9.99, 'thơ về\n" +
                "quê hương')";
        databaseBook.execSQL(sqlThem1);
        String sqlThem2 = "INSERT INTO BOOKS VALUES(2, 'việt nam quê hương tôi', 320, 19.00, 'thơ về\n" +
                "việt nam')";
        databaseBook.execSQL(sqlThem2);
        String sqlThem3 = "INSERT INTO BOOKS VALUES(3, 'đường về quê mẹ', 120, 0.99, 'thơ về \n" +
                "quê hương')";
        databaseBook.execSQL(sqlThem3);
        String sqlThem4 = "INSERT INTO BOOKS VALUES(4, 'quê hương', 1000, 29.50, 'thơ về\n" +
                "quê hương')";
        databaseBook.execSQL(sqlThem4);
        String sqlThem5 = "INSERT INTO BOOKS VALUES(5, 'việt nam', 1, 1, 'thơ về đất nước')";
        databaseBook.execSQL(sqlThem5);
    }
}