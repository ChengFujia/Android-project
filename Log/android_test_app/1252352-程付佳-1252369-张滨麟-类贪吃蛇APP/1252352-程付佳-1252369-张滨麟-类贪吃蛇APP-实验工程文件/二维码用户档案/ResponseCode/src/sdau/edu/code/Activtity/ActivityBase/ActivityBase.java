package sdau.edu.code.Activtity.ActivityBase;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public abstract class ActivityBase extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(getLayoutId());

		init();
	}

	protected abstract void init();

	/**
	 * 获取布局文件
	 * 
	 * @return
	 */
	protected abstract int getLayoutId();

	protected void showToast(String str) {
		Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	}
}
