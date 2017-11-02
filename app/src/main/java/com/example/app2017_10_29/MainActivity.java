package com.example.app2017_10_29;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //ส่งข้อมูลA->B ใช้ Intent

        //จากฺ B -> A ?
        //[1]
        Button button = (Button) findViewById(R.id.button);//fvb ประกาศตัวแปลเพือเรฟเฟอเลน(เชือมโยง)ไปปุ่ม
        mTextView = (TextView) findViewById(R.id.textView);//ประกาศตัวแปลเพือเรฟเฟอเลน(เชือมโยง)ไปtextView

        /*[2]เมือคลิ้กปุ่มให้ไปที่หน้าSecondActivity*/
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //B->A
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(intent,123);/*(1) */ //รับผลลัพจากปลายทางใช้เมธอทนี้startActivityForResult 123คือเลขจำนวนเต็มอะไรก็ได้ เป็นรีเศวสcode เพือเช็คว่าผลลัพที่กลับมานี้เป็นผลลัพปุ่มไหน
            }
        });




        /*ถ้ากดปุ่ม call */
        Button phoneCallButton = (Button) findViewById(R.id.phone_call_button);
        phoneCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);//ACTION_DIAL:ไปหน้าโทรแต่ยังไม่โทรออก ACTION_CALL:โทรออกให้อัตโนมัติ
                //Intent intent = new Intent(Intent.ACTION_CALL);//ถ้าเปฌนACTION_CALL ไปapp=>manif เพื่อขอเพอมิชัน
                intent.setData(Uri.parse("tel:0926485699"));
                startActivity(intent);

            }
        });

    }//end OnCreate
//[3] กดCTRL+O พิม OnActivitty แล้วไปทำหน้าsecondต่อ
    @Override//ใช้เมือปลายทางส่งข้อมูลกลับมาแล้ว /*(3) *///requestCode=123  resultCode=RESULT_OK  data=intentของหน้าB
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //เช็คrequestCode
        if(requestCode==123){
            if(resultCode==RESULT_OK){
                String result = data.getStringExtra("result");//ชื่อต้องตรงกับตัวที่ส่งมา
                mTextView.setText(result);
            }else if(resultCode==RESULT_CANCELED){
                Toast.makeText(
                        MainActivity.this,
                        "คุณยกเลิกการป้อนข้อมูล",
                        Toast.LENGTH_SHORT
                ).show();
            }
        }
    }
}//end Class
