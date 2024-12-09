package com.example.dynamicimageviewer;

import android.os.Bundle;
import android.transition.TransitionDrawable;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing views
        imageView = findViewById(R.id.imageView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        // Set up button click listeners
        button1.setOnClickListener(v -> changeImage(R.drawable.image1));
        button2.setOnClickListener(v -> changeImage(R.drawable.image2));
        button3.setOnClickListener(v -> changeImage(R.drawable.image3));
    }

    private void changeImage(int imageResId) {
        // Smooth image transition (cross-fade)
        TransitionDrawable crossFade = new TransitionDrawable(new Drawable[]{
                imageView.getDrawable(), getResources().getDrawable(imageResId)});
        imageView.setImageDrawable(crossFade);
        crossFade.startTransition(500); // 500ms for crossfade effect
    }
}
