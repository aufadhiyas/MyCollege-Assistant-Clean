package me.citrafa.mycollegeassistant.Activity.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import me.citrafa.mycollegeassistant.R;

/**
 * Created by SENSODYNE on 14/05/2017.
 */

public class frmJadwalLain extends Fragment {
    @BindView(R.id.txtNamaJl) EditText txtNama;
    @BindView(R.id.txtWaktuJlS) EditText txtWaktus;
    @BindView(R.id.txtWaktuJlF) EditText txtWaktuf;
    @BindView(R.id.txtTempatJl) EditText txtTempat;
    @BindView(R.id.txtDeskripsiJl)EditText txtDeskripsi;
    @BindView(R.id.btnSimpanJl) Button btnSimpan;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
