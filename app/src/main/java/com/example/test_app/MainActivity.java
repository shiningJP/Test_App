package com.example.test_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private final EditText[] INPUTS = new EditText[2];
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);
        INPUTS[0] = findViewById(R.id.input0);
        INPUTS[1] = findViewById(R.id.input1);
        Button button = findViewById(R.id.button);
    }

    public void onButtonTapped(View view) {
        var texts = new String[2];
        var sb = new StringBuilder();
        var pause = ": ";
        for (int i = 0; i < 2; i++) {
            texts[i] = INPUTS[i].getText().toString();
            sb.append(texts[i]).append("\n\n");
        }
        if (texts[0].isEmpty() && texts[1].isEmpty()) {
            textView.setText("");
            return;
        }
        sb.append(getString(R.string.match_rate)).append(pause);
        float rate = Utility.matchRate(texts[0], texts[1]) * 100;
        sb.append(String.format(Locale.getDefault(), "%.0f%%", rate));
        textView.setText(sb.toString());
    }
}