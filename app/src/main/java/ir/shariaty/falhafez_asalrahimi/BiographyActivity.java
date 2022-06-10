package ir.shariaty.falhafez_asalrahimi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import ir.shariaty.falhafez_asalrahimi.adapter.PoetAdapter;
import ir.shariaty.falhafez_asalrahimi.databinding.ActivityBiographyBinding;
import ir.shariaty.falhafez_asalrahimi.model.Poet;
import ir.shariaty.falhafez_asalrahimi.viewmodel.PoetViewModel;

public class BiographyActivity extends AppCompatActivity {

    // ** properties
    ActivityBiographyBinding activityBiographyBinding;
    private List<Poet> poetList;
    private PoetAdapter poetAdapter;
    private PoetViewModel poetViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // bind UI to java codes
        activityBiographyBinding = ActivityBiographyBinding.inflate(getLayoutInflater());
        setContentView(activityBiographyBinding.getRoot());

        // define recycler view for showing response items
        RecyclerView recyclerView = activityBiographyBinding.poetRv;
        LinearLayoutManager layoutManager = new GridLayoutManager(this , 1);
        recyclerView.setLayoutManager(layoutManager);

        // bind recycler view and  poet adapter
        poetAdapter=new PoetAdapter(this , poetList);
        recyclerView.setAdapter(poetAdapter);

        // define view model object
        poetViewModel = ViewModelProviders.of(this).get(PoetViewModel.class);

        // get data from view model and set in poet list
        poetViewModel.getPoetList().observe(this, new Observer<List<Poet>>() {
            @Override
            public void onChanged(List<Poet> poets) {
                if (poets != null){
                    poetList = poets;
                    poetAdapter.setPoetList(poets);
                }
            }
        });

        poetViewModel.makeApiCall();

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