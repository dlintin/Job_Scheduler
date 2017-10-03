package com.ptmanna.diand.job;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.pm.ProviderInfo;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private JobScheduler jobScheduler;
    private JobInfo jobInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void startservice(View view) {
       job(1);
        jobScheduler.schedule(jobInfo);
        Toast.makeText(this,"job dibuat",Toast.LENGTH_SHORT).show();
    }

    public void stopservice(View view) {
        jobScheduler.cancelAll();
        Toast.makeText(this,"job CANCELLED",Toast.LENGTH_SHORT).show();
    }

    public void START2(View view) {
       job(2);
        jobScheduler.schedule(jobInfo);
        Toast.makeText(this,"job dibuat",Toast.LENGTH_SHORT).show();
    }


    public  void job(Integer JOB_ID){
        ComponentName componentName = new ComponentName(this,MJobScheduler.class);
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID,componentName);
        PersistableBundle bundle = new PersistableBundle();
        bundle.putInt("height",JOB_ID);
        builder.setPeriodic(5);
        builder.setExtras(bundle);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setPersisted(true);

        jobInfo = builder.build();
        jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
    }
}
