package com.example.sujitassignmentone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

public class fragmentvedio2 extends Fragment {

    VideoView v;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview=inflater.inflate(R.layout.activity_fragmentvedio2,container,false);
        v=rootview.findViewById(R.id.v1);
        MediaController m=new MediaController(getActivity());
        String videopath="android.resource://"+getActivity().getPackageName()+"/"+R.raw.vedio3;
        v.setVideoURI(Uri.parse(videopath));
        v.setMediaController(m);
        v.start();

        return rootview;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}