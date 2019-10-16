package com.example.jota.appuno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String[] monedas = {"EUR", "USD", "BTC", "YEN"};
    private Map<String, Double> tiposDeCambio = new HashMap<String, Double>();

    // 1. declaro las variables de los componentes gráficos
    private EditText cantidad;
    private Spinner monedaOriginal;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_uno);

        //2. enlazo variables y componentes gráficos
        cantidad = findViewById(R.id.etCantidad);
        monedaOriginal = findViewById(R.id.spinnerOriginal);
        tvResultado = findViewById(R.id.tvMensaje);

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, monedas);
        monedaOriginal.setAdapter(adaptador);

        inicializarTiposDeCambio();

    }

    public void inicializarTiposDeCambio() {
        tiposDeCambio.put("EUR", 1.0);
        tiposDeCambio.put("USD", 1.103); // 1 euro es igual a 1.103 dólares
        tiposDeCambio.put("BTC", 0.00013); // 1 euro es igual a 0.00013 bitcoins
        tiposDeCambio.put("YEN", 120.0); // 1 euro es igual a 120 yenes
    }

    public void convertirDivisas(View v) {
        // 3. respuesta a pulsación de botón
        String monedaSeleccionada = monedaOriginal.getSelectedItem().toString();
        Double tipoDeCambio = tiposDeCambio.get(monedaSeleccionada);
        // hacer cálculo a monedaSeleccionada
        Double c = Double.parseDouble(cantidad.getText().toString());
        Double valor = c / tipoDeCambio;
        String resultado = "El resultado es " + String.format("%.2f",valor) + "€";

        // Mostrar resultado en un mensaje por pantalla
        // Toast.makeText(this, resultado, Toast.LENGTH_LONG).show();

        // Mostrar resultado en un textView
        tvResultado.setText(resultado);
    }
}