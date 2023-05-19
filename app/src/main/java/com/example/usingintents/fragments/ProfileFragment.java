package com.example.usingintents.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.usingintents.R;
import com.example.usingintents.models.User;

public class ProfileFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private User profileUser;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance(User user) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            profileUser = (User) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView profileFullName = view.findViewById(R.id.profileFullName);
        TextView profileEmail = view.findViewById(R.id.profileEmail);
        TextView profilePhone = view.findViewById(R.id.profilePhone);
        TextView profileAddress = view.findViewById(R.id.profileAddress);
        ImageView profilePhoto = view.findViewById(R.id.profilePhoto);

        //TODO: INVESTIGAR CÓMO ABRIR APLICACIÓN EN LUGAR DE NAVEGADOR
        ImageView profileFacebook = view.findViewById(R.id.profileFacebook);
        profileFacebook.setOnClickListener((v)->{
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(profileUser.getFacebook()));
            startActivity(intent);
        });

        profileFullName.setText(profileUser.getFirstName() + " " + profileUser.getLastName());
        profileEmail.setText(profileUser.getEmail());
        profilePhone.setText(profileUser.getPhone());
        profileAddress.setText(profileUser.getAddress());
        profilePhoto.setImageResource(profileUser.getPhoto());

        // Inflate the layout for this fragment
        return view;
    }
}