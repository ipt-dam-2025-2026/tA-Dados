package pt.ipt.dam2025.dados

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pt.ipt.dam2025.dados.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // objeto que fará a ligação aos objetos presentes na interface (XML) da app
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // instanciar o objeto binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        // setContentView(R.layout.activity_main)
        setContentView(binding.root)

        // ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // se carreguei no 'botão' alguma coisa deveria ser feita...
        // findViewById<Button>(R.id.btnRodarDado).setOnClickListener {}
        binding.btnRodarDado.setOnClickListener {
            // rodar o dado
            rodarDado()
        }
    }

    /**
     * Roda o dado e atualiza a imagem correspondente
     */
    private fun rodarDado() {
       /* Algoritmo
          1- gerar num. aletório [1;6]
          2- determinar a imagem a mostrar em função do num. gerado
          3- mostrar a imagem correspondente
          4- atualizar o texto com o num. gerado
        */

        // 1.
        val numAleatorio = (1..6).random()
        // val numAleatorio = Random.nextInt(1, 7)
        // val numAleatorio = Random().nextInt(6) + 1

        // 2.
        val imagemResource = when (numAleatorio) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        // 3.
        binding.imgViewDado.setImageResource(imagemResource)

        // 4.
        binding.txtViewValorDado.text = numAleatorio.toString()



    }
}