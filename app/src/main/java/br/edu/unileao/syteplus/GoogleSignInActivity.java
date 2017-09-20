package br.edu.unileao.syteplus;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;


public class GoogleSignInActivity extends BaseActivity implements
        GoogleApiClient.OnConnectionFailedListener,
        View.OnClickListener {

    private static final  String TAG  = "GoogleActivity";
     private static final  int RC_SIGN_IN = 9001;

     private FirebaseAuth mAuth;

    private GoogleApiClient mGoogleApiClient;

    private TextView mStatusTextView;
    private TextView mDetailTextView;

    @Override

    protected void  onCreate (Bundle savedInsatanceState){
        super.onCreate(savedInsatanceState);
        setContentView(R.layout.activity_google);
        mStatusTextView = (TextView) findViewById(R.id.status);
        mDetailTextView = (TextView) findViewById(R.id.detail);

        findViewById(R.id.sign_in_button). setOnClickListener(this);
        findViewById(R.id.sign_out_button). setOnClickListener(this);
        findViewById(R.id.sign_disconnect_button). setOnClickListener(this);

    }

        }

