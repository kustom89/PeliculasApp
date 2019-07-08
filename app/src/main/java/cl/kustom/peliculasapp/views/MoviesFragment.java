package cl.kustom.peliculasapp.views;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cl.kustom.peliculasapp.R;
import cl.kustom.peliculasapp.adapters.MovieAdapter;
import cl.kustom.peliculasapp.background.GetDataMovie;
import cl.kustom.peliculasapp.models.Movie;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {
    private MovieAdapter adapter;
    private boolean pendingRequest = false;


    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SwipeRefreshLayout refreshLayout ;
        refreshLayout = view.findViewById(R.id.reloadSRL);
        RecyclerView recyclerView= view.findViewById(R.id.moviesRv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MovieAdapter();
        List<Movie> movies = new ArrayList <>();
        recyclerView.setAdapter(adapter);
        new Background().execute();
        Log.d("Kustom Despues del execute","*************************ON-VIEW-CREATED**********************");

        new Background();





    }

    private class  Background extends GetDataMovie{
        private ProgressDialog progressDialog;



        @Override
        protected void onPreExecute() {
            Toast.makeText(getContext(), "INICIO", Toast.LENGTH_SHORT).show();
            Log.d("Kustom","******INICIO******");
            progressDialog = new ProgressDialog(getContext());

            progressDialog.show();
        }

        @Override
        protected void onPostExecute(List<Movie> movies) {
            super.onPostExecute(movies);
            Log.d("Kustom","*****FIN********");
            Toast.makeText(getContext(), "Termino", Toast.LENGTH_SHORT).show();
            for (int i = 0; i < movies.size(); i++) {
                adapter.update(Arrays. <Movie>asList(movies.get(i)));
                Log.d("Kustom FIN ", String.valueOf(Arrays.asList(movies.get(i))));
            }
            progressDialog.dismiss();


        }

    }

}