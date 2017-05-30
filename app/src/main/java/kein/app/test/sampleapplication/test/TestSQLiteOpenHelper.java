package kein.app.test.sampleapplication.test;

import android.content.Context;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

/**
 * SQLiteOpenHelper継承クラス
 * <p>
 * Created by murakamikei on 2016/10/25.
 */

public class TestSQLiteOpenHelper extends SQLiteOpenHelper {
    /**
     * SQLiteOpenHelperのシングルトンインスタンス。
     */
    private static TestSQLiteOpenHelper sOpenHelper;

    /**
     * コンストラクタ。
     */
    public TestSQLiteOpenHelper(final Context context, final String name) {
        super(context, name, null, 0);
    }

    /**
     * インスタンスを取得する。
     *
     * @param context アプリケーションコンテキスト
     * @return シングルトンインスタンス。
     */
    public static TestSQLiteOpenHelper getInstance(final Context context) {
        if (sOpenHelper == null) {
            sOpenHelper = new TestSQLiteOpenHelper(context, "");
        }

        return sOpenHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
