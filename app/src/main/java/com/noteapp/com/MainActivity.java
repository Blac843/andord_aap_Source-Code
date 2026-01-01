// Pehli line check karo, yeh aapke naye naam ke hisaab se hai
package com.noteapp.com;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {

    EditText noteInput;
    Button saveButton;
    SharedPreferences sharedPreferences;
    
    private static final String SHARED_PREF_NAME = "MyNotePref";
    private static final String KEY_NOTE = "note";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteInput = findViewById(R.id.noteInput);
        saveButton = findViewById(R.id.saveButton);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String savedNote = sharedPreferences.getString(KEY_NOTE, "");
        noteInput.setText(savedNote);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = noteInput.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NOTE, note);
                editor.apply();
                Toast.makeText(MainActivity.this, "Saved!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
