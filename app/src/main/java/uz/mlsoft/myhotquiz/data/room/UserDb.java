package uz.mlsoft.myhotquiz.data.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 1, exportSchema = false)
public abstract class UserDb extends RoomDatabase {

    public abstract UserDao getUserDao();

    private static UserDb instance;

    public static void init(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    UserDb.class,
                    "myDataBase"
            ).allowMainThreadQueries().build();
        }
    }

    public static UserDb getDataBase() {
        return instance;
    }
}
