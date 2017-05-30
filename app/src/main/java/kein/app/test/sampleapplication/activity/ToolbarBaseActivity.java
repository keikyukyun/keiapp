package kein.app.test.sampleapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import kein.app.test.sampleapplication.IBaseListener;
import kein.app.test.sampleapplication.R;

/**
 * ツールバーを表示するアクティビティのベースクラス。
 * <p>
 * Created by murakamikei on 16/02/11.
 */
public class ToolbarBaseActivity extends ActionBarActivity implements IBaseListener {
    /**
     * ツールバーを表示するかどうか。
     */
    private boolean mIsDisableToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        /*
         * 再起動等の処理時はここで対応するようにする。
         */
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        /**
         * ベースのアクティビティとなるので、不要なメモリをここで削除する
         */
    }

    /**
     * Toolbarを表示するViewを設定する。
     *
     * @param resourceId リソースID
     */
    protected void setToolbarView(final int resourceId) {
        setToolbarView(resourceId, false);
    }

    /**
     * メインとなるViewを設定する。<br>
     * 引数のリソースIDはメインとなるアクティビティのレイアウトとする。<br>
     * このメソッドは継承したアクティビティで常に呼ぶようにする。
     *
     * @param resourceId リソースID
     * @param disable    Toolbarを表示するかどうか
     */
    protected void setToolbarView(final int resourceId, final boolean disable) {
        mIsDisableToolbar = disable;
        setContentView(resourceId);

        if (!mIsDisableToolbar) {
            final Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
            if (toolbar != null) {
                setSupportActionBar(toolbar);
            }
        }
    }

    @Override
    public void onEnd() {
        // 実装する場合は継承先で実装する。
    }

    @Override
    public void onError(final String message) {
        // 実装する場合は継承先で実装する。
    }

    @Override
    public void onOffline() {
        // 実装する場合は継承先で実装する。
    }
}
