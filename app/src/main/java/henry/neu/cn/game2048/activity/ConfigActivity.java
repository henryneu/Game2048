package henry.neu.cn.game2048.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import henry.neu.cn.game2048.R;
import henry.neu.cn.game2048.utils.MyConfig;

/**
 * 用户设置游戏相关信息
 * <p>
 * Created by henryneu on 2017/3/1.
 */

public class ConfigActivity extends Activity implements View.OnClickListener {

    // 游戏行数列表
    private String[] mGameLinesList;
    // 游戏目标得分列表
    private String[] mGameGoalList;
    // 游戏 Lines 设定 Button
    private Button mGameLineButton;
    // 目标分数设定 Button
    private Button mTargetGoalButton;
    // 后退 Button
    private Button mBackButton;
    // 完成 Button
    private Button mDoneButton;
    // AlertDialog
    private AlertDialog.Builder mAlertBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_info);
        initViews();
    }

    /**
     * 初始化 View 相关
     */

    private void initViews() {
        // Button
        mGameLineButton = (Button) findViewById(R.id.game_lines_button);
        mTargetGoalButton = (Button) findViewById(R.id.target_goal_button);
        mBackButton = (Button) findViewById(R.id.back_button);
        mDoneButton = (Button) findViewById(R.id.done_button);
        mGameLineButton.setText("" + MyConfig.mSharedPreferences.getInt(MyConfig.KEY_GAME_LINES, 4));
        mTargetGoalButton.setText("" + MyConfig.mSharedPreferences.getInt(MyConfig.KEY_GAME_GOAL, 2048));
        // Button 添加点击事件监听
        mGameLineButton.setOnClickListener(this);
        mTargetGoalButton.setOnClickListener(this);
        mBackButton.setOnClickListener(this);
        mDoneButton.setOnClickListener(this);
        mGameLinesList = new String[]{"4", "5", "6"};
        mGameGoalList = new String[]{"1024", "2048", "4096"};
    }

    /**
     * Button 点击事件回调
     *
     * @param v
     */

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.game_lines_button:
                mAlertBuilder = new AlertDialog.Builder(this);
                mAlertBuilder.setTitle("choose the lines of the game");
                mAlertBuilder.setItems(mGameLinesList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mGameLineButton.setText(mGameLinesList[which]);
                    }
                });
                mAlertBuilder.create().show();
                break;
            case R.id.target_goal_button:
                mAlertBuilder = new AlertDialog.Builder(this);
                mAlertBuilder.setTitle("choose the goal of the game");
                mAlertBuilder.setItems(mGameGoalList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mTargetGoalButton.setText(mGameGoalList[which]);
                    }
                });
                mAlertBuilder.create().show();
                break;
            case R.id.back_button:
                this.finish();
                break;
            case R.id.done_button:
                saveConfig();
                setResult(RESULT_OK);
                this.finish();
                break;
            default:
                break;
        }
    }

    /**
     * 保存用户选择的数据信息
     */

    private void saveConfig() {
        SharedPreferences.Editor editor = MyConfig.mSharedPreferences.edit();
        editor.putInt(MyConfig.KEY_GAME_LINES, Integer.parseInt(mGameLineButton.getText().toString()));
        editor.putInt(MyConfig.KEY_GAME_GOAL, Integer.parseInt(mTargetGoalButton.getText().toString()));
        editor.commit();
    }
}
