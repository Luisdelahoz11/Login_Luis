package com.example.login_luis;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SegundaPantalla extends AppCompatActivity {

    String nombre;
    private TextView bienvenido;
    AppCompatButton btnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.segunda_pantalla);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bienvenido=findViewById(R.id.bienvenido);
        nombre = getIntent().getStringExtra("nombre");
        colocarNombre();

        btnSalir = findViewById(R.id.btnSalir);

        btnSalir.setOnClickListener(v -> {
            finish();
        });
    }
    public void colocarNombre(){
        bienvenido.setText("👋 Bienvenido, " + nombre);
    }
}