package com.rimapps.kotlintuts
import android.R.attr.key
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.rimapps.kotlintuts.network.Character
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString


class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy{
        ViewModelProvider(this)[MainViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.characterLiveData.observe(this) { state ->
            processCharacterResponse(state)
        }
    }
    private fun processCharacterResponse(state: ScreenState<List<Character>?>){
        val pbMain = findViewById<ProgressBar>(R.id.pbMain)
        when(state){
           is ScreenState.Loading->{
               pbMain.visibility = View.VISIBLE
            }
            is ScreenState.Success-> {
                pbMain.visibility = View.GONE
                if (state.data != null) {
                    val characterAdapter = CharacterAdapter(state.data)
                    val recyclerView = findViewById<RecyclerView>(R.id.rvCharacters)
                    recyclerView?.layoutManager = LinearLayoutManager(this@MainActivity)
                    recyclerView?.adapter = characterAdapter

                    characterAdapter.setOnItemClickListener(object : CharacterAdapter.OnItemClickListener{
                        override fun onItemClick(position: Int) {
                            val item = characterAdapter.getItem(position)
                            //Toast.makeText(this@MainActivity,item.toString(),Toast.LENGTH_SHORT).show()

                            val mIntent = Intent(this@MainActivity, CharaterViewActivity::class.java)
                            mIntent.putExtra("whole",Json.encodeToString(item))
                            startActivity(mIntent)
                        }
                    })
                }
            }
            is ScreenState.Error ->{
                pbMain.visibility = View.GONE
                val view = pbMain.rootView
                Snackbar.make(view,state.message!!, Snackbar.LENGTH_SHORT).show()
            }
            }
        }
    }
