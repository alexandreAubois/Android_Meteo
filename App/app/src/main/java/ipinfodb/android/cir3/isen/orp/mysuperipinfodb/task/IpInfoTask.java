package ipinfodb.android.cir3.isen.orp.mysuperipinfodb.task;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import ipinfodb.android.cir3.isen.orp.mysuperipinfodb.MainActivity;
import ipinfodb.android.cir3.isen.orp.mysuperipinfodb.TextLocationActivity;
import ipinfodb.android.cir3.isen.orp.mysuperipinfodb.task.parser.IpInfoData;
import ipinfodb.android.cir3.isen.orp.mysuperipinfodb.task.parser.IpInfoDbPullParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static ipinfodb.android.cir3.isen.orp.mysuperipinfodb.MainActivity.TAG;

/**
 * Created by auboi on 22/03/2018.
 */

public class IpInfoTask extends AsyncTask<String, String,IpInfoData> {

    private static final String key = "d57b1e68028f1e5629d553346e48f7f2457981a385726f9c6daf4ddff36f5eb6";
    private static final String url_prefixed = "http://api.ipinfodb.com/v3/ip-city";


    private OkHttpClient okHttpClient;
    private String url;
    private AppCompatActivity parentActivity;
    private ProgressDialog progressDialog;

    public IpInfoTask(AppCompatActivity parent, ProgressDialog progressDialog){
        this.okHttpClient = new OkHttpClient();
        this.parentActivity = parent;
        this.progressDialog = progressDialog;
    }

    @Override
    protected IpInfoData doInBackground(String... strings) {

        for(String ip : strings){
            url = url_prefixed + "/?key=" + key + "&ip=" + ip + "&format=xml";

            try {
                publishProgress("PHASE I");
                Request request = new Request.Builder().url(url).build();
                Response http_response = okHttpClient.newCall(request).execute();

                String xmlData = http_response.body().string();

                publishProgress("PHASE II");
                IpInfoDbPullParser parser = new IpInfoDbPullParser(xmlData);
                IpInfoData myData = parser.getData();
                Log.i(TAG, "Latitude:" +myData.getLatitude());
                Log.i(TAG, "Longitude:" +myData.getLongitude());
                return myData;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }


        }

        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        progressDialog.setMessage(values[0]);
    }

    @Override
    protected void onPostExecute(IpInfoData ipInfoData){
        progressDialog.dismiss();
        Intent intent = new Intent(
                parentActivity,
                TextLocationActivity.class);
        intent.putExtra("lat", ipInfoData.getLatitude());
        intent.putExtra("lon", ipInfoData.getLongitude());

        parentActivity.startActivity(intent);
    }


}
