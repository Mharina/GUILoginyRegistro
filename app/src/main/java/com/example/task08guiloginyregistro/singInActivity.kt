package com.example.task08guiloginyregistro

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class singInActivity : AppCompatActivity() {

    //VARIABLES
    private lateinit var email : EditText
    private lateinit var Password : EditText
    private lateinit var btnLogin : Button
    private lateinit var btnForgotPassword : Button
    private lateinit var btnLoginGoogle : Button
    private lateinit var btnLoginFacebook : Button
    private lateinit var btnSingIn : Button
    private lateinit var auth: FirebaseAuth
    private lateinit var btnatras : ImageButton

    //VARIABLE SISTEMA LOG
    private val TAG = "singInActivity"

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d(TAG, "onCreate: La actividad está siendo creada")
        //CREACION DE LA VISTA

        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singin)

        //ASIGNACION DE VARIABLES CON ELEMENTOS LAYOUT
        Log.d(TAG, "ASIGNACION DE VARIABLES CON ELEMENTOS LAYOUT")

        email = findViewById(R.id.usuario)
        Password = findViewById(R.id.contraseña)
        btnLogin = findViewById(R.id.btnLogin)
        btnSingIn = findViewById(R.id.btnSingIn)
        btnatras = findViewById(R.id.imageButton)

        btnatras.setOnClickListener{
            var intent = Intent(this@singInActivity, loginActivity::class.java)
            startActivity(intent)
        }

        try {
            btnLogin.setOnClickListener{
                if (email.text.isNotEmpty() && Password.text.isNotEmpty()){
                    auth.createUserWithEmailAndPassword(email.text.toString(), Password.text.toString()).addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "Autenticacion del ususario Correcta")
                                //val user = auth.currentUser
                                val intent = Intent(this@singInActivity, saludosActivity::class.java)
                                intent.putExtra("email", email.text.toString())
                                startActivity(intent)


                            } else {
                                val builder = AlertDialog.Builder(this)
                                builder.setTitle("Error")
                                builder.setMessage("Se ha producido un error en la autenticacion del ususario")
                                builder.setPositiveButton("Aceptar",null)
                                val dialog: AlertDialog = builder.create()
                                dialog.show()
                            }
                    }

                }else{ Log.d(TAG, "Debes rellenar los campos") }

             }
        } catch (e: Exception) {
            Log.d(TAG, "Error en la autentificacion del usuario")
        }




        try {

                btnSingIn.setOnClickListener(View.OnClickListener {
                    val intent = Intent(this@singInActivity, loginActivity::class.java)
                    startActivity(intent)
                })



        } catch (e: Exception) {
            Log.d(TAG, "Usuario No Creado Correctamente")
        }



    }


}













