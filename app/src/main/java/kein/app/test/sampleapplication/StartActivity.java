package kein.app.test.sampleapplication;

import android.os.Bundle;

import kein.app.test.sampleapplication.activity.ToolbarBaseActivity;

public class StartActivity extends ToolbarBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbarView(R.layout.activity_start);
    }
}
