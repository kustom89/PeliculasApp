package cl.kustom.peliculasapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import cl.kustom.peliculasapp.R;

public class MoviesActivity extends AppCompatActivity {


    Button btnTop;
    private MoviesFragment moviesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        moviesFragment = (MoviesFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentMovie);

        btnTop = findViewById(R.id.topBtn);
        btnTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),TopMovieActivity.class);
                startActivity(intent);

            }
        });




    }


}
