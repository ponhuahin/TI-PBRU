package ca.mogkolpon.tipbru;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private MyManage myManage;
    private static final String urlJSON="http://swiftcodingthai.com/pbru2/get_user_master.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myManage = new MyManage(this);

        //Test Add New User  ทดสอบ
        //myManage.addNewUser("123","name","sur","user","pass");

        //Delete All SQLite
        deleteAllSQLite();


    } // Main Method



    private void deleteAllSQLite() { //ลบฐานข้อมูลทั่งหมด

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        sqLiteDatabase.delete(MyManage.user_table, null, null);


    } //deleteAllSQLite

    public void clickSignUpMain(View view) {  // View view คือ ให้ฝัง หน้าออกแบบเห็น
        startActivity(new Intent(MainActivity.this, SignUPActivity.class));
    }


}   // Main Class นี่คือ คลาสหลัก นะจะ
