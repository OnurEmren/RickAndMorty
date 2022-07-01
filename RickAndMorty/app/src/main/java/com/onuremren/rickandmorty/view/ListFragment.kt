package com.onuremren.rickandmorty.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.onuremren.rickandmorty.R
import com.onuremren.rickandmorty.adapter.AbstractAdapter
import com.onuremren.rickandmorty.adapter.CharacterAbstractAdapter
import com.onuremren.rickandmorty.adapter.CharacterAdapter
import com.onuremren.rickandmorty.databinding.FragmentListBinding
import com.onuremren.rickandmorty.databinding.ItemRowBinding
import com.onuremren.rickandmorty.repo.Repository
import com.onuremren.rickandmorty.viewmodel.ListViewModel
import com.onuremren.rickandmorty.viewmodel.ListViewModelFactory
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment() {

    //Global değişken tanımlamamızın sebebi burada tanımladığımız değişkenlere gerek duyulduğu zaman
    //gerekli metodların içerisinden ulaşma isteğimiz. binding, adapter(verileri recyclerView'da göstermek için gerekli)
    // ve verileri alacağımız viewmodel ı burada değişken olarak belirtip daha sonra istenen yerlerde ilgili
    //sınıfların içerisindeki fonksiyonları çağırmamız gerekecek.


    private lateinit var dataBinding: FragmentListBinding
    private val viewModel: ListViewModel by activityViewModels{ListViewModelFactory(Repository())}
    var adapter = CharacterAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //dataBinding kurulumunu yapıyoruz.
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_list,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //onViewCreated metodunu, ui oluştuktan sonra meydana gelecek olayları
        //oluşturmak için çağırıyoruz.
        //observe kullanmamızın sebebi viewmodeldan veri çektikten sonra verileri izlememiz gerekmesindendir.
        //verileri gözlemleyip ilgili adapter ile bağlarız. bu şekilde verileri uida gösteririz.
        viewModel.rickList.observe(viewLifecycleOwner) {
            adapter.updateRickyList(it)

        }
        viewModel.getCharacters(0)
        dataBinding.recyclerview.layoutManager = LinearLayoutManager(context)
        dataBinding.recyclerview.adapter = adapter


    }

    //Fragment için kullanılan bu metod, fragmentın bir activity içerisinde yer aldığının kesin olduğunu
    //uygulamaya bildirir. onCreate metodundan bile önce çalışır.

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }
}