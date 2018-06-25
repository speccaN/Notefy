package com.speccan.notefy.Activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.speccan.notefy.Activities.Fragments.AllNotesFragment;
import com.speccan.notefy.Activities.Fragments.SettingsFragment;
import com.speccan.notefy.Activities.Fragments.WriteNoteFragment;
import com.speccan.notefy.R;

public class MainActivity extends FragmentActivity implements SettingsFragment.OnFragmentInteractionListener {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        FragmentManager mFragmentManager = getSupportFragmentManager();

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

            if(mFragmentManager.findFragmentById(R.id.framelayout_view) != null){
                mFragmentManager.beginTransaction().remove(mFragmentManager.findFragmentById(R.id.framelayout_view)).commit();
            }

            switch (item.getItemId()) {
                case R.id.navigation_write_note:
                    fragmentTransaction.add(R.id.framelayout_view, new WriteNoteFragment(), "WriteNote");
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_notes:
                    fragmentTransaction.add(R.id.framelayout_view, new AllNotesFragment(), "AllNotes");
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_settings:
                    fragmentTransaction.add(R.id.framelayout_view, new SettingsFragment(), "Settings");
                    fragmentTransaction.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        navigation.setSelectedItemId(R.id.navigation_notes);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
