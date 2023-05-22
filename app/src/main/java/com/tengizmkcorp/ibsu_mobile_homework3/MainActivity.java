package com.tengizmkcorp.ibsu_mobile_homework3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.tengizmkcorp.ibsu_mobile_homework3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setup();
}

    private void setup() {

// Obtain NavController from FragmentContainerView
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        assert navHostFragment != null;
        navController = navHostFragment.getNavController();
// Set up BottomNavigationView
        BottomNavigationView bottomNavigation = binding.bottomNavigationView;
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mainFragment:
                        navController.navigate(R.id.mainFragment);
                        return true;
                    case R.id.discoverFragment:
                        navController.navigate(R.id.discoverFragment);
                        return true;
                    case R.id.reelsFragment:
                        navController.navigate(R.id.reelsFragment);
                        return true;
                    case R.id.addFragment:
                        navController.navigate(R.id.addFragment);
                        return true;
                    case R.id.sendFragment:
                        navController.navigate(R.id.sendFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
}
