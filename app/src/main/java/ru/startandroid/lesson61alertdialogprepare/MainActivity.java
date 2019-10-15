package ru.startandroid.lesson61alertdialogprepare;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    final static String LOG_TAG = "myLogs";
    final int DIALOG = 1;
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //вызываем showDialog
    public void onclick(View v) {
        showDialog(DIALOG);
    }

    protected Dialog onCreateDialog(int id) {
        //добавили лог
        Log.d(LOG_TAG, "onCreateDialog");
        if (id == DIALOG) {
            //указываем в каком формате и виде будет отображаться время
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle("Текущее время");
            adb.setMessage(sdf.format(new Date(System.currentTimeMillis())));
            return adb.create();
        }
        return super.onCreateDialog(id);
    }

    protected void onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
        Log.d(LOG_TAG, "onPrepareDialog");
        if (id == DIALOG) {
            ((AlertDialog)dialog).setMessage(sdf.format(new Date(System.currentTimeMillis())));
        }
    }
}