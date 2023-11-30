package com.example.myapplication_first;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication_first.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private EditText heighted,weighted;
    private Button calc;
    private TextView res;
    private LinearLayoutCompat linear1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heighted=findViewById(R.id.height);
        weighted=findViewById(R.id.weight);
        calc=findViewById(R.id.bt1);
        res=findViewById(R.id.result);
        linear1=findViewById(R.id.main);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hei,wei;

                hei=Integer.parseInt(heighted.getText().toString());
                wei=Integer.parseInt(weighted.getText().toString());

                double m=(double)hei/100;
                double rest=wei/(m*m);

                String BMI = String.format("%.1f", rest);

                if(rest<=18.4) {
                    res.setText("Underweight, BMI is " + BMI);
                    linear1.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else if (rest>=18.5 && rest<=24.9){
                    res.setText("Normal, BMI is " + BMI);
                    linear1.setBackgroundColor(getResources().getColor(R.color.green));
                }
                else if (rest>=25.0 && rest<=39.9){
                    res.setText("Overweight, BMI is " + BMI);
                    linear1.setBackgroundColor(getResources().getColor(R.color.yellow));
                }
                else{
                    res.setText("Obese, BMI is " + BMI);
                    linear1.setBackgroundColor(getResources().getColor(R.color.orange));
                }


            }

        });
    }
};
