package com.tengizmkcorp.ibsu_mobile_homework3;

import static com.tengizmkcorp.ibsu_mobile_homework3.model.TopUserButton.topUserButtonList;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.tengizmkcorp.ibsu_mobile_homework3.adapter.TopUserButtonAdapter;
import com.tengizmkcorp.ibsu_mobile_homework3.databinding.ActivityMainBinding;
import com.tengizmkcorp.ibsu_mobile_homework3.model.TopUserButton;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private TopUserButtonAdapter topUserButtonRVAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupActionBar();
        fillTopUserButtonList();
        setupTopUserButtonRecycler();

    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.custom_action_bar);
        }
    }

    private void fillTopUserButtonList() {
        topUserButtonList.add(new TopUserButton("Follow",true,true,false,null));
        topUserButtonList.add(new TopUserButton("Message",false,true,false,null));
        topUserButtonList.add(new TopUserButton("Add User",false,false,true,R.drawable.user_add));
    }

    private void setupTopUserButtonRecycler() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        topUserButtonRVAdapter = new TopUserButtonAdapter(topUserButtonList,this);
        RecyclerView rv = binding.topUserRV;
        rv.setAdapter(topUserButtonRVAdapter);
        rv.setLayoutManager(layoutManager);
        rv.invalidate();
    }
}