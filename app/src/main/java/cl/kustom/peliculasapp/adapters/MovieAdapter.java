package cl.kustom.peliculasapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cl.kustom.peliculasapp.R;
import cl.kustom.peliculasapp.models.MoviesWrapper;
import cl.kustom.peliculasapp.models.Movie;
import cl.kustom.peliculasapp.views.MoviesFragment;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<Movie> resultsList = new ArrayList <>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d("Kustom5","*********************");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_movie, viewGroup, false);
        Log.d("Kustom5","*********************");
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d("Kustom5","*********************");

        Movie movie =  resultsList.get(i);
        //String tittula= movie.getTitle();
        //Context context = viewHolder.itemView.getContext();
        viewHolder.title.setText(movie.getTitle().toString());


    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }

    public  void update(List<Movie> moviesWrappers){
        Log.d("Kustom5","Entra por el Update");
        resultsList.addAll(moviesWrappers);
        notifyDataSetChanged();
        Log.d("Kustom5","Pasa por el Update");
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        private TextView title;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.titleTv);
        }
    }
}
