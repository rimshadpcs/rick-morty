package com.rimapps.kotlintuts
import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.rimapps.kotlintuts.network.Character
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString

class CharaterViewActivity : AppCompatActivity() {
    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charater_view)

        val obj = Json.decodeFromString<Character>(intent.getStringExtra("whole").toString())


        val characterNameView = findViewById<TextView>(R.id.tvCharacterViewName)
        val characterStatusView = findViewById<TextView>(R.id.tvCharacterStatusView)
        val characterGenderView = findViewById<TextView>(R.id.tvCharacterGender)
        val characterNameSpeciesView = findViewById<TextView>(R.id.tvCharacterSpecies)
        val characterImageView = findViewById<ImageView>(R.id.ivCharacterImageView)

        characterNameView.setText(obj.name)
        characterGenderView.setText(obj.gender)
        characterStatusView.setText(obj.status)
        characterNameSpeciesView.setText(obj.species)

        Glide.with(this)
            .load(Uri.parse(obj.image))
            .into(characterImageView);
   }
    }
