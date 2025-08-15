package com.abdel.project1

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val text1=findViewById<TextView>(R.id.textView01)
        val btn1=findViewById<Button>(R.id.clickhere)
        val textbox=findViewById<EditText>(R.id.editTextText)
        btn1.setOnClickListener{
            Toast.makeText(this, "abdel is here", Toast.LENGTH_LONG ).show()
            text1.setText(textbox.text.toString())
        }
        val btn2=findViewById<Button>(R.id.showbtn)
        //switch show button to hide button
        btn2.setOnClickListener{
            if(btn2.text.toString().equals("show")){
                textbox.transformationMethod = HideReturnsTransformationMethod.getInstance()
                btn2.text = "hide"
            }
            else{
                textbox.transformationMethod = PasswordTransformationMethod.getInstance()
                btn2.text = "Show"
            }
        }
        val nextpagebtn=findViewById<Button>(R.id.pagebtn)
        nextpagebtn.setOnClickListener{
         val intent=Intent(this,MainActivity2::class.java)
          startActivity(intent)
        }

    }
}