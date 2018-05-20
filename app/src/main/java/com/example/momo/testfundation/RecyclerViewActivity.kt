package com.example.momo.testfundation

import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.android.synthetic.main.cax_effect_item_layout.view.*

class RecyclerViewActivity : AppCompatActivity() {

    private var mList = ArrayList<Drawable>()
    private var layoutManager: GalleryLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        initData()
        initView()
    }

    private fun initData() {
        for (index in 0 until 10) {
            mList.add(resources.getDrawable(R.drawable.cax_effect_glitter))
        }
    }

    private fun initView() {
        //add by liuxu
        layoutManager = GalleryLayoutManager(GalleryLayoutManager.HORIZONTAL)
        layoutManager?.attach(recyclerView,2)
        layoutManager?.setItemTransformer(ScaleTransformer())
        layoutManager?.setCallbackInFling(true)
        recyclerView.adapter = FundationAdapter(mList)
    }

    class FundationAdapter() : RecyclerView.Adapter<FundationHolder>() {
        private var mList: ArrayList<Drawable>? = null

        override fun onBindViewHolder(holder: FundationHolder, position: Int) {
            holder.itemView.iv_effect.setImageDrawable(mList!![position])
        }

        constructor(list: ArrayList<Drawable>) : this() {
            mList = list
        }


        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FundationHolder {
            val v = LayoutInflater.from(parent?.context).inflate(R.layout.cax_effect_item_layout, parent, false)
            return FundationHolder(v)
        }

        override fun getItemCount(): Int {
            if (mList == null) {
                return 0
            }
            return mList?.size!!
        }

    }

    class FundationHolder : RecyclerView.ViewHolder {
        constructor(itemView: View?):super(itemView)
    }
}
