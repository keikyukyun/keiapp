package kein.app.test.sampleapplication.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 非同期処理を行うWorkerクラス
 * Created by murakamikei on 2017/09/03.
 */
public final class Worker {
    /**
     * メインスレッド。
     */
    private static final Handler UI_HANDLER = new Handler(Looper.getMainLooper());

    /**
     * スレッドプール。
     */
    private static final ExecutorService THREAD_POOL =
            new ThreadPoolExecutor(0, 200, 30L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

    /**
     * 予備のバックグラウンド実行ハンドラー。
     */
    private static Handler sBackgroundHandler;

    /**
     * コンストラクタ。
     */
    public Worker() {
    }

    /**
     * 非同期処理の結果を正常に返却するの実行タスクを生成する。
     *
     * @param listener 実行結果を返却するリスナー
     * @return 実行するタスク
     */
    public static Runnable createExecuteTask(final ExecuteListener listener) {
        if (listener == null) {
            return null;
        }

        return new Runnable() {
            @Override
            public void run() {
                if (listener.onExecuteInBackground()) {
                    UI_HANDLER.post(new Runnable() {
                        @Override
                        public void run() {
                            listener.onExecute();
                        }
                    });

                }
            }
        };
    }

    /**
     * 非同期で処理を行う。
     *
     * @param task 実行するタスク
     */
    public static void post(final Runnable task) {
        try {
            THREAD_POOL.execute(task);
        } catch (final IllegalThreadStateException e) {
            postSerially(task);
        }
    }

    /**
     * 連続でバックグラウンドで実行する。
     *
     * @param task 実行するタスク
     */
    private static void postSerially(final Runnable task) {
        getBackgroundHandler().post(task);
    }

    /**
     * バックグラウンドで実行する予備のハンドラーを取得する。
     *
     * @return バックグラウンド実行ハンドラー
     */
    private static Handler getBackgroundHandler() {
        if (sBackgroundHandler == null) {
            final HandlerThread handlerThread = new HandlerThread(Worker.class.getName());
            handlerThread.start();
            sBackgroundHandler = new Handler(handlerThread.getLooper());
        }
        return sBackgroundHandler;
    }

    /**
     * 遅延をかけたあとに非同期処理を行う。
     *
     * @param task        実行するタスク
     * @param delayMillis 遅延時間
     */
    public static void postDelay(final Runnable task, final long delayMillis) {
        UI_HANDLER.postDelayed(task, delayMillis);
    }

    /**
     * UIスレッドで処理を実行する。
     *
     * @param task 実行するタスク
     * @return 実行結果を返却する。
     */
    public static boolean OnUiThread(final Runnable task) {
        if (task == null) {
            return false;
        }
        return UI_HANDLER.post(task);
    }

    /**
     * 実行結果を返却するリスナー。
     */
    public interface ExecuteListener {
        /**
         * バックグラウンドで実行する処理。
         *
         * @return 処理に成功したかどうか
         */
        boolean onExecuteInBackground();

        /**
         * UIスレッドで実行する処理。
         */
        void onExecute();
    }
}
