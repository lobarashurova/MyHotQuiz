package uz.mlsoft.myhotquiz.data.room;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "users")
public class UserEntity implements Serializable {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String subject_name;
    int correctAnswer;
    int image;

    public UserEntity(int id, String name,String subject_name ,int correctAnswer, int image) {
        this.id = id;
        this.name = name;
        this.subject_name=subject_name;
        this.correctAnswer = correctAnswer;
        this.image = image;

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public int getImage() {
        return image;
    }

    public String getSubject_name() {
        return subject_name;
    }
}
