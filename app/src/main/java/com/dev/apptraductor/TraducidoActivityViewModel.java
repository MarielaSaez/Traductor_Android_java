package com.dev.apptraductor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class TraducidoActivityViewModel extends ViewModel {

    private MutableLiveData<String> palabraTraducida = new MutableLiveData<>();
    private MutableLiveData<Integer> imagenResId = new MutableLiveData<>();

    private List<Palabra> palabras;

    public TraducidoActivityViewModel() {
        palabras = new ArrayList<>();
        // Agregar palabras y sus imágenes
        palabras.add(new Palabra("gato", "cat", R.drawable.gatito));
        palabras.add(new Palabra("perro", "dog", R.drawable.perrito));
        palabras.add(new Palabra("casa", "house", R.drawable.casa));
        palabras.add(new Palabra("manzana", "manzana", R.drawable.manzana));
        palabras.add(new Palabra("conejo", "rabbit", R.drawable.conejito));
    }

    public void traducirPalabra(String palabraEsp) {
        for (Palabra palabra : palabras) {
            if (palabra.getEspanol().equalsIgnoreCase(palabraEsp)) {
                palabraTraducida.setValue(palabra.getIngles());
                imagenResId.setValue(palabra.getImg());
                return;
            }
        }

        palabraTraducida.setValue("No encontrado");
        imagenResId.setValue(R.drawable.nada);
    }

    public LiveData<String> getPalabraTraducida() {
        return palabraTraducida;
    }

    public LiveData<Integer> getImagenResId() {
        return imagenResId;
    }
}
