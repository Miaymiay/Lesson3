package com.mirea.pershinadv.favoritebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView bookView = findViewById(R.id.textViewFavoriteBook);
            String bookName = extras.getString(MainActivity.KEY);
            bookView.setText(String.format("Любимая книга разработчика: %s", bookName));
        }

        Button buttonSend = findViewById(R.id.buttonSend);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBookName(v);
            }
        });
    }

    public void sendBookName(View view) {
        EditText editText = findViewById(R.id.editTextBook);
        String text = editText.getText().toString();

        Intent data = new Intent();
        data.putExtra(MainActivity.USER_MESSAGE, text);
        setResult(Activity.RESULT_OK, data);
        finish();
    }
}

