package ipinfodb.android.cir3.isen.orp.mysuperipinfodb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TextLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_location);

        Intent thisIntent = getIntent();
        String data_lat = thisIntent.getExtras().getString("lat");
        String data_lon = thisIntent.getExtras().getString("lon");

        TextView latText = (TextView) findViewById(R.id.lat);
        latText.setText(data_lat);

        TextView lonText = (TextView) findViewById(R.id.lon);
        lonText.setText(data_lon);

    }
}
