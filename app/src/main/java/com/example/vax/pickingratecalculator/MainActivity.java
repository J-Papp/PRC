package com.example.vax.pickingratecalculator;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    EditText logon1, logon2, logon3, logon4, logon5,logon6,pick1, pick2, pick3, pick4, pick5, pick6,mins1, mins2, mins3, mins4, mins5,mins6;
    EditText s1, s2,s3, s4, s5, s6, pickb1, pickb2, pickb3, pickb4, pickb5, pickb6;
    double sec1, sec2, sec3, sec4, sec5, sec6, pb1, pb2, pb3, pb4, pb5, pb6;
    ArrayList<EditText> fields = new ArrayList<EditText>();
    String keyArray[]= new String[]{"logH1","logH2","logH3","logH4","logH5","logH6","logM1","logM2","logM3","logM4","logM5","logM6","pck1","pck2","pck3","pck4","pck5","pck6","logS1","logS2","logS3","logS4","logS5","logS6"};
    List<String> keys = Arrays.asList(keyArray);
    View view;
    TextView weeklyRate,dropRate;
    double day1Time , day2Time,day3Time,day4Time,day5Time,day6Time;
    double day1PRate, day2PRate, day3PRate, day4PRate, day5PRate, day6PRate;
    double weekTime = 0.0, weekPRate =0.0;
    SharedPreferences sharedPrefs;
    RelativeLayout rightDrawer, root;
    Spinner spinner1,spinner2,spinner3,spinner4,spinner5,spinner6;
    ViewGroup group;
    GridLayout gL1, gL2, gL3, gL4, gL5, gL6;
    boolean del, react;






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
            if (view instanceof EditText) {
                ((EditText) view).addTextChangedListener(textWatcher);
            }}
    }
    public TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            view = getCurrentFocus();

        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            view = getCurrentFocus();
                if (count != 0) {

                if (((EditText) view).getText().length() == 3) {
                    String hour1 = ((EditText) view).getText().toString();
                    ((EditText) view).setText(hour1 + ".");
                    ((EditText) view).setSelection(((EditText) view).getText().length());
                }


                if (((EditText) view).getTag().toString().matches("h.")) {
                    if (((EditText) view).getText().length() == 1) {
                        //Log.i("xxxx","df");
                        view.focusSearch(View.FOCUS_RIGHT).requestFocus();
                    }
                }
                if (((EditText) view).getTag().toString().matches("m.")) {
                    if (((EditText) view).getText().length() == 2) {
                        view.focusSearch(View.FOCUS_RIGHT).requestFocus();
                    }
                }
                if (((EditText) view).getTag().toString().matches("s.")) {
                    if (((EditText) view).getText().length() == 2) {
                        view.focusSearch(View.FOCUS_RIGHT).requestFocus();
                    }
                }
            }else{if (((EditText) view).getText().length() == 0) {
                   try {
                       view.focusSearch(View.FOCUS_LEFT).requestFocus();
                       ((EditText) view).setSelection(((EditText) view).getText().length());
                   } catch (Exception e){

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
            if (view instanceof EditText) {
                ((EditText)view).setText("");
            }

            if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                clearForm((ViewGroup)view);
        }
    }
    public void clickClear (View view) {
        clearForm((ViewGroup) findViewById(R.id.root));
        weeklyRate.setText("");
    }

    public void rightin (View view){
        rightDrawer.setVisibility(View.VISIBLE);
    }

    public void onFocusChange(View v, boolean hasFocus){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fields.add(logon1 = (EditText) findViewById(R.id.h1));
        fields.add(logon2 = (EditText) findViewById(R.id.h2));
        fields.add(logon3 = (EditText) findViewById(R.id.h3));
        fields.add(logon4 = (EditText) findViewById(R.id.h4));
        fields.add(logon5 = (EditText) findViewById(R.id.h5));
        fields.add(logon6 = (EditText) findViewById(R.id.h6));
        fields.add(pick1 = (EditText) findViewById(R.id.pick1));
        fields.add(pick2 = (EditText)findViewById(R.id.pick2));
        fields.add(pick3 = (EditText)findViewById(R.id.pick3));
        fields.add(pick4 = (EditText)findViewById(R.id.pick4));
        fields.add(pick5 = (EditText)findViewById(R.id.pick5));
        fields.add(pick6 = (EditText)findViewById(R.id.pick6));

        fields.add(mins1 = (EditText)findViewById(R.id.m1));
        fields.add(mins2 = (EditText)findViewById(R.id.m2));
        fields.add(mins3 = (EditText)findViewById(R.id.m3));
        fields.add(mins4 = (EditText)findViewById(R.id.m4));
        fields.add(mins5 = (EditText)findViewById(R.id.m5));
        fields.add(mins6 = (EditText)findViewById(R.id.m6));
        fields.add(s1 = (EditText)findViewById(R.id.s1));
        fields.add(s2 = (EditText)findViewById(R.id.s2));
        fields.add(s3 = (EditText)findViewById(R.id.s3));
        fields.add(s4 = (EditText)findViewById(R.id.s4));
        fields.add(s5 = (EditText)findViewById(R.id.s5));
        fields.add(s6 = (EditText)findViewById(R.id.s6));
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner3 = (Spinner)findViewById(R.id.spinner3);
        spinner4 = (Spinner)findViewById(R.id.spinner4);
        spinner5 = (Spinner)findViewById(R.id.spinner5);
        spinner6 = (Spinner)findViewById(R.id.spinner6);
        weeklyRate = (TextView)findViewById(R.id.weeklyRate);
        dropRate = (TextView)findViewById(R.id.dropRate);
        String[] areaList = new String[]{"North Front Lower","North Front Upper","North Rear Lower","North Rear Upper","South Front Lower","South Front Upper","South Rear Lower","South Rear Lower"};
        ArrayAdapter<String > aa=new ArrayAdapter<String> (this,android.R.layout.simple_spinner_dropdown_item,areaList);
        spinner1.setAdapter(aa);
        spinner2.setAdapter(aa);
        spinner3.setAdapter(aa);
        spinner4.setAdapter(aa);
        spinner5.setAdapter(aa);
        spinner6.setAdapter(aa);
        root = (RelativeLayout)findViewById(R.id.root);
        rightDrawer = (RelativeLayout) findViewById(R.id.rightdrawer);
        gL1 = (GridLayout)findViewById(R.id.gL1);
        gL2 = (GridLayout)findViewById(R.id.gL2);
        gL3 = (GridLayout)findViewById(R.id.gL3);
        gL4 = (GridLayout)findViewById(R.id.gL4);
        gL5 = (GridLayout)findViewById(R.id.gL5);
        gL6 = (GridLayout)findViewById(R.id.gL6);

        addWatcher((ViewGroup)gL1 );
        addWatcher((ViewGroup)gL2 );
        addWatcher((ViewGroup)gL3 );
        addWatcher((ViewGroup)gL4 );
        addWatcher((ViewGroup)gL5 );
        addWatcher((ViewGroup)gL6 );


    }





    public void loadInfo (View view){
        sharedPrefs = this.getSharedPreferences(
                "com.example.vax.pickingratecalculator", Context.MODE_PRIVATE);

        for (int i=0;i<fields.size(); i++ ){
            fields.get(i).setText(sharedPrefs.getString(keys.get(i), ""));
            }
        weeklyRate.setText(sharedPrefs.getString("wklRate", ""));
    }

    public void saveInfo (View view){
        sharedPrefs = this.getSharedPreferences(
                "com.example.vax.pickingratecalculator", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.clear();
        for (int i=0;i<fields.size(); i++ ){
                editor.remove(keys.get(i));
                editor.putString(keys.get(i), fields.get(i).getText().toString());
        }

        editor.putString("wklRate", weeklyRate.getText().toString());
        editor.apply();
        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
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
