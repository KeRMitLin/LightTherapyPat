package com.kermitlin.lighttherapypat.ui.therapyLists;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ServerValue;
import com.firebase.client.ValueEventListener;
import com.kermitlin.lighttherapypat.R;
import com.kermitlin.lighttherapypat.model.TherapyList;
import com.kermitlin.lighttherapypat.model.User;
import com.kermitlin.lighttherapypat.ui.BaseActivity;
import com.kermitlin.lighttherapypat.utils.Constants;

import java.util.HashMap;

public class MainActivity extends BaseActivity {

    private Firebase mUserRef, mTherapyListsRef;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private ValueEventListener mUserRefListener;
    private Query queryRef;

    private TherapyListAdapter mTherapyListAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserRef = new Firebase(Constants.FIREBASE_URL_USERS).child(mEncodedEmail);
        mTherapyListsRef = new Firebase(Constants.FIREBASE_URL_DEPLOYED_LISTS).child(mEncodedEmail);
        queryRef = mTherapyListsRef.orderByChild(Constants.FIREBASE_PROPERTY_TOGGLE_SWITCH).equalTo(true);

        initializeScreen();

        mUserRefListener = mUserRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);

                /**
                 * Set the activity title to current user name if user is not null
                 */
                if (user != null) {
                    /* Assumes that the first word in the user's name is the user's first name. */
                    String firstName = user.getName().split("\\s+")[0];
                    String title = firstName + "'s Lists";
                    setTitle(title);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e(LOG_TAG,
                        getString(R.string.log_error_the_read_failed) +
                                firebaseError.getMessage());
            }
        });

        mTherapyListAdapter = new TherapyListAdapter(this, TherapyList.class,
                R.layout.single_active_list, queryRef);

        mListView.setAdapter(mTherapyListAdapter);

        /**
         * Set interactive bits, such as click events and adapters
         */
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TherapyList selectedList = mTherapyListAdapter.getItem(position);
                if (selectedList != null) {
//                    Intent intent = new Intent(getActivity(), TherapyGo.class);
//                    /* Get the list ID using the adapter's get ref method to get the Firebase
//                     * ref and then grab the key.
//                     */
//                    String listId = mActiveListAdapter.getRef(position).getKey();
//                    intent.putExtra(Constants.KEY_LIST_ID, listId);
//                    /* Starts an active showing the details for the selected list */
//                    startActivity(intent);
                }
            }
        });


        //insertTest
        Firebase mInsertRef = new Firebase(Constants.FIREBASE_URL_DEPLOYED_LISTS).child(mEncodedEmail);
        Firebase newListRef = mInsertRef.push();

        /* Save listsRef.push() to maintain same random Id */
        final String listId = newListRef.getKey();

        /**
         * Set raw version of date to the ServerValue.TIMESTAMP value and save into
         * timestampCreatedMap
         */
        HashMap<String, Object> timestampCreated = new HashMap<>();
        timestampCreated.put(Constants.FIREBASE_PROPERTY_TIMESTAMP, ServerValue.TIMESTAMP);

            /* Build the shopping list */
        TherapyList newTherapyList = new TherapyList("testList", true, timestampCreated);

            /* Add the shopping list */
        newListRef.setValue(newTherapyList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUserRef.removeEventListener(mUserRefListener);
    }

    public void initializeScreen() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mListView = (ListView) findViewById(R.id.list_view_therapy_lists);
    }
}
