package ipinfodb.android.cir3.isen.orp.mysuperipinfodb.task.parser;

/**
 * Created by auboi on 22/03/2018.
 */

public class IpInfoData {

    private String ipAdress;
    private String countryCode;
    private String  countryName;
    private String regionName;
    private String cityName;
    private String zipCode;
    private String latitude;
    private String longitude;
    private String timezone;

    public IpInfoData(){
        ipAdress = new String();
        countryCode = new String();
        countryName = new String();
        regionName = new String();
        cityName = new String();
        zipCode = new String();
        latitude = new String();
        longitude = new String();
        timezone = new String();
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
