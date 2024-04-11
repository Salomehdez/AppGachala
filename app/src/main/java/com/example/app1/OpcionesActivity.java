package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class OpcionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        // Obtener referencias a los botones
        Button buttonHospedajes = findViewById(R.id.buttonHospedajes);
        Button buttonRestaurantes = findViewById(R.id.buttonRestaurantes);
        Button buttonActividades = findViewById(R.id.buttonActividades);

        // Configurar clics de los botones
        buttonHospedajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad de hospedajes
                Intent intent = new Intent(OpcionesActivity.this, HospedajesActivity.class);
                startActivity(intent);
            }
        });

        buttonRestaurantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad de restaurantes
                Intent intent = new Intent(OpcionesActivity.this, RestaurantesActivity.class);
                startActivity(intent);
            }
        });

        buttonActividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad de actividades
                Intent intent = new Intent(OpcionesActivity.this, ActividadesActivity.class);
                startActivity(intent);
            }
        });
    }

    public void openRestaurantesActivity(View view) {
        // Agrega aquí la lógica para abrir la actividad de restaurantes si es necesario
    }

    public void openActividadesActivity(View view) {
        // Agrega aquí la lógica para abrir la actividad de actividades si es necesario
    }
}
