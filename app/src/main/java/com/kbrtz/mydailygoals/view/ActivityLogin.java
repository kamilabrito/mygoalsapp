package com.kbrtz.mydailygoals.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.kbrtz.mydailygoals.R;
import com.kbrtz.mydailygoals.constants.Constants;
import com.kbrtz.mydailygoals.model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.kbrtz.mydailygoals.presenter.PresenterLoginActivity;

/**
 * Created by kamilabrito on 5/10/17.
 */

public class ActivityLogin extends AppCompatActivity {

    @BindView(R.id.login_button)
    LoginButton loginButton;
    CallbackManager callbackManager;
    private PresenterLoginActivity presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);

        presenter = new PresenterLoginActivity(this);

        if (!presenter.isFirstBoot(this)) {
            presenter.openMainActivity();
        }

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        loginButton.setReadPermissions(Arrays.asList(
                "public_profile", "email"));

        callbackManager = CallbackManager.Factory.create();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {

                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                getFacebookData(object);
                            }
                        });

                Bundle parameters = new Bundle();
                parameters.putString("fields", "id, first_name, last_name, email");
                request.setParameters(parameters);
                request.executeAsync();

            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException exception) {
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void getFacebookData(JSONObject object) {

        try {
            Bundle bundle = new Bundle();
            String id = object.getString("id");

            try {
                URL profile_pic = new URL("https://graph.facebook.com/" + id + "/picture?width=200&height=150");
                Log.i(Constants.PROFILE_PIC, profile_pic + "");
                bundle.putString(Constants.PROFILE_PIC, profile_pic.toString());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            bundle.putString(Constants.FACEBOOK_ID, id);
            if (object.has(Constants.FIRST_NAME))
                bundle.putString(Constants.FIRST_NAME, object.getString(Constants.FIRST_NAME));
            if (object.has(Constants.LAST_NAME))
                bundle.putString(Constants.LAST_NAME, object.getString(Constants.LAST_NAME));
            if (object.has(Constants.EMAIL))
                bundle.putString(Constants.EMAIL, object.getString(Constants.EMAIL));

            presenter.createUser(bundle);
            presenter.loadDataFirstBoot(this);
            presenter.openMainActivity();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
