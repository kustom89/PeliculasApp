package cl.kustom.peliculasapp.adapters;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import cl.kustom.peliculasapp.R;
import cl.kustom.peliculasapp.models.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    public List<Movie> resultsList = new ArrayList <>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_movie, viewGroup, false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d("Kustom5","*********************");

        Movie movie =  resultsList.get(i);
        viewHolder.title.setText(movie.getTitle().toString());
        viewHolder.fechaEstreno.setText(movie.getRelease_date().toString());
        Picasso.get().load("https://image.tmdb.org/t/p/w500/" + movie.getPoster_path()).centerCrop().fit().into(viewHolder.portada);

    }

    @Override
    public int getItemCount() {
        Log.d("Kustom getItemCount", String.valueOf(resultsList.size()));
        return resultsList.size();
    }

    public  void update(List<Movie> moviesWrappers){
        Log.d("Kustom5","Entra por el Update");
        resultsList.addAll(moviesWrappers);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        private TextView title;
        private TextView fechaEstreno;
        private ImageView portada;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.titleTv);
            fechaEstreno = itemView.findViewById(R.id.fechaEstrenoTv);
            portada = itemView.findViewById(R.id.posterIv);

        }
    }
}
