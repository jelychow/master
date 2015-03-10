package com.sec.hidinner;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;

import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

import com.litesuits.http.LiteHttpClient;
import com.litesuits.http.async.HttpAsyncExecutor;
import com.litesuits.http.exception.HttpException;
import com.litesuits.http.request.Request;
import com.litesuits.http.request.content.JsonBody;
import com.litesuits.http.request.content.MultipartBody;
import com.litesuits.http.request.content.multi.FilePart;
import com.litesuits.http.request.content.multi.StringPart;
import com.litesuits.http.request.param.HttpMethod;
import com.litesuits.http.response.Response;
import com.litesuits.http.response.handler.HttpModelHandler;
import com.sec.hidinner.util.BitmapScale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class RegisterActivity extends Activity implements OnClickListener {

	private Button mPickPic;
	private ImageView mPhoto;

	private static final int PHOTO_REQUEST_TAKEPHOTO = 1;// 拍照
	private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
	private static final int PHOTO_REQUEST_CUT = 3;// 结果
	// 创建一个以当前时间为名称的文件
	File tempFile = new File("/sdcard/tempphoto.jpg");
	private String name;
	private String pw;
	private String add;
	private String teleNum;
	private String nickname;

	private EditText email;
	private EditText mEtPw;
	private EditText mEtAdd;
	private EditText mEtTeleNum;
	private EditText mEtNickname;

	private Button mBtnRegister;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		mPickPic = (Button) findViewById(R.id.pick_pic);
		mPickPic.setOnClickListener(this);
		mPhoto = (ImageView) findViewById(R.id.img_photo);

		email = (EditText) findViewById(R.id.et_email);
		mEtPw = (EditText) findViewById(R.id.et_pw);
		mEtAdd = (EditText) findViewById(R.id.et_add);
		mEtTeleNum = (EditText) findViewById(R.id.et_telenum);
		mEtNickname = (EditText) findViewById(R.id.et_nickname);

		mBtnRegister = (Button) findViewById(R.id.register_normal_btn);
		mBtnRegister.setOnClickListener(this);
	}

	public void register() {
		String target = "http://112.124.113.88:8080/dinner/user/add";
		LiteHttpClient client = LiteHttpClient
				.newApacheHttpClient(RegisterActivity.this);
		Request req = new Request(target);
		LinkedHashMap<String, String> headers = new LinkedHashMap<String, String>();
		headers.put("api_version", "0.1");
		headers.put("device_type", "1");
		headers.put("Content-Type", "application/json");
		req.setHeaders(headers);
		req.setMethod(HttpMethod.Post);

		HttpAsyncExecutor asyncExcutor = HttpAsyncExecutor.newInstance(client);
		try {
			JSONObject params = new JSONObject();
			params.put("account", name);
			params.put("nick_name", name);

			params.put("portrait_file", url);
			params.put("password", pw);
			StringEntity se = new StringEntity(params.toString());
			System.out.println(params.toString());
			req.setHttpBody(new JsonBody(params.toString()));
		} catch (JSONException e1) {
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		asyncExcutor.execute(req, new HttpModelHandler<String>() {
			@Override
			protected void onSuccess(String data, Response res) {
				Toast.makeText(RegisterActivity.this, "註冊成功",
						Toast.LENGTH_SHORT).show();
				// sharedpreference save token
				System.out.println("success");
				System.out.println(data + "data");
				System.out.println(1 + res.toString() + "respone");
				// upload();
			}

			@Override
			protected void onFailure(HttpException e, Response res) {
			}

		});
	}

	String url;

	public String upload() {
		String target = "http://112.124.113.88:8080/dinner/file/upload";
		LiteHttpClient client = LiteHttpClient
				.newApacheHttpClient(RegisterActivity.this);
		Request req = new Request(target);
		LinkedHashMap<String, String> headers = new LinkedHashMap<String, String>();
		headers.put("api_version", "0.1");
		headers.put("device_type", "1");
		headers.put("token_id", "08edc9fc53e649d79238b00e7f274d8a");
		req.setHeaders(headers);
		MultipartBody body = new MultipartBody();
		body.addPart(new FilePart("file", cacheFile, "image/png"));
		req.setMethod(HttpMethod.Post).setHttpBody(body);

		HttpAsyncExecutor asyncExcutor = HttpAsyncExecutor.newInstance(client);

		asyncExcutor.execute(req, new HttpModelHandler<String>() {
			@Override
			protected void onSuccess(String data, Response res) {
				Toast.makeText(RegisterActivity.this, "上传成功",
						Toast.LENGTH_SHORT).show();
				System.out.println("success");
				System.out.println(data + "data");
				try {
					JSONObject result = new JSONObject(data);
					System.out.println(result);
					JSONObject bodyJson = result.optJSONObject("body");
					url = bodyJson.optString("url");
					String url2 = bodyJson.getString("url");
					System.out.println(url);
					System.out.println(url.toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				register();
			}

			@Override
			protected void onFailure(HttpException e, Response res) {
			}

		});
		return url;
	}

	// 提示对话框方法
	private void showDialog() {
		new AlertDialog.Builder(this)
				.setTitle("头像设置")
				.setMessage("请选择图片。。。")
				.setPositiveButton("拍照", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.dismiss();
						// 调用系统的拍照功能
						Intent intent = new Intent(
								MediaStore.ACTION_IMAGE_CAPTURE);
						// 指定调用相机拍照后照片的储存路径
						intent.putExtra(MediaStore.EXTRA_OUTPUT,
								Uri.fromFile(tempFile));
						startActivityForResult(intent, PHOTO_REQUEST_TAKEPHOTO);
					}
				})
				.setNegativeButton("相册", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.dismiss();
						Intent intent = new Intent(Intent.ACTION_PICK, null);
						intent.setDataAndType(
								MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
								"image/*");
						startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
					}
				}).show();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub

		switch (requestCode) {
		case PHOTO_REQUEST_TAKEPHOTO:
			startPhotoZoom(Uri.fromFile(tempFile), 350);
			break;

		case PHOTO_REQUEST_GALLERY:
			if (data != null)
				startPhotoZoom(data.getData(), 350);
			break;

		case PHOTO_REQUEST_CUT:
			if (data != null)
				setPicToView(data);
			break;
		}
		super.onActivityResult(requestCode, resultCode, data);

	}

	private void startPhotoZoom(Uri uri, int size) {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		// crop为true是设置在开启的intent中设置显示的view可以剪裁
		intent.putExtra("crop", "true");
		// aspectX aspectY 是宽高的比例
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		// outputX,outputY 是剪裁图片的宽高
		intent.putExtra("outputX", size);
		intent.putExtra("outputY", size);
		intent.putExtra("return-data", true);

		startActivityForResult(intent, PHOTO_REQUEST_CUT);
	}

	// 将进行剪裁后的图片显示到UI界面上
	private void setPicToView(Intent picdata) {
		Bundle bundle = picdata.getExtras();
		if (bundle != null) {
			Bitmap photo = bundle.getParcelable("data");
			//@SuppressWarnings("deprecation")
			//Drawable drawable = new BitmapDrawable(photo);
			//Bitmap temp= BitmapScale.compressImage(photo);
			mPhoto.setImageBitmap(photo);
			try {
				saveBitmap(photo);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// String path;
	public void saveBitmap(Bitmap bm) throws IOException {

		try {

			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			createBitmap(bm).compress(Bitmap.CompressFormat.PNG, 90, baos);
			Writetemp(baos.toByteArray());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// save this bitmap
	public void Write(byte[] b) throws IOException {
		File cacheFile = null;
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			File sdCardDir = Environment.getExternalStorageDirectory();

			long time = Calendar.getInstance().getTimeInMillis();
			String fileName = time + ".png";
			File dir = new File(sdCardDir.getCanonicalPath() + "/barcode/");
			if (!dir.exists()) {
				dir.mkdirs();
			}
			cacheFile = new File(dir, fileName);

		}
		Toast toast = Toast.makeText(getApplicationContext(),
				"temp pic save in sec/temp", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(getApplicationContext());
		imageCodeProject.setImageResource(android.R.drawable.sym_def_app_icon);
		toastView.addView(imageCodeProject, 0);
		toast.show();
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(cacheFile));

			bos.write(b, 0, b.length);
			bos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// save a temp pic
	File cacheFile = null;

	public void Writetemp(byte[] b) throws IOException {
		// File cacheFile = null;
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			File sdCardDir = Environment.getExternalStorageDirectory();
			Date curDate = new Date(System.currentTimeMillis());
			File dir = new File(sdCardDir.getCanonicalPath() + "/sec/temp");
			if (!dir.exists()) {
				dir.mkdirs();
			}
			cacheFile = new File(dir, "tempphoto.png");
		}
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(cacheFile));

			bos.write(b, 0, b.length);
			bos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Bitmap createBitmap(Bitmap src)

	{

		if (src == null) {
			return null;
		}
		Paint paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setAntiAlias(true);

		int w = 300;
		int h = 300;
		Bitmap newb = Bitmap.createBitmap(w, h, Config.ARGB_8888);
		Canvas cv = new Canvas(newb);

		cv.drawColor(Color.WHITE);

		cv.drawBitmap(src, 0, 0, null);
		cv.save(Canvas.ALL_SAVE_FLAG);
		cv.restore();// 瀛樺偍
		return newb;

	}

	// 使用系统当前日期加以调整作为照片的名称
	private String getPhotoFileName() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"'IMG'_yyyyMMdd_HHmmss");
		return dateFormat.format(date) + ".jpg";
	}

	public void initString() {
		name = email.getText().toString();
		pw = mEtPw.getText().toString();
		add = mEtAdd.getText().toString();
		teleNum = mEtTeleNum.getText().toString();
		nickname = mEtNickname.getText().toString();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.pick_pic:
			showDialog();
			break;
		case R.id.register_normal_btn:
			initString();
			// register();
			upload();
		default:
			break;
		}
	}
}