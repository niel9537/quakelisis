package com.akhari.quakelisis;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeActivity extends AppCompatActivity {
    Button btnDeteksi;
    TextView txtKekuatan;

    List<String> kekuatanList;
    Random random;
    Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDeteksi = findViewById(R.id.btnDeteksi);
        txtKekuatan = findViewById(R.id.txtKekuatan);
        txtKekuatan.setText("-");
        kekuatanList = new ArrayList<>();
        kekuatanList.add("20 g (Kuat)");
        kekuatanList.add("45 g (Sangat Kuat)");
        kekuatanList.add("5 g (Sangat Lemah)");
        kekuatanList.add("10 g (Lemah)");

        random = new Random();
        handler = new Handler();

        btnDeteksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ganti drawable dengan text "Sedang Mendeteksi"
                btnDeteksi.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                btnDeteksi.setText("Sedang Mendeteksi");

                Toast.makeText(HomeActivity.this, "Deteksi dimulai", Toast.LENGTH_SHORT).show();

                // Tunda eksekusi selama 3 detik sebelum menampilkan nilai kekuatan
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setRandomKekuatan();
                    }
                }, 3000);
            }
        });
    }

    private void setRandomKekuatan() {
        // Ambil nilai acak dari list kekuatan
        int randomIndex = random.nextInt(kekuatanList.size());
        String randomKekuatan = kekuatanList.get(randomIndex);

        // Set nilai kekuatan pada TextView
        txtKekuatan.setText(randomKekuatan);

        // Ganti text dengan drawable
        btnDeteksi.setText("");
        btnDeteksi.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_baseline_equalizer_24, 0, 0);
        Toast.makeText(HomeActivity.this, "Deteksi selesai", Toast.LENGTH_SHORT).show();
    }
}
