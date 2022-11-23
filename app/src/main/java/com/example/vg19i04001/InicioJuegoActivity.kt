package com.example.vg19i04001

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.example.vg19i04001.Models.PuntuacionEntity
import com.example.vg19i04001.databinding.ActivityInicioJuegoBinding
import com.example.vg19i04001.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class InicioJuegoActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityInicioJuegoBinding

    private lateinit var num: String
    private var tipodificultad: Int = 0
    private var numIntentos: Int = 0
    private var numPuntaje: Int = 0
    private var respuesta: Int = 0
    private var respuestaC: Int = 0
    private lateinit var nick: String

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioJuegoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Habilitar action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Inicio del juego"

        tipodificultad = intent.extras!!.getInt("dificultad")
        nick = intent.extras!!.getString("nick").toString()
        respuestaC = intent.extras!!.getInt("respuesta")



        binding.txvIntentos.text = "Numero de intentos: $numIntentos"
        binding.tvxnick.text = "nick: $nick"


        binding.btnIniciar.setOnClickListener(this)

        if(tipodificultad == 1){
            binding.txvTipodificultad.text = "Dificultad fácil"
            binding.tvxnumMedio.visibility = View.GONE
            binding.tvxnumdificil.visibility = View.GONE
        }

        if(tipodificultad == 2){
            binding.txvTipodificultad.text = "Dificultad media"
            binding.tvxnum.visibility = View.GONE
            binding.tvxnumdificil.visibility = View.GONE
        }

        if(tipodificultad == 3){
            binding.txvTipodificultad.text = "Dificultad dificil"
            binding.tvxnum.visibility = View.GONE
            binding.tvxnumMedio.visibility = View.GONE
        }


    }

    override fun onClick(p0: View?){
        when(p0!!.id){
            binding.btnIniciar.id->{
                if(tipodificultad == 1) {
                    if (binding.edtNum.text.toString().isNotEmpty()) {
                        respuesta = Integer.parseInt(binding.edtNum.text.toString())

                        if(respuesta == respuestaC){
                            doAsync {
                                PuntuacionApplication.database.getPuntuacionDao().addPuntuacion(
                                    PuntuacionEntity(nick = nick,
                                    puntaje = numIntentos.toString())
                                )
                                uiThread {
                                    finish()
                                }
                            }
                            Snackbar.make(
                                binding.root, R.string.respuesta,
                                Snackbar.LENGTH_SHORT
                            ).show()
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        }else{
                            if(respuesta < respuestaC){
                                Snackbar.make(
                                    binding.root, R.string.numMayor,
                                    Snackbar.LENGTH_SHORT
                                ).show()
                            }
                            else if(respuesta > respuestaC){
                                Snackbar.make(
                                    binding.root, R.string.numMenor,
                                    Snackbar.LENGTH_SHORT
                                ).show()
                            }
                        }
                        numIntentos+= 1
                        binding.txvIntentos.text = "numero de intentos: $numIntentos"
                    }
                }

                if(tipodificultad == 2) {
                    if (binding.edtNum.text.toString().isNotEmpty()) {
                        respuesta = Integer.parseInt(binding.edtNumMedio.text.toString())

                        if(respuesta == respuestaC){
                            doAsync {
                                PuntuacionApplication.database.getPuntuacionDao().addPuntuacion(
                                    PuntuacionEntity(nick = nick,
                                        puntaje = numIntentos.toString())
                                )
                                uiThread {
                                    finish()
                                }
                            }
                            Snackbar.make(
                                binding.root, R.string.respuesta,
                                Snackbar.LENGTH_SHORT
                            ).show()
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        }else{
                            if(respuesta < respuestaC){
                                Snackbar.make(
                                    binding.root, R.string.numMayor,
                                    Snackbar.LENGTH_SHORT
                                ).show()
                            }
                            else if(respuesta > respuestaC){
                                Snackbar.make(
                                    binding.root, R.string.numMenor,
                                    Snackbar.LENGTH_SHORT
                                ).show()
                            }
                        }
                        numIntentos+= 1
                        binding.txvIntentos.text = "numero de intentos: $numIntentos"
                    }
                }

                if(tipodificultad == 3) {
                    if (binding.edtNum.text.toString().isNotEmpty()) {
                        respuesta = Integer.parseInt(binding.edtNumDificil.text.toString())

                        if(respuesta == respuestaC){
                            doAsync {
                                PuntuacionApplication.database.getPuntuacionDao().addPuntuacion(
                                    PuntuacionEntity(nick = nick,
                                        puntaje = numIntentos.toString())
                                )
                                uiThread {
                                    finish()
                                }
                            }
                            Snackbar.make(
                                binding.root, R.string.respuesta,
                                Snackbar.LENGTH_SHORT
                            ).show()
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        }else{
                            if(respuesta < respuestaC){
                                Snackbar.make(
                                    binding.root, R.string.numMayor,
                                    Snackbar.LENGTH_SHORT
                                ).show()
                            }
                            else if(respuesta > respuestaC){
                                Snackbar.make(
                                    binding.root, R.string.numMenor,
                                    Snackbar.LENGTH_SHORT
                                ).show()
                            }
                        }
                        numIntentos+= 1
                        binding.txvIntentos.text = "numero de intentos: $numIntentos"
                    }
                }
            }
        }
    }
    // Configuracion del action bar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                // Deberá permitir volver a la actividad anterior
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}