package com.jennifer.ef_torrespalomino.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.jennifer.ef_torrespalomino.model.ProductEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ProductEntity.class}, version = 1)
public abstract class StoreDatabase extends RoomDatabase {

    public abstract ProductDao productDao();
    private static volatile StoreDatabase db;

    public static final ExecutorService dataBaseWriteExecutor = Executors.newFixedThreadPool(4);

    public static StoreDatabase getInstance(Context context){
        if (db == null){
            synchronized(StoreDatabase.class){
                if (db== null){
                    db = Room.databaseBuilder(context.getApplicationContext(), StoreDatabase.class, "store-database").build();
                }
            }
        }
        return db;
    }
}