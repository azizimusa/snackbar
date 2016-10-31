package org.apache.cordova.snackbar;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.FrameLayout;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by azizimusa on 27/10/2016.
 */

public class SnackBarPlugin extends CordovaPlugin {

    private static final String ACTION = "snackBar";
    FrameLayout rootView;
    private int msgId = 0;

    public SnackBarPlugin() {

    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {

            if (action.equals(ACTION)) {
                JSONObject orb = args.getJSONObject(0);

                String msg = orb.optString("msg");
                int delay = orb.optInt("delay");
                String actionBtn = orb.optString("action");

                showNormalSnackbar(msg, delay, actionBtn, callbackContext);
                return true;
            }

            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void showNormalSnackbar(final String msg, final int delay, final String actionBtn, final CallbackContext callbackContext) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                final Snackbar snackbar = Snackbar.make(rootView, msg, Snackbar.LENGTH_INDEFINITE);

                switch (delay) {
                    case -2: //Snackbar.LENGTH_INDEFINITE
                        snackbar.setDuration(Snackbar.LENGTH_INDEFINITE);
                        msgId = 1010;
                        break;
                    case 0: //Snackbar.LENGTH_LONG
                        snackbar.setDuration(Snackbar.LENGTH_LONG);
                        msgId = 2020;
                        break;
                    case 1: //Snackbar.LENGTH_SHORT
                        snackbar.setDuration(Snackbar.LENGTH_SHORT);
                        msgId = 3030;
                        break;
                }

                if (!actionBtn.equals("")) {
                    snackbar.setAction(actionBtn, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            snackbar.dismiss();
                            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, msgId));
                        }
                    });
                }

                snackbar.show();

            }
        };

        cordova.getActivity().runOnUiThread(runnable);
    }

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        rootView = (FrameLayout) webView.getView().getParent();
    }
}
