package com.example.quiz2;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quiz2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    public double ps5 = 10000;
    public double ps4 = 8000;
    public double ps3 = 5000;
    public double psvr = 20000;
    public double total = 0;
    public double htambahan = 0;
    String tambahan;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btPesan.setOnClickListener(v -> {
            double jam;
            String jamString = binding.jam.getText().toString();
            if (jamString.isEmpty()) {
                jam = 0;
            } else {
                jam = Double.parseDouble(jamString);


                if (binding.rbPs5.isChecked()) {
                    type = "PS5(Rp 10.000)";
                    total += ps5;
                } else if (binding.rbPs4.isChecked()) {
                    type = "PS4(Rp 8.000)";
                    total += ps4;
                } else if (binding.rbPs3.isChecked()) {
                    type = "PS3(Rp 5.000)";
                    total += ps3;
                } else if (binding.rbPsVr.isChecked()) {
                    type = "PSVR(Rp 20.000)";
                    total += psvr;
                }
                total *= jam;

                if (binding.rbIndomie.isChecked()) {
                    tambahan = "Indomie";
                    htambahan = 7000;
                    total += htambahan;
                }
                if (binding.rbMieAyam.isChecked()) {
                    tambahan = "Mie Ayam";
                    htambahan = 10000;
                    total += htambahan;
                }
                if (binding.rbSiomay.isChecked()) {
                    tambahan = "Siomay";
                    htambahan = 5000;
                    total += htambahan;
                }
            }

            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("type" ,type);
            intent.putExtra("tambahan" ,tambahan);
            intent.putExtra("htambahan" ,htambahan);
            intent.putExtra("waktu", jam);
            intent.putExtra("Total", total);
            startActivity(intent);

        });
    }
}