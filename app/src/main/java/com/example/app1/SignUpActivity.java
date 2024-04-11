package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextFullName, editTextEmail, editTextPassword, editTextConfirmPassword;
    private RadioGroup radioGroupGender;
    private Button buttonCreateAccount;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextFullName = findViewById(R.id.editTextFullName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        buttonCreateAccount = findViewById(R.id.buttonCreateAccount);

        dbHelper = new DatabaseHelper(this);

        buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores de los campos
                String username = editTextUsername.getText().toString();
                String fullName = editTextFullName.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String confirmPassword = editTextConfirmPassword.getText().toString();
                String gender = getSelectedGender();

                // Verificar si las contraseñas coinciden
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(SignUpActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Insertar usuario en la base de datos
                insertUser(username, fullName, email, password, gender);
            }
        });
    }

    private String getSelectedGender() {
        int selectedId = radioGroupGender.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        return radioButton.getText().toString();
    }

    private void insertUser(String username, String fullName, String email, String password, String gender) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_USERNAME, username);
        values.put(DatabaseHelper.COLUMN_FULL_NAME, fullName);
        values.put(DatabaseHelper.COLUMN_EMAIL, email);
        values.put(DatabaseHelper.COLUMN_PASSWORD, password);
        values.put(DatabaseHelper.COLUMN_GENDER, gender);

        // Insertar la nueva fila en la tabla
        long newRowId = db.insert(DatabaseHelper.TABLE_NAME, null, values);

        // Verificar si la inserción fue exitosa
        if (newRowId != -1) {
            // Mostrar mensaje de éxito
            Toast.makeText(SignUpActivity.this, "Cuenta creada con éxito", Toast.LENGTH_SHORT).show();
        } else {
            // Mostrar mensaje de error
            Toast.makeText(SignUpActivity.this, "Error al crear la cuenta", Toast.LENGTH_SHORT).show();
        }
    }
}




