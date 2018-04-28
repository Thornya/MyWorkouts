package gorillabox.myworkouts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class ExercisesFragment extends Fragment{
    private View view;
    private ArrayList<Exercise> items;
    private ArrayList<Boolean> itemsOpen;
    private NestedScrollView scrollView;
    private FloatingActionButton floatButton;
    private ExerciseAdapter adapter;

    public ExercisesFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.exercices_fragment, container, false);
        items = new ArrayList<>();
        itemsOpen = new ArrayList<>();
        scrollView = view.findViewById(R.id.exercise_container);

        initAddExercice();
        buildList();
        return view;
    }

    public void setFloatButton(FloatingActionButton floatButton){
        this.floatButton = floatButton;
    }

    private void initAddExercice(){
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddExercise.class);
                ((Activity) getContext()).startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //when we add a game
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
               //addTheExerciseHere
                Handler handler = new Handler();
                final Runnable r = new Runnable() {
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                };
                handler.post(r);
            }
        }
    }

    private void checkEmptyList(){
        scrollView.removeAllViews();
        TextView noTrainings = new TextView(this.getContext());
        noTrainings.setText(R.string.no_exercise);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        noTrainings.setGravity(Gravity.CENTER);
        noTrainings.setLayoutParams(params);
        scrollView.addView(noTrainings);
    }

    private void buildList(){
        //get items
        if(items.size() != 0) {
            ListView list = new ListView(this.getContext());
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
            list.setLayoutParams(params);
            adapter = new ExerciseAdapter(this.getContext(), items);
            list.setAdapter(adapter);
            scrollView.addView(list);

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    LinearLayout details = view.findViewById(R.id.exercise_layout_more);
                    if (itemsOpen.get(position)) {
                        itemsOpen.set(position, false);
                        details.removeAllViews();
                    } else {
                        itemsOpen.set(position, true);
                        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT,
                                1.0f
                        );
                        //+1 because we add labels
                        for (int i = 0; i < items.get(position).getSerial() + 1; i++) {
                            LinearLayout infos = new LinearLayout(getContext());
                            infos.setOrientation(LinearLayout.HORIZONTAL);
                            TextView serial = new TextView(getContext());
                            if (i != 0)
                                serial.setText(getResources().getString(R.string.serial) + " " + i);
                            serial.setGravity(Gravity.CENTER);
                            serial.setLayoutParams(param);
                            TextView repetitions = new TextView(getContext());
                            if (i == 0)
                                repetitions.setText(getResources().getString(R.string.repetitions));
                            else
                                repetitions.setText(Integer.toString(items.get(position).getRepetitions().get(i - 1)));
                            repetitions.setGravity(Gravity.CENTER);
                            repetitions.setLayoutParams(param);
                            TextView weight = new TextView(getContext());
                            if (i == 0)
                                weight.setText(getResources().getString(R.string.weight));
                            else
                                weight.setText(Integer.toString(items.get(position).getWeight().get(i - 1)));
                            weight.setGravity(Gravity.CENTER);
                            weight.setLayoutParams(param);
                            TextView rest = new TextView(getContext());
                            if (i == 0)
                                rest.setText(getResources().getString(R.string.rest_time));
                            else
                                rest.setText(Integer.toString(items.get(position).getRestTime().get(i - 1)));
                            rest.setGravity(Gravity.CENTER);
                            rest.setLayoutParams(param);
                            infos.addView(serial);
                            infos.addView(repetitions);
                            infos.addView(weight);
                            infos.addView(rest);
                            details.addView(infos);
                        }
                    }
                }
            });
        }else
            checkEmptyList();
    }
}
