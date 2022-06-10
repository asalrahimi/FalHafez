package ir.shariaty.falhafez_asalrahimi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.shariaty.falhafez_asalrahimi.R;
import ir.shariaty.falhafez_asalrahimi.model.Poet;

public class PoetAdapter extends RecyclerView.Adapter<PoetAdapter.MyViewHolder> {

    // ** properties
    private final Context context;
    private List<Poet> poetList;


    // ** constructor
    public PoetAdapter(Context context , List<Poet> poetList) {
        this.context=context;
        this.poetList=poetList;
    }

    // ** function for set data to poet list from api
    public void setPoetList(List<Poet> poetList){
        this.poetList=poetList;
        notifyDataSetChanged();
    }

    // ************* set received data to poet_card

    // ** define poet_card layout as view holder
    @NonNull
    @Override
    public PoetAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.poet_card , parent ,false);
       return new MyViewHolder(view);
    }

    // ** set received data to poet_card components
    @Override
    public void onBindViewHolder(@NonNull PoetAdapter.MyViewHolder holder, int position) {
        holder.nameTxt.setText(this.poetList.get(position).getName());
        holder.birthYearTxt.setText("تولد(هجری): " + this.poetList.get(position).getBirthYearInLHijri());
        holder.deathYearTxt.setText( "وفات(هجری): "+ this.poetList.get(position).getDeathYearInLHijri());
        holder.birthPlaceTxt.setText( "زادکاه: "+ this.poetList.get(position).getBirthPlace());

    }

    @Override
    public int getItemCount() {
        if(this.poetList != null) {
            return this.poetList.size();
        }
        return 0;
    }




    // ** MyViewHolder class
    public  class  MyViewHolder extends  RecyclerView.ViewHolder{
        // ** properties
        TextView nameTxt , birthYearTxt , deathYearTxt , birthPlaceTxt ;

        // ** constructor
        public  MyViewHolder(View itemView){
            super(itemView);
            nameTxt = itemView.findViewById(R.id.poetNameTxt);
            birthYearTxt = itemView.findViewById(R.id.poetBirthTxt);
            deathYearTxt = itemView.findViewById(R.id.poetDeathTxt);
            birthPlaceTxt = itemView.findViewById(R.id.poetCityTxt);
        }
    }
}
