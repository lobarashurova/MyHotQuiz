package uz.mlsoft.myhotquiz.data.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void addContacts(UserEntity contactData);

    @Query("SELECT * FROM users")
    public List<UserEntity> readAllData();

}
