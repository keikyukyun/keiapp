package kein.app.test.sampleapplication.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import kein.app.test.sampleapplication.R;
import kein.app.test.sampleapplication.fragment.StartFragment;

public class StartActivity extends ToolbarBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbarView(R.layout.activity_start);
        setToolbarTitleName("はじめに"); // strings.xmlに書く
        final Toolbar toolbar = getMToolbar();
        toolbar.setTitle("最初の画面");

        final StartFragment fragment = new StartFragment();
        final FragmentManager manager = getSupportFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(fragment, "Start");
        transaction.commit();
    }
}
