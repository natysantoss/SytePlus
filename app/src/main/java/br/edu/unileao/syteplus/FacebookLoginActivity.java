package br.edu.unileao.syteplus;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.provider.Settings.Global.getString;

public class FacebookLoginActivity extends BaseActivity implements
        View.OnClickListener {

    private static final String TAG = "FacebookLogin";

    private TextView mStatusTextView;
    private TextView mDetailTextView;
    private FirebaseAuth mAuth;

    private MainActivity mCallbackManager;
    private int contentView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_facebook);

        mStatusTextView = (TextView) findViewById(R.id.status);
        mDetailTextView = (TextView) findViewById(R.id.detail);
        findViewById(R.id.button_facebook_signout).setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        mCallbackManager = MainActivity.Factory.create();
        Login77896iButton loginButton = (LoginButton) findViewById(R.id.button_facebook_login);
        loginButton.setReadPermissions("email", "public_profile");
        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            public Object data;

            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "facebook:onSuccess:" + loginResult);
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");
            }


            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "facebook:onError", error);
                updateUI(null);
                @Override
                public void onStart(){
                    super.onStart();
                    FirebaseUser currentUser = mAuth.getCurrentUser();
                    updateUI(currentUser);
                }
                @Override
                protected void onActivityResult(int requestCode,int resultCode, Intent data){
                    super.onActivityResult(requestCode, resultCode, data);
                    mCallbackManager.onActivityResult(requestCode, resultCode, data);
                }

            private void handleFacebookAccessToken(AccessToken token) {
                Log.d(TAG, "handleFacebookAccessToken:" + token);
                showProgressDialog();
                AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
                mAuth.signInWithCredential(credential)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Log.d(TAG, "signInWithCredential:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    Log.w(TAG, "signInWithCredential:failure", task.getException());
                                    Toast.makeText(FacebookLoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }
                                hideProgressDialog();

                            }
                        });
            }

            public void signOut() {
                mAuth.signOut();
                LoginManager.getInstance().logOut();

                updateUI(null);
            }

            private void updateUI(FirebaseUser user) {
                hideProgressDialog();
                if (user != null) {
                    mStatusTextView.setText(getString(R.string.facebook_status_fmt, user.getDisplayName()));

                    mDetailTextView.setText(getString(R.string.firebase_status_fmt, user.getUid()));

                    findViewById(R.id.button_facebook_login).setVisibility(View.GONE);
                    findViewById(R.id.button_facebook_signout).setVisibility(View.VISIBLE);
                } else {
                    mStatusTextView.setText(R.string.signed_out);
                    mDetailTextView.setText(null);

                    findViewById(R.id.button_facebook_login).setVisibility(View.VISIBLE);
                    findViewById(R.id.button_facebook_signout).setVisibility(View.GONE);
                }
            }

            private View findViewById(int buttonFacebookLogin) {
                return null;
            }

            @Override
            public void onClick(View v) {
                int i = v.getId();
                if (i == R.id.button_facebook_signout) {
                    signOut();
                }
            }
        }

        public void setContentView ( int contentView){
            this.contentView = contentView;
        }

        public void setContentView ( int contentView){
            this.contentView = contentView;
        }
    }

    public void getApplicationContext() {
        return applicationContext;
    }