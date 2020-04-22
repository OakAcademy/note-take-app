package com.company.notetake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText title;
    EditText description;
    Button cancel;
    Button save;
    int noteid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Update Note");
        setContentView(R.layout.activity_update);

        title = findViewById(R.id.editTextTitleUpdate);
        description = findViewById(R.id.editTextDescriptionUpdate);
        cancel = findViewById(R.id.buttonCancelUpdate);
        save = findViewById(R.id.buttonSaveUpdate);

        getData();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Nothing Updated", Toast.LENGTH_LONG).show();
                finish();

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNote();
            }
        });
    }

    public void updateNote()
    {
        String titlelast = title.getText().toString();
        String descriptionlast = description.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("titlelast", titlelast);
        intent.putExtra("descriptionlast", descriptionlast);
        if(noteid != -1)
        {
            intent.putExtra("noteid", noteid);
            setResult(RESULT_OK, intent);
            finish();
        }

    }

    public void getData()
    {
        Intent i = getIntent();
        noteid = i.getIntExtra("id", -1);
        String notetitle = i.getStringExtra("title");
        String notedescription = i.getStringExtra("description");

        title.setText(notetitle);
        description.setText(notedescription);
    }
}
