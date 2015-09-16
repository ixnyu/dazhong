package com.xnyu.mymaizi;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xnyu.mymaizi.fragment.GroupFragment;
import com.xnyu.mymaizi.fragment.HomeFragment;
import com.xnyu.mymaizi.fragment.MyFragment;
import com.xnyu.mymaizi.fragment.SearchFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.main_home_rb)
    RadioButton mMainHomeRb;
    @Bind(R.id.main_Group_rb)
    RadioButton mMainGroupRb;
    @Bind(R.id.main_search_rb)
    RadioButton mMainSearchRb;
    @Bind(R.id.main_my_rb)
    RadioButton mMainMyRb;
    @Bind(R.id.main_tabs_rg)
    RadioGroup mMainTabsRg;

    public static final String TAG = "main";
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFragmentManager = getFragmentManager();
        mMainHomeRb.setChecked(true);
        mMainTabsRg.setOnCheckedChangeListener(this);
        ChangedFragment(new HomeFragment(), true);


    }


    private void ChangedFragment(Fragment fragment, boolean isInit) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.main_tabs_fl, fragment).commit();

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Log.i(TAG, "onCheckedChanged zhu");
        switch (checkedId) {
            case R.id.main_home_rb:
                ChangedFragment(new HomeFragment(), true);
                Log.i(TAG, "onCheckedChanged home");
                break;
            case R.id.main_Group_rb:
                ChangedFragment(new GroupFragment(), true);
                Log.i(TAG, "onCheckedChanged tuan");
                break;
            case R.id.main_search_rb:
                ChangedFragment(new SearchFragment(), true);
                Log.i(TAG, "onCheckedChanged faxian");
                break;
            case R.id.main_my_rb:
                ChangedFragment(new MyFragment(), true);
                Log.i(TAG, "onCheckedChanged wode");
                break;
        }

    }
}
