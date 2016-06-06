package ca.mogkolpon.tipbru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    } // Main Method

    public void clickSignUpMain(View view) {  // View view คือ ให้ฝัง หน้าออกแบบเห็น
        startActivity(new Intent(MainActivity.this, SignUPActivity.class));
    }


}   // Main Class นี่คือ คลาสหลัก นะจะ
