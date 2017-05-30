package kein.app.test.sampleapplication.test;

import android.os.Bundle;

import kein.app.test.sampleapplication.IBaseListener;
import kein.app.test.sampleapplication.activity.ToolbarBaseActivity;

/**
 * Created by murakamikei on 2016/10/25.
 */

public class TestActivity extends ToolbarBaseActivity implements IBaseListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
