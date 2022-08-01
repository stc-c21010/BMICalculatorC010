package jp.suntech.c21010bmicalculatorc010;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mathBmi;
    private Button clear;
    private EditText iT;
    private EditText iH;
    private EditText iA;
    private TextView category1;
    private TextView result;
    private TextView weighti;
    private TextView weightr1;
    private TextView kg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iT=findViewById(R.id.ettall);
        iH=findViewById(R.id.etheavy);
        mathBmi=findViewById(R.id.mathb);
        iA=findViewById(R.id.etage);
        clear=findViewById(R.id.clearb);
        category1=findViewById(R.id.category);
        result=findViewById(R.id.resultt);
        weighti=findViewById(R.id.weight);
        weightr1=findViewById(R.id.weightr);
        kg=findViewById(R.id.kg);
        mathBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double itd=Double.valueOf(iT.getText().toString());
                double ihd=Double.valueOf(iH.getText().toString());
                double bmi=calcBMI(itd,ihd);
                double aged=Double.valueOf(iA.getText().toString());
                category1.setText("あなたの肥満度は");
                weighti.setText("あなたの適正体重は");
                double result2=Double.valueOf(22*(itd*itd)/10000);
                String result3=String.format("%.1f",result2);
                weightr1.setText(result3);
                kg.setText("kg");
                if (aged<16){
                    BMIDialogFragment bmid=new BMIDialogFragment();
                    bmid.show(getSupportFragmentManager(),"BMIDialogFragment");
                }
                if (bmi<18.5){
                    result.setText("低体重です");
                }
                else if (18.5<=bmi&&bmi<25){
                    result.setText("普通体重");
                }
                else if(25<=bmi&&bmi<30){
                    result.setText("肥満(1度)");
                }
                else if(30<=bmi&&bmi<35){

                    result.setText("肥満(2度)");
                }
                else if(35<=bmi&&bmi<40){
                    result.setText("肥満(3度)");
                }
                else{
                    result.setText("肥満(4度)");
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
               EditText itd=findViewById(R.id.ettall);
               EditText ihd=findViewById(R.id.etheavy);
               EditText iad=findViewById(R.id.etage);

               itd.setText("");
               ihd.setText("");
               iad.setText("");
               category1.setText("");
               weighti.setText("");
               weightr1.setText("");
               kg.setText("");
               result.setText("");
           }
        });

    }
    private double calcBMI(double h,double w){
        double bmi1=0;
        if(w>0&&h>0){
            bmi1=w/(h*h)*10000;
        }
        return bmi1;
    }
}