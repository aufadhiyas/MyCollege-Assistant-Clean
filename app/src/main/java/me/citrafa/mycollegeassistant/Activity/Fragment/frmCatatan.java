package me.citrafa.mycollegeassistant.Activity.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmResults;
import me.citrafa.mycollegeassistant.AdapterRecycleView.AdapterCatatanRV;
import me.citrafa.mycollegeassistant.CustomWidget.btnMuseo;
import me.citrafa.mycollegeassistant.CustomWidget.etMuseo;
import me.citrafa.mycollegeassistant.CustomWidget.tvMuseo;
import me.citrafa.mycollegeassistant.ModelClass.CatatanModel;
import me.citrafa.mycollegeassistant.R;

/**
 * Created by SENSODYNE on 14/05/2017.
 */

public class frmCatatan extends Fragment {
    @BindView(R.id.txtCatatanNama) etMuseo txtNama;
    @BindView(R.id.txtWaktuCatatan)etMuseo txtWaktu;
    @BindView(R.id.txtDeskripsiCatatan) etMuseo txtCatatan;
    @BindView(R.id.btnCatatanSimpan) btnMuseo btnSimpan;
    @BindView(R.id.lblCatatanFileName) tvMuseo lblFile;
    @BindView(R.id.btnCatatanAttach) btnMuseo btnAttach;
    @BindView(R.id.recyclerC) RecyclerView recyclerView;

    AdapterCatatanRV adapter;
    Realm realm;
    OrderedRealmCollection<CatatanModel> data;
    RealmResults<CatatanModel> catatanModels;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_frm_catatan, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        realm = Realm.getDefaultInstance();
        data = realm.where(CatatanModel.class).equalTo("status",true).findAll();
        catatanModels = realm.where(CatatanModel.class).equalTo("status",true).findAll();
        adapter = new AdapterCatatanRV(getActivity(),data,catatanModels);
        final LinearLayoutManager layout = new LinearLayoutManager(getActivity());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }
    public void simpanData(){

    }
}
