package com.ptmanna.diand.job;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.AsyncTask;
import android.os.PersistableBundle;
import android.widget.Toast;

/**
 * Created by diand on 03-Oct-17.
 */

public class MJobScheduler extends JobService {
Integer pbc;
private MJobExecuter mJobExecuter;
    @Override
    public boolean onStartJob(final JobParameters jobParameters) {
        final Integer pb = jobParameters.getExtras().getInt("height");
        pbc = pb;
        mJobExecuter = new MJobExecuter(){

            @Override
            protected void onPostExecute(String s) {
               Toast.makeText(getApplicationContext(),s+pbc,Toast.LENGTH_SHORT).show();
                jobFinished(jobParameters,false);
            }
        };
        mJobExecuter.execute();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {


        return false;

    }


}
