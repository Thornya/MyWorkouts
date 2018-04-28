package gorillabox.myworkouts;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExerciseAdapter extends BaseAdapter {
    Context context;
    ArrayList<Exercise> exercises;

    public ExerciseAdapter(Context context, ArrayList<Exercise> exercises){
        this.context = context;
        this.exercises = exercises;
    }

    @Override
    public int getCount() {
        return exercises.size();
    }

    @Override
    public Object getItem(int position) {
        return exercises.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.exercise_adapter, parent, false);
        }
        Exercise currentItem = (Exercise) getItem(position);

        TextView itemName = convertView.findViewById(R.id.exercise_name);
        itemName.setText(currentItem.getName());

        return convertView;
    }
}
