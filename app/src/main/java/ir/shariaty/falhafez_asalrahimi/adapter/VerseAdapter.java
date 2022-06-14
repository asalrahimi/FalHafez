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
import ir.shariaty.falhafez_asalrahimi.model.Verse;

public class VerseAdapter extends RecyclerView.Adapter<VerseAdapter.MyViewHolder>{

    // ** properties
    private final Context context;
    private List<Verse> verse;
    private int textAlign;

    // ** constructor
    public VerseAdapter(Context context, List<Verse> verse , int textAlign) {
        this.context = context;
        this.verse = verse;
        this.textAlign=textAlign;
    }

    // ** setter

    public void setVerse(List<Verse> verse , int textAlign) {
        this.verse = verse;
        this.textAlign=textAlign;
    }

    // ************* set received data to verse_holder Txt

    // ** define verse_holder layout as view holder
    @NonNull
    @Override
    public VerseAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.verse_holder , parent ,false);
        return new VerseAdapter.MyViewHolder(view);
    }

    // ** set received data to verse_holder
    @Override
    public void onBindViewHolder(@NonNull VerseAdapter.MyViewHolder holder, int position) {
        holder.verseTxt.setText(this.verse.get(position).getText());
    }

    @Override
    public int getItemCount() {
        if(this.verse != null) {
            return this.verse.size();
        }
        return 0;
    }


    // ** MyViewHolder class

    public  class  MyViewHolder extends  RecyclerView.ViewHolder{

        // ** properties
        TextView verseTxt ;

        // ** constructor

        public  MyViewHolder(View itemView){
            super(itemView);
            verseTxt = itemView.findViewById(R.id.verseTxt);
            verseTxt.setTextAlignment(textAlign);
        }
    }

}
