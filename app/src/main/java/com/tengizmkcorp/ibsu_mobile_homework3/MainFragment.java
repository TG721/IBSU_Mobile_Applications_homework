package com.tengizmkcorp.ibsu_mobile_homework3;

import static com.tengizmkcorp.ibsu_mobile_homework3.model.TopUserButton.topUserButtonList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tengizmkcorp.ibsu_mobile_homework3.adapter.TopUserButtonAdapter;
import com.tengizmkcorp.ibsu_mobile_homework3.databinding.FragmentMainBinding;
import com.tengizmkcorp.ibsu_mobile_homework3.model.TopUserButton;


public class MainFragment extends Fragment {
    private FragmentMainBinding binding;
    private TopUserButtonAdapter topUserButtonRVAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupProfileImage();
        setupActionBar();
        fillTopUserButtonList();
        setupTopUserButtonRecycler();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setupProfileImage() {
        Glide.with(this)
                .load(R.drawable.profile)
                .circleCrop()
                .into(binding.profileIV);
    }

    private void setupActionBar() {
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.custom_action_bar);
        }
    }

    private void fillTopUserButtonList() {
        topUserButtonList.add(new TopUserButton("Follow", true, true, false, null));
        topUserButtonList.add(new TopUserButton("Message", false, true, false, null));
        topUserButtonList.add(new TopUserButton("Add User", false, false, true, R.drawable.user_add));
    }

    private void setupTopUserButtonRecycler() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        topUserButtonRVAdapter = new TopUserButtonAdapter(topUserButtonList, requireContext());
        RecyclerView rv = binding.topUserRV;
        rv.setAdapter(topUserButtonRVAdapter);
        rv.setLayoutManager(layoutManager);
        rv.invalidate();
    }
}