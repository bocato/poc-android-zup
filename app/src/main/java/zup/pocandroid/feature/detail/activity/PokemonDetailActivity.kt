package zup.pocandroid.feature.detail.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pokemon_list.*
import zup.pocandroid.R
import zup.pocandroid.base.BaseActivity
import zup.pocandroid.base.BaseDatabindingActivity
import zup.pocandroid.data.model.presentation.PokemonPresentation
import zup.pocandroid.feature.list.adapter.PokemonAdapter
import zup.pocandroid.feature.list.viewmodel.PokemonListViewModel
import javax.inject.Inject
/*
class PokemonDetailActivity : BaseDatabindingActivity<ActivityDetailDatabinding, ActivityPokemonDe>() {

    override fun getViewModelClass(): Class<PokemonListViewModel> = PokemonListViewModel::class.java

}*/
