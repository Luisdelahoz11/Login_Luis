package com.example.login_luis;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    EditText usuario;
    private EditText contraseña;
    AppCompatButton btnLogin;
    private String contra = "12345678";
    private String user = "LuisDa";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        usuario=findViewById(R.id.usuario);
        contraseña=findViewById(R.id.contraseña);
        btnLogin=findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }

    public void Login(){
        String contraIngresada = contraseña.getText().toString();
        String userIngresado = usuario.getText().toString();

        if(userIngresado.isEmpty() || contraIngresada.isEmpty()){
            Toast.makeText(this,"Los campos no pueden estra vacios,esegurece de llenarlos",Toast.LENGTH_LONG).show();
        }else{
            if (userIngresado.equals(user) && contraIngresada.equals(contra)){
                enviarDatos(userIngresado);
            }else{
                Toast.makeText(this,"Clave o usuario incorrectos",Toast.LENGTH_LONG).show();
                usuario.setText("");
                contraseña.setText("");
                usuario.requestFocus();
            }
        }
    }

    public void enviarDatos(String i){
        Intent intent = new Intent(MainActivity.this, SegundaPantalla.class);
        intent.putExtra("nombre",i);
        startActivity(intent);
    }
}