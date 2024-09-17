package com.example.quiz_gustavoeric;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TelaPergunta5 extends AppCompatActivity {

    TextView tVNomeP5,tVPontosP5;
    RadioGroup rdgP5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pergunta5);

        tVNomeP5 = findViewById(R.id.txtVNomeP5);
        tVPontosP5 = findViewById(R.id.txtVPontosP5);

        Intent telaAtual5 = getIntent();

        Bundle valoresRecebidos5 = telaAtual5.getExtras();

        tVPontosP5.setText(valoresRecebidos5.getString("PontosJogadorP4"));
        tVNomeP5.setText(valoresRecebidos5.getString("NomeJogador5"));
        rdgP5 = findViewById(R.id.rdgPergunta5);

    }
    public void butaoOKP5 (View v){
        Intent telaAtual5 = getIntent();

        Bundle valoresRecebidos5 = telaAtual5.getExtras();

        tVPontosP5.setText(valoresRecebidos5.getString("PontosJogadorP4"));
        String ponto = valoresRecebidos5.getString("PontosJogadorP4");

        int op = rdgP5.getCheckedRadioButtonId();
        int pontosP5 = Integer.parseInt(ponto);
        String somaStr= String.valueOf(pontosP5);
        Log.e("Pontos:",somaStr);

        if (op==R.id.rdbAP5){
            Toast.makeText(this, "Resposta Correta", Toast.LENGTH_SHORT).show();
            pontosP5 +=1;

        }
        else{
            Toast.makeText(this, "Resposta Errada", Toast.LENGTH_SHORT).show();
        }
        String pontoStr;
        pontoStr = String.valueOf(pontosP5);
        Log.e("Pontos Somados:",pontoStr);
        Intent TP6 = new Intent(TelaPergunta5.this,TelaPergunta6.class);
        TP6.putExtra("PontosJogadorP5",pontoStr);

        String nome6= tVNomeP5.getText().toString();
        TP6.putExtra("NomeJogador6",nome6);

        startActivity(TP6);

    }
}