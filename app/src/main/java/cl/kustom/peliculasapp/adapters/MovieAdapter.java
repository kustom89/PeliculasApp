package cl.kustom.peliculasapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cl.kustom.peliculasapp.R;
import cl.kustom.peliculasapp.models.Movie;
import cl.kustom.peliculasapp.models.MovieResults;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<MovieResults> resultsList = new ArrayList <>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_movie, viewGroup, false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        MovieResults movieResults = resultsList.get(i);
        viewHolder.title.setText(new MovieResults().getTitle());

    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }

    public  void update(List<MovieResults> movieResults){
        resultsList.addAll(movieResults);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        private TextView title;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.titleTv);
        }
    }
}
