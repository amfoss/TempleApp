package org.amfoss.templeapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import org.amfoss.templeapp.R;
import org.amfoss.templeapp.activities.ConfirmDetails;

public class AddDonation extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_donation);
    }

    public void confirm(View view) {
        Intent intent = new Intent(this, ConfirmDetails.class);
        startActivity(intent);
    }
}
