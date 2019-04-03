package uagrm.soe.awesomelogin.controller

import uagrm.soe.awesomelogin.R
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import android.widget.Toast


class DataAdapter(val viewAllDataActivity: ViewAllDataActivity,val arrayList: ArrayList<HashMap<String, String>>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    //lateinit var helper : DatabaseHelper
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vi=LayoutInflater.from(viewAllDataActivity).inflate(R.layout.cust_layout,parent,false)
        return ViewHolder(vi)
    }

    override fun getItemCount(): Int {
        return arrayList.size
        Log.d("size",arrayList.size.toString())
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text=arrayList.get(position).get(NAME)
        holder.detail.text=arrayList.get(position).get(DETAIL)
        holder.requeriment.text=arrayList.get(position).get(REQUERIMENT)
        holder.status.text=arrayList.get(position).get(STATUS)
       //helper= DatabaseHelper(viewAllDataActivity)
        Log.d("Adapter init", arrayList.toString())

        holder.update.setOnClickListener {

            if (position == 0){
                val intent = Intent(viewAllDataActivity, UpdateFailedLoginMaximumNumberActivity::class.java)
                intent.putExtra(ID, arrayList.get(position).get(ID))
                intent.putExtra(NAME,arrayList.get(position).get(NAME))
                intent.putExtra(DETAIL, arrayList.get(position).get(DETAIL))
                intent.putExtra(REQUERIMENT,arrayList.get(position).get(REQUERIMENT))
                intent.putExtra(STATUS, arrayList.get(position).get(STATUS))
                viewAllDataActivity.startActivity(intent)
            }else{
                if (position == 1){
                    val intent = Intent(viewAllDataActivity, UpdatePasswordExpirationActivity::class.java)
                    intent.putExtra(ID, arrayList.get(position).get(ID))
                    intent.putExtra(NAME,arrayList.get(position).get(NAME))
                    intent.putExtra(DETAIL, arrayList.get(position).get(DETAIL))
                    intent.putExtra(REQUERIMENT,arrayList.get(position).get(REQUERIMENT))
                    intent.putExtra(STATUS, arrayList.get(position).get(STATUS))
                    viewAllDataActivity.startActivity(intent)
                }else{
                    if (position == 2){
                        val intent = Intent(viewAllDataActivity, UpdateFailedLoginMaximumNumberActivity::class.java)
                        intent.putExtra(ID, arrayList.get(position).get(ID))
                        intent.putExtra(NAME,arrayList.get(position).get(NAME))
                        intent.putExtra(DETAIL, arrayList.get(position).get(DETAIL))
                        intent.putExtra(REQUERIMENT,arrayList.get(position).get(REQUERIMENT))
                        intent.putExtra(STATUS, arrayList.get(position).get(STATUS))
                        viewAllDataActivity.startActivity(intent)
                    }else{
                        Toast.makeText(viewAllDataActivity,"Epic Fail", Toast.LENGTH_LONG).show()
                    }
                }
            }

        }

        holder.delete.setOnClickListener {
          //val result : Boolean = helper.deleteUser(Integer.parseInt(arrayList.get(position).get(ID)))

         //   when{
          //      result->{
                    Toast.makeText(viewAllDataActivity,"Data deleted Successfully..", Toast.LENGTH_LONG).show()
                    val intent = Intent(viewAllDataActivity, ViewAllDataActivity::class.java)
                    viewAllDataActivity.startActivity(intent)
             //   }
             //   else-> Toast.makeText(viewAllDataActivity,"Failed to delete data", Toast.LENGTH_LONG).show()
           // }

        }
    }

    class ViewHolder(item : View) : RecyclerView.ViewHolder(item) {
        val name=item.findViewById<TextView>(R.id.txt_name)
        val detail=item.findViewById<TextView>(R.id.txt_detail)
        val requeriment=item.findViewById<TextView>(R.id.txt_requeriment)
        val status=item.findViewById<TextView>(R.id.txt_status)
        val update=item.findViewById<Button>(R.id.btn_update)
        val delete=item.findViewById<Button>(R.id.btn_delete)
    }

    companion object {
        private val ID = "Id"
        private val NAME = "name"
        private val DETAIL= "detail"
        private val REQUERIMENT = "requeriment"
        private val STATUS="status"
    }
}