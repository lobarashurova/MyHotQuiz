package uz.mlsoft.myhotquiz.presentation.screens;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.ArrayList;

import uz.mlsoft.myhotquiz.R;
import uz.mlsoft.myhotquiz.data.room.UserDb;
import uz.mlsoft.myhotquiz.data.room.UserEntity;
import uz.mlsoft.myhotquiz.databinding.ActivityResultsBinding;
import uz.mlsoft.myhotquiz.presentation.adapter.UserAdapter;

public class ResultsActivity extends AppCompatActivity {
    private ActivityResultsBinding binding;
    private UserAdapter adapter;
    private ArrayList<UserEntity> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getApplication().setTheme(R.style.Theme_MyHotQuiz);
        super.onCreate(savedInstanceState);
        binding = ActivityResultsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        adapter = new UserAdapter();
        list.addAll(UserDb.getDataBase().getUserDao().readAllData());
        if (list.isEmpty()) {
            binding.textPlaceHolder.setVisibility(View.VISIBLE);
            binding.recyclerView.setAdapter(adapter);
        } else {
            adapter.submitList(list);
            binding.recyclerView.setAdapter(adapter);
        }


        binding.backImage.setOnClickListener(v -> {
            finish();
        });
    }

}