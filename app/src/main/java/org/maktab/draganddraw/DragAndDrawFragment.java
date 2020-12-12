package org.maktab.draganddraw;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import org.maktab.draganddraw.databinding.FragmentDragAndDrawBinding;

public class DragAndDrawFragment extends Fragment {

    private FragmentDragAndDrawBinding mBinding;

    public DragAndDrawFragment() {
        // Required empty public constructor
    }

    public static DragAndDrawFragment newInstance() {
        DragAndDrawFragment fragment = new DragAndDrawFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_drag_and_draw,
                container,
                false);
        return mBinding.getRoot();
    }
}