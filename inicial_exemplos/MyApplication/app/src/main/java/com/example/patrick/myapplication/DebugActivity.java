package com.example.patrick.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by patrick on 24/02/18.
 */

public class DebugActivity extends AppCompatActivity {
    protected static final String TAG = "livro";

    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);
        Log.i(TAG, getClassName() + ".onCreate() chamado: " + icicle);
    }

    protected void onStart(){
        super.onStart();
        Log.i(TAG, getClassName() + ".onStart() chamado");
    }

    protected void onRestart(){
        super.onRestart();
        Log.i(TAG, getClassName() + ".onRestart chamado");
    }

    protected void onResume(){
        super.onResume();
        Log.i(TAG, getClassName() + ".onResume() chamado");
    }

    protected void onPause(){
        super.onPause();
        Log.i(TAG, getClassName() + ".onPause chamado");
    }

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        Log.i(TAG, getClassName() + ".onSaveInstanceState() chamado");
    }

    protected void onStop(){
        super.onStop();
        Log.i(TAG, getClassName() + ".onStop() chamado");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, getClassName() + ".onDestroy() chamado");
    }

    protected String getClassName(){
        String s = getClass().getName();

        return s.substring(s.lastIndexOf("."));
    }

}
