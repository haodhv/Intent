package com.tranhao.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView un, pas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void ProccessButton(View view) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);

        un = findViewById(R.id.textViewTen);
        pas = findViewById(R.id.textViewMk);

        Bundle bundle = new Bundle();
        bundle.putString("un", un.getText().toString());
        bundle.putString("pas", pas.getText().toString());

        intent.putExtra("chuoi", "Đại học Vinh");
        intent.putExtra("dulieu", bundle);

        startActivityForResult(intent, 12);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 12 && resultCode == RESULT_OK) {
            String chuoi = data.getStringExtra("chuoi");
            Toast.makeText(this, chuoi, Toast.LENGTH_SHORT).show();
            Bundle bundle = data.getBundleExtra("dulieumoi");
            un.setText(bundle.getString("tenmoi"));
            pas.setText(bundle.getString("mkmoi"));
        }
    }
}
