package edu.cs.birzeit.executertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_click(View view) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        final TextView txt = findViewById(R.id.txt);
        executor.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String str = "done";
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        txt.setText(str);
                    }
                });
            }
        });
    }

    public void btn_Toast(View view) {
        Toast.makeText(this, "this is a test message!", Toast.LENGTH_SHORT).show();
    }
}