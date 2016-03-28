package com.kermitlin.lighttherapypat.ui.therapyLists;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.firebase.client.Firebase;
import com.kermitlin.lighttherapypat.R;
import com.kermitlin.lighttherapypat.utils.Constants;

public class TherapyListsFragment extends Fragment {
    private ListView mListView;

    public TherapyListsFragment() {
        /* Required empty public constructor */
    }

    /**
     * Create fragment and pass bundle with data as it's arguments
     * Right now there are not arguments...but eventually there will be.
     */
    public static TherapyListsFragment newInstance() {
        TherapyListsFragment fragment = new TherapyListsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Initialize instance variables with data from bundle
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /**
         * Initialize UI elements
         */
        View rootView = inflater.inflate(R.layout.fragment_therapy_lists, container, false);
        initializeScreen(rootView);

        /**
         * Create Firebase references
         */
        Firebase activeListsRef = new Firebase(Constants.FIREBASE_URL_ACTIVE_LISTS);

//        /**
//         * Add ValueEventListeners to Firebase references
//         * to control get data and control behavior and visibility of elements
//         */
//        mActiveListAdapter = new ActiveListAdapter(getActivity(), ShoppingList.class,
//                R.layout.single_active_list, activeListsRef);
//
//        /**
//         * Set the adapter to the mListView
//         */
//        mListView.setAdapter(mActiveListAdapter);

        /**
         * Set interactive bits, such as click events and adapters
         */
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ShoppingList selectedList = mActiveListAdapter.getItem(position);
//                if (selectedList != null) {
//                    Intent intent = new Intent(getActivity(), ActiveListDetailsActivity.class);
//                    /* Get the list ID using the adapter's get ref method to get the Firebase
//                     * ref and then grab the key.
//                     */
//                    String listId = mActiveListAdapter.getRef(position).getKey();
//                    intent.putExtra(Constants.KEY_LIST_ID, listId);
//                    /* Starts an active showing the details for the selected list */
//                    startActivity(intent);
//                }
            }
        });

        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        mActiveListAdapter.cleanup();
    }

    /**
     * Link layout elements from XML
     */
    private void initializeScreen(View rootView) {
        mListView = (ListView) rootView.findViewById(R.id.list_view_active_lists);
    }
}
