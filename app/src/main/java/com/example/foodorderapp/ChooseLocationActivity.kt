package com.example.foodorderapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.foodorderapp.databinding.ActivityChooseLocationBinding
import android.widget.ArrayAdapter
import android.widget.Button

class ChooseLocationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChooseLocationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val districtList = arrayOf("Thanh xuân", "Đống đa", "Hà Đông","Hoàng mai","Cầu giấy","Long biên","Hai bà trưng","Hoàn kiếm","Tây hồ","Ba đình","Nam từ liêm","Bắc từ liêm","Hà đông","Thanh trì","Gia lâm","Đông anh","Sóc sơn","Mê linh","Phúc thọ","Thạch thất","Quốc oai","Chương mỹ","Thanh oai","Thường tín","Phú xuyên","Ứng hòa","Mỹ đức")
        val districtAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, districtList)
        val districtAutoCompleteTextView = binding.district
        districtAutoCompleteTextView.setAdapter(districtAdapter)

        val wardlist = arrayOf("Nguyễn Trãi", "Nguyễn Văn Cừ", "Nguyễn Khánh Toàn","Nguyễn Chí Thanh","Nguyễn Lương Bằng","Nguyễn Thị Định","Nguyễn Văn Huyên","Nguyễn Văn Lộc","Nguyễn Văn Ngọc","Nguyễn Văn Thủ")
        val wardAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, wardlist)
        val wardAutoCompleteTextView = binding.ward
        wardAutoCompleteTextView.setAdapter(wardAdapter)

        val streetList = arrayOf("Nguyễn Trãi", "Nguyễn Văn Cừ", "Nguyễn Khánh Toàn","Nguyễn Chí Thanh","Nguyễn Lương Bằng","Nguyễn Thị Định","Nguyễn Văn Huyên","Nguyễn Văn Lộc","Nguyễn Văn Ngọc","Nguyễn Văn Thủ")
        val streetAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, streetList)
        val streetAutoCompleteTextView = binding.street
        streetAutoCompleteTextView.setAdapter(streetAdapter)

        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}