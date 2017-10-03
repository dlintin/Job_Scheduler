package com.ptmanna.diand.job;

import android.os.AsyncTask;

/**
 * Created by diand on 03-Oct-17.
 */

public class MJobExecuter extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... params) {
return "Backgrouind finished";

    }
}
