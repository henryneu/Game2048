package henry.neu.cn.game2048.utils;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by henryneu on 2017/3/1.
 */

public class MyConfig extends Application {

    // SharedPreferences 对象
    public static SharedPreferences mSharedPreferences;
    // Game Goal
    public static int mGameGoal;
    // GameView 行列数
    public static int mGameLines;
    // GameItem 宽高
    public static int mItemSize;
    // Score 记录分数
    public static int SCORE = 0;

    public static String SP_HIGH_SCORE = "SP_HIGHSCORE";

    public static String KEY_HIGH_SCORE = "KEY_HighScore";

    public static String KEY_GAME_LINES = "KEY_GameLines";

    public static String KEY_GAME_GOAL = "KEY_GameGoal";

    @Override
    public void onCreate() {
        super.onCreate();
        mSharedPreferences = getSharedPreferences(SP_HIGH_SCORE, 0);
        mGameLines = mSharedPreferences.getInt(KEY_GAME_LINES, 4);
        mGameGoal = mSharedPreferences.getInt(KEY_GAME_GOAL, 2048);
        mItemSize = 0;
    }
}
