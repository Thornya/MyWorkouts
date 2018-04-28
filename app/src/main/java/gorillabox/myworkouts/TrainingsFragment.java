package gorillabox.myworkouts;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class TrainingsFragment extends Fragment{
    private View view;
    private ArrayList<Training> items;
    private NestedScrollView scrollView;
    private FloatingActionButton floatButton;

    public TrainingsFragment(){}

    public void setFloatButton(FloatingActionButton floatButton){
        this.floatButton = floatButton;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.trainings_fragment, container, false);
        items = new ArrayList<>();
        scrollView = view.findViewById(R.id.trainings_container);
        buildList();
        return view;
    }

    private void buildList(){
        //check items

        if(items.size() != 0) {
            ListView list = new ListView(this.getContext());
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT);
            list.setLayoutParams(params);
            TrainingAdapter adapter = new TrainingAdapter(this.getContext(), items);
            list.setAdapter(adapter);
            items.add(new Training(null, "test", null));
            scrollView.addView(list);
        }else
            checkEmptyList();
    }

    private void checkEmptyList(){
        scrollView.removeAllViews();
        TextView noTrainings = new TextView(this.getContext());
        noTrainings.setText(R.string.no_training);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        noTrainings.setGravity(Gravity.CENTER);
        noTrainings.setLayoutParams(params);
        scrollView.addView(noTrainings);
    }
}
