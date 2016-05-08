package dias.m.yuri.fivespace;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Acvitity to display the information and put a nice image on top of it.
 */
public class DisplaySpaceImageInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_space_image_info);

        Intent intent = getIntent();
        int photoID = Integer.parseInt(intent.getStringExtra(MainActivity
                        .IMAGE_ID));
        Log.d("displayImage", "Starting with photoID: " + photoID);
        int descriptionID = Integer.parseInt(intent.getStringExtra
                (MainActivity
                .TEXT_ID));
        Log.d("displayImage", "Starting with descriptionID: " + descriptionID);

        ImageView imageView = (ImageView) findViewById(R.id.space_image);
        imageView.setImageResource(photoID);

        TextView textView = (TextView) findViewById(R.id
                .space_image_description);
        textView.setText(descriptionID);

    }

}
