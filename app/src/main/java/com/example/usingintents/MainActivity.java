package com.example.usingintents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.usingintents.fragments.ProfileFragment;
import com.example.usingintents.models.User;

public class MainActivity extends AppCompatActivity {
    private TextView txtWelcome;
    User user = null;
    //private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtWelcome = findViewById(R.id.txtWelcome);
        //fragmentContainer = findViewById(R.id.fragmentContainer)

        Bundle bundle = getIntent().getExtras();
        user = (User) bundle.getSerializable("user");
        txtWelcome.setText("Welcome " + user.getFirstName() + ", enjoy this app...");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.profile_item){
            loadFragment(ProfileFragment.newInstance(user));
        } else if(item.getItemId()==R.id.about_item){

        }else if(item.getItemId()==R.id.exit_item){

        }

        return super.onOptionsItemSelected(item);
    }

    private void loadFragment(Fragment new_fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        //transaction.replace(fragmentContainer.getId(), new_fragment);
        transaction.replace(R.id.fragmentContainer, new_fragment);
        transaction.commit();
    }
}