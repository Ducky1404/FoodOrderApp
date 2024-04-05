package com.example.foodorderapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderapp.adapter.NotificationAdapter
import com.example.foodorderapp.databinding.FragmentNotifactionBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class Notifaction_Bottom_Fragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNotifactionBottomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotifactionBottomBinding.inflate(layoutInflater, container, false)
        val notification = listOf("Đơn hàng đã được Hủy thành công","Tài xế đã lấy đơn","Giao hàng thành công")
        val notificationImage = listOf(
            R.drawable.sademoji,
            R.drawable.truck,
            R.drawable.congrats,
        )
        val adapter = NotificationAdapter(
            ArrayList(notification),
            ArrayList(notificationImage)
        )
        binding.notificationRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.notificationRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}