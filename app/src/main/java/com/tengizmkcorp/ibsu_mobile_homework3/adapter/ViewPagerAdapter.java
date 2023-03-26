package com.tengizmkcorp.ibsu_mobile_homework3.adapter;

import android.content.res.Resources;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.tengizmkcorp.ibsu_mobile_homework3.FollowersFragment;
import com.tengizmkcorp.ibsu_mobile_homework3.FollowingFragment;
import com.tengizmkcorp.ibsu_mobile_homework3.PostsFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new PostsFragment();
            case 1:
                return new FollowersFragment();
            case 2:
                return new FollowingFragment();
            default:
                throw new Resources.NotFoundException("Position not found");
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
