package com.example.task08guiloginyregistro

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth

class loginActivity : AppCompatActivity() {

     private lateinit var email : EditText
     private lateinit var Password : EditText
     private lateinit var radioButtonH : RadioButton
     private lateinit var radioButtonM : RadioButton
     private lateinit var spinner : Spinner
     private lateinit var btnSingIn: Button
     private lateinit var auth: FirebaseAuth
     //VARIABLE SISTEMA LOG
     private val TAG = "LoginActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.editText)
        Password = findViewById(R.id.editText2)
        btnSingIn = findViewById(R.id.btnSingIn)
        auth= Firebase.auth



        try {
            btnSingIn.setOnClickListener{

                if (email.text.isNotEmpty() && Password.text.isNotEmpty()){



                    auth.createUserWithEmailAndPassword(email.text.toString(), Password.text.toString()).addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Log.d(TAG, "Usuario Creado Correctamente")
                            //val user = auth.currentUser
                            val intent = Intent(this@loginActivity, saludosActivity::class.java)
                            intent.putExtra("email", email.text.toString())
                            startActivity(intent)
                        } else {
                            Log.d(TAG, "Usuario No Creado Correctamente")
                        }
                    }
                } else{
                    Log.d(TAG, "Debes rellenar los campos")
                }
            }

        } catch (e: Exception) {
            Log.d(TAG, "Error no esperado")
        }



    }

}