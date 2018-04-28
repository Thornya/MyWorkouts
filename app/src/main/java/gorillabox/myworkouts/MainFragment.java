package gorillabox.myworkouts;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;

public class MainFragment extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton floatButtonTraining;
    private FloatingActionButton floatButtonExercise;
    private TrainingsFragment trainingsFragment;
    private ExercisesFragment exercisesFragment;
    private CalendarFragment calendarFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_fragment);
        initialize();
    }

    void initialize(){
        viewPager = findViewById(R.id.viewpager);
        floatButtonTraining = findViewById(R.id.floatingActionButtonTraining);
        floatButtonExercise = findViewById(R.id.floatingActionButtonExercise);

        trainingsFragment = new TrainingsFragment();
        trainingsFragment.setFloatButton(floatButtonTraining);
        exercisesFragment = new ExercisesFragment();
        exercisesFragment.setFloatButton(floatButtonExercise);
        calendarFragment = new CalendarFragment();

        FragmentPageAdapter adapter = new FragmentPageAdapter(getSupportFragmentManager());
        adapter.addFragment(trainingsFragment, getApplicationContext().getResources().getString(R.string.my_trainings));
        adapter.addFragment(exercisesFragment, getApplicationContext().getResources().getString(R.string.my_exercises));
        adapter.addFragment(calendarFragment, getApplicationContext().getResources().getString(R.string.calendar));
        viewPager.setAdapter(adapter);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position){
                switch (position) {
                    case 0:
                        floatButtonTraining.show();
                        floatButtonExercise.hide();
                        break;
                    case 1:
                        floatButtonExercise.show();
                        floatButtonTraining.hide();
                        break;
                    default:
                        floatButtonTraining.hide();
                        floatButtonExercise.show();
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


    }

}