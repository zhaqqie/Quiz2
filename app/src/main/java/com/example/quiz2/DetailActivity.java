package com.example.quiz2;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quiz2.databinding.ActivityDetailBinding;

import java.text.DecimalFormat;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DecimalFormat format = new DecimalFormat("#");

        Intent intent = getIntent();
        if (intent != null){
            String type = intent.getStringExtra("type");
            String tambahan = intent.getStringExtra("tambahan");
            double htambahan = intent.getDoubleExtra("htambahan", 0);
            double waktu = intent.getDoubleExtra("waktu", 0);
            double total = intent.getDoubleExtra("Total", 0);

            binding.tvType.setText("Type :" + type);
            binding.tvTambahan.setText(tambahan +" : Rp "+ format.format(htambahan));
            binding.tvWaktu.setText("Waktu : " + format.format(waktu) +" jam");
            binding.tvTotal.setText("Total :  Rp " +format.format(total));
        }
    }
}