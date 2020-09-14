package com.matthewcannefax.fragmentandapipractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.widget.Button;

import com.matthewcannefax.fragmentandapipractice.ui.main.FirstFragment;
import com.matthewcannefax.fragmentandapipractice.ui.main.MainFragment;
import com.matthewcannefax.fragmentandapipractice.ui.main.MainViewModel;
import com.matthewcannefax.fragmentandapipractice.ui.main.SecondFragment;
import com.matthewcannefax.fragmentandapipractice.ui.main.ThirdFragment;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        NavController navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_fragment)).getNavController();

        button1 = findViewById(R.id.button_one);
        button1.setOnClickListener(view -> {
            navController.popBackStack(R.id.mainFragment, false);
            navController.navigate(R.id.firstFragment);
        });

        button2 = findViewById(R.id.button_two);
        button2.setOnClickListener(view -> {
            navController.popBackStack(R.id.mainFragment, false);
            navController.navigate(R.id.secondFragment);
        });

        button3 = findViewById(R.id.button_three);
        button3.setOnClickListener(view -> {
            navController.popBackStack(R.id.mainFragment, false);
            navController.navigate(R.id.thirdFragment);
        });
    }
}