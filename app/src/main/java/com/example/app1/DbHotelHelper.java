package com.example.app1;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHotelHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "hotels";
    private static final int DB_VERSION = 1;

    public static final String TABLE_HOTEL = "hotel";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_IMAGE_RESOURCE_ID = "image_resource_id";

    DbHotelHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_HOTEL + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT, "
                + COLUMN_DESCRIPTION + " TEXT, "
                + COLUMN_IMAGE_RESOURCE_ID + " INTEGER);");

        // Insertar hoteles solo si la tabla está recién creada
        insertHotel(sqLiteDatabase, "Hotel Real", "Descripción del Hotel Real", R.drawable.hotel_real);
        insertHotel(sqLiteDatabase, "Hotel Gachalá", "Descripción del Hotel Gachalá", R.drawable.hotel_gachala);
        insertHotel(sqLiteDatabase, "Hotel Oriental", "Descripción del Hotel Oriental", R.drawable.hotel_oriental);
        insertHotel(sqLiteDatabase, "Hotel Divisa", "Descripción del Hotel Divisa", R.drawable.hotel_divisa);
        insertHotel(sqLiteDatabase, "Hotel Paraiso", "Descripción del Hotel Paraíso", R.drawable.hotel_paraiso);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_HOTEL);
        onCreate(sqLiteDatabase);
    }

    private void insertHotel(SQLiteDatabase db, String name, String description, int imageResourceId) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_DESCRIPTION, description);
        values.put(COLUMN_IMAGE_RESOURCE_ID, imageResourceId);
        db.insert(TABLE_HOTEL, null, values);
    }

    public Cursor getAllHotels() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_HOTEL, null);
    }

    public Cursor getHotel(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_HOTEL + " WHERE " + COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public Cursor findHotelByName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_HOTEL + " WHERE " + COLUMN_NAME + " = ?", new String[]{name});
    }
}
