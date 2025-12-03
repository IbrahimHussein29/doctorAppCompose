package com.example.doctorappexample.core.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.doctorappexample.core.model.CategoryModel
import com.example.doctorappexample.core.model.DoctorModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ViewModel() {
    private val db = FirebaseDatabase.getInstance()
    private val _category = MutableLiveData<List<CategoryModel>>(emptyList())
    val category: LiveData<List<CategoryModel>> = _category

    private val _doctor = MutableLiveData<List<DoctorModel>>(emptyList())
    val doctor: LiveData<List<DoctorModel>> = _doctor



    private var categoryLoaded = false
    private var doctorLoaded = false


    fun loadCategory(force: Boolean = false) {
        if (categoryLoaded && !force) return
        categoryLoaded = true
        val ref = db.getReference("Category")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val items = mutableListOf<CategoryModel>()
                for (child in snapshot.children) {
                    child.getValue(CategoryModel::class.java)?.let { items.add(it) }
                }
                _category.value = items
            }

            override fun onCancelled(error: DatabaseError) {
                categoryLoaded = false
            }

        }
        )


    }

    fun loadDoctor(force: Boolean = false) {
        if (doctorLoaded && !force) return
        doctorLoaded = true
        val ref = db.getReference("Doctors")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val items = mutableListOf<DoctorModel>()
                for (child in snapshot.children) {
                    child.getValue(DoctorModel::class.java)?.let { items.add(it) }
                }
                _doctor.value = items
            }

            override fun onCancelled(error: DatabaseError) {
                doctorLoaded = false
            }
        }
        )

    }


}