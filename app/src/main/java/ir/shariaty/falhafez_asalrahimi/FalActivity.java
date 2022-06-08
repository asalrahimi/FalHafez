package ir.shariaty.falhafez_asalrahimi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ir.shariaty.falhafez_asalrahimi.databinding.ActivityFalBinding;

public class FalActivity extends AppCompatActivity {

    ActivityFalBinding activityFalBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // bind UI to java codes
        activityFalBinding = ActivityFalBinding.inflate(getLayoutInflater());
        setContentView(activityFalBinding.getRoot());

        // function for intent to MainActivity by click on falBackBtn
        activityFalBinding.falBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent falIntent = new Intent(FalActivity.this, MainActivity.class);
                startActivity(falIntent);
            }
        });

    }
}