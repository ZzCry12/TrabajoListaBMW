package com.example.trabajo1ud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.bumptech.glide.Glide;
import com.example.trabajo1ud.databinding.LvCochesRowBinding;

import java.util.List;

public class CochesAdapter extends ArrayAdapter<Coches> {

    public CochesAdapter(Context context, int resource, List<Coches> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int posotion, View convertView, ViewGroup parent) {
        Coches coche = getItem(posotion);

        LvCochesRowBinding binding = null;

        if (convertView == null) {
            binding = LvCochesRowBinding.inflate(LayoutInflater.from(getContext()), parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (LvCochesRowBinding) convertView.getTag();
        }
        binding.viewnamecoches.setText(coche.getModel());

        Glide.with(getContext()).load(coche.getImg_url()).into(binding.imagecoches);

        return binding.getRoot();
    }


}
