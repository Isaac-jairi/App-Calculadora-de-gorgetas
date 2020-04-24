package com.example.calculadoradegorgeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextView txtTotal,txtGorgetaTotal,txtPorcentagemBarra;
    private TextInputEditText txtinputGorgeta;
    private SeekBar seekBarPorcentagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTotal = findViewById(R.id.txtTotal);
        txtGorgetaTotal = findViewById(R.id.txtGorgetaTotal);
        txtPorcentagemBarra = findViewById(R.id.txtPorcentagemBarra);
        seekBarPorcentagem = findViewById(R.id.seekBarPorcentagem);
        txtinputGorgeta = findViewById(R.id.txtinputGorgeta);

        seekBarPorcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if ( validar()) {
                    Double doublegorgetaIn = Double.parseDouble(txtinputGorgeta.getText().toString());

                    txtPorcentagemBarra.setText(progress * 5 + "%");

                    txtGorgetaTotal.setText("R$ " + (doublegorgetaIn * (progress * 5) / 100));

                    txtTotal.setText("R$ " + ((doublegorgetaIn * (progress * 5) / 100) + doublegorgetaIn));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public boolean validar(){
        boolean valido = true;
        if (txtinputGorgeta.getText().toString() == null ||txtinputGorgeta.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Preencha todos os campos!",Toast.LENGTH_LONG).show();
            valido=false;
        }
        return valido;
    }
}
