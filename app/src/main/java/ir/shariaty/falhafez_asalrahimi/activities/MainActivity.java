package ir.shariaty.falhafez_asalrahimi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ir.shariaty.falhafez_asalrahimi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // bind UI to java codes
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        // function for intent to FalActivity by click on falBtn
        activityMainBinding.falBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent falIntent = new Intent(MainActivity.this, FalActivity.class);
                startActivity(falIntent);
            }
        });

        // function for intent to BiographyActivity by click on biographyBtn
        activityMainBinding.biographyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bioIntent = new Intent(MainActivity.this, BiographyActivity.class);
                startActivity(bioIntent);
            }
        });
    }
}