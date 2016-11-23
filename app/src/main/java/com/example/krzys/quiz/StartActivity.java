package com.example.krzys.quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartActivity extends AppCompatActivity {
    @BindView(R.id.playername)
protected EditText nName;
    @BindView(R.id.level)
    protected Spinner mLevel;
    private UserPreference mPrefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
        mPrefs= new UserPreference(this);
        nName.setText(mPrefs.getUsername());
        mLevel.setSelection(mPrefs.getLevel());
    }
@OnClick(R.id.next)
    protected void onNextClick(){

    String name=nName.getText().toString();
    if(name.trim().isEmpty()){
        nName.setError("brak nazwy" +
                "");
    }
    int selectedLevel= mLevel.getSelectedItemPosition();
    if(selectedLevel==0){
        Toast.makeText(this,"select level",Toast.LENGTH_LONG).show();
    }


    mPrefs.setLevel(selectedLevel);
    mPrefs.setUsername(name);
    //TODO losowanie puli
    //TODO Otwarcie nowego okna
    Intent questionIntent=new Intent(this,QuestionActivity.class);
    startActivity(questionIntent);
}

}
