package com.example.trabajo1ud;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Coches.class}, version = 1)
public abstract class CochesDb extends RoomDatabase {

    private static CochesDb INSTANCE;

    public static CochesDb getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(
                            context.getApplicationContext(),
                            CochesDb.class, "db"
                    ).build();
        }
        return INSTANCE;
    }

    public abstract CochesDao getCochesdao();

}

