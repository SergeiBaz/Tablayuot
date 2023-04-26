package com.example.tablayuot.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.example.tablayuot.MainViewModel
import com.example.tablayuot.PlantModel
import com.example.tablayuot.R
import com.example.tablayuot.databinding.MainFragmentBinding

class MainFragment : Fragment() {
    private lateinit var binding: MainFragmentBinding
    private val viewModel: MainViewModel by activityViewModels()
       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
           binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button2.setOnClickListener{
            viewModel.plant.value = PlantModel(
                R.drawable.romachca,
                "Рома́шка (лат. Matricária) — род однолетних цветковых растений семейства астровые, или сложноцветные (Asteraceae)" +
                        ", по современной классификации объединяет около 70 видов[10]невысоких пахучих трав[11]" +
                        ", цветущих с первого года жизни. " +
                        "Наиболее известный вид — Ромашка аптечная (Matricaria chamomilla" +
                        ", syn. Matricaria recutita), это растение широко используется в лечебных и косметических целях.\n" +
                        "\n" +
                        "Часто ромашкой (с ботанической точки зрения ошибочно) называют виды растений других родов семейства Астровые" +
                        ", таких как Астра, Гербера, Дороникум, Нивяник, Остеоспермум, Пижма, Пупавка, Трёхрёберник, Хризантема" +
                        ", для соцветий-корзинок которых характерны краевые язычковые цветки с белыми или другой окраски лепестками " +
                        "и более тёмная центральная часть соцветия. Эти соцветия напоминают единый цветок, поэтому называются антодий. " +
                        "Примечательно, что в английском языке цветки в виде ромашек называют маргаритками",
                "Высушенную и свежую ромашку аптечную издавна применяют в медицине:" +
                        " (отвары, экстракты) — как противовоспалительное, слабое антисептическое и вяжущее средство, наружно — для полосканий," +
                        " примочек и ванн. Лечение ромашкой применяется в отношении патологий ЖКТ (желудочно-кишечного тракта), " +
                        "гинекологической сферы, мочеполовой и других систем организма как основная или дополнительная терапия. " +
                        "Ромашка принимается внутрь в виде чая или отвара (традиционное английское домашнее средство) или настоя," +
                        " её используют при спазмах кишечника, метеоризме и диарее, а также как потогонное средство. Препараты — Рекутан, Ротокан",
            )
            (activity as AppCompatActivity).supportFragmentManager.beginTransaction().replace(R.id.holder, ContentFragment.newInstance()).commit()
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
