package com.example.app1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app1.HospedajesActivity.Hotel.Hospedaje;

import java.util.ArrayList;

public class HotelAdapter extends ArrayAdapter<Hospedaje> {

    private Context mContext;
    private ArrayList<Hospedaje> mHoteles;

    public HotelAdapter(Context context, ArrayList<Hospedaje> hoteles) {
        super(context, 0, hoteles);
        mContext = context;
        mHoteles = hoteles;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(mContext).inflate(R.layout.list_item_hotel, parent, false);
        }

        // Obtener el objeto Hospedaje actual
        Hospedaje currentHotel = mHoteles.get(position);

        // Buscar las vistas en el layout
        ImageView photoImageView = listItemView.findViewById(R.id.photo);
        TextView nombreTextView = listItemView.findViewById(R.id.nombre);
        TextView descripcionTextView = listItemView.findViewById(R.id.descripcion);

        // Asignar los valores del Hospedaje a las vistas
        photoImageView.setImageResource(currentHotel.getImagenId());
        nombreTextView.setText(currentHotel.getNombre());
        descripcionTextView.setText(currentHotel.getDescripcion());

        return listItemView;
    }
}
