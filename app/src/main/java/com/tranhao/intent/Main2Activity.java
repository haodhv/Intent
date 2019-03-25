package com.tranhao.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressWarnings("ConstantConditions")
public class Main2Activity extends AppCompatActivity {
    Button button2;
    EditText editTextUn, editTextPas;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);

        button2 = findViewById(R.id.btnCapNhat);

        editTextUn = findViewById(R.id.edtTen);
        editTextPas = findViewById(R.id.edtMk);

        intent = getIntent();

        final String chuoi = intent.getStringExtra("chuoi");
        Bundle bundle = intent.getBundleExtra("dulieu");

        String un = bundle.getString("un");
        String pas = bundle.getString("pas");
        editTextUn.setText(un);
        editTextPas.setText(pas);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, chuoi, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                String tenmoi = editTextUn.getText().toString();
                String mk = editTextPas.getText().toString();

                Bundle bundle2 = new Bundle();
                bundle2.putString("tenmoi", tenmoi);
                bundle2.putString("mkmoi", mk);
                intent.putExtra("dulieumoi", bundle2);

                intent.putExtra("chuoi", "Vinh University");

                setResult(RESULT_OK, intent);
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
