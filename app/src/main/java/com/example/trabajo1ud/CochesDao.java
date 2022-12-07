package com.example.trabajo1ud;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Dao;
import androidx.room.Update;

import java.util.List;
@Dao
public interface CochesDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addCoches(List<Coches> coches);


    @Query("SELECT * FROM cars")
    List<Coches> selectAllDevicePreferences();

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateDevicePreferences(Coches coches);

}
