package ipinfodb.android.cir3.isen.orp.mysuperipinfodb.task.parser;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by auboi on 22/03/2018.
 */

public class IpInfoDbPullParser {

    public static final String TAG = IpInfoDbPullParser.class.getName();
    public enum Element{Null, Other, IpAddress, CountryCode, CountryName, RegionName, CityName, zipCode, latitude, longitude, timeZone};

    private IpInfoData data;
    private String xmldata;
    private XmlPullParserFactory factory;

    public IpInfoDbPullParser(String xmldata) throws XmlPullParserException{
        this.xmldata = xmldata;
        factory = XmlPullParserFactory.newInstance();
        this.data = null;
    }

    public IpInfoData getData(){
        if(data == null){
            data = parse();
        }
        return data;
    }

    private IpInfoData parse(){
        IpInfoData result = new IpInfoData();
        try{
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput( new StringReader(this.xmldata));
            int eventType = 0;

            eventType= xpp.getEventType();
            Element lastElement = Element.Null;
            while(eventType != XmlPullParser.END_DOCUMENT){
                if(eventType == XmlPullParser.START_TAG){
                    Log.d(TAG, "Start tag "+xpp.getName());
                    if(xpp.getName().equals("latitude")){
                        lastElement = Element.latitude;
                    }else if(xpp.getName().equals("longitude")){
                        lastElement = Element.longitude;
                    }
                }else if (eventType == XmlPullParser.END_TAG){
                    Log.d(TAG, "End tag "+xpp.getName());
                    lastElement = Element.Null;
                }else if (eventType == XmlPullParser.TEXT){
                    Log.d(TAG, "Text "+xpp.getText());
                    if(lastElement.equals(Element.latitude)){
                        result.setLatitude(xpp.getText());
                    } else if(lastElement.equals(Element.longitude)){
                        result.setLongitude(xpp.getText());
                    }
                }
                eventType = xpp.next();
            }
        } catch (XmlPullParserException e) {
            Log.e(TAG, "error while parsing", e);
            //e.printStackTrace();
        } catch (IOException e) {
            Log.e(TAG, "error while parsing", e);
            //e.printStackTrace();
        }
        return result;
    }




}
