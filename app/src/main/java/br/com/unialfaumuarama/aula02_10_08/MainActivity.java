package br.com.unialfaumuarama.aula02_10_08;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnCalcular;
    EditText edtEtanol, edtGasolina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //vinculando os campos do XML com os objetos do Java
        edtEtanol = findViewById(R.id.edtEtanol);
        edtGasolina = findViewById(R.id.edtGasolina);
        btnCalcular = findViewById(R.id.btnCalcular);

        //criando um listener para "ouvir" o clique do botao
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });
    }
    private  void calcular(){
        double valorEtanol = Double.parseDouble(edtEtanol.getText().toString());
        double valorGasolina = Double.parseDouble(edtGasolina.getText().toString());

        double resultado = valorEtanol / valorGasolina;
        if (resultado <= 0.7){
            //melhorEtanol
            mostrarMensagem("Melhor abastecer com etanol");
        }else{
            //melhorGasolina
            mostrarMensagem("Melhor abastecer com gasolina");
        }
    }
    private  void mostrarMensagem(String texto){
        //Criando uma mensagem do tipo TOAST
        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();

        //Criando uma mensagem
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);

        //adicionando um titulo no alerta/dialog
        alerta.setTitle("Resutlado");

        //adicionando uma mensagem no alerta/dialog
        alerta.setMessage(texto);

        //adicionando btn para fechar a mensagem
        alerta.setNeutralButton("ok", null);

        //exebindo o alerta/dialog na tela
        alerta.show();
    }
}