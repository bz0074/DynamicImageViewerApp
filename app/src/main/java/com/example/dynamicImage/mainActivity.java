import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.animation.AlphaAnimation;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private int currentImageIndex = 0; // Track the current image
    private int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3}; // Array of images

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference to the ImageView
        imageView = findViewById(R.id.imageView);

        // Button references
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        // Set click listeners for each button
        button1.setOnClickListener(v -> switchImage(0));
        button2.setOnClickListener(v -> switchImage(1));
        button3.setOnClickListener(v -> switchImage(2));
    }

    private void switchImage(int imageIndex) {
        if (imageIndex >= 0 && imageIndex < images.length) {
            int nextImageResId = images[imageIndex];
            crossFadeImage(nextImageResId);
            currentImageIndex = imageIndex; // Update current image index
        }
    }

    private void crossFadeImage(int nextImageResId) {
        // Animation for fading out the current image
        AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);
        fadeOut.setDuration(500); // Animation duration in milliseconds
        fadeOut.setFillAfter(true);

        // Animation for fading in the new image
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(500); // Animation duration in milliseconds
        fadeIn.setFillAfter(true);

        // Start fade-out animation on the current image
        imageView.startAnimation(fadeOut);

        // Update image resource after fade-out and start fade-in
        imageView.postDelayed(() -> {
            imageView.setImageResource(nextImageResId);
            imageView.startAnimation(fadeIn);
        }, 500); // Delay to match the fade-out duration
    }
}
