package ca.mogkolpon.tipbru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class SignUPActivity extends AppCompatActivity {

    // Explicit ประกาศตัวแปร
    private EditText nameEditText, surnameEditText, userEditText, passwordEditText;
    private String nameString, surnameString, userString, passwoedString;
    private static final String urlUpload="http://swiftcodingthai.com/pbru2/add_user_master.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Bind Widge
        nameEditText = (EditText) findViewById(R.id.editText);
        surnameEditText= (EditText) findViewById(R.id.editText2);
        userEditText= (EditText) findViewById(R.id.editText3);
        passwordEditText= (EditText) findViewById(R.id.editText4);

    } // Main Method

    public void clickSignUpSign(View view) {


        nameString = nameEditText.getText().toString().trim();  //trim คือตัดช่องว่างออก
        surnameString=surnameEditText.getText().toString().trim();
        userString=userEditText.getText().toString().trim();
        passwoedString=passwordEditText.getText().toString().trim();

        //Chech Space เซ็คช่องว่าง
        if (checkSpace()) {
            //True
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this,"มีช่วงว่าง", "กรุณากรอกทุกช่วง");

        } else {
            //False
            uploadValueToServer();

        }

    } // clinkSign คลิกปุ่ม SignUp

    private void uploadValueToServer() {

        OkHttpClient okHttpClient=new OkHttpClient();
        RequestBody requestBody=new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("Name", nameString)
                .add("Surname", surnameString)
                .add("User", userString)
                .add("Password", passwoedString)
                .build();
        Request.Builder builder=new Request.Builder();
        Request request = builder.url(urlUpload).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                finish();
            }
        });


    } // upload

    private boolean checkSpace() {

        boolean result = true;

        result = nameString.equals("") || surnameString.equals("") ||
                userString.equals("") || passwoedString.equals("");

        return result;
    }


} // Mani Class
