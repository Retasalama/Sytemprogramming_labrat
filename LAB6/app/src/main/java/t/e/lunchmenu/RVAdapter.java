package t.e.lunchmenu;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MealViewHolder>{

    private List<Lunches> lunches;

    RVAdapter(List<Lunches> aLunches){
        this.lunches = aLunches;
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_layout, viewGroup, false);
        MealViewHolder pvh = new MealViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder mealViewHolder, int i) {
        mealViewHolder.mainCourse.setText(lunches.get(i).getHeadCourse());
        mealViewHolder.sideCourse.setText(lunches.get(i).getSideDish());
        mealViewHolder.secondSideCourse.setText(lunches.get(i).getSecondSideDish());
        mealViewHolder.mealIcon.setImageResource(lunches.get(i).getIconId());


    }

    @Override
    public int getItemCount() {
        return lunches.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class MealViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView mainCourse;
        TextView sideCourse;
        TextView secondSideCourse;
        ImageView mealIcon;

        MealViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_view);
            mainCourse = (TextView)itemView.findViewById(R.id.tv_mainCourse);
            sideCourse = (TextView)itemView.findViewById(R.id.tv_sideCourse);
            secondSideCourse = (TextView)itemView.findViewById(R.id.tv_sideCourse2);
            mealIcon = (ImageView)itemView.findViewById(R.id.imageviewLunch);
        }
    }

}
