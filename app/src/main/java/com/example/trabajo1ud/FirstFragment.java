package com.example.trabajo1ud;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.preference.PreferenceManager;

import com.example.trabajo1ud.databinding.FragmentFirstBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ArrayList<Coches> items;
    private ArrayAdapter<Coches> adapter;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        items = new ArrayList<>();
        adapter = new CochesAdapter(
                getContext(),
                R.id.viewnamecoches,
                items
        );
        binding.listView1.setAdapter(adapter);

        binding.listView1.setOnItemClickListener((adapter, fragment, i, l) -> {
            Bundle args = new Bundle();

            Coches item = (Coches) adapter.getItemAtPosition(i);

            args.putSerializable("item", item);

            NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment, args);

        });


        refresh();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.refresh) {
            refresh();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void refresh() {
        Toast.makeText(getContext(), "Refrescando...", Toast.LENGTH_LONG).show();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());


        executor.execute(() -> {
            CochesApi api = new CochesApi();
            ArrayList<Coches> listacoches = api.getmodelosBMW();

            System.out.println(listacoches);

            handler.post(() -> {
                adapter.clear();
                adapter.addAll(listacoches);


            });

        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}