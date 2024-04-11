package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class HospedajesActivity extends AppCompatActivity {

    public static final Hotel.Hospedaje[] Hospedajes = {
            new Hotel.Hospedaje("Hotel Real", "Descripción del Hotel Real", R.drawable.hotel_real),
            new Hotel.Hospedaje("Hotel Gachalá", "Descripción del Hotel Gachalá", R.drawable.hotel_gachala),
            new Hotel.Hospedaje("Hotel Oriental", "Descripción del Hotel Oriental", R.drawable.hotel_oriental),
            new Hotel.Hospedaje("Hotel Divisa", "Descripción del Hotel Divisa", R.drawable.hotel_divisa),
            new Hotel.Hospedaje("Hotel Paraiso", "Descripción del Hotel Paraíso", R.drawable.hotel_paraiso)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospedajes);

        ListView listView = findViewById(R.id.listViewHotels);
        HotelAdapter adapter = new HotelAdapter(this, R.layout.list_item_hotel, Hospedajes);
        listView.setAdapter(adapter);
    }

    public static class Hotel {
        private int id;
        private String name;
        private String description;
        private int imageResourceId;

        public static class Hospedaje {
            private String nombre;
            private String descripcion;
            private int imagenId;

            public Hospedaje(String nombre, String descripcion, int imagenId) {
                this.nombre = nombre;
                this.descripcion = descripcion;
                this.imagenId = imagenId;
            }

            public String getNombre() {
                return nombre;
            }

            public String getDescripcion() {
                return descripcion;
            }

            public int getImagenId() {
                return imagenId;
            }
        }
    }
}

