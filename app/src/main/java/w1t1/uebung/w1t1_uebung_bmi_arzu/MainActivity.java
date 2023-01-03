package w1t1.uebung.w1t1_uebung_bmi_arzu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private EditText ed_Groesse, ed_Gewicht;
    private Button btn;
    private TextView tv_Ergebnis;

//==================================================================================================
    private class MyOCL implements View.OnClickListener
    {

        @Override
        public void onClick(View view)
        {
            double gewicht = toDouble(ed_Gewicht);
            double groesse = toDouble(ed_Groesse);

            if ((gewicht > 0 && groesse >0))
            {
                groesse /= 100.0;
                double bmi = gewicht / (groesse * groesse);
                String kategorie = "";

                if (bmi < 18.5)
                    kategorie = "Untergewicht";
                else if (bmi < 25)
                kategorie = "Normalgewicht";
                else if (bmi < 30.0)
                    kategorie = "Übergewicht";
                else
                    kategorie = "Adipositas";

                tv_Ergebnis.setText(String.format("Dein BMI: %1.2f (%s)", bmi, kategorie));
            }
        }
    }

//==================================================================================================
    private double toDouble(EditText ed)
    {
        String text = ed.getText().toString();
        double back = -1;
        try
        {
            back = Double.parseDouble(text);
        }
        catch (RuntimeException ex)
        {
            tv_Ergebnis.setText("Falsche Eingabe");
        }
        return back;
    }
//--------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_Groesse = (EditText) findViewById(R.id.ed_groese);
        ed_Gewicht = (EditText) findViewById(R.id.ed_gewicht);
        tv_Ergebnis = (TextView) findViewById(R.id.tv_Ergebnis);

        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new MyOCL());
    }
}