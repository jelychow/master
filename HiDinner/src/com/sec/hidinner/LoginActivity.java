package com.sec.hidinner;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.litesuits.http.LiteHttpClient;
import com.litesuits.http.async.HttpAsyncExecutor;
import com.litesuits.http.exception.HttpException;
import com.litesuits.http.request.Request;
import com.litesuits.http.request.content.JsonBody;
import com.litesuits.http.request.param.HttpMethod;
import com.litesuits.http.response.Response;
import com.litesuits.http.response.handler.HttpModelHandler;

public class LoginActivity extends Activity implements OnClickListener{

    private Button mButton;
    private EditText mLoginName;
    private EditText mLoginPassword;
    private TextView mSummit;
    private String loginName;
    private String loginPw;
    private TextView register;
    
    private ImageButton img_btn;
    private Button btn;
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        mLoginName = (EditText) findViewById(R.id.login_name);
        mLoginPassword = (EditText) findViewById(R.id.login_password);
        mSummit = (TextView) findViewById(R.id.login_submit);
        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(this);
        mSummit.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		switch (v.getId()){
		case R.id.login_submit:
			loginName = mLoginName.getText().toString();
			loginPw = mLoginPassword.getText().toString();
//			register(loginName,loginPw);
			login();
		//	getUserInfo();
			break;
		case R.id.register:
			Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
			startActivity(intent);
		}
		
	}
	
	
	public void login() {
		String target = "http://112.124.113.88:8080/dinner/user/login";
		LiteHttpClient client = LiteHttpClient.newApacheHttpClient(LoginActivity.this);
		Request req = new Request(target);
		LinkedHashMap<String, String> headers = new LinkedHashMap<String, String>();
		headers.put("api_version", "0.1");
		headers.put("device_type", "1");
		headers.put("Content-Type", "application/json");
		//headers.put("token_id", "63fb61b1a68844fabfe227922a48c4e8");
		req.setHeaders(headers);
		req.setMethod(HttpMethod.Post);
		
		HttpAsyncExecutor asyncExcutor= HttpAsyncExecutor.newInstance(client);
		try {
				JSONObject params = new JSONObject();  
				params.put("account", "111");
				//params.put("nick_name", name);
				params.put("password", "qq");
				//StringEntity se = new StringEntity(params.toString());
				System.out.println(params.toString());
				req.setHttpBody(new JsonBody(params.toString()));
			} catch (JSONException e1) {
				e1.printStackTrace();
			} 
		
			asyncExcutor.execute(req, new HttpModelHandler<String>() {
		            @Override
		            protected void onSuccess(String data, Response res) {
		            	Toast.makeText(LoginActivity.this, "登录成功+login", Toast.LENGTH_SHORT).show();
		            	//sharedpreference save token
		            	System.out.println("success");
		            	System.out.println(data+"data");
		            	System.out.println(1+res.toString()+"respone");
		            }

		            @Override
		            protected void onFailure(HttpException e, Response res) {
		            }

		        });
		    }

	  /*
	   * test success by zhou
	   * 转义符的反斜杠无需担心，此情况只会发生在外层嵌套json自动转义。
	  */  
	public void getUserInfo() {
		String target = "http://112.124.113.88:8080/dinner/user/get?user_id="+"d2f333421d4047699e9ad393ae914976";
		LiteHttpClient client = LiteHttpClient.newApacheHttpClient(LoginActivity.this);
		Request req = new Request(target);
		LinkedHashMap<String, String> headers = new LinkedHashMap<String, String>();
		headers.put("api_version", "0.1");
		headers.put("device_type", "1");
		headers.put("token_id", "7a686b6f05ed4c83a7f53396149feca8");
		//headers.put("Content-Type", "application/json");
		req.setHeaders(headers);
		req.setMethod(HttpMethod.Get);
		
		HttpAsyncExecutor asyncExcutor= HttpAsyncExecutor.newInstance(client);
		
			asyncExcutor.execute(req, new HttpModelHandler<String>() {
		            @Override
		            protected void onSuccess(String data, Response res) {
		            	Toast.makeText(LoginActivity.this, "登录成功+login", Toast.LENGTH_SHORT).show();
		            	//sharedpreference save token
		            	System.out.println("success");
		            	System.out.println(data+"data");
		            	try {
							JSONObject js = new JSONObject(data);
							JSONObject body = js.optJSONObject("body");
							String url = body.optString("portrait_file");
							System.out.println(url);
							System.out.println(url.toString());
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }

		            @Override
		            protected void onFailure(HttpException e, Response res) {
		            }

		        });
		    }


    
  
}


