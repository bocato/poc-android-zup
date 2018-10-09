package zup.pocandroid.feature.list.navigator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import org.junit.Test

import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import zup.pocandroid.feature.detail.activity.PokemonDetailActivity
import org.powermock.api.mockito.PowerMockito
import org.powermock.api.mockito.PowerMockito.whenNew

@RunWith(PowerMockRunner::class)
@PrepareForTest(PokemonDetailActivity::class)
class PokemonListNavigatorTest {

    @Mock
    private lateinit var activityMock: AppCompatActivity
    @Mock
    private lateinit var intentMock: Intent

    private lateinit var pokemonListNavigator: PokemonListNavigator

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        PowerMockito.mockStatic(PokemonDetailActivity::class.java)

        whenNew<Intent>(Intent::class.java)
                .withAnyArguments()
                .thenReturn(intentMock)

        pokemonListNavigator = PokemonListNavigator(activityMock)
    }

    @Test
    fun onClickPokemon() {
        // Given
        val pokemonId = "1"

        // When
        pokemonListNavigator.onClickPokemon(pokemonId)

        // Then
        verify(activityMock).startActivity(intentMock)
    }
}