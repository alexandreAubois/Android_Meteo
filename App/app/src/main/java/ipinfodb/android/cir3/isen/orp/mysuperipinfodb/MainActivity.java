package ipinfodb.android.cir3.isen.orp.mysuperipinfodb;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import ipinfodb.android.cir3.isen.orp.mysuperipinfodb.task.IpInfoTask;
import ipinfodb.android.cir3.isen.orp.mysuperipinfodb.task.parser.IpInfoData;
import ipinfodb.android.cir3.isen.orp.mysuperipinfodb.task.parser.IpInfoDbPullParser;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static String TAG = MainActivity.class.getName();
    protected ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void connect(View view){
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Please Wait ...");
        progressDialog.setMessage("Preparing");
        progressDialog.show();

        EditText et_ip = findViewById(R.id.ip);
        String adrip = et_ip.getText().toString();
        Log.i("ip : ", adrip);

        IpInfoTask ipInfoTask = new IpInfoTask(this, progressDialog);
        ipInfoTask.execute(adrip);
    }
}
