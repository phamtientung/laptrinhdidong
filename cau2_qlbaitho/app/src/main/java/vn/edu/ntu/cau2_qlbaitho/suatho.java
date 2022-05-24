package vn.edu.ntu.cau2_qlbaitho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class suatho extends AppCompatActivity {
    SQLiteDatabase databaseBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suatho);

        databaseBook =  SQLiteDatabase.openOrCreateDatabase("/data/data/vn.edu.ntu.cau2_qlbaitho/Mybook.db", null);
        // lấy về intent sửa đã gửi
        Intent intentSS = getIntent();
        // lấy ra dữ liệu đã gói thông qua key là masach
        //
        int mathosua = intentSS.getIntExtra("matho",0);
        //
        // lấy các thông tin hiện tại, fill vào các điều khiển
        String sqlChon = "SELECT * FROM BOOKS";
        String[] thamsotruyen = {String.valueOf(mathosua)};
        Cursor cs =  databaseBook.rawQuery("SELECT * FROM BOOKS where BookID = ?",thamsotruyen);
        int ma = cs.getInt(0);
        String ten = cs.getString(1);
        // lấy các thông tin từ điều khiển, truyền vào hàm cập nhật

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
}