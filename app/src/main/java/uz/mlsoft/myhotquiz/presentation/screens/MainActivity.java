package uz.mlsoft.myhotquiz.presentation.screens;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import uz.mlsoft.myhotquiz.R;
import uz.mlsoft.myhotquiz.data.local.MyPref;
import uz.mlsoft.myhotquiz.databinding.ActivityMainBinding;
import uz.mlsoft.myhotquiz.domain.DataRepository;

public class MainActivity extends AppCompatActivity {
    LinearLayout math_linear;
    LinearLayout physics_linear;
    LinearLayout english_linear;
    LinearLayout android_linear;
    ActivityMainBinding binding;
    TextView per_text;
    private DataRepository repository;
    private String math = "Math";
    private String physics = "Physics";
    private String english = "English";
    private String android = "Android";
    private final MyPref myPref = MyPref.Companion.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getApplication().setTheme(R.style.Theme_MyHotQuiz);
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        repository = DataRepository.getInstance();
        per_text = findViewById(R.id.per_name);
        String name = myPref.getName();
        per_text.setText(String.valueOf(name));
        int image = myPref.getImage();
        binding.imagePer.setBackgroundResource(image);
        binding.resultsBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, ResultsActivity.class));
        });
        binding.infoBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, InfoActivity.class));
            finish();
        });

        binding.logoutBtn.setOnClickListener(v -> {
            myPref.clearData();
            showLogoutDialog();
        });

        math_linear = findViewById(R.id.math_btn);
        math_linear.setOnClickListener(v -> {
            Intent intent = new Intent(this, TestActivity.class);
            intent.putExtra("1", math);
            repository.setSubject_name(math);
            startActivity(intent);
            finish();
        });
        physics_linear = findViewById(R.id.physics_linear);
        physics_linear.setOnClickListener(v -> {
            Intent intent = new Intent(this, TestActivity.class);
            intent.putExtra("2", physics);
            repository.setSubject_name(physics);
            startActivity(intent);
            finish();
        });
        english_linear = findViewById(R.id.english_linear);
        english_linear.setOnClickListener(v -> {
            Intent intent = new Intent(this, TestActivity.class);
            intent.putExtra("3", english);
            repository.setSubject_name(english);
            startActivity(intent);
            finish();
        });
        android_linear = findViewById(R.id.android_linear);
        android_linear.setOnClickListener(v -> {
            Intent intent = new Intent(this, TestActivity.class);
            intent.putExtra("4", android);
            repository.setSubject_name(android);
            startActivity(intent);
            finish();
        });
    }

    private void showLogoutDialog() {
        Context context = this;
        Dialog dialogFinish = new Dialog(this);
        dialogFinish.setContentView(R.layout.dialog_logout);
        dialogFinish.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogFinish.setCancelable(false);
        dialogFinish.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogFinish.show();

        AppCompatButton yesBtn = dialogFinish.findViewById(R.id.btn_logout);
        AppCompatButton noBtn = dialogFinish.findViewById(R.id.cancel_btn_logout);

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogFinish.dismiss();
            }
        });

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, UserActivity.class));
                finish();
            }
        });
    }
}