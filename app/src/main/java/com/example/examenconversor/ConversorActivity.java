package com.example.examenconversor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConversorActivity extends AppCompatActivity {
    // Declaración de vistas
    private TextView txtTituloConversion, txtUnidad1, txtUnidad2, txtResultado;
    private EditText etValor1, etValor2;
    private Button btnConvertir1, btnConvertir2;

    // Variable para el tipo de conversión
    private int conversionType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_conversor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

            // Inicializar vistas
            initViews();

            // Obtener datos del Intent
            conversionType = getIntent().getIntExtra("conversion_type", 0);
            String conversionName = getIntent().getStringExtra("conversion_name");

            // Mostrar el título de la conversión seleccionada
            txtTituloConversion.setText(conversionName);

            // Configurar las unidades según el tipo de conversión
            configurarUnidades();

            // Configurar botones
            btnConvertir1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    convertirUnidad1();
                }
            });

            btnConvertir2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    convertirUnidad2();
                }
            });

            // Limpiar resultados al iniciar
            txtResultado.setText("Ingrese un valor para convertir");
        }

        /**
         * Inicializa todas las vistas del layout
         */
        private void initViews() {
            txtTituloConversion = findViewById(R.id.txtTituloConversion);
            txtUnidad1 = findViewById(R.id.txtUnidad1);
            txtUnidad2 = findViewById(R.id.txtUnidad2);
            txtResultado = findViewById(R.id.txtResultado);
            etValor1 = findViewById(R.id.etValor1);
            etValor2 = findViewById(R.id.etValor2);
            btnConvertir1 = findViewById(R.id.btnConvertir1);
            btnConvertir2 = findViewById(R.id.btnConvertir2);
        }

        /**
         * Configura los textos de las unidades según el tipo de conversión
         */
        private void configurarUnidades() {
            switch (conversionType) {
                case 0: // Metros ↔ Pies
                    txtUnidad1.setText("Metros (m)");
                    txtUnidad2.setText("Pies (ft)");
                    break;
                case 1: // Kilómetros ↔ Millas
                    txtUnidad1.setText("Kilómetros (km)");
                    txtUnidad2.setText("Millas (mi)");
                    break;
                case 2: // Centímetros ↔ Pulgadas
                    txtUnidad1.setText("Centímetros (cm)");
                    txtUnidad2.setText("Pulgadas (in)");
                    break;
            }
        }

        /**
         * Convierte de Unidad 1 a Unidad 2
         */
        private void convertirUnidad1() {
            String valorStr = etValor1.getText().toString();

            // Validar que se haya ingresado un valor
            if (valorStr.isEmpty()) {
                Toast.makeText(this, "Ingrese un valor en " + txtUnidad1.getText(), Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double valor = Double.parseDouble(valorStr);
                double resultado = 0;
                String unidadOrigen = "";
                String unidadDestino = "";

                switch (conversionType) {
                    case 0: // Metros a Pies
                        resultado = valor * 3.28084;
                        unidadOrigen = "metros";
                        unidadDestino = "pies";
                        break;
                    case 1: // Kilómetros a Millas
                        resultado = valor * 0.621371;
                        unidadOrigen = "kilómetros";
                        unidadDestino = "millas";
                        break;
                    case 2: // Centímetros a Pulgadas
                        resultado = valor * 0.393701;
                        unidadOrigen = "centímetros";
                        unidadDestino = "pulgadas";
                        break;
                }

                // Mostrar resultado en el segundo campo y en el TextView de resultado
                String resultadoFormateado = String.format("%.4f", resultado);
                etValor2.setText(resultadoFormateado);
                txtResultado.setText(String.format("%.4f %s = %.4f %s",
                        valor, unidadOrigen, resultado, unidadDestino));

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Por favor ingrese un número válido", Toast.LENGTH_SHORT).show();
            }
        }

        /**
         * Convierte de Unidad 2 a Unidad 1
         */
        private void convertirUnidad2() {
            String valorStr = etValor2.getText().toString();

            // Validar que se haya ingresado un valor
            if (valorStr.isEmpty()) {
                Toast.makeText(this, "Ingrese un valor en " + txtUnidad2.getText(), Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double valor = Double.parseDouble(valorStr);
                double resultado = 0;
                String unidadOrigen = "";
                String unidadDestino = "";

                switch (conversionType) {
                    case 0: // Pies a Metros
                        resultado = valor / 3.28084;
                        unidadOrigen = "pies";
                        unidadDestino = "metros";
                        break;
                    case 1: // Millas a Kilómetros
                        resultado = valor / 0.621371;
                        unidadOrigen = "millas";
                        unidadDestino = "kilómetros";
                        break;
                    case 2: // Pulgadas a Centímetros
                        resultado = valor / 0.393701;
                        unidadOrigen = "pulgadas";
                        unidadDestino = "centímetros";
                        break;
                }

                // Mostrar resultado en el primer campo y en el TextView de resultado
                String resultadoFormateado = String.format("%.4f", resultado);
                etValor1.setText(resultadoFormateado);
                txtResultado.setText(String.format("%.4f %s = %.4f %s",
                        valor, unidadOrigen, resultado, unidadDestino));

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Por favor ingrese un número válido", Toast.LENGTH_SHORT).show();
            }
        }
    }