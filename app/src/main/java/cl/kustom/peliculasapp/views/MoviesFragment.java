package cl.kustom.peliculasapp.views;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import cl.kustom.peliculasapp.R;
import cl.kustom.peliculasapp.adapters.MovieAdapter;
import cl.kustom.peliculasapp.background.GetDataMovie;
import cl.kustom.peliculasapp.models.MovieResults;
import cl.kustom.peliculasapp.networks.GetMovie;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {
    private MovieAdapter adapter;


    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView= (RecyclerView) view;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MovieAdapter();
        recyclerView.setAdapter(adapter);
        new Background().execute();


    }

    private class  Background extends GetDataMovie{
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(getContext());
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(MovieResults[] movieResults) {
            if(movieResults !=null){
                adapter.update(Arrays.asList(movieResults));
            }

            progressDialog.dismiss();
        }
    }


    }