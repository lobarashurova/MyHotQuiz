package uz.mlsoft.myhotquiz.presentation.screens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.ArrayList;

import uz.mlsoft.myhotquiz.R;
import uz.mlsoft.myhotquiz.data.local.MyPref;
import uz.mlsoft.myhotquiz.data.room.UserDb;
import uz.mlsoft.myhotquiz.data.room.UserEntity;
import uz.mlsoft.myhotquiz.databinding.ActivityScoreBinding;
import uz.mlsoft.myhotquiz.domain.DataRepository;

public class ScoreActivity extends AppCompatActivity {
    private TextView correct_text;
    private TextView incorrect_text;
    private ActivityScoreBinding binding;
    private DataRepository repository;
    private String subject_name;
    private int correctCount;
    private TextView view;
    private String name;
    private int image;
    private ArrayList<UserEntity> list = new ArrayList<>();
    private MyPref myPref=MyPref.Companion.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getApplication().setTheme(R.style.Theme_MyHotQuiz);

        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        repository = DataRepository.getInstance();
        UserDb userDb = UserDb.getDataBase();
        view = binding.userName;
        correctCount = getIntent().getIntExtra("score", 0);
        int wrongCount = 20 - correctCount;
        if (correctCount > wrongCount) {
            findViewById(R.id.congratulations_layout).setVisibility(View.VISIBLE);
            findViewById(R.id.bad_linear).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.congratulations_layout).setVisibility(View.INVISIBLE);
            findViewById(R.id.bad_linear).setVisibility(View.VISIBLE);
        }

        correct_text = findViewById(R.id.correct_text);
        incorrect_text = findViewById(R.id.incorrect_text);
        correct_text.setText(String.valueOf(correctCount));
        incorrect_text.setText(String.valueOf(wrongCount));

        name = myPref.getName();
        view.setText(String.valueOf(name));
        image = myPref.getImage();
        subject_name = repository.getSubject_name();
        UserDb.getDataBase().getUserDao().addContacts(new UserEntity(0, name, subject_name, correctCount, image));


        findViewById(R.id.restart_btn).setOnClickListener(v -> {
            shareApp(this);
        });
        findViewById(R.id.share_btn).setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }

    private void shareApp(Context context) {
        final String packageName = context.getPackageName();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Downloand now: https://t.me/laibaBlog/106" + packageName);
        sendIntent.setType("text/plain");
        context.startActivity(sendIntent);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
