package uz.mlsoft.myhotquiz.presentation.screens;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;

import androidx.appcompat.app.AppCompatActivity;

import uz.mlsoft.myhotquiz.databinding.ActivityInfoBinding;

public class InfoActivity extends AppCompatActivity {
    private ActivityInfoBinding binding;
    private String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backImage.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

        text = "<div>\n" +
                "        <h1>\n" +
                "            Test app\n" +
                "        </h1>\n" +
                "        \n" +
                "        <ul>\n" +
                "            <li>\n" +
                "                \tThis app was created by a coder girl who studied in Gita academy and it should be used to solve some easy questions from four subjects  .\n" +
                "            </li> \n" +
                "            <li>\n" +
                "                \tWhen you lunch this app, you should register there with choosing an image and nick for yourself.\n" +
                "            </li> \n" +
                "            <li>\n" +
                "                \tAfter successfully registering, you can choose a subject to solve problems. If you finish, you can recognize your own score and it automatically saved to results list\n" +
                "            </li>\n" +
                "            <li>\n" +
                "                \tBy clicking results button, you can see all results of yours with each subject.\n" +
                "            </li>\n" +
                "        </ul>\n" +
                "        <div>\n" +
                "            <h3>\n" +
                "                Framework:\n" +
                "            </h3>\n" +
                "            <ul>\n" +
                "                <li>\n" +
                "                    <b>\n" +
                "                        Android Studio\n" +
                "                    </b>\n" +
                "                </li>\n" +
                "                <li>\n" +
                "                    <b>\n" +
                "                        Java and Kotlin\n" +
                "                    </b>\n" +
                "                </li>\n" +
                "                <li>\n" +
                "                    <div>\n" +
                "                        <h3>\n" +
                "                            Used technologies:\n" +
                "                        </h3>\n" +
                "                        <ul>\n" +
                "                            <li>\n" +
                "                                Room database\n" +
                "                            </li>\n" +
                "                            <li>\n" +
                "                                MVP pattern\n" +
                "                            </li>\n" +
                "                            <li>\n" +
                "                                Html editor\n" +
                "                            </li>\n" +
                "                        </ul>\n" +
                "                    </div>\n" +
                "                </li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "    </div>";


        binding.descriptionText.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY));

        binding.contactDev.setPaintFlags(binding.contactDev.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        binding.contactDev.setOnClickListener(v -> {
            gotoLink("https://t.me/astrogirll06");
        });

    }

    private void gotoLink(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}

