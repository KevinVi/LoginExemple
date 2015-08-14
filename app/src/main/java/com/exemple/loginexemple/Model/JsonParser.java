package com.exemple.loginexemple.Model;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by leolebogoss on 14/08/2015.
 */
public class JsonParser {
    private static ArrayList<Data> mListPesonne;
    public static String CONTENT_ALL= "contents";
    public static String CONTENT_ID = "id";
    public static String CONTENT_NOM = "nom";
    public static String CONTENT_PRENOM = "prenom";
    public static String CONTENT_AGE = "age";
    public static String CONTENT_INFO = "info";

    public static ArrayList<Data> listFromJson(String jsonStr,Context context)
    {
        Data contentin = null;
        Data content = null;
        ArrayList<Data> contents = new ArrayList<>();
        try {

            JSONObject json = new JSONObject(jsonStr);
            JSONArray contentsJSON = json.getJSONArray(CONTENT_ALL);

            for (int i = 0; i < contentsJSON.length(); i++) {

                JSONObject contentObject = contentsJSON.getJSONObject(i);

                Integer id = contentObject.getInt(CONTENT_ID);
                String nom = contentObject.getString(CONTENT_NOM);
                String prenom = contentObject.getString(CONTENT_PRENOM);
                String age = contentObject.getString(CONTENT_AGE);
                String info = contentObject.getString(CONTENT_INFO);

                content = new Data(id,
                        nom,
                        prenom,
                        age,
                        info);

                contentin=content;
                contents.add(contentin);

            }
            mListPesonne = contents;
            return contents;

        } catch (Exception e) {
            Log.i("Content", e.getMessage());
        }
        mListPesonne = contents;
        return contents;
    }
    public static ArrayList<Data> videosList(Context ctx) {
        if(mListPesonne==null){
           /* Intent it = new Intent(ctx,SplashActivity.class);
            ctx.startActivity(it);*/
            Intent i = ctx.getPackageManager()
                    .getLaunchIntentForPackage( ctx.getPackageName() );
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            ctx.startActivity(i);
        }
        return mListPesonne;
    }

    public static ArrayList<String> ListNom(Context ctx){

        ArrayList<String> mListNom=new ArrayList<>();
        if(mListPesonne==null){
           /* Intent it = new Intent(ctx,SplashActivity.class);
            ctx.startActivity(it);*/
            Intent i = ctx.getPackageManager()
                    .getLaunchIntentForPackage( ctx.getPackageName() );
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            ctx.startActivity(i);
        }else{
            Log.i("dataeee", "" +mListPesonne);
            for(Data data : mListPesonne){
                Log.i("dataeee", "" + data.getNom());
                if (data.getNom()!=null){
                    mListNom.add(data.getNom());
                }

            }
        }

        return mListNom;
    }
    public static ArrayList<String> ListPrenom(Context ctx){

        ArrayList<String> mListPrenom=new ArrayList<>();
        if(mListPesonne==null){
           /* Intent it = new Intent(ctx,SplashActivity.class);
            ctx.startActivity(it);*/
            Intent i = ctx.getPackageManager()
                    .getLaunchIntentForPackage( ctx.getPackageName() );
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            ctx.startActivity(i);
        }
        for(Data data : mListPesonne){
            if(data.getPrenom()!=null){
                mListPrenom.add(data.getPrenom());
            }

        }
        return mListPrenom;
    }
}
