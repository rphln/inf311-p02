package io.github.rphln.inf311_p02;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(getLocalClassName(), "onCreate");

        setContentView(R.layout.activity_main);
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

    public void submit(View view) {
        String name = ((EditText) findViewById(R.id.inputName)).getText().toString();

        String inputAge = ((EditText) findViewById(R.id.inputAge)).getText().toString();
        String inputHeight = ((EditText) findViewById(R.id.inputHeight)).getText().toString();
        String inputWeight = ((EditText) findViewById(R.id.inputWeight)).getText().toString();

        if (name.isEmpty() || inputAge.isEmpty() || inputHeight.isEmpty() || inputWeight.isEmpty()) {
            Toast toast = Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_SHORT);
            toast.show();

            return;
        }

        double height = Double.parseDouble(inputHeight);
        double weight = Double.parseDouble(inputWeight);

        int age = Integer.parseInt(inputAge);

        Intent it = new Intent(getBaseContext(), ResultActivity.class);
        it.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        it.putExtra("height", height);
        it.putExtra("weight", weight);
        it.putExtra("name", name);
        it.putExtra("age", age);

        it.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(it);
    }
}