package br.com.edgar.meuappcomiot

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        botaoConectar.setOnClickListener{
            startActivity(Intent(
                    this,
                    SignUpActivity::class.java))
        }

        botaoCriarConta.setOnClickListener{
            mAuth.signInWithEmailAndPassword(email.text.toString(),
                    senha.text.toString()).addOnCompleteListener{
                if (it.isSuccessful){
                    vaiParaProximaTela()
                }else{
                    exibeErro()
                }


            }
        }


    }
    private fun vaiParaProximaTela(){
        startActivity(Intent(this, ContolActivity::class.java))
        finish()
    }

    private fun exibeErro(){
        Toast.makeText(this, "Email/senha inválida",Toast.LENGTH_SHORT).show()
        
    }
}