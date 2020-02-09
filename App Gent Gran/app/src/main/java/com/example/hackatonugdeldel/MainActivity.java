package com.example.hackatonugdeldel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private adapterTodoListFilter scTasks;


    JSONObject jsonjObject = new JSONObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAfegir = findViewById(R.id.btnAfegir);
        btnAfegir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intentMoviments = new Intent(getApplicationContext(), Afegir_Articles.class );
                startActivity(intentMoviments);
            }
        });

        JSONObject jsonjObject = new JSONObject();


    }
}

class adapterTodoListFilter extends android.widget.SimpleCursorAdapter {

    public adapterTodoListFilter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = super.getView(position, convertView, parent);

        return view;
    }
}
