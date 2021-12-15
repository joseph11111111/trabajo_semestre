package com.example.trabajo_final_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SegundaActivity2 extends AppCompatActivity {

    private EditText _editexa, _editexb;
    CheckBox _check1, _check2, _check3;
    Button _botona;
    int _suma = 0, _sumaa = 0,_sumab = 0,_sumac = 0;
    String x="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda2);

        _editexa    = findViewById(R.id.edittext1);
        _editexb    = findViewById(R.id.edittext2);
        _check1    = findViewById(R.id.checkbox1);
        _check2    = findViewById(R.id.checkbox2);
        _check3    = findViewById(R.id.checkbox3);
        _botona    = findViewById(R.id.boton2);

    }
    public void irSiguiente(View view){
        if(_check1.isChecked()){
            _sumaa = _sumaa + 4500;
            Toast.makeText(getApplicationContext(), "+4500", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "+4500", Toast.LENGTH_SHORT).show();
            _sumaa = 0;
        }
        if(_check2.isChecked()){
            _sumab = _sumab + 3500;
        }
        else {
            _sumab = 0;
        }
        if(_check3.isChecked()){
            _sumac = _sumac + 2500;
        }
        else {
            _sumac = 0;
        }
        _suma = _sumaa+_sumab+_sumac;
        x = Integer.toString(_suma);
        Intent intent= new Intent(this, TerceraActivity3.class);
        intent.putExtra("dato1", _editexa.getText().toString());
        intent.putExtra("dato2", _editexb.getText().toString());
        intent.putExtra("dato3", x);
        startActivity(intent);
        finish();
    }
    protected void onResume() {
        super.onResume();
        Log.w("Resume : ", "la aplicacion esta en resumen");
    }
    protected void onStart() {
        super.onStart();
        Log.w("Start : ", "comenso la aplicacion");
    }
    protected void onRestart() {
        super.onRestart();
        Log.w("Restart: ", "la aplicacion se esta reiniciado");
    }
    protected void onPause() {
        super.onPause();
        Log.w("Pause: ", "la aplicacion esta en pausa");
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.w("Destroy: ", "la aplicacion fue destruida");
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        Log.w("save: ", "se esta salvando");
    }
}