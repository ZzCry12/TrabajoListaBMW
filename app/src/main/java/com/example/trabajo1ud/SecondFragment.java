package com.example.trabajo1ud;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.trabajo1ud.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);

        View view = binding.getRoot();

        Bundle args = getArguments();

        if (args != null) {
            Coches coches = (Coches) args.getSerializable("item");

            if (coches != null) {
                update(coches);

            }

        }
        return view;
    }

    private void update(Coches coche) {

        binding.txtModelocoche.setText("Modelo/Serie \n" + "     " + coche.getModel());
        binding.txtFabricacion.setText("Año de fabricación \n" + "            " + coche.getYear());
        binding.txtPotensia.setText("Caballos \n" + "  " + coche.getHorsepower()+"HP");
        binding.txtPresio.setText("Precio \n" + "" + coche.getPrice() + "€");
        binding.txtMarca.setText("Marca \n" + " " + coche.getMake());

        Glide.with(getContext()).load(coche.getImg_url()).into(binding.imageViewSegFrag);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}