package net.nimazare.loadimagepicasso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView myImg = findViewById(R.id.bg_image);
        Picasso.get().load("https://i.imgur.com/DvpvklR.png").placeholder(R.drawable.my_bkg)
                .into(myImg);
    }
}