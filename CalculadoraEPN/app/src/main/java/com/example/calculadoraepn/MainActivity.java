package com.example.calculadoraepn;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.faendir.rhino_android.RhinoAndroidHelper;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ast.Scope;

public class MainActivity extends AppCompatActivity {

     Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnSum, btnRest, btnMul, btnDiv, btnSin, btnCos, btnTan, btnIgual, btnPunto, btnClear, btnParent, btnPorcent;
     TextView tvEntrada, tvSalida;
     String proceso;
     int trigonometrica = 0;
     boolean checkParent =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn_Cero);
        btn1 = findViewById(R.id.btn_Uno);
        btn2 = findViewById(R.id.btn_Dos);
        btn3 = findViewById(R.id.btn_Tres);
        btn4 = findViewById(R.id.btn_Cuatro);
        btn5 = findViewById(R.id.btn_Cinco);
        btn6 = findViewById(R.id.btn_Seis);
        btn7 = findViewById(R.id.btn_Siete);
        btn8 = findViewById(R.id.btn_Ocho);
        btn9 = findViewById(R.id.btn_Nueve);


        btnSum = findViewById(R.id.btn_Sum);
        btnRest = findViewById(R.id.btn_Rest);
        btnMul = findViewById(R.id.btn_Mult);
        btnDiv = findViewById(R.id.btn_Div);

        btnSin = findViewById(R.id.btn_Sin);
        btnCos = findViewById(R.id.btn_Cos);
        btnTan = findViewById(R.id.btn_Tan);
        btnPorcent= findViewById(R.id.btn_Porcent);

        btnIgual = findViewById(R.id.btn_Igual);
        btnPunto = findViewById(R.id.btn_Punto);
        btnClear = findViewById(R.id.btn_Eliminar);
        btnParent = findViewById(R.id.btnParent);

        tvEntrada = findViewById(R.id.entrada);
        tvSalida = findViewById(R.id.salida);



        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvEntrada.setText("");
                tvSalida.setText("");
            }
        });

        btnPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso=tvEntrada.getText().toString();
                tvEntrada.setText(proceso + ".");
            }
        });


        btnParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkParent){
                    proceso=tvEntrada.getText().toString();
                    tvEntrada.setText(proceso + ")");
                    checkParent=false;
                }else{proceso=tvEntrada.getText().toString();
                tvEntrada.setText(proceso + "(");
                checkParent=true;
                }

            }
        });

        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso = tvEntrada.getText().toString();

                proceso = proceso.replace("x","*");
                proceso = proceso.replace("%","/100");
                proceso = proceso.replace("÷","/");


                if(trigonometrica==1){
                    proceso = proceso.replace("Sin(","");
                    Double NewValor = Double.parseDouble(proceso);
                    Double newContainer = Math.toRadians(NewValor);
                    proceso = ""+Math.sin(newContainer);

                    System.out.println("EL Sin de:"+ NewValor + "es = "+proceso);
                }else if (trigonometrica==2){

                    proceso = proceso.replace("Cos(","");
                    Double NewValor = Double.parseDouble(proceso);
                    Double newContainer = Math.toRadians(NewValor);
                    proceso = ""+Math.cos(newContainer);

                    System.out.println("EL Sin de:"+ NewValor + "es = "+proceso);
                }else if(trigonometrica==3){
                    proceso = proceso.replace("Tan(","");
                    Double NewValor = Double.parseDouble(proceso);
                    Double newContainer = Math.toRadians(NewValor);
                    proceso = ""+Math.tan(newContainer);
                    System.out.println("EL Sin de:"+ NewValor + "es = "+proceso);

                }

                    Context rhino = Context.enter();

                    rhino.setOptimizationLevel(-1);

                    String ResultadoFinal = " ";

                    try{
                        Scriptable scriptable = rhino.initStandardObjects();
                        ResultadoFinal = rhino.evaluateString(scriptable,proceso,"javascript",1,null).toString();
                    }catch (Exception e){
                        ResultadoFinal="0";

                    }
                    tvSalida.setText(ResultadoFinal);




            }
        });


        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso=tvEntrada.getText().toString();
                tvEntrada.setText(proceso+"+");
            }
        });
        btnRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso=tvEntrada.getText().toString();
                tvEntrada.setText(proceso+"-");
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso=tvEntrada.getText().toString();
                tvEntrada.setText(proceso+"x");
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso=tvEntrada.getText().toString();
                tvEntrada.setText(proceso+"÷");
            }
        });



        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso=tvEntrada.getText().toString();
                tvEntrada.setText(proceso + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso=tvEntrada.getText().toString();
                tvEntrada.setText(proceso + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso=tvEntrada.getText().toString();
                tvEntrada.setText(proceso+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso=tvEntrada.getText().toString();
                tvEntrada.setText(proceso+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso=tvEntrada.getText().toString();
                tvEntrada.setText(proceso+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso=tvEntrada.getText().toString();
                tvEntrada.setText(proceso+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso=tvEntrada.getText().toString();
                tvEntrada.setText(proceso+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso=tvEntrada.getText().toString();
                tvEntrada.setText(proceso+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso=tvEntrada.getText().toString();
                tvEntrada.setText(proceso+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso=tvEntrada.getText().toString();
                tvEntrada.setText(proceso+"9");
            }
        });



        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso=tvEntrada.getText().toString();
                tvEntrada.setText("Sin("+proceso);
                trigonometrica =1;


            }
        });

        btnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso=tvEntrada.getText().toString();
                tvEntrada.setText("Cos("+proceso);
                trigonometrica =2;
            }
        });

        btnTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso=tvEntrada.getText().toString();
                tvEntrada.setText("Tan("+proceso);
                trigonometrica =3;
            }
        });


        btnPorcent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceso=tvEntrada.getText().toString();
                tvEntrada.setText(proceso+"%");
            }
        });







    }



}
