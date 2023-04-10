package net.nimazare.viewpagerslide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SlideFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_slide, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.tv_slide_character);
        textView.setText(getArguments().getString("data"));
    }

    public static SlideFragment newInstance(String data) {
        Bundle args = new Bundle();
        args.putString("data", data);
        SlideFragment fragment = new SlideFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
