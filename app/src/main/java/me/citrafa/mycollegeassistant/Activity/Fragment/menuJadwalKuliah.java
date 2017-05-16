package me.citrafa.mycollegeassistant.Activity.Fragment;

import android.content.Intent;
import android.graphics.Paint;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

import me.citrafa.mycollegeassistant.AdapterRecycleView.AdapterJadwalKuliahNew;

import me.citrafa.mycollegeassistant.ModelClass.JadwalKuliahModel;
import me.citrafa.mycollegeassistant.OperationRealm.RealmController;
import me.citrafa.mycollegeassistant.R;

/**
 * Created by SENSODYNE on 13/04/2017.
 */

public class menuJadwalKuliah extends Fragment{
    private static RecyclerView recyclerView;
    private Realm realm;
    private AdapterJadwalKuliahNew adapter;
    private Context mContex;
    private FloatingActionButton fab;
    private Paint p = new Paint();
    private OrderedRealmCollection<JadwalKuliahModel> data;
    String TAG = "";



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    protected RecyclerView.LayoutManager mLayoutManager;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private menuJadwalKuliah.OnFragmentInteractionListener mListener;

    public menuJadwalKuliah() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment menuJadwalKuliah.
     */
    // TODO: Rename and change types and number of parameters
    public static menuJadwalKuliah newInstance(String param1, String param2) {
        menuJadwalKuliah fragment = new menuJadwalKuliah();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.realm = RealmController.with(getActivity()).getRealm();

        realm.getDefaultInstance();
        View rootView = inflater.inflate(R.layout.fragment_menu_jadwal_kuliah, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerjk);
        data = realm.where(JadwalKuliahModel.class).equalTo("status_jk",true).findAll();
        RealmResults<JadwalKuliahModel> jkm = realm.where(JadwalKuliahModel.class).equalTo("status_jk",true).findAll().sort("nohari", Sort.ASCENDING);
            adapter = new AdapterJadwalKuliahNew(data,jkm);
            final LinearLayoutManager layout = new LinearLayoutManager(getActivity());
            layout.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layout);
            recyclerView.setAdapter(adapter);

        fab = (FloatingActionButton)rootView.findViewById(R.id.fabAddJadwalKuliah);
        fab.show();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),
                        frmJadwalKuliah.class);
                startActivity(intent);
            }
        });
                recyclerView.setHasFixedSize(true);
        Log.d(TAG, "TAG : OnCreateView Fragment");
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContex = context;
//        dataJadwal = new ArrayList<>();
        Log.d(TAG, "tag : OnAttach Fragment");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
