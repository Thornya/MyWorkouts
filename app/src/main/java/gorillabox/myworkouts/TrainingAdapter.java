package gorillabox.myworkouts;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TrainingAdapter extends BaseAdapter {
    Context context;
    ArrayList<Training> trainings;
    private ArrayList<Exercise> items;
    private ArrayList<Boolean> itemsOpen;
    private NestedScrollView scrollView;

    public TrainingAdapter(Context context, ArrayList<Training> trainings){
        this.context = context;
        this.trainings = trainings;
    }

    @Override
    public int getCount() {
        return trainings.size();
    }

    @Override
    public Object getItem(int position) {
        return trainings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.training_adapter, parent, false);
        }
        Training currentTraining = (Training) getItem(position);

        TextView trainingName = (TextView) convertView.findViewById(R.id.training_name);
        trainingName.setText(currentTraining.getName());
        return convertView;
    }
}
