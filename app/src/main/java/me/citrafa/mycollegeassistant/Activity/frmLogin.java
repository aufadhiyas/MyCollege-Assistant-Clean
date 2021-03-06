package me.citrafa.mycollegeassistant.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.citrafa.mycollegeassistant.AppController.AppController;
import me.citrafa.mycollegeassistant.AppController.SessionManager;
import me.citrafa.mycollegeassistant.CustomWidget.btnMuseo;
import me.citrafa.mycollegeassistant.CustomWidget.etMuseo;
import me.citrafa.mycollegeassistant.CustomWidget.jToast;
import me.citrafa.mycollegeassistant.CustomWidget.tvRoboto;
import me.citrafa.mycollegeassistant.R;
import me.citrafa.mycollegeassistant.WebService.WebUrl;

public class frmLogin extends AppCompatActivity{
    private static final String TAG = "LOG";
    private int counter = 0;
    @BindView(R.id.loginEmail) etMuseo txtEmail;
    @BindView(R.id.loginPass) etMuseo txtPass;
    @BindView(R.id.loginBtnLogin) btnMuseo btnLogin;
    @BindView(R.id.loginBtnDaftar) btnMuseo btnDaftar;
    @BindView(R.id.loginBtnHere) tvRoboto btnHere;
    ProgressDialog pDialog;
    SessionManager s;

    String Email,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_login);
        ButterKnife.bind(this);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        s = new SessionManager(getApplicationContext());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtEmail.getText().toString()!=null &&txtPass !=null){
                    checkLogin();
                }else {
                    jToast.makeText(frmLogin.this,"Isi data kamu dengan benar",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(frmLogin.this, frmDaftar.class));
            }
        });
        btnHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter ==0){
                    //Jalankan Program
                    counter++;
                }else {
                    jToast.makeText(frmLogin.this, "Kamu Sudah Klik Sekali !", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
    public void checkLogin(){
        Email = txtEmail.getText().toString();
        Password = txtPass.getText().toString();
        String tag_string_req = "req_login";

        pDialog.setMessage("Logging in ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                WebUrl.URL_LOGIN, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Login Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObjs = new JSONObject(response);
                    boolean error = jObjs.getBoolean("error");
                    String status_verifikasi = jObjs.getString("status_verifikasi");
                    String email = jObjs.getString("email");
                    String nama = jObjs.getString("nama");
                    // Check for error node in json
                    if (!error) {
                        // user successfully logged in
                        // Create login session
                        if (status_verifikasi.equals("0")){
                            s.setVerifyStat(false);
                            s.setEmailUser(email);
                            s.setNamaUser(nama);
                            Intent intent = new Intent(frmLogin.this, frmVerifikasi.class);
                            intent.putExtra("email",email);
                            startActivity(intent);

                        }else{
                            s.setLogin(true);
                            s.setEmailUser(email);
                            s.setNamaUser(nama);
                            Intent intent = new Intent(frmLogin.this,
                                    Dashboard.class);
                            startActivity(intent);
                            finish();
                        }

                    } else {
                        // Error in login. Get the error message
                        String errorMsg = jObjs.getString("message");
                        jToast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error, Cek Koneksi Kamu!");
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", Email);
                params.put("password", Password);

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }
    public void startDaftar(){
        Intent intent = new Intent(frmLogin.this, frmDaftar.class);
        startActivity(intent);
    }


    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
