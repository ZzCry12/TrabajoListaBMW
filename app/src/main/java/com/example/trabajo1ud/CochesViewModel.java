package com.example.trabajo1ud;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CochesViewModel extends AndroidViewModel {

    private final Application app;
    private final CochesDb db;
    private final CochesDao dao;
    private LiveData<List<Coches>> coches;


    public CochesViewModel(@NonNull Application application) {
        super(application);
        this.app = application;
        this.db = CochesDb.getDatabase(this.app);
        this.dao = (CochesDao) this.db.getCochesdao();
    }


    public LiveData<List<Coches>> getCoches() {
        return null;
    }

    public void refresh() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(
                app.getApplicationContext()
        );
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(() -> {
            CochesApi api = new CochesApi();
            ArrayList<Coches> Coches = api.getmodelosBMW();
            this.dao.addCoches((List<Coches>) coches);
        });

    }

}
