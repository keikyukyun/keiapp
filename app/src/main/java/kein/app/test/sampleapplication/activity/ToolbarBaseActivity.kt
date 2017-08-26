package kein.app.test.sampleapplication.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.ActionBarActivity
import android.support.v7.widget.Toolbar

import kein.app.test.sampleapplication.IBaseListener
import kein.app.test.sampleapplication.R

/**
 * ツールバーを表示するアクティビティのベースクラス。
 *
 *
 * Created by murakamikei on 16/02/11.
 */
open class ToolbarBaseActivity : ActionBarActivity(), IBaseListener {
    /**
     * ツールバーを表示するかどうか。
     */
    private var mIsDisableToolbar: Boolean = false

    /**
     * ツールバーの実態。
     */
    private var mToolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        /*
         * 再起動等の処理時はここで対応するようにする。
         */
    }

    override fun onDestroy() {
        super.onDestroy()

        // ベースのアクティビティとなるので、不要なメモリをここで削除する
    }

    /**
     * メインとなるViewを設定する。<br>
     * 引数のリソースIDはメインとなるアクティビティのレイアウトとする。<br>
     * このメソッドは継承したアクティビティで常に呼ぶようにする。

     * @param resourceId リソースID
     * @param disable    Toolbarを表示するかどうか
     */
    @JvmOverloads protected fun setToolbarView(resourceId: Int, disable: Boolean = false) {
        mIsDisableToolbar = disable
        setContentView(resourceId)

        if (!mIsDisableToolbar) {
            mToolbar = findViewById(R.id.tool_bar) as Toolbar
            setSupportActionBar(mToolbar)
        }
    }

    override fun onEnd() {
        // 実装する場合は継承先で実装する。
    }

    override fun onError(message: String) {
        // 実装する場合は継承先で実装する。
    }

    override fun onOffline() {
        // 実装する場合は継承先で実装する。
    }

    /**
     *
     */
    fun a(b: Int): Boolean {
        return b < 0
    }
}
/**
 * Toolbarを表示するViewを設定する。

 * @param resourceId リソースID
 */
