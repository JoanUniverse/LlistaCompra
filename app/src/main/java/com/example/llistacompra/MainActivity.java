package com.example.llistacompra;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.llistacompra.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView myListView;
    private Button button;
    private List<String> lista = new ArrayList<>();
    private ArrayAdapter<String> myAdapter;
    private EditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = findViewById(R.id.listView);
        myListView.setOnItemClickListener(this);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        myEditText = findViewById(R.id.editText);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button: String texto = myEditText.getText().toString().trim();
                lista.add(texto);
                myEditText.getText().clear();
                myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
                myListView.setAdapter(myAdapter);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(this, "Click Item" + position, Toast.LENGTH_LONG).show();
    }
}