package com.hackathon.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 = {
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"},
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"},
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"},
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"},
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"}
    };
    TextView tv;
    private String[][] doctor_details2 = {
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"},
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"},
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"},
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"},
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"}
    };
    private String[][] doctor_details3 = {
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"},
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"},
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"},
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"},
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"}
    };
    private String[][] doctor_details4 = {
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"},
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"},
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"},
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"},
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"}
    };
    private String[][] doctor_details5 = {
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"},
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"},
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"},
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"},
            {"Doctor Name : Ajit Saate","Hospital Address : Pimpri","Exp : 5yrs", "Mobile Number : 9876543210","600"}
    };
    Button btn;
    String[][] doctor_details = {};
    ArrayList list;
    HashMap<String,String> item;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonLTGoToCart);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);
        if(title.compareTo("pediatrician") == 0){
            doctor_details = doctor_details1;
        }
        else if(title.compareTo("Dietician") == 0){
            doctor_details = doctor_details2;
        }
        else if(title.compareTo("Surgeon") == 0){
            doctor_details = doctor_details3;
        }
        else if(title.compareTo("Dentist") == 0){
            doctor_details = doctor_details4;
        }
        else if(title.compareTo("Cardiologists") == 0){
            doctor_details = doctor_details5;
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class));

            }
        });
        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("1",doctor_details[i][0]);
            item.put("2",doctor_details[i][1]);
            item.put("3",doctor_details[i][2]);
            item.put("4",doctor_details[i][3]);
            item.put("5","Cons Fees : " + doctor_details[i][4] + "/-");
            list.add(item);
            sa = new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"1","2","3","4","5"},new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
            ListView lst = findViewById(R.id.listViewLT);
            lst.setAdapter(sa);

            lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                    it.putExtra("text1",title);
                    it.putExtra("text2",doctor_details[i][0]);
                    it.putExtra("text3",doctor_details[i][1]);
                    it.putExtra("text4",doctor_details[i][3]);
                    it.putExtra("text5",doctor_details[i][4]);
                    startActivity(it);

                }
            });
        }
    }
}