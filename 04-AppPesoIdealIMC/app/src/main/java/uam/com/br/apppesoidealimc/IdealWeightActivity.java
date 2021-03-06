package uam.com.br.apppesoidealimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ObjectInputStream;
import java.text.DecimalFormat;

public class IdealWeightActivity extends AppCompatActivity {

    EditText inputHeight;
    TextView idealWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideal_weight);
    }

    public void calculateIdealWeight(View view){

        // gets the current intent
        Intent intent = getIntent();

        double factor = intent.getDoubleExtra("factor", 0.0);

        // get the height
        inputHeight = (EditText) findViewById(R.id.input_height);
        String stringHeight = inputHeight.getText().toString();

        //format
        stringHeight = stringHeight.replaceAll(",", "");
        stringHeight = stringHeight.replaceAll("\\.", "");
        double height = Double.valueOf(stringHeight);

        // calculate
        double weight = (height - 100.0) * factor;

        // define the weight
        idealWeight = (TextView) findViewById(R.id.ideal_weight);
        idealWeight.setText(String.valueOf(weight));
    }
}
