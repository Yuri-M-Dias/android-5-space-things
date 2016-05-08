package dias.m.yuri.fivespace;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import dias.m.yuri.fivespace.model.SpaceFact;

import java.util.List;

/**
 * Adapter to use the RecyclerView and be able to dynamically use a number of
 * cardviews.
 * Created by Yuri on 07-May-16.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.SpaceFactsHolder> {

    public static class SpaceFactsHolder extends RecyclerView.ViewHolder {

        CardView cv;
        Button photoName;
        ImageView spacePhoto;

        public SpaceFactsHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cardview);
            spacePhoto = (ImageView) itemView.findViewById(R.id.space_photo_min);
            photoName = (Button) itemView.findViewById(R.id
                    .space_photo_button);
        }

    }

    List<SpaceFact> facts;

    public RVAdapter(List<SpaceFact> facts) {
        this.facts = facts;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public SpaceFactsHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout
                .item_cardview, viewGroup, false);
        SpaceFactsHolder pvh = new SpaceFactsHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(SpaceFactsHolder spaceFactsViewHolder, int i) {
        spaceFactsViewHolder.photoName.setText(facts.get(i).getName());
        spaceFactsViewHolder.spacePhoto.setImageResource(facts.get(i).getPhotoID());
    }

    @Override
    public int getItemCount() {
        return facts.size();
    }
}
