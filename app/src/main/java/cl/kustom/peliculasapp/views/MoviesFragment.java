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

import java.util.Arrays;
import java.util.List;

import cl.kustom.peliculasapp.R;
import cl.kustom.peliculasapp.adapters.MovieAdapter;
import cl.kustom.peliculasapp.background.GetDataMovie;
import cl.kustom.peliculasapp.models.Movie;
import cl.kustom.peliculasapp.models.MoviesWrapper;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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
        //linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MovieAdapter();
        recyclerView.setAdapter(adapter);
        new Background().execute();


    }

    private class  Background extends GetDataMovie{
        private ProgressDialog progressDialog;



        @Override
        protected void onPreExecute() {
            Toast.makeText(getContext(), "Esta pasando por el pre", Toast.LENGTH_SHORT).show();
            Log.d("Kustom","Pasando por el pre");
            progressDialog = new ProgressDialog(getContext());

            //progressDialog.show();
        }

        @Override
        protected void onPostExecute(List<Movie> movies) {
            super.onPostExecute(movies);
            Log.d("kustom","toque con la petite");
        }
    }
    /* Log.d("Kustom","Pasando al post");
            if(moviesWrappers !=null){
                Log.d("Kustom post Fragment",moviesWrappers.toString());
                adapter.update(Arrays.asList(moviesWrappers));
            }else{
                Toast.makeText(getContext(), "Esta tirando null", Toast.LENGTH_SHORT).show();
            }

            progressDialog.dismiss();*/


    }