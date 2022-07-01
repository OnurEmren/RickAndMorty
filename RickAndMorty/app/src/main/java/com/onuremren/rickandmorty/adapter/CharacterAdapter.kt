package com.onuremren.rickandmorty.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.onuremren.rickandmorty.R
import com.onuremren.rickandmorty.databinding.ItemRowBinding
import com.onuremren.rickandmorty.downloadFromUrl
import com.onuremren.rickandmorty.model.Character
import com.onuremren.rickandmorty.view.ListFragmentDirections
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.item_row.view.*

class CharacterAdapter(val rickList: ArrayList<Character>): RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(var view: ItemRowBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {

        //dataBinding i bağladığımız kısım. Burada Recyclerview görüntülerini layouta bağlıyoruz.
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.item_country,parent,false)
        val view = DataBindingUtil.inflate<ItemRowBinding>(inflater,R.layout.item_row,parent,false)
        return CharacterViewHolder(view)

    }

    override fun getItemCount(): Int {
        //gelen listemizin boyutunu recycler a bildirmiş oluyoruz. ne kadar veri geleceğini bilmiyoruz.
        // Bu durumda verilerin boyutunu adapterın otomatik belirlemesini sağlayabiliyoruz.
        return rickList.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {

        //görüntüyü tuttuğumuz yer. burada dataBinding kullanıldığı için xml'deki character variable ını burada kulanıyoruz.
        //daha sonra bunu listemize bağlıyoruz. bu şekilde gelen veriler otomatik olarak idsine göre
        //ilgili görüntüye aktarılacak.

        holder.view.character = rickList[position]
        //Görüntülerin çağırılması. Burada extenciondan yararlanılıyor. Utils klasörü ziyaret edilebilir.
        holder.view.imageView.downloadFromUrl(rickList[position].image)
        //listener oluşturma işlemi. Tıklanıldığı zaman ne olacağını yazıyoruz. Burada nav_args'da belirttiğimiz argümanı
        //alıyoruz ve listemizin uygun pozisyonuna adapte olmasını sağlıyoruz. Bu şekilde tıklanan itemin
        //açılmasını sağlamış oluyoruz.
        holder.itemView.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(rickList[position],rickList[position].location)
            Navigation.findNavController(it).navigate(action)
        }
    }


    //Burada bu şekilde bir fonksiyon kullanmamızın sebebi aslında bu fonksiyonu listFragmenttan çağıracak olmamız.

    fun updateRickyList(newRickList: List<Character>) {
        //Liste kullanıldıktan sonra temizlenmesini sağlıyor.(?)
        rickList.clear()
        //listeye çekilen tüm verilerin adapterda oluşturduğumuz listeye eklenmesini sağlıyor.
        rickList.addAll(newRickList)
        //Listeye döndüğümüz zaman bir değişiklik varsa güncelleme yapmamızı sağlıyor. Eski bir metod
        notifyDataSetChanged()
    }

}