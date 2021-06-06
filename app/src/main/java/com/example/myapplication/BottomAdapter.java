package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.myapplication.Fragment.Home;
import com.example.myapplication.Fragment.Infomation;
import com.example.myapplication.Fragment.Notification;

public class BottomAdapter extends FragmentStatePagerAdapter {

    public BottomAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Home();
            case 1:
                return new Notification();
            case 2:
                return new Infomation();

            default:
                return new Home();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
