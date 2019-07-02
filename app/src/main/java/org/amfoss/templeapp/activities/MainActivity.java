package org.amfoss.templeapp.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import org.amfoss.templeapp.R;
import org.amfoss.templeapp.databinding.ActivityMainBinding;
import org.amfoss.templeapp.json_api.InternetConnection;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;


    public class Presenter {
        public void onInsertClick(View view){
            if (InternetConnection.checkConnection(getApplicationContext())) {
                Intent intent = new Intent(getApplicationContext(), InsertData.class);
                startActivity(intent);
            } else {
                createNetErrorDialog();
            }
        }

        public void onReadAllClick(View view){
            if (InternetConnection.checkConnection(getApplicationContext())) {
                Intent intent = new Intent(getApplicationContext(), ReadAllData.class);
                startActivity(intent);
            } else {
                createNetErrorDialog();
            }
        }

        public void onUpdateClick(View view){
            if (InternetConnection.checkConnection(getApplicationContext())) {
                Intent intent = new Intent(getApplicationContext(), UpdateData.class);
                startActivity(intent);
            } else {
                createNetErrorDialog();
            }
        }

        public void onReadSingleData(View view){
            if (InternetConnection.checkConnection(getApplicationContext())) {
                Intent intent = new Intent(getApplicationContext(), ReadSingleData.class);
                startActivity(intent);
            } else {
                createNetErrorDialog();
            }
        }

        public void onDeleteClick(View view){
            if (InternetConnection.checkConnection(getApplicationContext())) {
                Intent intent = new Intent(getApplicationContext(), DeleteData.class);
                startActivity(intent);
            } else {
                createNetErrorDialog();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setPresenter(new Presenter());
    }

    protected void createNetErrorDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setMessage(getString(R.string.internet_warn))
                .setTitle(getString(R.string.unable_to_connect))
                .setCancelable(false)
                .setPositiveButton(
                        getString(R.string.settings),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent i = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                                startActivity(i);
                            }
                        })
                .setNegativeButton(
                        getString(R.string.Cancel),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
