package com.example.trabajo_final_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void irSiguiente(View view){
        Intent intent= new Intent(this, SegundaActivity2.class);
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


