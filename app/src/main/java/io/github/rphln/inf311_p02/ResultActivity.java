package io.github.rphln.inf311_p02;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    private static String formatNumber(Double number) {
        // Removes trailing zeroes. See: <https://stackoverflow.com/a/25308216>
        DecimalFormat format = new DecimalFormat("0");
        format.setMaximumFractionDigits(4);

        return format.format(number);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Log.i(getLocalClassName(), "onCreate");

        Intent it = getIntent();

        String name = it.getStringExtra("name");

        double height = it.getDoubleExtra("height", 0);
        String heightFmt = String.format("%s m", formatNumber(height));

        double weight = it.getDoubleExtra("weight", 0);
        String weightFmt = String.format("%s Kg", formatNumber(weight));

        int age = it.getIntExtra("age", 0);
        String ageFmt = String.format("%d anos", age);

        double bmi = weight / Math.pow(height, 2);
        String bmiFmt = String.format("%s Kg/m²", formatNumber(bmi));

        String group;

        if (bmi < 18.5)
            group = "Abaixo do peso";
        else if (bmi < 25)
            group = "Saudável";
        else if (bmi < 30)
            group = "Sobrepeso";
        else if (bmi < 35)
            group = "Obesidade Grau I";
        else if (bmi < 40)
            group = "Obesidade Grau II (Severa)";
        else
            group = "Obesidade Grau III (Mórbida)";


        setContentView(R.layout.activity_result);

        ((TextView) findViewById(R.id.labelOutputAge)).setText(ageFmt);
        ((TextView) findViewById(R.id.labelOutputBMI)).setText(bmiFmt);
        ((TextView) findViewById(R.id.labelOutputGroup)).setText(group);
        ((TextView) findViewById(R.id.labelOutputWeight)).setText(weightFmt);
        ((TextView) findViewById(R.id.labelOutputHeight)).setText(heightFmt);
        ((TextView) findViewById(R.id.labelOutputName)).setText(name);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(getLocalClassName(), "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(getLocalClassName(), "onRestart");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(getLocalClassName(), "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(getLocalClassName(), "onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(getLocalClassName(), "onDestroy");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(getLocalClassName(), "onResume");
    }

    public void goBack(View view) {
        Intent it = new Intent(getBaseContext(), MainActivity.class);
        it.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        startActivity(it);
    }
}