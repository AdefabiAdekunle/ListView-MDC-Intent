package com.kuntech.listviewmdcintent

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class AppAdapter( context: Context,facts:List<AppModel>) : ArrayAdapter<AppModel>(context,0,facts) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val facts = getItem(position)
        if(view == null){
            view = LayoutInflater.from(parent.context).inflate(R.layout.facts_item,parent,false)
        }
        val logo = view?.findViewById<ImageView>(R.id.image_logo)
        val name = view?.findViewById<TextView>(R.id.name_tv)
//        if (facts != null) {
//            logo?.setImageResource(facts.logo)
//        }
        facts?.logo?.let { logo?.setImageResource(it) }
        name?.text = facts?.name

        view?.setOnClickListener {
            val intent = Intent(parent.context,DetailActivity::class.java)
            intent.putExtra(LOGO_EXTRA,facts?.logo)
            intent.putExtra(NAME_EXTRAS,facts?.name)
            intent.putExtra(FACT_EXTRAS,facts?.fact)
            parent.context.startActivities(arrayOf(intent))
        }

        return view!!

    }

    companion object{
        val LOGO_EXTRA = "logo_extras"
        val NAME_EXTRAS = "name_extras"
        val FACT_EXTRAS = "fact_extras"
    }
}