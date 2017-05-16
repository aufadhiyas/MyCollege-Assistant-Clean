package me.citrafa.mycollegeassistant.Activity.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.BindView;
import me.citrafa.mycollegeassistant.R;

/**
 * Created by SENSODYNE on 14/05/2017.
 */

public class frmJadwalUjian extends Fragment {
    @BindView(R.id.spJenisUjian) Spinner spJenisUjian;
    @BindView(R.id.txtNamaJU) EditText txtNama;
    @BindView(R.id.txtWaktuJU)EditText txtWaktu;
    @BindView(R.id.txtDeskripsiJU) EditText txtDeskripsi;
    @BindView(R.id.txtRuanganJU) EditText txtRuangan;
    @BindView(R.id.btnSelesaiJu) Button btnSelesai;
    @BindView(R.id.btnSimpanJu) Button btnSimpan;



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