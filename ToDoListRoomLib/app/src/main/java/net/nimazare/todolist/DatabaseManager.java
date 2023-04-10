package net.nimazare.todolist;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(version = 1, exportSchema = false, entities = {Task.class})
public abstract class DatabaseManager extends RoomDatabase {

    private static DatabaseManager databaseManager;

    public static DatabaseManager getDatabaseManager(Context context) {
        if (databaseManager == null) {
            databaseManager = Room.databaseBuilder(context.getApplicationContext(), DatabaseManager.class, "db_todo")
                    .allowMainThreadQueries().build();
        }
        return databaseManager;
    }

    public abstract TaskDao getTaskDao();
}
