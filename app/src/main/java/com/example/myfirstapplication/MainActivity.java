package com.example.myfirstapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {
    int num1;
    int num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
//        here we take the view in
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Random random = new Random();

        num1= random.nextInt(2000);
        num2 = random.nextInt(2000);
        // logic related to randoomness
        TextView number1 = findViewById(R.id.nombre1);
        TextView number2 = findViewById(R.id.nombre2);



        number1.setText(String.valueOf(num1));
        number2.setText(String.valueOf(num2));

        // logic rellated to the actions buttons
        Button plus = findViewById(R.id.btn_plus);
        Button minus = findViewById(R.id.btn_minus);
        Button multiply = findViewById(R.id.btn_multiply);
        TextView result = findViewById(R.id.resultat);
            //actiions based oon click of the buttons
            plus.setOnClickListener(v ->
                result.setText(String.valueOf(num1+num2)));
            minus.setOnClickListener(v ->
                result.setText(String.valueOf(num1-num2)));
            multiply.setOnClickListener(v ->
                result.setText(String.valueOf(num1*num2)));        // now the grand final when clicking on the generate button


        Button generate = findViewById(R.id.btn_generer);

        generate.setOnClickListener(v->{
            num1= random.nextInt(2000);
            num2 = random.nextInt(2000);
            number1.setText(String.valueOf(num1));
            number2.setText(String.valueOf(num2));

        });


    }
}