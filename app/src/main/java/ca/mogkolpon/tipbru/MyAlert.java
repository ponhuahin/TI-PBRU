package ca.mogkolpon.tipbru;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by lap324-04 on 6/7/16 AD.
 */
public class MyAlert {

    public void myDialog(Context context, String strTitle, String strMessage) { //context คือการส่ง คลาส ถึงคลาส
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);  //ถ้าป็อปอัพขึ้นไม่ให้กดกลับได้
        builder.setIcon(R.drawable.nobita48);  //ใส่ภาพที่ต้องการแจ้งเตือน
        //builder.setIcon(R.drawable.skull);
        builder.setTitle(strTitle);
        builder.setMessage(strMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();  //เมื่อกด ok ป็อปอัพจะหายไป

           }
        });

        builder.show();


    }




} // Main Class
