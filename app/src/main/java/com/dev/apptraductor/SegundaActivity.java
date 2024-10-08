package com.dev.apptraductor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.dev.apptraductor.databinding.ActivityTraducidoBinding;
public class SegundaActivity extends AppCompatActivity {

    private ActivityTraducidoBinding binding;
    private TraducidoActivityViewModel traducirViewModel;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityTraducidoBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    traducirViewModel = new ViewModelProvider(this).get(TraducidoActivityViewModel.class);

    String palabra = getIntent().getStringExtra("palabraEsp");

    if (palabra != null) {
        traducirViewModel.traducirPalabra(palabra);
    }

    traducirViewModel.getPalabraTraducida().observe(this, new Observer<String>() {
        @Override
        public void onChanged(String palabraTraducida) {
            Log.d("aqui",palabraTraducida);
            binding.etTraducido.setText(palabraTraducida);
        }
    });

    traducirViewModel.getImagenResId().observe(this, new Observer<Integer>() {
        @Override
        public void onChanged(Integer imagenResId) {
            binding.ivImg.setImageResource(imagenResId);
        }
    });

    binding.btVolver.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(SegundaActivity.this, MainActivity.class);
            startActivity(intent);
        }
    });
}
}

