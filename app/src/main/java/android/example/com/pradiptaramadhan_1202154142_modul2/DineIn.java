package android.example.com.pradiptaramadhan_1202154142_modul2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class DineIn extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    private static final String TAG = DineIn.class.getSimpleName();
    private String mSpinnerLabel = "";
    Button b1;
    Intent pindah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dine_in);

        Spinner spinner = (Spinner) findViewById(R.id.nmr_meja);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

        b1 = findViewById(R.id.tbl_lanjut) ;

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pindah = new Intent(DineIn.this, DaftarMenu.class) ;
                startActivity(pindah) ;
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
        mSpinnerLabel = adapterView.getItemAtPosition(pos).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d(TAG, getString(R.string.nothing_selected));
    }
}
