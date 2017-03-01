package henry.neu.cn.game2048.bean;

import android.content.Context;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.widget.TextView;

import henry.neu.cn.game2048.utils.MyConfig;

/**
 * Created by henryneu on 2017/3/1.
 */

public class GameItem extends FrameLayout {

    private int mCardShowNum;

    private TextView mTextViewNum;

    public GameItem(Context context, int cardShowNum) {
        super(context);
        this.mCardShowNum = cardShowNum;
        initCardItem();
    }

    /**
     * 初始化 CardItem
     */

    private void initCardItem() {
        // 设置面板背景色，是由Frame拼起来的
        setBackgroundColor(Color.GRAY);
        mTextViewNum = new TextView(getContext());
        //setNum(mCardShowNum);
        // 修改5X5时字体大小
        int gameLines = MyConfig.mSharedPreferences.getInt(MyConfig.KEY_GAME_LINES, 4);
        if (gameLines == 4) {
            mTextViewNum.setTextSize(35);
        } else if (gameLines == 5) {
            mTextViewNum.setTextSize(25);
        } else {
            mTextViewNum.setTextSize(20);
        }
    }
}
