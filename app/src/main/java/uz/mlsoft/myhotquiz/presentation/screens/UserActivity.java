package uz.mlsoft.myhotquiz.presentation.screens;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.textfield.TextInputEditText;

import uz.mlsoft.myhotquiz.R;
import uz.mlsoft.myhotquiz.data.local.MyPref;
import uz.mlsoft.myhotquiz.databinding.ActivityUserBinding;
import uz.mlsoft.myhotquiz.domain.DataRepository;

public class UserActivity extends AppCompatActivity {
    private TextInputEditText inputEditText;
    private AppCompatButton button;
    private int isSelected = -1;
    private ActivityUserBinding binding;
    private Boolean isValidName = false;
    private final DataRepository repository = DataRepository.getInstance();
    private final MyPref myPref = MyPref.Companion.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getApplication().setTheme(R.style.Theme_MyHotQuiz);
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        button = findViewById(R.id.btn_register);

        inputEditText = findViewById(R.id.edit_text);


        binding.boyImg.setOnClickListener(v -> {
            binding.boyImg.setBackgroundResource(R.drawable.selectable);
            binding.girlImg.setBackgroundResource(R.drawable.unselectable);
            isSelected = 0;
            myPref.setImage(R.drawable.boy);
            repository.setImage(myPref.getImage());
            check();
        });
        binding.girlImg.setOnClickListener(V -> {
            binding.girlImg.setBackgroundResource(R.drawable.selectable);
            binding.boyImg.setBackgroundResource(R.drawable.unselectable);
            isSelected = 1;
            myPref.setImage(R.drawable.girl);
            repository.setImage(myPref.getImage());
            check();
        });

        binding.btnRegister.setOnClickListener(v -> {
            check();
            if (isValidName && isSelected != -1) {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }

        });
    }

    private void check() {

        if (isSelected == -1) {
            binding.errorText.setTextColor(Color.RED);
            return;
        }
        if (binding.editText.getText().toString().length() > 3) {
            isValidName = true;
            myPref.setName(binding.editText.getText().toString());
            myPref.setRegisterd(true);
            repository.setName(myPref.getName());
        } else {
            isValidName = false;
            binding.editText.setError("Name length should be longer than 3");
        }
    }
}
