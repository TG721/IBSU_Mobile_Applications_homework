package com.tengizmkcorp.ibsu_mobile_homework3;

import static com.tengizmkcorp.ibsu_mobile_homework3.model.StoryItem.storyList;
import static com.tengizmkcorp.ibsu_mobile_homework3.model.TopUserButton.topUserButtonList;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.tengizmkcorp.ibsu_mobile_homework3.adapter.StoryItemAdapter;
import com.tengizmkcorp.ibsu_mobile_homework3.adapter.TopUserButtonAdapter;
import com.tengizmkcorp.ibsu_mobile_homework3.adapter.ViewPagerAdapter;
import com.tengizmkcorp.ibsu_mobile_homework3.databinding.FragmentMainBinding;
import com.tengizmkcorp.ibsu_mobile_homework3.model.StoryItem;
import com.tengizmkcorp.ibsu_mobile_homework3.model.TopUserButton;


public class MainFragment extends Fragment {
    private FragmentMainBinding binding;
    private TopUserButtonAdapter topUserButtonRVAdapter;
    private StoryItemAdapter storyAdapter;

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
        fillStoryList();
        setupTopUserButtonRecycler();
        setupStoryRecycler();
        setupTabLayout();
    }

    private void setupTabLayout() {
        TabLayout tabLayout = binding.tabLayout;
        ViewPager2 viewPager2 = binding.viewPager;
        ViewPagerAdapter mainViewPagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(mainViewPagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText(HtmlCompat.fromHtml("<font color='#000000' ><b>" + "2,557" + "</b></font>" + "<br> posts",
                                HtmlCompat.FROM_HTML_MODE_LEGACY));
                        break;
                    case 1:
                        tab.setText(HtmlCompat.fromHtml("<font color='#000000' ><b>" + "132K" + "</b></font>" + "<br> followers",
                                HtmlCompat.FROM_HTML_MODE_LEGACY));
                        break;
                    case 2:
                        tab.setText(HtmlCompat.fromHtml("<font color='#000000' ><b>" + "1,510" + "</b></font>" + "<br> following",
                                HtmlCompat.FROM_HTML_MODE_LEGACY));
                        break;
                    default:
                        throw new Resources.NotFoundException("Position not found");
                }
            }
        }).attach();
    }

    private void fillStoryList() {
        storyList.clear();
        storyList.add(new StoryItem(R.drawable.quartieri,true,"Quartieri"));
        storyList.add(new StoryItem(R.drawable.tiziano,true,"Tiziano"));
        storyList.add(new StoryItem(R.drawable.santa_out,true,"Santa Out"));
        storyList.add(new StoryItem(R.drawable.natale_2021,true,"Natale 2021"));
        storyList.add(new StoryItem(R.drawable.quiz,true,"Quiz Quartieri"));
    }

    private void setupStoryRecycler() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        storyAdapter = new StoryItemAdapter(storyList, requireContext());
        RecyclerView rv = binding.storyRV;
        rv.setAdapter(storyAdapter);
        rv.setLayoutManager(layoutManager);
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
        topUserButtonList.clear();
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
    }
}