package com.example.vax.pickingratecalculator;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    com.example.vax.pickingratecalculator.CustomEditText logon1, logon2, logon3, logon4, logon5,logon6,pick1, pick2, pick3, pick4, pick5, pick6,mins1, mins2, mins3, mins4, mins5,mins6;
    com.example.vax.pickingratecalculator.CustomEditText s1, s2,s3, s4, s5, s6;
    double sec1, sec2, sec3, sec4, sec5, sec6;
    ArrayList<com.example.vax.pickingratecalculator.CustomEditText> fields = new ArrayList<com.example.vax.pickingratecalculator.CustomEditText>();
    String keyArray[]= new String[]{"logH1","logH2","logH3","logH4","logH5","logH6","logM1","logM2","logM3","logM4","logM5","logM6","pck1","pck2","pck3","pck4","pck5","pck6","logS1","logS2","logS3","logS4","logS5","logS6"};
    List<String> keys = Arrays.asList(keyArray);
    View view;
    TextView weeklyRate,dropRate, diff1, diff2, diff3, diff4, diff5, diff6, diffDay1,diffDay2,diffDay3,percent1,percent2,percent3;
    double day1Time , day2Time,day3Time,day4Time,day5Time,day6Time;
    double day1PRate, day2PRate, day3PRate, day4PRate, day5PRate, day6PRate;
    double weekTime = 0.0, weekPRate =0.0;
    SharedPreferences sharedPrefs;
    RelativeLayout rightDrawer, root, historyPanel;
    Spinner spinner1,spinner2,spinner3,spinner4,spinner5,spinner6;
    Button btnArea,btnHistory;
    GridLayout gL1, gL2, gL3, gL4, gL5, gL6;
    int dayEasy, dayMod, dayHard;
    String[] diffList;

    public void exit(View view){
        finish();
        System.exit(0);
    }

    public void process1(){
        if (logon1.getText().length()!=0 && mins1.getText().length()!=0 && pick1.getText().length()!=0) {
            if (s1.getText().length()==0){
                sec1=0.0;
            }
            else {
                sec1=Double.parseDouble(s1.getText().toString())/60;
            }
            day1Time = (Double.parseDouble(logon1.getText().toString()) * 60 + Double.parseDouble(mins1.getText().toString())+sec1) / 60;
            day1PRate = Double.parseDouble(pick1.getText().toString()) * day1Time;
            weekTime += day1Time;
            weekPRate += day1PRate;
        }
    }

    public void process2(){
        if (logon2.getText().length()!=0 && mins2.getText().length()!=0 && pick2.getText().length()!=0) {
            if (s2.getText().length()==0){
                sec2=0.0;
            }
            else {
                sec2=Double.parseDouble(s2.getText().toString())/60;
            }
            day2Time = (Double.parseDouble(logon2.getText().toString()) * 60 + Double.parseDouble(mins2.getText().toString())+sec2) / 60;
            day2PRate = Double.parseDouble(pick2.getText().toString()) * day2Time;
            weekTime += day2Time;
            weekPRate += day2PRate;
        }
    }
    public void process3(){
        if (logon3.getText().length()!=0 && mins3.getText().length()!=0 && pick3.getText().length()!=0) {
            if (s3.getText().length()==0){
                sec3=0.0;
            }
            else {
                sec3=Double.parseDouble(s3.getText().toString())/60;
            }
            day3Time = (Double.parseDouble(logon3.getText().toString()) * 60 + Double.parseDouble(mins3.getText().toString())+sec3) / 60;
            day3PRate = Double.parseDouble(pick3.getText().toString()) * day3Time;
            weekTime += day3Time;
            weekPRate += day3PRate;
        }
    }
    public void process4(){
        if (logon4.getText().length()!=0 && mins4.getText().length()!=0 && pick4.getText().length()!=0) {
            if (s4.getText().length()==0){
                sec4=0.0;
            }
            else {
                sec4=Double.parseDouble(s4.getText().toString())/60;
            }
            day4Time = (Double.parseDouble(logon4.getText().toString()) * 60 + Double.parseDouble(mins4.getText().toString())+sec4) / 60;
            day4PRate = Double.parseDouble(pick4.getText().toString()) * day4Time;
            weekTime += day4Time;
            weekPRate += day4PRate;
        }
    }
    public void process5(){
        if (logon5.getText().length()!=0 && mins5.getText().length()!=0 && pick5.getText().length()!=0) {
            if (s5.getText().length()==0){
                sec5=0.0;
            }
            else {
                sec5=Double.parseDouble(s5.getText().toString())/60;
            }
            day5Time = (Double.parseDouble(logon5.getText().toString()) * 60 + Double.parseDouble(mins5.getText().toString())+sec5) / 60;
            day5PRate = Double.parseDouble(pick5.getText().toString()) * day5Time;
            weekTime += day5Time;
            weekPRate += day5PRate;
        }
    }
    public void process6(){

        if (logon6.getText().length()!=0 && mins6.getText().length()!=0 && pick6.getText().length()!=0){
            if (s6.getText().length()==0){
                sec6=0.0;
            }
            else {
                sec6=Double.parseDouble(s6.getText().toString())/60;
            }
            day6Time = (Double.parseDouble(logon6.getText().toString())*60 + Double.parseDouble(mins6.getText().toString())+sec6)/60;
            day6PRate = Double.parseDouble(pick6.getText().toString())*day6Time;
            weekTime += day6Time;
            weekPRate += day6PRate;
        }
    }

    public void calculate(View view){
        weekTime = 0.0;
        weekPRate =0.0;
        process1();
        process2();
        process3();
        process4();
        process5();
        process6();

        if (weekTime ==0.0 || weekPRate ==0.0){
            Toast.makeText(getApplicationContext(),"fill up minimum one line", Toast.LENGTH_SHORT).show();
            weeklyRate.setText("N/A");
        }
        else{
            weeklyRate.setText(String.format("%.2f", (weekPRate / weekTime)));
            Log.i("weekPRate", String.valueOf(weekPRate));
            Log.i("weektime+30/60", String.valueOf(weekTime+(30.00/60.00)));
            dropRate.setText(String.format("%.2f", ((weekPRate / weekTime)- (weekPRate / (weekTime + (1.00 / 60.00)))))+" /minute");
        }
    }
    private void addWatcher(ViewGroup group)
    {
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof com.example.vax.pickingratecalculator.CustomEditText) {
                ((com.example.vax.pickingratecalculator.CustomEditText) view).addTextChangedListener(textWatcher);
            }}
    }

public void diffCalc(){
    int percTotal = dayEasy+dayHard+dayMod;
    if (dayEasy != 0){percent1.setText(String.valueOf((100 / percTotal) * dayEasy)+"%");}
    if (dayMod != 0){percent2.setText(String.valueOf((100 / percTotal) * dayMod)+"%");}
    if (dayHard != 0){percent3.setText(String.valueOf((100 / percTotal) * dayHard)+"%");}
    diffList = new String[]{diff1.getText().toString(),diff2.getText().toString(),diff3.getText().toString(),diff4.getText().toString(),diff5.getText().toString(),diff6.getText().toString()};
    dayEasy =dayHard=dayMod =0;
    for (int k=0; k<diffList.length;k++){
        if (diffList[k].equals("Hard")){
            dayHard++;
        }
        if (diffList[k].equals("Easy")){
            dayEasy++;
        }
        if (diffList[k].equals("Moderate")){
            dayMod++;
        }
    }
    diffDay1.setText(String.valueOf(dayEasy));
    diffDay2.setText(String.valueOf(dayMod));
    diffDay3.setText(String.valueOf(dayHard));
    percTotal = dayEasy+dayHard+dayMod;
    if (dayEasy != 0){percent1.setText(String.valueOf((100 / percTotal) * dayEasy)+"%");}
    else{percent1.setText("");}
    if (dayMod != 0){percent2.setText(String.valueOf((100 / percTotal) * dayMod)+"%");}
    else{percent2.setText("");}
    if (dayHard != 0){percent3.setText(String.valueOf((100 / percTotal) * dayHard)+"%");}
    else{percent3.setText("");}
}

    public AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (parent.getSelectedItem().toString().equals("North Rear Lower") ||
                    (parent.getSelectedItem().toString().equals("South Front Upper"))) {
                ViewGroup row = (ViewGroup) view.getParent().getParent();
                for (int i = 0; i < (row.getChildCount()); ++i) {
                    View v2 = row.getChildAt(i);
                    if (v2 instanceof TextView) {
                        ((TextView) v2).setText("Hard");
                        ((TextView) v2).setTextColor(Color.RED);
                        diffCalc();
                    }
                }
            }
            if (parent.getSelectedItem().toString().equals("North Front Upper") ||
                    (parent.getSelectedItem().toString().equals("South Rear Upper"))) {
                //dayEasy++;
                ViewGroup row = (ViewGroup) view.getParent().getParent();
                for (int i = 0; i < (row.getChildCount()); ++i) {
                    View v2 = row.getChildAt(i);
                    if (v2 instanceof TextView) {
                        ((TextView) v2).setText("Easy");
                        ((TextView) v2).setTextColor(Color.GREEN);
                        diffCalc();
                    }
                }
            }
            if (parent.getSelectedItem().toString().equals("North Front Lower") ||
                    (parent.getSelectedItem().toString().equals("North Rear Upper")) ||
                    (parent.getSelectedItem().toString().equals("South Front Lower")) ||
                    (parent.getSelectedItem().toString().equals("South Rear Lower"))) {
                ViewGroup row = (ViewGroup) view.getParent().getParent();
                for (int i = 0; i < (row.getChildCount()); ++i) {
                    View v2 = row.getChildAt(i);
                    if (v2 instanceof TextView) {
                        ((TextView) v2).setText("Moderate");
                        ((TextView) v2).setTextColor(Color.DKGRAY);
                        diffCalc();
                    }
                }
            }
            if (parent.getSelectedItem().toString().contains("Off")){
                ViewGroup row = (ViewGroup) view.getParent().getParent();

                for (int i = 0; i < (row.getChildCount()); ++i) {
                    View v2 = row.getChildAt(i);
                    if (v2 instanceof TextView) {
                        ((TextView) v2).setText("-");
                        ((TextView) v2).setTextColor(Color.BLACK);
                        diffCalc();
                    }}
            }

        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }

    };

    public TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            view = getCurrentFocus();
            if (count != 0) {
                if (((com.example.vax.pickingratecalculator.CustomEditText) view).getText().length() == 0) {
                    try {
                        view.focusSearch(View.FOCUS_LEFT).requestFocus();
                        ((com.example.vax.pickingratecalculator.CustomEditText) view).setSelection(((com.example.vax.pickingratecalculator.CustomEditText) view).getText().length());
                    } catch (Exception e){

                    }
            }}
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            view = getCurrentFocus();
            if (count != 0) {
                if (((com.example.vax.pickingratecalculator.CustomEditText) view).getText().length() == 3) {
                    String hour1 = ((com.example.vax.pickingratecalculator.CustomEditText) view).getText().toString();
                    ((com.example.vax.pickingratecalculator.CustomEditText) view).setText(hour1 + ".");
                    ((com.example.vax.pickingratecalculator.CustomEditText) view).setSelection(((com.example.vax.pickingratecalculator.CustomEditText) view).getText().length());
                }
                if (((com.example.vax.pickingratecalculator.CustomEditText) view).getTag().toString().matches("h.")) {
                    if (((com.example.vax.pickingratecalculator.CustomEditText) view).getText().length() == 1) {
                        view.focusSearch(View.FOCUS_RIGHT).requestFocus();
                    }
                }
                if (((com.example.vax.pickingratecalculator.CustomEditText) view).getTag().toString().matches("s.")||
                        ((com.example.vax.pickingratecalculator.CustomEditText) view).getTag().toString().matches("m.")) {
                    if (((com.example.vax.pickingratecalculator.CustomEditText) view).getText().length() == 2) {
                        view.focusSearch(View.FOCUS_RIGHT).requestFocus();
                    }
                }
            }else{if (((com.example.vax.pickingratecalculator.CustomEditText) view).getText().length() == 0) {
                try {
                    view.focusSearch(View.FOCUS_LEFT).requestFocus();
                    ((com.example.vax.pickingratecalculator.CustomEditText) view).setSelection(((com.example.vax.pickingratecalculator.CustomEditText) view).getText().length());
                }
                catch (Exception e){
                }
            }

            }
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    private void clearForm(ViewGroup group)
    {
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof com.example.vax.pickingratecalculator.CustomEditText) {
                ((com.example.vax.pickingratecalculator.CustomEditText)view).setText("");
            }
            if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                clearForm((ViewGroup) view);
        }
    }
    public void clickClear (View view) {
        clearForm((ViewGroup) findViewById(R.id.root));
        clearArea((ViewGroup) findViewById(R.id.rightdrawer));
        weeklyRate.setText("");
        dropRate.setText("");
    }

    private void clearArea(ViewGroup group){
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof Spinner) {
                ((Spinner)view).setSelection(0);
            }
            if (view.getTag()!=null && view.getTag().toString().contains("txt")){
                ((TextView)view).setText("-");
            }
            if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                clearArea((ViewGroup)view);
        }
        diffCalc();
    }


    public void rightin (View view){
        if (rightDrawer.getAlpha()==1f){
            rightDrawer.animate().translationX(1000f);
            rightDrawer.animate().alpha(0f);
            btnArea.setText("Area");
            btnArea.setPadding(10, 0, 0, 0);
            btnArea.setTextSize(16f);
            spinner1.requestFocus();
        }
        else{
            rightDrawer.animate().translationX(0f);
            rightDrawer.animate().alpha(1f);
            //rightDrawer.setVisibility(view.VISIBLE);
            btnArea.setText(">>>");
            btnArea.setTextSize(18f);
            btnArea.setPadding(0, 0, 5, 0);

        }
    }
    public void leftin (View view){
        if (historyPanel.getAlpha()==1f){
            historyPanel.animate().translationX(-1200f);
            historyPanel.animate().alpha(0f);
            btnHistory.setText("History");
            btnHistory.setPadding(0, 0, 0, 0);
            btnHistory.setTextSize(14f);

        }
        else{
            historyPanel.animate().translationX(0f);
            historyPanel.animate().alpha(1f);
            //rightDrawer.setVisibility(view.VISIBLE);
            btnHistory.setText("<<<");
            btnHistory.setTextSize(18f);
            btnHistory.setPadding(0, 0, 0, 0);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fields.add(logon1 = (com.example.vax.pickingratecalculator.CustomEditText) findViewById(R.id.h1));
        fields.add(logon2 = (com.example.vax.pickingratecalculator.CustomEditText) findViewById(R.id.h2));
        fields.add(logon3 = (com.example.vax.pickingratecalculator.CustomEditText) findViewById(R.id.h3));
        fields.add(logon4 = (com.example.vax.pickingratecalculator.CustomEditText) findViewById(R.id.h4));
        fields.add(logon5 = (com.example.vax.pickingratecalculator.CustomEditText) findViewById(R.id.h5));
        fields.add(logon6 = (com.example.vax.pickingratecalculator.CustomEditText) findViewById(R.id.h6));
        fields.add(pick1 = (com.example.vax.pickingratecalculator.CustomEditText) findViewById(R.id.pick1));
        fields.add(pick2 = (com.example.vax.pickingratecalculator.CustomEditText)findViewById(R.id.pick2));
        fields.add(pick3 = (com.example.vax.pickingratecalculator.CustomEditText)findViewById(R.id.pick3));
        fields.add(pick4 = (com.example.vax.pickingratecalculator.CustomEditText)findViewById(R.id.pick4));
        fields.add(pick5 = (com.example.vax.pickingratecalculator.CustomEditText)findViewById(R.id.pick5));
        fields.add(pick6 = (com.example.vax.pickingratecalculator.CustomEditText)findViewById(R.id.pick6));
        fields.add(mins1 = (com.example.vax.pickingratecalculator.CustomEditText)findViewById(R.id.m1));
        fields.add(mins2 = (com.example.vax.pickingratecalculator.CustomEditText)findViewById(R.id.m2));
        fields.add(mins3 = (com.example.vax.pickingratecalculator.CustomEditText)findViewById(R.id.m3));
        fields.add(mins4 = (com.example.vax.pickingratecalculator.CustomEditText)findViewById(R.id.m4));
        fields.add(mins5 = (com.example.vax.pickingratecalculator.CustomEditText)findViewById(R.id.m5));
        fields.add(mins6 = (com.example.vax.pickingratecalculator.CustomEditText)findViewById(R.id.m6));
        fields.add(s1 = (com.example.vax.pickingratecalculator.CustomEditText)findViewById(R.id.s1));
        fields.add(s2 = (com.example.vax.pickingratecalculator.CustomEditText)findViewById(R.id.s2));
        fields.add(s3 = (com.example.vax.pickingratecalculator.CustomEditText)findViewById(R.id.s3));
        fields.add(s4 = (com.example.vax.pickingratecalculator.CustomEditText)findViewById(R.id.s4));
        fields.add(s5 = (com.example.vax.pickingratecalculator.CustomEditText)findViewById(R.id.s5));
        fields.add(s6 = (com.example.vax.pickingratecalculator.CustomEditText)findViewById(R.id.s6));
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner3 = (Spinner)findViewById(R.id.spinner3);
        spinner4 = (Spinner)findViewById(R.id.spinner4);
        spinner5 = (Spinner)findViewById(R.id.spinner5);
        spinner6 = (Spinner)findViewById(R.id.spinner6);
        weeklyRate = (TextView)findViewById(R.id.weeklyRate);
        dropRate = (TextView)findViewById(R.id.dropRate);
        String[] areaList = new String[]{"--Off--","North Front Lower","North Front Upper","North Rear Lower","North Rear Upper","South Front Lower","South Front Upper","South Rear Lower","South Rear Lower"};
        ArrayAdapter<String > aa=new ArrayAdapter<String> (this,android.R.layout.simple_spinner_dropdown_item,areaList);
        spinner1.setAdapter(aa);
        spinner2.setAdapter(aa);
        spinner3.setAdapter(aa);
        spinner4.setAdapter(aa);
        spinner5.setAdapter(aa);
        spinner6.setAdapter(aa);
        spinner1.setOnItemSelectedListener(spinnerListener);
        spinner2.setOnItemSelectedListener(spinnerListener);
        spinner3.setOnItemSelectedListener(spinnerListener);
        spinner4.setOnItemSelectedListener(spinnerListener);
        spinner5.setOnItemSelectedListener(spinnerListener);
        spinner6.setOnItemSelectedListener(spinnerListener);
        diff1 = (TextView)findViewById(R.id.diff1);
        diff2 = (TextView)findViewById(R.id.diff2);
        diff3 = (TextView)findViewById(R.id.diff3);
        diff4 = (TextView)findViewById(R.id.diff4);
        diff5 = (TextView)findViewById(R.id.diff5);
        diff6 = (TextView)findViewById(R.id.diff6);
        diffDay1 = (TextView)findViewById(R.id.diffDay1);
        diffDay2 = (TextView)findViewById(R.id.diffDay2);
        diffDay3 = (TextView)findViewById(R.id.diffDay3);
        percent1 = (TextView)findViewById(R.id.percent1);
        percent2 = (TextView)findViewById(R.id.percent2);
        percent3 = (TextView)findViewById(R.id.percent3);
        root = (RelativeLayout)findViewById(R.id.root);
        rightDrawer = (RelativeLayout) findViewById(R.id.rightdrawer);
        historyPanel = (RelativeLayout) findViewById(R.id.historyPanel);
        gL1 = (GridLayout)findViewById(R.id.gL1);
        gL2 = (GridLayout)findViewById(R.id.gL2);
        gL3 = (GridLayout)findViewById(R.id.gL3);
        gL4 = (GridLayout)findViewById(R.id.gL4);
        gL5 = (GridLayout)findViewById(R.id.gL5);
        gL6 = (GridLayout)findViewById(R.id.gL6);
        addWatcher(gL1);
        addWatcher(gL2 );
        addWatcher(gL3 );
        addWatcher(gL4 );
        addWatcher(gL5 );
        addWatcher(gL6 );
        btnArea = (Button)findViewById(R.id.btnArea);
        btnHistory = (Button)findViewById(R.id.btnHistory);
        rightDrawer.setX(1000f);
        rightDrawer.setAlpha(0f);
        historyPanel.setX(-1200f);
        historyPanel.setAlpha(0f);

    }

    public void load(){
        sharedPrefs = this.getSharedPreferences(
                "com.example.vax.pickingratecalculator", Context.MODE_PRIVATE);

        for (int i=0;i<fields.size(); i++ ){
            fields.get(i).setText(sharedPrefs.getString(keys.get(i), ""));
        }
        spinner1.setSelection(sharedPrefs.getInt("sp1", 0));
        spinner2.setSelection(sharedPrefs.getInt("sp2",0));
        spinner3.setSelection(sharedPrefs.getInt("sp3",0));
        spinner4.setSelection(sharedPrefs.getInt("sp4",0));
        spinner5.setSelection(sharedPrefs.getInt("sp5",0));
        spinner6.setSelection(sharedPrefs.getInt("sp6",0));
        weeklyRate.setText(sharedPrefs.getString("wklRate", ""));
        dropRate.setText(sharedPrefs.getString("drpRate", ""));

    }
    public void loadInfo (View view){
        load();
    }

    public void save(){
        sharedPrefs = this.getSharedPreferences(
                "com.example.vax.pickingratecalculator", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.clear();
        for (int i=0;i<fields.size(); i++ ){
            editor.remove(keys.get(i));
            editor.putString(keys.get(i), fields.get(i).getText().toString());
        }
        editor.putInt("sp1", spinner1.getSelectedItemPosition());
        editor.putInt("sp2", spinner2.getSelectedItemPosition());
        editor.putInt("sp3", spinner3.getSelectedItemPosition());
        editor.putInt("sp4", spinner4.getSelectedItemPosition());
        editor.putInt("sp5", spinner5.getSelectedItemPosition());
        editor.putInt("sp6", spinner6.getSelectedItemPosition());
        editor.putString("wklRate", weeklyRate.getText().toString());
        editor.putString("drpRate", dropRate.getText().toString());
        editor.apply();
        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
    }
    public void saveInfo (View view){
        save();
    }
    @Override
     public void onResume(){
        super.onResume();
        Handler handlerTimer = new Handler();
        handlerTimer.postDelayed(new Runnable() {
            public void run() {
                load();
            }
        }, 100);

    }
    @Override
    public void onStop(){
        super.onStop();
       save();
    }

    @Override
    public void onPause(){
        super.onPause();
        save();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
