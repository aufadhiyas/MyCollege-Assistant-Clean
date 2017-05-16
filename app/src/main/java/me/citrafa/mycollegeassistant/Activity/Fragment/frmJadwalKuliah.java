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
import android.widget.TextView;

import butterknife.BindView;
import me.citrafa.mycollegeassistant.R;

/**
 * Created by SENSODYNE on 14/05/2017.
 */

public class frmJadwalKuliah extends Fragment {
    @BindView(R.id.spinnerHari) Spinner spHari;
    @BindView(R.id.txtMakul) EditText txtMakul;
    @BindView(R.id.txtRuangan) EditText txtRuangan;
    @BindView(R.id.txtJam) EditText txtJam;
    @BindView(R.id.txtKelas) EditText txtKelas;
    @BindView(R.id.txtDosen) EditText txtDosen;
    @BindView(R.id.btnSimpan) Button btnSimpan;
    @BindView(R.id.btnBatal) Button btnBatal;


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
