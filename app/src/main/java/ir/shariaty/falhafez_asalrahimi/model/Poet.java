package ir.shariaty.falhafez_asalrahimi.model;

import com.google.gson.annotations.SerializedName;

public class Poet  {

    // ** constructor
    public Poet(int id, String name, int birthYearInLHijri, int deathYearInLHijri, String birthPlace) {
        this.id = id;
        this.name = name;
        this.birthYearInLHijri = birthYearInLHijri;
        this.deathYearInLHijri = deathYearInLHijri;
        this.birthPlace = birthPlace;
    }

    // ** properties
    @SerializedName("id")
    private final int id;

    @SerializedName("name")
    private final String name;

    @SerializedName("birthYearInLHijri")
    private final int birthYearInLHijri;

    @SerializedName("deathYearInLHijri")
    private final int deathYearInLHijri;

    @SerializedName("birthPlace")
    private final String birthPlace;

    // ** getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBirthYearInLHijri() {
        return birthYearInLHijri;
    }

    public int getDeathYearInLHijri() {
        return deathYearInLHijri;
    }

    public String getBirthPlace() {
        return birthPlace;
    }
}
