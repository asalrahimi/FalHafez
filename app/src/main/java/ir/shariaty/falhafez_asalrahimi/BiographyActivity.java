package ir.shariaty.falhafez_asalrahimi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import ir.shariaty.falhafez_asalrahimi.databinding.ActivityBiographyBinding;

public class BiographyActivity extends AppCompatActivity {

    ActivityBiographyBinding activityBiographyBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // bind UI to java codes
        activityBiographyBinding = ActivityBiographyBinding.inflate(getLayoutInflater());
        setContentView(activityBiographyBinding.getRoot());

        // function for intent to MainActivity by click on bioBackBtn
        activityBiographyBinding.bioBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent falIntent = new Intent(BiographyActivity.this, MainActivity.class);
                startActivity(falIntent);
            }
        });


    }
}