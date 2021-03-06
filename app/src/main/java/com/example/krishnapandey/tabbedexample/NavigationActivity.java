package com.example.krishnapandey.tabbedexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.ShareActionProvider;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    private ShareActionProvider mShareActionProvider;

    public static SharedPreferences sharedpreferences;
    public static String TAG="Ankit";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);/// Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

//        private SharedPreferences sharedpreferences;
        sharedpreferences = getSharedPreferences("DATA", Context.MODE_PRIVATE);









    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.shareButton);
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "here goes your share content body";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Share Subject");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);

        //then set the sharingIntent
        mShareActionProvider.setShareIntent(sharingIntent);

        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_visitUs) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("http://www.banaao.co.in"));
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.gu_language) {
//            setLocale("gu");

            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);

            //replace following link with your Gujrati app link here
            intent.setData(Uri.parse("http://www.banaao.co.in"));
            startActivity(intent);

        }else if (id == R.id.hi_language) {
//            setLocale("en");
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);

            //replace following link with your Hindi app link here
            intent.setData(Uri.parse("http://www.banaao.co.in"));
            startActivity(intent);


        } else if (id == R.id.nav_send) {

            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"ankit.pandey14ap@gmail.com","prem.sagar@banaao.co.in","paritoshadvance@gmail.com"});
//        i.putExtra(Intent.EXTRA_EMAIL  , arrayList);
            i.putExtra(Intent.EXTRA_SUBJECT, "Banaao Electronics");
//            i.putExtra(Intent.EXTRA_TEXT   , feedbackEditText.getText().toString());
            try {
                startActivity(Intent.createChooser(i, "Send mail..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(NavigationActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //old code

    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        MyCustomAdapter myCustomAdapter;
        public PlaceholderFragment() {
            Log.i(TAG, "PlaceholderFragment: ");
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            Log.i(TAG, "newInstance: ");
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.i(TAG, "onCreateView: ");
            final ArrayList<String> list = new ArrayList<>();
            list.add("Power in AC Circuits");
            list.add("Passive Components");
            list.add("Harmonics");
            list.add("Reactive Power");
            list.add("Average Voltage");
            list.add("RMS Voltage Tutorial");
            list.add("Power Triangle and Power Factor");
            list.add("Binary");

            final ArrayList<String> iconList = new ArrayList<>();
            iconList.add(String.valueOf(R.drawable.icon2));
            iconList.add(String.valueOf(R.drawable.icon3));
            iconList.add(String.valueOf(R.drawable.icon4));
            iconList.add(String.valueOf(R.drawable.icon5_png_icon));
            iconList.add(String.valueOf(R.drawable.icon1));
            iconList.add(String.valueOf(R.drawable.icon2));
            iconList.add(String.valueOf(R.drawable.icon4));
            iconList.add(String.valueOf(R.drawable.electronics_48));


            //for Favourite List
            final ArrayList<String> list1 = new ArrayList<>();
            final ArrayList<String> iconList1 = new ArrayList<>();

            for (int i = 0; i <list.size() ; i++) {
                if(sharedpreferences .getBoolean(list.get(i), false)){
                    list1.add(list.get(i));
                    iconList1.add(iconList.get(i));
                }
            }

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            ListView listView = (ListView) rootView.findViewById(R.id.listView);


            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                myCustomAdapter = new MyCustomAdapter(this.getActivity(), list,iconList);
                listView.setAdapter(myCustomAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getActivity(),ReadActivity.class);
                        intent.putExtra("TITLE", list.get(position));
                        Log.i("Ankit","main "+list.get(position) );

                        startActivity(intent);
                        getActivity().finish();
                    }
                });

            }else if(getArguments().getInt(ARG_SECTION_NUMBER) == 2){
                MyCustomAdapter myCustomAdapter = new MyCustomAdapter(this.getActivity(), list1,iconList1);
                listView.setAdapter(myCustomAdapter);


                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getActivity(),ReadActivity.class);
                        intent.putExtra("TITLE", list1.get(position));
                        startActivity(intent);
                        getActivity().finish();
                    }
                });

            }


//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            Log.i("Ankit", String.valueOf(getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            Log.i(TAG, "onViewCreated: ");
            
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.theory);
                case 1:
                    return getString(R.string.favourite);
                /*case 2:
                    return "SECTION 3";*/
            }
            return null;
        }

    }


    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
//        Intent intent = new Intent(this, ReadActivity.class);
        Intent refresh = new Intent(this, NavigationActivity.class);
        refresh.putExtra("TITLE", "hello");
        finish();
        startActivity(refresh);
    }
}
