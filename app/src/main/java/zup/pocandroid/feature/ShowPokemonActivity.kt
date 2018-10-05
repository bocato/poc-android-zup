package zup.pocandroid.feature

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show_pokemon.*
import zup.pocandroid.R
import zup.pocandroid.data.model.presentation.Pokemon

class ShowPokemonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_pokemon)

        pokemonRV.adapter = PokemonAdapter(getPokemonList(), this)
    }

    private fun getPokemonList(): List<Pokemon> {
        return ArrayList<Pokemon>()
    }

}
