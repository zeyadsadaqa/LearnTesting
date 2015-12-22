package com.zeyad.tutorial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Zeyad Assem on 22/12/15.
 * @author Zeyad Assem.
 *
 * The tutorial fragment class represents single tutorial page.
 * Make the activity to finish when the position of the fragment is zero.
 */
public class TutorialFragment extends Fragment {
    private View zTutorialView;
    private ImageView zTutorialImageView;
    private int zPosition;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        zTutorialView = inflater.inflate(R.layout.tut_fragment, container, false);
        return zTutorialView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        zTutorialImageView = (ImageView) zTutorialView.findViewById(R.id.tutorial_image);
        zPosition = getArguments().getInt("pos");
        zTutorialImageView.setImageResource(getArguments().getInt("imgResId"));
        zTutorialImageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (zPosition == 0)
                    getActivity().finish();
            }
        });

    }
}
