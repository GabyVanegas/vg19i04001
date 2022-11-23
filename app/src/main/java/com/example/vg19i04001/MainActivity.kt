package com.example.vg19i04001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.vg19i04001.Repository.PuntuacionRepository
import com.example.vg19i04001.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var tipoDificultad: Int = 0
    private lateinit var nick: String
    private var respuesta: Int = 0
    companion object {
        val puntuacionRepository: PuntuacionRepository = PuntuacionRepository()
    }
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
                        respuesta =(Math.random()*50+1).toInt()
                        val intent: Intent = Intent(this, InicioJuegoActivity::class.java)
                        intent.putExtra("dificultad", tipoDificultad)
                        intent.putExtra("nick", nick)
                        intent.putExtra("respuesta", respuesta)
                        startActivity(intent)
                    }else if(tipoDificultad == 2){
                        respuesta =(Math.random()*100+1).toInt()
                        val intent: Intent = Intent(this, InicioJuegoActivity::class.java)
                        intent.putExtra("dificultad", tipoDificultad)
                        intent.putExtra("nick", nick)
                        intent.putExtra("respuesta", respuesta)
                        startActivity(intent)
                    }else if(tipoDificultad == 3){
                        respuesta =(Math.random()*150+1).toInt()
                        val intent: Intent = Intent(this, InicioJuegoActivity::class.java)
                        intent.putExtra("dificultad", tipoDificultad)
                        intent.putExtra("nick", nick)
                        intent.putExtra("respuesta", respuesta)
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