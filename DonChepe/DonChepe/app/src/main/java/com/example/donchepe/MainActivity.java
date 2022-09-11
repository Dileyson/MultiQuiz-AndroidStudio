package com.example.donchepe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    TextView tvTitulo;
    EditText etPlaca;
    Button btnConsultarEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnConsultarEstado = findViewById(R.id.btnConsultarEstado);
        this.etPlaca = findViewById(R.id.etPlaca);
        this.tvTitulo = findViewById(R.id.tvTitulo);


        btnConsultarEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int placa = Integer.parseInt(etPlaca.getText().toString());
                int mayor=numeroMayor(placa);
                double porcentaje=placa*100/mayor;
                System.out.println(porcentaje);
                if(porcentaje>=75) {
                    btnConsultarEstado.setText("Bueno");
                    btnConsultarEstado.setBackgroundColor(Color.GREEN);
                }else if (porcentaje>=45){
                    btnConsultarEstado.setText("Regular");
                    btnConsultarEstado.setBackgroundColor(Color.BLUE);
                }else {
                    btnConsultarEstado.setText("Malo");
                    btnConsultarEstado.setBackgroundColor(Color.RED);
                }

            }
        });

    }

    public int numeroMayor(int placaE){

        int p=Integer.valueOf(placaE/100);
        int u=Integer.valueOf(placaE% 10);
        int m=Integer.valueOf((placaE % 100)/10);
        int mayor;
        ArrayList<Integer> stack = new ArrayList<Integer>();
        stack.add(p);
        stack.add(m);
        stack.add(u);
        Collections.sort(stack);
        mayor = stack.get(2)*100 + stack.get(1)*10 + stack.get(0);
        System.out.println(mayor);
        return mayor;

    }

}
