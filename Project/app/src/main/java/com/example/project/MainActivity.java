package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Calendar date = Calendar.getInstance();
    WebView webView;
    Button buttonDate;
    Button buttonShow;
    TextView birthDate;
    public int day;
    public int month;
    public int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonDate = findViewById(R.id.dateButton);
        buttonShow = findViewById(R.id.showButton);
        birthDate = findViewById(R.id.birthDateText);
        webView = findViewById(R.id.web);
        birthDate.setText("Не задана");
    }

    public void loadAstro(View view) {
        if (!birthDate.getText().equals("Не задана")) {
            String link = "https://1001goroskop.ru/astroportret/?day=" + day + "&month=" +
                    month + "&year=" + year;
            webView.getSettings().setLoadsImagesAutomatically(true);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            webView.loadUrl(link);
        }
    }

    public void setDate(View view) {
        new DatePickerDialog(MainActivity.this, listener, date.get(Calendar.YEAR),
                date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH)).show();
    }

    DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int y, int m, int d) {
            year = y;
            month = m + 1;
            day = d;
            System.out.println(year);
            System.out.println(month);
            System.out.println(day);
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            birthDate.setText(df.format(new Date(year - 1900, month - 1, day)));
        }
    };
}
