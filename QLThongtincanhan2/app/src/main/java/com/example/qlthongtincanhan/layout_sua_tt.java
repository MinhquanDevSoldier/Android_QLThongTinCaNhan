package com.example.qlthongtincanhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class layout_sua_tt extends AppCompatActivity {
    final static int resultcodeupdate = 1115;
    EditText edtten_sua,edtsdt_sua,edtdiachi_sua;
    Spinner spquequan_sua;
    Button btncapnhat_sua,btntrolai_sua;
    String[] arrdsquequan_sua;
    String quequan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_sua_tt);
        mapping();
        arrdsquequan_sua = getResources().getStringArray(R.array.Danhsachquequanthemsua);
        spinnerQueQuanAdapter adapter = new spinnerQueQuanAdapter(getApplicationContext(),R.layout.spinnerquequan,arrdsquequan_sua);
        spquequan_sua.setAdapter(adapter);
        spquequan_sua.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                quequan = arrdsquequan_sua[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Intent getintent = getIntent();
        Bundle bundle = getintent.getBundleExtra("thongtinchinhsua");
        Person personmodify = (Person) bundle.getSerializable("personmodify");
        edtten_sua.setText(personmodify.getName());
        edtsdt_sua.setText(personmodify.getPhoneNumber());
        edtdiachi_sua.setText(personmodify.getAddress());
        for(int i = 0 ;i < arrdsquequan_sua.length;i++)
        {
            if(arrdsquequan_sua[i].equals(personmodify.getCountry()))
            {
                spquequan_sua.setSelection(i);
            }
        }
        btntrolai_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btncapnhat_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten_sua,sdt_sua,diachi_sua;
                try{
                    ten_sua = edtten_sua.getText().toString();
                    sdt_sua = edtsdt_sua.getText().toString();
                    diachi_sua = edtdiachi_sua.getText().toString();
                    if(ten_sua.equals(""))
                    {
                        Toast.makeText(layout_sua_tt.this, "Đừng để trống tên", Toast.LENGTH_SHORT).show();
                    }
                    else if(sdt_sua.equals(""))
                    {
                        Toast.makeText(layout_sua_tt.this, "Thiếu số điện thoại kìa !!", Toast.LENGTH_SHORT).show();
                    }
                    else if(diachi_sua.equals(""))
                    {
                        Toast.makeText(layout_sua_tt.this, "Bạn ở đâu ?", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Person personAfterModify = new Person(personmodify.getId(),ten_sua,sdt_sua,diachi_sua,quequan);
                        Intent result = new Intent();
                        Bundle bundle1 = new Bundle();
                        bundle1.putSerializable("personAfterModify",personAfterModify);
                        result.putExtra("resultFromUpdate",bundle1);
                        setResult(resultcodeupdate,result);
                        finish();
                    }
                }catch (Exception ex)
                {
                    Toast.makeText(layout_sua_tt.this, ex.toString(), Toast.LENGTH_SHORT).show();
                }
                }
            });

    }
    public void mapping()
    {
        edtten_sua = (EditText) findViewById(R.id.edtten_sua);
        edtsdt_sua = (EditText) findViewById(R.id.edtsdt_sua);
        edtdiachi_sua = (EditText) findViewById(R.id.edtdiachi_sua);
        spquequan_sua = (Spinner) findViewById(R.id.spquequan_sua);
        btncapnhat_sua = (Button) findViewById(R.id.btncapnhap_sua);
        btntrolai_sua = (Button) findViewById(R.id.btntrolai_sua);
    }

}