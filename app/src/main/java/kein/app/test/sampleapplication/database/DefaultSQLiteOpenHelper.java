package kein.app.test.sampleapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by murakamikei on 2017/09/01.
 */
public class DefaultSQLiteOpenHelper extends SQLiteOpenHelper {
    /**
     * データベース名。
     */
    private static final String DATABASE_NAME = "sample.db";

    /**
     * コンテキスト。
     *
     * @param context コンテキスト
     * @param name    名前
     * @param factory カーソルファクトリー
     * @param version DBバージョン
     */
    public DefaultSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
