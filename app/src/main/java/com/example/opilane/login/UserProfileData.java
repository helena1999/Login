package com.example.opilane.login;

/**
 * Created by opilane on 21.03.2018.
 */

public class UserProfileData {
    public String eesNimi;
    public  String pereNimi;
    public String epost;

    public UserProfileData(String eesNimi, String pereNimi, String epost) {
        this.eesNimi = eesNimi;
        this.pereNimi = pereNimi;
        this.epost = epost;
    }

    public UserProfileData (){

    }
    public String getEesNimi(){
        return eesNimi;
    }
    public String getEesNimi(String eesNimi){
        this.eesNimi = eesNimi;
    }
    public String getPereNimi(){
        return pereNimi;
    }
    public String getPereNimi(String pereNimi){
        this.pereNimi = pereNimi;
    }
    public String getEpost(){
        return epost;
    }
    public String getEpost(String epost){
        this.epost = epost;

    }


}
