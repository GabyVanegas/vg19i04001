package com.example.vg19i04001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.vg19i04001.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var tipoDificultad: Int = 0
    private lateinit var nick: String
    private var respuestaC: Int = 0
    var nFacil = 50
    var nMedio = 100
    var nDificil = 150

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.layoutPrincipal.btnIniciarJuego.setOnClickListener(this)
        binding.layoutPrincipal.btnPuntuacion.setOnClickListener(this)
        binding.layoutPrincipal.btnConfiguracion.setOnClickListener(this)


    }

    override fun onClick(p0: View?){
        when(p0!!.id){
            binding.layoutPrincipal.btnIniciarJuego.id->{
                tipoDificultad = intent.extras!!.getInt("dificultad")
                nick = intent.extras!!.getString("nick").toString()

                if(tipoDificultad == 0){
                    Snackbar.make(binding.root,R.string.registrar_nick,
                        Snackbar.LENGTH_SHORT).show()
                }else{
                    if(tipoDificultad == 1){
                        respuestaC = (Math.random()* nFacil).toInt() + 1
                        val intent: Intent = Intent(this, InicioJuegoActivity::class.java)
                        intent.putExtra("dificultad", tipoDificultad)
                        intent.putExtra("nick", nick)
                        intent.putExtra("respuesta", respuestaC)
                        startActivity(intent)

                    }else if(tipoDificultad == 2){
                        respuestaC =(Math.random()* nMedio).toInt() + 1
                        val intent: Intent = Intent(this, InicioJuegoActivity::class.java)
                        intent.putExtra("dificultad", tipoDificultad)
                        intent.putExtra("nick", nick)
                        intent.putExtra("respuesta", respuestaC)
                        startActivity(intent)

                    }else if(tipoDificultad == 3){
                        respuestaC =(Math.random()* nDificil).toInt() + 1
                        val intent: Intent = Intent(this, InicioJuegoActivity::class.java)
                        intent.putExtra("dificultad", tipoDificultad)
                        intent.putExtra("nick", nick)
                        intent.putExtra("respuesta", respuestaC)
                        startActivity(intent)
                    }
                }

            }
            binding.layoutPrincipal.btnConfiguracion.id->{
                startActivity(Intent(this, ConfiguracionActivity::class.java))
            }
            binding.layoutPrincipal.btnPuntuacion.id->{
                startActivity(Intent(this, PuntuacionActivity::class.java))
            }
        }
    }
}