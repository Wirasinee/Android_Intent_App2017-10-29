package com.example.app2017_10_29;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final EditText editText = (EditText) findViewById(R.id.editText);
        Button okButton = (Button) findViewById(R.id.button2); //ปุ่มok เมือกดจะกลับไปหน้าหลัก
       // String date = editText.getText().toString(); //อ่านข้อมูลจากที่กรอกมาเลยไหม ตอนนี้อันนี้คือมันทำตอนขั้นตอนหน้าที่2โหลดเลยแต่ตอนนั้นข้อมูลตรงช่องนี้ยังไม่มีเลย ควรทำตอนคลิกปุ่มสิ!!!

        //เมือกดปุ่มok ให้กลับไปหน้าหลัก
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = editText.getText().toString(); //ใส่ตรงนี้ และใส่final EditTextด้วยเพราะโค้ดที่อยู่ในแอโนนิมัสตอินเนอคลาสเวลาจะอ้างตัวแปลที่อยู่ภายนอก้องประกาศเป็นไฟนอล พอผู้ใช้แตะปุ่มก็อ่านข้อมูลจากeditText

                /* ***โยนข้อมูลกลับไป A โดย*/
                Intent intent = new Intent();//ไม่ต้องระบุว่าจะส่งข้อมูลไปที่ไหน
                intent.putExtra("result",date);//เอาข้อมูลใส่ในintent โดยให้ชื่อkeyว่าresult
/*(2) */
                setResult(RESULT_OK,intent);//ส่งข้อมูลไป(ไปหน้าก่อนหน้ามั่ง) RESULT_OKคือ Result Code เป็นสถานะเช่นเป็นokนะ พวกนี้คือresultCode
                finish();
            }
        });

        Button cancelButton = (Button) findViewById(R.id.button3);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);//บอกว่าค่าเป็นแคนเซิลส่งไปA ความหมายคือข้อมูลไม่ได้ส่งกลับมานะ
                finish();
            }
        });
    }
}
