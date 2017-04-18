package sdau.edu.code.Activtity;

import com.google.zxing.WriterException;

import sdau.edu.code.R;
import sdau.edu.code.Activtity.ActivityBase.ActivityBase;
import sdau.edu.code.util.EncodingHandler;

import android.graphics.Bitmap;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ActivityBarCode extends ActivityBase {

	private Button mButton;
	private ImageView mImageView;
	private EditText mEditText;

	/**
	 * 初始化控件
	 */

	protected void init() {
		mButton = (Button) findViewById(R.id.create_code);
		mImageView = (ImageView) findViewById(R.id.iv_qr_image);
		mEditText = (EditText) findViewById(R.id.editText1);
		mButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				String str = mEditText.getText().toString().trim();
				if (!TextUtils.isEmpty(str)) {
					Bitmap _Bitmap;
					try {
						_Bitmap = EncodingHandler.createQRCode(str, 350);

						mImageView.setImageBitmap(_Bitmap);
					} catch (WriterException e) {
						showToast("异常");
					}
				} else {
					showToast("不能为空");
				}

			}
		});
	}

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_main;
	}

}
