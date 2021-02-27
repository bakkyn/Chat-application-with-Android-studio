package com.example.app;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

public class TabsAdapter extends FragmentPagerAdapter {

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch(position){



            case 0:
                ChatFragment chatFragment= new ChatFragment();
                return chatFragment;
            case 1:
                FriendsFragment friendsFragment= new FriendsFragment();
                return friendsFragment;
            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return 2;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch(position){


            case 0:
                return "MESAJLAR";
            case 1:
                return "ARKADAŞLAR";
            default:
                return  null;

        }

    }
}
