package ir.shariaty.falhafez_asalrahimi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Fal {

    // ** constructor

    public Fal(String title, List<Verse> verse) {
        this.title = title;
        this.verse = verse;
    }


    // ** properties

    @SerializedName("title")
    private  String title;

    @SerializedName("verses")
    private  List<Verse> verse;


    // ** getters

    public String getTitle() {
        return title;
    }

    public List<Verse> getVerse() {
        return verse;
    }

}
