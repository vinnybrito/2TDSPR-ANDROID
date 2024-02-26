package com.caiosilva.jankenpo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.caiosilva.jankenpo.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    private val options: List<String> = listOf("Papel", "Pedra", "Tesoura")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageViewPadrao.setOnClickListener {
            Toast.makeText(this, "Você clicou no seu adversário", Toast.LENGTH_SHORT).show()
        }

        binding.imageViewPapel.setOnClickListener {
            // Toast.makeText(this, "Você clicou no ${options[0]}", Toast.LENGTH_SHORT).show()
            onOptionSelected(0)
        }

        binding.imageViewPedra.setOnClickListener {
            // Toast.makeText(this, "Você clicou na ${options[1]}", Toast.LENGTH_SHORT).show()
            onOptionSelected(1)
        }

        binding.imageViewTesoura.setOnClickListener {
            // Toast.makeText(this, "Você clicou na ${options[2]}", Toast.LENGTH_SHORT).show()
            onOptionSelected(2)
        }

    }

    private fun onOptionSelected(choice: Int) {
        println(choice)
        val computerChoice: Int = Random.nextInt(3)
        println(options[computerChoice])

        binding.resultTextView.text = checkWinner(Pair(computerChoice, choice))

    }

    private fun checkWinner(choices: Pair<Int, Int>): String {
        if (choices.first == choices.second)
            return getString(R.string.result_draw, options[choices.first])

        return when(choices) {
            Pair(0, 1) -> {
                binding.imageViewPadrao.setImageDrawable(getDrawable(R.drawable.papel))
                getString(R.string.result_app_loses, options[choices.first])
            }
            Pair(0, 2) -> {
                binding.imageViewPadrao.setImageDrawable(getDrawable(R.drawable.papel))
                getString(R.string.result_app_wins, options[choices.first])
            }
            Pair(1, 0) -> {
                binding.imageViewPadrao.setImageDrawable(getDrawable(R.drawable.pedra))
                getString(R.string.result_app_wins, options[choices.first])
            }
            Pair(1, 2) -> {
                binding.imageViewPadrao.setImageDrawable(getDrawable(R.drawable.pedra))
                getString(R.string.result_app_loses, options[choices.first])
            }
            Pair(2, 0) -> {
                binding.imageViewPadrao.setImageDrawable(getDrawable(R.drawable.tesoura))
                getString(R.string.result_app_loses, options[choices.first])
            }
            Pair(2, 1) -> {
                binding.imageViewPadrao.setImageDrawable(getDrawable(R.drawable.tesoura))
                getString(R.string.result_app_wins, options[choices.first])
            }
            else -> ""
        }
    }

}
