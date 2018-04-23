package volleyimage.androidacademia.com.volleyimagedownload;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener<Bitmap> {
    ImageView imageView;
    RequestQueue requestQueue;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        requestQueue = Volley.newRequestQueue(this);
        progressBar = findViewById(R.id.progressBar);
    }

    public void download(View view) {
        if (NetworkConnection.getConnection(this)) {
            progressBar.setVisibility(View.VISIBLE);
            ImageRequest imageRequest = new ImageRequest(
                    "https://www.androidacademy.com/images/intro/news/platforms/android-p_300x300.jpg",
                    this,
                    600, 600,
                    ImageView.ScaleType.CENTER, null,
                    this);
            requestQueue.add(imageRequest);
        }else {
            Toast.makeText(this, "No internet connectivity...", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onResponse(Bitmap bitmap) {
        progressBar.setVisibility(View.GONE);
        imageView.setImageBitmap(bitmap);

    }
}
