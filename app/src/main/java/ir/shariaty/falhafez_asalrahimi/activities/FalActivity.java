package ir.shariaty.falhafez_asalrahimi.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ir.shariaty.falhafez_asalrahimi.adapter.VerseAdapter;
import ir.shariaty.falhafez_asalrahimi.databinding.ActivityFalBinding;
import ir.shariaty.falhafez_asalrahimi.model.Fal;
import ir.shariaty.falhafez_asalrahimi.model.Verse;
import ir.shariaty.falhafez_asalrahimi.network.Api;
import ir.shariaty.falhafez_asalrahimi.network.FalPlaceHolderApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FalActivity extends AppCompatActivity {

    // ** properties

    ActivityFalBinding activityFalBinding;
    private Fal fal;
    private VerseAdapter leftAdapter ,rightAdapter;
    private List<Verse> verse , leftVerse , rightVerse ;
    private int randomNumber;
    private RecyclerView leftRv ,rightRv;
    private final String[] descrip = {
            "مدتهاست با فکر انجام این نیت روزگار می گذرانی و برای رسیدن به هدف خود به هر دست آویزی چنگ می زنی، اما گاهی نیز دچار ناامیدی می شوی. بدان که عاقبت این قصه فرجامی بسیار خوش و دل انگیز برای تو خواهد بود، پس به تلاش خود ادامه بده.",
"هر کسی در زندگی خود مشکلات و گرفتاری هایی دارد و هیچ کس در زندگی آسوده مطلق نیست. مهم این است که با این مشکلات چگونه برخورد کنیم. برای حل مشکلات خود با بزرگان و عقلا مشورت کن چرا که همه چیز را همگان می دانند. به جای ستیز با تقدیر با زندگی سازش کن و در هیچ موردی از یاد خدا و کتاب آسمانیش و ائمه اطهار غافل مشو.",
            "مدتی است به درد هجران گرفتاری و به شدت نگران آن یار سفر کرده. نگرانی تو بی مورد است، او باز خواهد گشت. به پشتوانه های نامطمئن دنیا تکیه مکن و اگر زندگی فرصت دوباره ای در اختیارت گذاشت از آن استفاده مطلوب کن و از سوءاستفاده کردن از امکاناتی که در اختیارت قرار می گیرد، بپرهیز. حرفهایی از قول تو به کسی که دوستش داری گفته شده، هرچه زودتر حقیقت را برای او بیان کن قبل از آنکه اسباب دردسر شود.",
            "تلاش بسیار در راه عشق نموده ای و عمر خود را صرف آن کرده ای. هنوز هم به عهد خود پایبندی و طعنه ها و سرزنشهای دیگران در تو بی اثر است. با این حال فکر می کنی هنوز آنچه را که لیاقت اوست انجام نداده ای. نگران نباش تو تلاشت را کرده ای و حتما نتیجه مطلوب را خواهی گرفت."
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // bind UI to java codes
        activityFalBinding = ActivityFalBinding.inflate(getLayoutInflater());
        setContentView(activityFalBinding.getRoot());

        // cal get fal function
        getFal();



        // function for intent to MainActivity by click on falBackBtn
        activityFalBinding.falBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent falIntent = new Intent(FalActivity.this, MainActivity.class);
                startActivity(falIntent);
            }
        });

        // function for getFal again by click on again button
        activityFalBinding.againBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFal();

            }
        });


    }


    // ************* function for get new fal
    private void getFal() {


        // set random number
        Random random = new Random();
        randomNumber = random.nextInt(4);

        // set random description for poem
        activityFalBinding.descrpitBodyTxt.setText(descrip[randomNumber]);

        verse = new ArrayList<>();
        leftVerse = new ArrayList<>();
        rightVerse = new ArrayList<>();


        // set recycler views attributes and adapters

        leftRv = activityFalBinding.leftRv;
        rightRv = activityFalBinding.rightRv;

        LinearLayoutManager layoutManagerLeft = new GridLayoutManager(this , 1);
        LinearLayoutManager layoutManagerRight = new GridLayoutManager(this , 1);

        leftRv.setLayoutManager(layoutManagerLeft);
        rightRv.setLayoutManager(layoutManagerRight);

        leftAdapter=new VerseAdapter(this, leftVerse , 5);
        rightAdapter=new VerseAdapter(this, rightVerse , 6);



        // get data from Api and send to UI

        FalPlaceHolderApi falPlaceHolderApi = Api.getRetrofit().create(FalPlaceHolderApi.class);
        Call<Fal> call = falPlaceHolderApi.getFal();
        call.enqueue(new Callback<Fal>() {

            @Override
            public void onResponse(Call<Fal> call, Response<Fal> response) {
                fal = response.body();
                verse = fal.getVerse();
                activityFalBinding.poemNameTxt.setText(fal.getTitle());
                if (verse != null) {

                    // set first and second verses in separated Lists
                    for (int i = 0; i < verse.size(); i++) {
                        if (verse.get(i).getVersePosition() == 0) {
                            rightVerse.add(verse.get(i));
                        } else {
                            leftVerse.add(verse.get(i));
                        }
                    }

                    // pass right and left lists to adapter
                    leftAdapter.setVerse(leftVerse, 5);
                    leftRv.setAdapter(leftAdapter);

                    rightAdapter.setVerse(rightVerse, 6);
                    rightRv.setAdapter(rightAdapter);


                } else
                    Toast.makeText(FalActivity.this, "no verse !", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Fal> call, Throwable t) {
                Toast.makeText(FalActivity.this, "no data !", Toast.LENGTH_SHORT).show();
            }
        });
    }

}