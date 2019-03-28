package com.averoes.daff.beritakotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.averoes.daff.beritakotlin.DetailActivity
import com.averoes.daff.beritakotlin.DetailActivity.Companion.AUTHOR
import com.averoes.daff.beritakotlin.DetailActivity.Companion.CONTENT
import com.averoes.daff.beritakotlin.DetailActivity.Companion.DATE
import com.averoes.daff.beritakotlin.DetailActivity.Companion.IMAGE
import com.averoes.daff.beritakotlin.DetailActivity.Companion.TITLE
import com.averoes.daff.beritakotlin.R
import com.averoes.daff.beritakotlin.model.BeritaItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_model.view.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity

/**
 * Created by daff on 28/03/19 at 15:07.
 */

//todo 5 buat adapter agar data nya bisa tampil di list
class MyAdapter(val context: Context, val item: List<BeritaItem?>?) : RecyclerView.Adapter<MyAdapter.Holder>() {

    //untuk memasukkan custom layout yang kita buat agar bisa ditampilkan
    override fun onCreateViewHolder(parent: ViewGroup, positio: Int): Holder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_model, parent, false)
        return Holder(view)
    }

    //seberapa banyak data yang ingin ditampilkan di list
    override fun getItemCount(): Int {

        return item?.size!!
    }

    //untuk menampilkan view yang telah kita buat
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindItem(item = item?.get(position)!!)

        //todo 6 buat activity baru untuk menampilkan detail beritanya
        holder.itemView.setOnClickListener {

            //pindah activity dengan mengirim data menggunakan anko layout
            context.startActivity(
                context.intentFor<DetailActivity>(

                    TITLE to item[position]!!.judulBerita,
                    AUTHOR to item[position]!!.penulis,
                    CONTENT to item[position]!!.isiBerita,
                    DATE to item[position]!!.tanggalPosting,
                    IMAGE to "http://192.168.0.106/portal_berita/images/${item[position]!!.foto}"
                )
            )

        }
    }

    //untuk menampung view yang kita buat
    class Holder(view: View) : RecyclerView.ViewHolder(view) {

        //simpan view yang kita buat kedalam variable
        val title = view.item_judul
        val author = view.item_penulis
        val date = view.item_tanggal
        val image = view.item_image

        val url_image = "http://192.168.0.106/portal_berita/images/"


        //mengatur view yang kita buat agar menampilkan data dari server
        fun bindItem(item: BeritaItem) {
            title.text = item.judulBerita
            author.text = item.penulis
            date.text = item.tanggalPosting

            //masukkan gambar dengan picasso
            Picasso.get().load(url_image + item.foto).into(image)
        }
    }
}