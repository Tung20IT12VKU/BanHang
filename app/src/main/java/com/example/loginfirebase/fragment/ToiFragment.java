package com.example.loginfirebase.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.loginfirebase.R;
import com.example.loginfirebase.activity.DanhGiaActivity;
import com.example.loginfirebase.activity.HoSoActivity;
import com.example.loginfirebase.adapter.ToiAdapter;
import com.example.loginfirebase.model.Toi;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ToiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ToiFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView_toi;
    ArrayList<Toi> arrayList;

    public ToiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ToiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ToiFragment newInstance(String param1, String param2) {
        ToiFragment fragment = new ToiFragment();
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
        View view = inflater.inflate(R.layout.fragment_toi, container, false);
        recyclerView_toi = view.findViewById(R.id.rcv_toi);
        arrayList = new ArrayList<>();
        arrayList.add(new Toi(1,R.drawable.ic_person,"Hồ Sơ của tôi"));
        arrayList.add(new Toi(2,R.drawable.ic_contact_page,"Địa chỉ"));
        arrayList.add(new Toi(3,R.drawable.ic_star,"Đánh giá của tôi"));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView_toi.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), layoutManager.getOrientation());
        recyclerView_toi.addItemDecoration(dividerItemDecoration);
        ToiAdapter adapter = new ToiAdapter(arrayList, getContext(), toi -> ClickItemToi(toi));
        recyclerView_toi.setAdapter(adapter);
        return view;
    }
    private void ClickItemToi(Toi toi) {
        switch (toi.getId())
        {
            case 1:
                Intent intent = new Intent(getContext(), HoSoActivity.class);
                startActivity(intent);
                break;
            case 2:
                break;
            case 3:
                Intent intent1 = new Intent(getContext(), DanhGiaActivity.class);
                startActivity(intent1);
                break;
        }
    }
}