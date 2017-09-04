package kein.app.test.sampleapplication.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import kein.app.test.sampleapplication.R;
import kein.app.test.sampleapplication.adapter.SelectListAdapter;

/**
 * 次のアクションを選択させるリスト画面。
 * <p>
 * Created by murakamikei on 2017/09/03.
 */
public class SelectListActivity extends ToolbarBaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setToolbarView(R.layout.select_list_activity);

        // とりあえず形式だけ。あとで実態を入れるように
        final ExpandableListAdapter adapter = new SelectListAdapter();

        final ExpandableListView listView = (ExpandableListView) findViewById(R.id.select_list);
        listView.setAdapter(adapter);
    }
}
