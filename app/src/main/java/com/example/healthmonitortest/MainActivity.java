package com.example.healthmonitortest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.User;
import io.realm.mongodb.sync.SyncConfiguration;

public class MainActivity extends AppCompatActivity {

    Realm uiThreadRealm;
    User user;
    App app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);

        String appID = "healthmonitorapp-pfisi";
        app = new App(new AppConfiguration.Builder(appID)
                .build());
        Credentials credentials = Credentials.emailPassword("teste6@mail.com","password");
        app.loginAsync(credentials, result -> {
            if (result.isSuccess()) {
                Log.v("QUICKSTART", "Login Successful.");
                user = app.currentUser();

                String partitionValue = "private";

                SyncConfiguration config = new SyncConfiguration.Builder(
                        user,partitionValue)
                        .allowWritesOnUiThread(true)
                        .allowQueriesOnUiThread(true)
                        .build();

                uiThreadRealm = Realm.getInstance(config);
                addChangeListenerToRealm(uiThreadRealm);
                // interact with realm using your user object here
            } else {
                Log.e("QUICKSTART", "Failed to log in. Error: " + result.getError());
            }
        });




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // the ui thread realm uses asynchronous transactions, so we can only safely close the realm
        // when the activity ends and we can safely assume that those transactions have completed
        app.currentUser().logOutAsync(result -> {
            if (result.isSuccess()) {
                Log.v("QUICKSTART", "Successfully logged out.");
            } else {
                Log.e("QUICKSTART", "Failed to log out, error: " + result.getError());
            }
        });
        uiThreadRealm.close();
    }

    private void addChangeListenerToRealm(Realm realm) {
        // all Tasks in the realm
        RealmResults<ActivityData> activityDatas = uiThreadRealm.where(ActivityData.class).findAllAsync();
        activityDatas.addChangeListener(new OrderedRealmCollectionChangeListener<RealmResults<ActivityData>>() {
            @Override
            public void onChange(RealmResults<ActivityData> collection, OrderedCollectionChangeSet changeSet) {
                // process deletions in reverse order if maintaining parallel data structures so indices don't change as you iterate
                OrderedCollectionChangeSet.Range[] deletions = changeSet.getDeletionRanges();
                for (OrderedCollectionChangeSet.Range range : deletions) {
                    Log.v("QUICKSTART", "Deleted range: " + range.startIndex + " to " + (range.startIndex + range.length - 1));
                }
                OrderedCollectionChangeSet.Range[] insertions = changeSet.getInsertionRanges();
                for (OrderedCollectionChangeSet.Range range : insertions) {
                    Log.v("QUICKSTART", "Inserted range: " + range.startIndex + " to " + (range.startIndex + range.length - 1));                            }
                OrderedCollectionChangeSet.Range[] modifications = changeSet.getChangeRanges();
                for (OrderedCollectionChangeSet.Range range : modifications) {
                    Log.v("QUICKSTART", "Updated range: " + range.startIndex + " to " + (range.startIndex + range.length - 1));                            }
            }
        });
    }

   /* public class BackgroundQuickStart implements Runnable {
        @Override
        public void run() {
            String realmName = "HealthMonitorApp";
            RealmConfiguration config = new RealmConfiguration.Builder().name(realmName).build();
            Realm backgroundThreadRealm = Realm.getInstance(config);
            User User = new User("user3","password","user3@mail.com",919918917);
            backgroundThreadRealm.executeTransaction (transactionRealm -> {
                transactionRealm.insert(User);
            });
            // all Tasks in the realm
            RealmResults<User> Users = backgroundThreadRealm.where(User.class).findAll();

            // because this background thread uses synchronous realm transactions, at this point all
            // transactions have completed and we can safely close the realm
            backgroundThreadRealm.close();
        }
    }*/


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void buttonGenerate(View view) {
        Random random = new Random();
        int minHeartrate = random.ints(50,120).findFirst().getAsInt();
        int maxHeartrate = random.ints(minHeartrate+15,170).findFirst().getAsInt();
        int restHeartrate = random.ints(minHeartrate+5,((maxHeartrate+minHeartrate)/2)-5).findFirst().getAsInt();

        for (int i = 0; i < 100; i++) {
            ActivityData activityData = new ActivityData(random.doubles(2.5,100.0).findFirst().getAsDouble(),
                    random.doubles(5.00,160.00).findFirst().getAsDouble(),
                    random.ints(100,1300).findFirst().getAsInt(),
                    new GregorianCalendar(2022,random.ints(1,12).findFirst().getAsInt(),random.ints(1,31).findFirst().getAsInt()).getTime(),
                    random.ints(100,10000).findFirst().getAsInt(),
                    minHeartrate,
                    maxHeartrate,
                    restHeartrate,
                    random.ints(21,62).findFirst().getAsInt(),
                    random.ints(10,30).findFirst().getAsInt());
            uiThreadRealm.executeTransaction (transactionRealm -> {
                transactionRealm.insert(activityData);
            });
        }



        Toast.makeText(this, "Dados foram gerados", Toast.LENGTH_SHORT).show();

        /*AppUser appUser = new AppUser("user8","password","teste8@mail.com",919918918,false);
        uiThreadRealm.executeTransaction(transactionRealm ->{
            transactionRealm.insert(appUser);
        });
        app.getEmailPassword().registerUserAsync("teste8@mail.com","password",result -> {
            //Log.v("Result",result.getError().getErrorMessage());
            if (result.isSuccess()){
                Log.v("User","Registered with email successfully");
            }else {
                Log.v("User","Registration failed");
            }
        });*/



    }
}