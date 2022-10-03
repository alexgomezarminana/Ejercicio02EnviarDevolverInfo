package com.example.ejercicio02enviardevolverinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.StringTokenizer;

public class ContadorPalabrasActivity extends AppCompatActivity {

    private TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

        lblResultado = findViewById(R.id.lblResultadoCalculadora);

        //obtener la info enviada
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null){
            String frase = bundle.getString("FRASE");
            int operacion = bundle.getInt("OPERACION");

            if (operacion == R.id.btnPalabrasMain){
                int resultado = contarPalabras(frase);
                lblResultado.setText("PALABRAS: " + resultado);
            }else if (operacion == R.id.btnCaracteresMain){
                int resultado= contarCaracteres(frase);
                lblResultado.setText("caracteres: " + resultado);
            }
        }
    }

    private int contarCaracteres(String frase) {
        return frase.length();
    }

    private int contarPalabras(String frase) {
        StringTokenizer stringTokenizer = new StringTokenizer(frase);
        return stringTokenizer.countTokens();
    }
}