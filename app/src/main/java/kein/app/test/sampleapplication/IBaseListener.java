package kein.app.test.sampleapplication;

/**
 * ベースとなるリスナーを管理するクラス。
 * <p>
 * Created by murakamikei on 2016/04/24.
 */
public interface IBaseListener {
    /**
     * 処理完了時のコールバックリスナー。
     */
    void onEnd();

    /**
     * 処理が失敗時の汎用的なコールバックリスナー。
     *
     * @param message エラーメッセージ
     */
    void onError(String message);

    /**
     * オフライン状態時の汎用的なコールバックリスナー。
     */
    void onOffline();
}
