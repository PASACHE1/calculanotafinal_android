package com.example.calcula_nota_final;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText objU11,objU12,objU13,objU21,objU22,objU23,objU31,objU32,objU33;
    TextView objP1,objP2,objP3,objPfin;

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
        objU11 = (EditText) findViewById(R.id.txt1);
        objU12 = (EditText) findViewById(R.id.txt2);
        objU13 = (EditText) findViewById(R.id.txt3);
        objU21 = (EditText) findViewById(R.id.txt4);
        objU22 = (EditText) findViewById(R.id.txt5);
        objU23 = (EditText) findViewById(R.id.txt6);
        objU31 = (EditText) findViewById(R.id.txt7);
        objU32 = (EditText) findViewById(R.id.txt8);
        objU33 = (EditText) findViewById(R.id.txt9);

        objP1 = (TextView) findViewById(R.id.txvResult1);
        objP2 = (TextView) findViewById(R.id.txvResult2);
        objP3 = (TextView) findViewById(R.id.txvResult3);
        objPfin = (TextView) findViewById(R.id.txvFinal);
    }
    public void calcularPromedio(View v) {
        try {
            Float n1 = Float.parseFloat(objU11.getText().toString());
            Float n2 = Float.parseFloat(objU12.getText().toString());
            Float n3 = Float.parseFloat(objU13.getText().toString());
            Float n4 = Float.parseFloat(objU21.getText().toString());
            Float n5 = Float.parseFloat(objU22.getText().toString());
            Float n6 = Float.parseFloat(objU23.getText().toString());
            Float n7 = Float.parseFloat(objU31.getText().toString());
            Float n8 = Float.parseFloat(objU32.getText().toString());
            Float n9 = Float.parseFloat(objU33.getText().toString());

            if (n1>=0 && n1<=20 && n2>=0 && n2<=20 && n3>=0 && n3<=20 && n4 >= 0 && n4 <= 20 && n5 >= 0 && n5 <= 20 && n6 >= 0 && n6 <= 20 && n7 >= 0 && n7 <= 20
                    && n8 >= 0 && n8 <= 20 && n9 >= 0 && n9 <= 20) {
                Float resultadoU1 = (n1 + n2 + n3) / 3;
                Float resultadoU2 = (n4 + n5 + n6) / 3;
                Float resultadoU3 = (n7 + n8 + n9) / 3;
                Float promedioGeneral = (resultadoU1 + resultadoU2 + resultadoU3) / 3;

                objP1.setText(String.valueOf(resultadoU1));
                objP2.setText(String.valueOf(resultadoU2));
                objP3.setText(String.valueOf(resultadoU3));
                objPfin.setText(String.valueOf(promedioGeneral));

                if (promedioGeneral >= 11) {
                    Toast.makeText(this, "¡Felicidades! Estás aprobado con un promedio de " + promedioGeneral, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Lo siento, no has alcanzado el promedio mínimo de aprobación.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Los valores deben estar entre 0 y 20", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor complete todas las respectivas casillas", Toast.LENGTH_SHORT).show();
        }
    }
}