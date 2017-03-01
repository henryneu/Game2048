package henry.neu.cn.game2048;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import henry.neu.cn.game2048.activity.ConfigActivity;

/**
 * 游戏主界面
 * <p>
 * Created by henryneu on 2017/2/28.
 */

public class MainActivity extends Activity implements View.OnClickListener {

    // 复位 Button
    private Button mRevertButton;
    // 重新开始 Button
    private Button mRestartButton;
    // 选项 Button
    private Button mOptionsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    /**
     * 初始化 View 相关
     */

    private void initViews() {
        // Button
        mRevertButton = (Button) findViewById(R.id.revert_button);
        mRestartButton = (Button) findViewById(R.id.restart_button);
        mOptionsButton = (Button) findViewById(R.id.options_button);
        // Button 添加点击事件监听
        mRevertButton.setOnClickListener(this);
        mRestartButton.setOnClickListener(this);
        mOptionsButton.setOnClickListener(this);
    }

    /**
     * Button 点击事件回调
     *
     * @param v
     */

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.revert_button:

                break;
            case R.id.restart_button:

                break;
            case R.id.options_button:
                Intent intent = new Intent(MainActivity.this, ConfigActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
