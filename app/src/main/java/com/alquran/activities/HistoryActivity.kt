package com.alquran.activities

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import androidx.recyclerview.widget.LinearLayoutManager
import com.alquran.R
import com.alquran.adapter.MainAdapter
import com.alquran.model.main.ModelSurah
import com.alquran.viewmodel.SurahViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.layoutProfile
import java.util.*

class HistoryActivity : AppCompatActivity() {

    lateinit var strDate: String
    lateinit var strDateNow: String
    lateinit var mainAdapter: MainAdapter
    lateinit var progressDialog: ProgressDialog
    lateinit var surahViewModel: SurahViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        setInitLayout()
        setViewModel()
    }

    private fun setInitLayout() {
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Mohon Tunggu")
        progressDialog.setCancelable(false)
        progressDialog.setMessage("Sedang menampilkan data...")

        val dateNow = Calendar.getInstance().time
        strDate = DateFormat.format("EEEE", dateNow) as String
        strDateNow = DateFormat.format("d MMMM yyyy", dateNow) as String

        tvToday.setText("$strDate,")
        tvDate.setText(strDateNow)

        mainAdapter = MainAdapter(this)
        rvSurah.setHasFixedSize(true)
        rvSurah.setLayoutManager(LinearLayoutManager(this))
        rvSurah.setAdapter(mainAdapter)

        layoutMenu.setOnClickListener {
            startActivity(
                Intent(
                    this@HistoryActivity,
                    MainActivity::class.java
                )
            )
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

        layoutAbout.setOnClickListener {
            startActivity(
                Intent(
                    this@HistoryActivity,
                    AboutActivity::class.java
                )
            )
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

        layoutProfile.setOnClickListener {
            startActivity(
                Intent(
                    this@HistoryActivity,
                    ProfileActivity::class.java
                )
            )
        }
    }

    private fun setViewModel() {
        progressDialog.show()
        surahViewModel = ViewModelProvider(this, NewInstanceFactory()).get(SurahViewModel::class.java)
        surahViewModel.setSurah()
        surahViewModel.getSurah()
            .observe(this) { modelSurah: ArrayList<ModelSurah> ->
                if (modelSurah.size >= 3) { // Check if there are at least 2 items
                    val filteredData = ArrayList<ModelSurah>()
                    filteredData.add(modelSurah[0]) // Add item at index 0
                    filteredData.add(modelSurah[1]) // Add item at index 1
                    filteredData.add(modelSurah[2]) // Add item at index 2

                    mainAdapter.setAdapter(filteredData)
                    progressDialog.dismiss()
                } else {
                    Toast.makeText(this, "Data Tidak Ditemukan!", Toast.LENGTH_SHORT).show()
                    progressDialog.dismiss()
                }
            }
    }
}