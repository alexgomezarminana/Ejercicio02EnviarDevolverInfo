package com.example.ejercicio02enviardevolverinfo;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Atributos para las vistas
    private Button btnPalabras;
    private Button btnCaracteres;
    private EditText txtFrase;

    //constantes
    public static final int PALABRAS = 1;
    public static final int CARACTERES = -1;
    
    private ActivityResultLauncher<Intent> launcherPalabras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaVista();

        //inicializaEventos();
    }

    private void inicializaEventos() {
        btnPalabras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick(PALABRAS);
            }
        });

        btnCaracteres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick(CARACTERES);
            }
        });
    }

    private void onclick(int PALABRAS) {
        String frase = txtFrase.getText().toString();
        if (!frase.isEmpty()){
            Bundle bundle = new Bundle();
            bundle.putString("FRASE", frase);
            bundle.putInt("OPERACION", PALABRAS);
            Intent intent = new Intent(MainActivity.this, ContadorPalabrasActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }else {
            Toast.makeText(MainActivity.this, "Frase vacia", Toast.LENGTH_SHORT).show();
        }
    }

    private void inicializaVista() {
        btnPalabras = findViewById(R.id.btnPalabrasMain);
        btnCaracteres = findViewById(R.id.btnCaracteresMain);
        txtFrase = findViewById(R.id.txtFrasesMain);
    }


    //en el xml lo he insertado en los botones en el onClick
    public void onClickBotones(View boton){
        String frase = txtFrase.getText().toString();
        if (!frase.isEmpty()){
            Bundle bundle = new Bundle();
            bundle.putString("FRASE", frase);
            //Cada boton inserta su id
            bundle.putInt("OPERACION", boton.getId());
            Intent intent = new Intent(MainActivity.this, ContadorPalabrasActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }else {
            Toast.makeText(MainActivity.this, "Frase vacia", Toast.LENGTH_SHORT).show();
        }
    }
}