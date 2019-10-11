package org.amfoss.templeapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import org.amfoss.templeapp.R;

/** @author Chromicle. */
public class PoojaFragment extends Fragment {
    private FloatingActionButton fab;

    public PoojaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_pooja, container, false);

        fab = rootView.findViewById(R.id.fab_pooja);
        fab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), AddPooja.class);
                        startActivity(intent);
                    }
                });

        return rootView;
    }
}
