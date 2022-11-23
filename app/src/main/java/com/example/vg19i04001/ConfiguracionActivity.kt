package com.example.vg19i04001

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.example.vg19i04001.databinding.ActivityConfiguracionBinding
import com.google.android.material.snackbar.Snackbar

class ConfiguracionActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityConfiguracionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfiguracionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Habilitar action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Configuraciones"

        // Configuracion del evento click en los botones
        binding.btnSiguiente.setOnClickListener(this)
    }

    override fun onClick(p0: View?){
        when(p0!!.id){
            binding.btnSiguiente.id ->{
                // Validar si se ha seleccionado uno de los radiobuttons
                if((binding.edtNick.text.toString().isNotEmpty())&& !binding.rbtFacil.isChecked
                    && !binding.rbtMedio.isChecked && !binding.rbtDificil.isChecked){
                    Snackbar.make(binding.root,R.string.seleccionar_opcion,
                        Snackbar.LENGTH_SHORT).show()
                }else if(binding.rbtFacil.isChecked){
                    if(binding.edtNick.text.toString().isNotEmpty()){
                        val intent: Intent = Intent(this, InicioJuegoActivity::class.java)

                        intent.putExtra("dificultad", 1)
                        val nick: String = binding.edtNick.text.toString()
                        intent.putExtra("nick", nick)
                        startActivity(intent)
                    }
                }
                else if(binding.rbtMedio.isChecked){
                    if(binding.edtNick.text.toString().isNotEmpty()){
                        val intent: Intent = Intent(this, InicioJuegoActivity::class.java)

                        intent.putExtra("dificultad", 2)
                        val nick: String = binding.edtNick.text.toString()
                        intent.putExtra("nick", nick)
                        startActivity(intent)
                    }
                }
                else if(binding.rbtDificil.isChecked){
                    if(binding.edtNick.text.toString().isNotEmpty()){
                        val intent: Intent = Intent(this, InicioJuegoActivity::class.java)

                        intent.putExtra("dificultad", 3)
                        val nick: String = binding.edtNick.text.toString()
                        intent.putExtra("nick", nick)
                        startActivity(intent)
                    }
                }
            }
        }
    }

    // Configurar action bar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                // Debe permitir regresar a la actividad anterior
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}