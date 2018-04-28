package gorillabox.myworkouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddExercise extends AppCompatActivity {
    private LinearLayout layout;
    private EditText name;
    private EditText serials;
    private RadioButton buttonYes;
    private RadioButton buttonNo;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(View.inflate(getApplicationContext(), R.layout.add_exercise, null));
        initialize();

    }

    private void initialize(){
        layout = findViewById(R.id.add_exercise_linear);
        name = findViewById(R.id.add_exercise_name);
        serials = findViewById(R.id.add_exercise_serial);
        buttonYes = findViewById(R.id.add_exercise_button_yes);
        buttonNo = findViewById(R.id.add_exercise_button_no);
        radioGroup = findViewById(R.id.add_exercise_radio_group);

        serials.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.equals("") ) {
                    buttonYes.setClickable(true);
                    buttonNo.setClickable(true);
                }else{
                    buttonYes.setClickable(false);
                    buttonNo.setClickable(false);
                    buttonYes.setChecked(false);
                    buttonNo.setChecked(false);
                    layout.removeAllViews();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
        });
        initRadioGroup();
    }

    private void initRadioGroup(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.add_exercise_button_yes){
                    buttonYesChecked();
                }else{
                    buttonNoChecked();
                }
            }
        });
    }

    private void buttonYesChecked(){
        layout.removeAllViews();
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT,1.0f);
        LinearLayout infos = new LinearLayout(getApplicationContext());
        infos.setOrientation(LinearLayout.HORIZONTAL);
        EditText repetitions = new EditText(getApplicationContext());
        repetitions.setHint(getResources().getString(R.string.repetitions));
        repetitions.setLayoutParams(param);
        repetitions.setInputType(InputType.TYPE_CLASS_NUMBER);
        EditText weight = new EditText(getApplicationContext());
        weight.setHint(getResources().getString(R.string.weight));
        weight.setLayoutParams(param);
        repetitions.setInputType(InputType.TYPE_CLASS_NUMBER);
        EditText restTime = new EditText(getApplicationContext());
        restTime.setHint(getResources().getString(R.string.rest_time));
        restTime.setLayoutParams(param);
        repetitions.setInputType(InputType.TYPE_CLASS_NUMBER);
        infos.addView(repetitions);
        infos.addView(weight);
        infos.addView(restTime);
        layout.addView(infos);
    }

    private void buttonNoChecked(){
        layout.removeAllViews();

    }
}
