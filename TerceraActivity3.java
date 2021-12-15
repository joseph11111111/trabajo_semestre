package com.example.trabajo_final_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

public class TerceraActivity3 extends AppCompatActivity {

    private TextView _tv1, _tv2, _tv3;
    Button _botona;
    ImageView _imagena;
    String rutaImagen;
    private Spinner _spiner;
    private String[] arraypago= {"Efectivo","Devito","Credito","cupon"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera3);

        _tv1    = findViewById(R.id.texto5);
        _tv2    = findViewById(R.id.texto6);
        _tv3    = findViewById(R.id.texto7);
        _botona    = findViewById(R.id.boton3);
        _imagena    = findViewById(R.id.foto4);
        _spiner    = findViewById(R.id.spiner1);

        String dato1 = getIntent().getStringExtra("dato1");
        String dato2 = getIntent().getStringExtra("dato2");
        String dato3 = getIntent().getStringExtra("dato3");

        _tv1.setTextSize(20);
        _tv2.setTextSize(20);
        _tv3.setTextSize(20);

        _tv1.setText("Orden para el cliente: " + dato1);
        _tv2.setText("Mesa del pedido es la n°: " + dato2);
        _tv3.setText("Valor de la orden es:"+ dato3);

        _botona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AbrirCamara();
            }
        });

        _spiner.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_item_pago,arraypago));

        _spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("El pago elegido es: ", parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void AbrirCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager()) != null){

            File imagenArchivo = null;

            try {
                imagenArchivo = crearImagen();
            }catch (IOException ex){
                Log.e("Erorr", ex.toString());
            }

            if (imagenArchivo != null) {
                Uri fotoUri = FileProvider.getUriForFile(this, "com.example.trabajo_final_6.fileprovider", imagenArchivo);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, fotoUri);
                startActivityForResult(intent, 1);
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK){
            //Bundle extras = data.getExtras();
            //Bitmap imgBitmap = (Bitmap) extras.get("data");
            Bitmap imgBitmap = BitmapFactory.decodeFile(rutaImagen);
            _imagena.setImageBitmap(imgBitmap);
        }
    }

    private File crearImagen() throws IOException {
        String nombreImagen = "foto_";
        File directorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File imagen = File.createTempFile(nombreImagen, ".jpg", directorio);

        rutaImagen = imagen.getAbsolutePath();
        return imagen;
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