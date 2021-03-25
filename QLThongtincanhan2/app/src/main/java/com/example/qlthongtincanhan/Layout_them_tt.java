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

import java.io.Serializable;

public class Layout_them_tt extends AppCompatActivity {
    final static int resultcodeadd = 1114;
    Button btnxacnhan,btntrolai;
    EditText edtten,edtsdt,edtdiachi;
    Spinner spquequan_them;
    String[] arrdsquequan_them;
    String id;
    String ten,diachi,sdt,quequan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_them_tt);
        mapping();
        Intent getintent = getIntent();
        id = getintent.getStringExtra("idmax");
        arrdsquequan_them = getResources().getStringArray(R.array.Danhsachquequanthemsua);
        spinnerQueQuanAdapter adapter = new spinnerQueQuanAdapter(getApplicationContext(),R.layout.spinnerquequan,arrdsquequan_them);
        spquequan_them.setAdapter(adapter);
        spquequan_them.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                quequan = arrdsquequan_them[position].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btntrolai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ten = edtten.getText().toString();
                    diachi = edtdiachi.getText().toString();
                    sdt = edtsdt.getText().toString();
                    if(ten.equals(""))
                    {
                        Toast.makeText(Layout_them_tt.this, "Tôi cá là bạn có 1 cái tên rất đẹp", Toast.LENGTH_SHORT).show();
                    }
                    else if(sdt.equals(""))
                    {
                        Toast.makeText(Layout_them_tt.this, "Cho mình xin số điện thoại nha !!", Toast.LENGTH_SHORT).show();
                    }
                    else if(diachi.equals(""))
                    {
                        Toast.makeText(Layout_them_tt.this, "Bạn ở đâu ?", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Intent intentreturn = new Intent();
                        Bundle bundle = new Bundle();
                        int idadd = Integer.parseInt(id)+1;
                        Person newperson = new Person(idadd+"",ten,sdt,diachi,quequan);
                        bundle.putSerializable("newperson",newperson);
                        intentreturn.putExtra("thongtincanthem",bundle);
                        setResult(resultcodeadd,intentreturn);
                        Toast.makeText(Layout_them_tt.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }catch (Exception ex)
                {
                    Toast.makeText(Layout_them_tt.this, ex.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void mapping()
    {
        btnxacnhan = (Button) findViewById(R.id.btnxacnhan_them);
        btntrolai = (Button) findViewById(R.id.btntrolai_them);
        edtten = (EditText) findViewById(R.id.edtten_them);
        edtsdt = (EditText) findViewById(R.id.edttsdt_them);
        edtdiachi = (EditText) findViewById(R.id.edtdiachi_them);
        spquequan_them = (Spinner) findViewById(R.id.spinnerquequan_them);
    }

}