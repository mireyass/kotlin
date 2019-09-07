package com.maeruiz.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {


    // Declaramos las variables
    private var operador: String? = null
    //Esta variable siempre guarda el valor anterior antes de presionar algún operador, Almacena el dato de manera temporal
    private var valorAnterior: String ? = null

    private var etIngreso: EditText?= null

    private var btn1: Button?=null
    private var btn2: Button?=null
    private var btn3: Button?=null
    private var btn4: Button?=null
    private var btn5: Button?=null
    private var btn6: Button?=null
    private var btn7: Button?=null
    private var btn8: Button?=null
    private var btn9: Button?=null
    private var btn0: Button?=null
    private var btnpunto: Button?=null

    private var btnsuma: Button?=null
    private var btnresta: Button?=null
    private var btnmultiplicacion: Button?=null
    private var btndivision: Button?=null
    private var btnigual : Button?=null
    private var btndel : Button?=null
    private var btnac : Button?=null
    private var btmasmenos : Button?=null
    private var tvsigno : TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Asignnamos variables al Xml
        etIngreso = findViewById<EditText>(R.id.etIngreso)
        btn1=findViewById<Button>(R.id.btn1)
        btn2=findViewById<Button>(R.id.btn2)
        btn3=findViewById<Button>(R.id.btn3)
        btn4=findViewById<Button>(R.id.btn4)
        btn5=findViewById<Button>(R.id.btn5)
        btn6=findViewById<Button>(R.id.btn6)
        btn7=findViewById<Button>(R.id.btn7)
        btn8=findViewById<Button>(R.id.btn8)
        btn9=findViewById<Button>(R.id.btn9)
        btn0=findViewById<Button>(R.id.btn0)
        btnpunto=findViewById<Button>(R.id.btnpunto)
        btnsuma=findViewById<Button>(R.id.btnsuma)
        btnresta=findViewById<Button>(R.id.btnresta)
        btnmultiplicacion=findViewById<Button>(R.id.btnmultiplicacion)
        btndivision=findViewById<Button>(R.id.btndivision)
        btnigual=findViewById<Button>(R.id.btnigual)
        btndel=findViewById<Button>(R.id.btndel)
        btnac=findViewById<Button>(R.id.btnac)
        btmasmenos=findViewById<Button>(R.id.btnmasmenos)
        tvsigno=findViewById<TextView>(R.id.tvSigno)


        /*
        btn1=findViewById<Button>(R.id.btn1)
        btn1!!.setOnClickListener(View.OnClickListener {
            etIngreso?.setText("Hola");
        })
        */
        //Preparamos para el evento de OnClick
        btn1!!.setOnClickListener(this)
        btn2!!.setOnClickListener(this)
        btn3!!.setOnClickListener(this)
        btn4!!.setOnClickListener(this)
        btn5!!.setOnClickListener(this)
        btn6!!.setOnClickListener(this)
        btn7!!.setOnClickListener(this)
        btn8!!.setOnClickListener(this)
        btn9!!.setOnClickListener(this)
        btn0!!.setOnClickListener(this)
        btnpunto!!.setOnClickListener(this)
        btnsuma!!.setOnClickListener(this)
        btnresta!!.setOnClickListener(this)
        btnmultiplicacion!!.setOnClickListener(this)
        btndivision!!.setOnClickListener(this)
        btnigual!!.setOnClickListener(this)
        btndel!!.setOnClickListener(this)
        btnac!!.setOnClickListener(this)
        btmasmenos!!.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        //Utilizo esta variable para calcular el resultado, solo lo hago para que sea mas entendible mi codigo, por que no hace falta utilizar esta variable
        var resultado: Float = 0f
        //De acuerdo a que boton se presione se identifica por su id
        when (v?.id) {
            R.id.btn1 -> { etIngreso?.setText( etIngreso?.text.toString() + "1") }
            R.id.btn2 -> { etIngreso?.setText( etIngreso?.text.toString() + "2") }
            R.id.btn3 -> { etIngreso?.setText( etIngreso?.text.toString() + "3") }
            R.id.btn4 -> { etIngreso?.setText( etIngreso?.text.toString() + "4") }
            R.id.btn5 -> { etIngreso?.setText( etIngreso?.text.toString() + "5") }
            R.id.btn6 -> { etIngreso?.setText( etIngreso?.text.toString() + "6") }
            R.id.btn7 -> { etIngreso?.setText( etIngreso?.text.toString() + "7") }
            R.id.btn8 -> { etIngreso?.setText( etIngreso?.text.toString() + "8") }
            R.id.btn9 -> { etIngreso?.setText( etIngreso?.text.toString() + "9") }
            R.id.btn0 -> { etIngreso?.setText( etIngreso?.text.toString() + "0") }
            R.id.btnpunto -> { etIngreso?.setText( etIngreso?.text.toString() + ".") }

            R.id.btnsuma -> {
                //Almacenamos el valor anterior
                valorAnterior=etIngreso?.text.toString()
                etIngreso?.setText("") // Lo ingresado lo ponemos en vacio
                operador="+"
            }
            R.id.btnresta -> {
                //Almacenamos el valor anterior
                valorAnterior=etIngreso?.text.toString()
                etIngreso?.setText("")// Lo ingresado lo ponemos en vacio
                operador="-"
            }
            R.id.btnmultiplicacion -> {
                //Almacenamos el valor anterior
                valorAnterior=etIngreso?.text.toString()
                etIngreso?.setText("")// Lo ingresado lo ponemos en vacio
                operador="*"
            }
            R.id.btndivision -> {
                //Almacenamos el valor anterior
                valorAnterior=etIngreso?.text.toString()
                etIngreso?.setText("")// Lo ingresado lo ponemos en vacio
                operador="/"
            }

            R.id.btnigual->{
                when (operador){
                    "+"->{
                        //Procesamos dentro de la variable
                        resultado = valorAnterior?.toFloat()!! + etIngreso?.text.toString().toFloat()
                        etIngreso?.setText( resultado.toString());
                    }
                    "-"->{
                        resultado = valorAnterior?.toFloat()!! - etIngreso?.text.toString().toFloat()
                        etIngreso?.setText( resultado.toString());
                    }
                    "*"->{
                        resultado = valorAnterior?.toFloat()!! * etIngreso?.text.toString().toFloat()
                        etIngreso?.setText( resultado.toString());
                    }
                    "/"->{
                        resultado = valorAnterior?.toFloat()!! / etIngreso?.text.toString().toFloat()
                        etIngreso?.setText( resultado.toString());
                    }
                }
            }

            R.id.btndel -> {
                var cadena = etIngreso?.text.toString()
                if ( (cadena != null) && (!cadena.equals("")) ) { //Verifica que la cadena no este vacia o nula
                    cadena = cadena.substring(0, cadena.length - 1) //Elimine el ultimo caracter
                    etIngreso?.setText(cadena)
                }

            }
            R.id.btnac -> {
                etIngreso?.setText("")
                operador="";
            }
            R.id.btnmasmenos -> {
                resultado = etIngreso?.text.toString().toFloat()
                resultado = resultado  * (-1) //Multiplica por negativo para pasar de positivo a negativo
                //Log.e("resultado", resultado.toString())
                etIngreso?.setText(resultado.toString())
                if (resultado>0) {
                    tvsigno?.setText("+")
                }
                else
                {
                    tvsigno?.setText("-")
                }

            }
        }

    }
}
