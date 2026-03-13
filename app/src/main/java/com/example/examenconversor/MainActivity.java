package com.example.examenconversor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listViewConversiones;
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
        listViewConversiones = findViewById(R.id.listViewConversiones);

        // Lista de conversiones específicas
        List<String> conversiones = new ArrayList<>();
        conversiones.add("Metros a pies");
        conversiones.add("Kilómetros a millas");
        conversiones.add("Centímetros a pulgadas");

        // Adaptador para el ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                conversiones
        );
        listViewConversiones.setAdapter(adapter);

        // Evento click en el ListView
        listViewConversiones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ConversorActivity.class);
                intent.putExtra("conversion_type", position);
                intent.putExtra("conversion_name", conversiones.get(position));
                startActivity(intent);
            }
        });
    }
}

