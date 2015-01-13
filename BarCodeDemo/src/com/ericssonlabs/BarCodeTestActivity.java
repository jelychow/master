package com.ericssonlabs;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.zxing.activity.CaptureActivity;
import com.zxing.encoding.EncodingHandler;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * ********************************************************** 内容摘要 ：二维码生成及扫瞄
 * <p>
 * 
 * 作者 ：gy 创建时间 ：2013-6-5 上午10:56:36 当前版本号：v1.0 历史记录 : 日期 : 2013-6-5 上午10:56:36
 * 修改人： 描述 :
 *********************************************************** 
 */
public class BarCodeTestActivity extends Activity {
	private TextView resultTextView;
	private EditText qrStrEditText;
	private ImageView qrImgImageView;
	private static final int IMAGE_HALFWIDTH = 20;
	int[] pixels = new int[2 * IMAGE_HALFWIDTH * 2 * IMAGE_HALFWIDTH];
	private Bitmap mBitmap;
	private final String IMAGE_TYPE = "image/*";

	private final int IMAGE_CODE = 0; // �����IMAGE_CODE���Լ����ⶨ���
	private final int SCANER_CODE = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		resultTextView = (TextView) this.findViewById(R.id.tv_scan_result);
		qrStrEditText = (EditText) this.findViewById(R.id.et_qr_string);
		qrImgImageView = (ImageView) this.findViewById(R.id.iv_qr_image);

		Button scanBarCodeButton = (Button) this
				.findViewById(R.id.btn_scan_barcode);
		scanBarCodeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 打开扫描界面扫描条形码或二维码
				Intent openCameraIntent = new Intent(BarCodeTestActivity.this,
						CaptureActivity.class);
				startActivityForResult(openCameraIntent, SCANER_CODE);
			}
		});

		Button generateQRCodeButton = (Button) this
				.findViewById(R.id.btn_add_qrcode);
		generateQRCodeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					String contentString = qrStrEditText.getText().toString();
					if (contentString != null
							&& contentString.trim().length() > 0) {
						// 根据字符串生成二维码图片并显示在界面上，第二个参数为图片的大小（350*350）
						Bitmap qrCodeBitmap = EncodingHandler.createQRCode(
								contentString, 350);
						saveJpeg(qrCodeBitmap);
						qrImgImageView.setImageBitmap(qrCodeBitmap);
					} else {
						Toast.makeText(BarCodeTestActivity.this,
								"Text can not be empty", Toast.LENGTH_SHORT)
								.show();
					}

				} catch (WriterException e) {
					e.printStackTrace();
				}
			}
		});

		findViewById(R.id.btn_add_img).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						String contentString = qrStrEditText.getText()
								.toString();
						if (contentString != null && !contentString.equals("")) {
							Intent getAlbum = new Intent(
									Intent.ACTION_GET_CONTENT);
							getAlbum.setType(IMAGE_TYPE);
							startActivityForResult(getAlbum, IMAGE_CODE);
						} else {
							Toast.makeText(getApplication(), "未填写信息",
									Toast.LENGTH_LONG).show();
						}
					}
				});

	}

	public Bitmap cretaeBitmap(String str) throws WriterException {

		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.MARGIN, 1);

		BitMatrix matrix = new MultiFormatWriter().encode(str,
				BarcodeFormat.QR_CODE, 300, 300, hints);
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		int halfW = width / 2;
		int halfH = height / 2;
		int[] pixels = new int[width * height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (x > halfW - IMAGE_HALFWIDTH && x < halfW + IMAGE_HALFWIDTH
						&& y > halfH - IMAGE_HALFWIDTH
						&& y < halfH + IMAGE_HALFWIDTH) {
					pixels[y * width + x] = mBitmap.getPixel(x - halfW
							+ IMAGE_HALFWIDTH, y - halfH + IMAGE_HALFWIDTH);
				} else {
					if (matrix.get(x, y)) {
						pixels[y * width + x] = 0xff000000;
					} else {
						pixels[y * width + x] = 0xffffffff;
					}
				}
			}
		}
		Bitmap bitmap = Bitmap.createBitmap(width, height,
				Bitmap.Config.ARGB_8888);
		bitmap.setPixels(pixels, 0, width, 0, 0, width, height);

		return bitmap;
	}

	public String initSavePath() {
		File dateDir = Environment.getExternalStorageDirectory();
		String path = dateDir.getAbsolutePath() + "/RectPhoto/";
		File folder = new File(path);
		if (!folder.exists()) {
			folder.mkdir();
		}
		return path;
	}

	public void saveJpeg(Bitmap bm) {

		long dataTake = System.currentTimeMillis();
		String jpegName = initSavePath() + dataTake + ".jpg";

		// File jpegFile = new File(jpegName);
		try {
			FileOutputStream fout = new FileOutputStream(jpegName);
			BufferedOutputStream bos = new BufferedOutputStream(fout);

			// Bitmap newBM = bm.createScaledBitmap(bm, 600, 800, false);

			bm.compress(Bitmap.CompressFormat.JPEG, 100, bos);
			bos.flush();
			bos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		// 处理扫描结果（在界面上显示）
		if (resultCode == RESULT_OK) {
			if (requestCode == SCANER_CODE) {
				Bundle bundle = data.getExtras();
				String scanResult = bundle.getString("result");
				resultTextView.setText(scanResult);

			}

			if (requestCode == IMAGE_CODE) {
				try {
					ContentResolver resolver = getContentResolver();
					Uri originalUri = data.getData();

					mBitmap = MediaStore.Images.Media.getBitmap(resolver,
							originalUri);
					Matrix m = new Matrix();
					float sx = (float) 2 * IMAGE_HALFWIDTH / mBitmap.getWidth();
					float sy = (float) 2 * IMAGE_HALFWIDTH
							/ mBitmap.getHeight();
					m.setScale(sx, sy);
					mBitmap = Bitmap.createBitmap(mBitmap, 0, 0,
							mBitmap.getWidth(), mBitmap.getHeight(), m, false);
					String contentString = qrStrEditText.getText().toString();
					mBitmap = cretaeBitmap(new String(contentString.getBytes(),
							"utf-8"));
					qrImgImageView.setImageBitmap(mBitmap);
					saveJpeg(mBitmap);
				} catch (Exception e) {

					Log.e("TAG-->Error", e.toString());

				}
			}
		}
	}
}