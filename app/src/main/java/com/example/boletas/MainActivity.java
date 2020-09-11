package com.example.boletas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    //variables que usaremos para alojar datos
    private int contador;
    private ArrayList<Boleta> boletas;

    //objetos que usaremos para obtener los datos
    EditText str_monto;
    TextView _boletasIngresadas;
    TextView _idTotal;
    TextView _idProm;
    TextView _idBajo;
    TextView _idAlto;

    //metodo principal de nuestra APP
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador = 0;
        boletas = new ArrayList<Boleta>();

        _boletasIngresadas = findViewById(R.id.idBoletasIngresadas);
        _idTotal = findViewById(R.id.idTotal);
        _idProm = findViewById(R.id.idPromedio);
        _idBajo = findViewById(R.id.idBajo);
        _idAlto = findViewById(R.id.idAlto);

        str_monto = findViewById(R.id.idMontoText);
    }

    //metodo del boton encargado de agregar boletas
    public void cargarBoleta(View view)
    {
        contador++;
        Boleta boleta = new Boleta(contador);
        boleta.setMonto(monto_to_num());
        boletas.add(boleta);

        _boletasIngresadas.setText("Boletas Ingresadas:" + String.valueOf(contador));
        _idTotal.setText("Total: " + String.valueOf(getTotal()));
        _idProm.setText("Promedio: " + String.valueOf(getProm()));
        /*if (contador > 2){
            _idBajo.setText("Bajo: " + String.valueOf(getLowest().getFolio()) + String.valueOf(getLowest().getMonto()));
            _idAlto.setText("Alto: " + String.valueOf(getHighest().getFolio()) + String.valueOf(getHighest().getMonto()));
        }*/
    }

    //metodos implementados para la solucion del problema
    //==============================================================================================
    public int monto_to_num(){
        return Integer.parseInt(str_monto.getText().toString());
    }

    public int getTotal(){
        int total = 0;
        for(Boleta b : boletas){
            total += b.getMonto();
        }
        return total;
    }

    public int getProm(){
        return getTotal()/contador;
    }

    public Boleta getLowest(){
        int[] lowest = new int[boletas.toArray().length];
        for (int i = 0; i < lowest.length; i++){
            lowest[i] = boletas.get(i).getMonto();
        }
        Arrays.sort(lowest);

        return boletas.get(lowest[0]);
    }

    public Boleta getHighest(){
        int[] highest = new int[boletas.toArray().length];
        for (int i = 0; i < highest.length; i++){
            highest[i] = boletas.get(i).getMonto();
        }

        Arrays.sort(highest);

        return boletas.get(highest[highest.length]);
    }
}