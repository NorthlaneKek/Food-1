package com.example.makpro.recipedesign1.Fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.makpro.recipedesign1.R;
import com.example.makpro.recipedesign1.staticString;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link addCaloriesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link addCaloriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class addCaloriesFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View view;

    EditText editCalories;
    Button apply;
    TextView head;
    private OnFragmentInteractionListener mListener;

    public addCaloriesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment addCaloriesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static addCaloriesFragment newInstance(String param1, String param2) {
        addCaloriesFragment fragment = new addCaloriesFragment();
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
        view = inflater.inflate(R.layout.fragment_add_calories, container, false);
        view.setFocusableInTouchMode(true);
        view.requestFocus();

        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        FragmentManager fm = getFragmentManager();
                        fm.popBackStack();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.commit();
                        return true;
                    }
                }
                return false;
            }
        });
        Typeface cal = Typeface.createFromAsset(getActivity().getAssets(), "Mateur.ttf");
        Typeface cal1 = Typeface.createFromAsset(getActivity().getAssets(), "Peace Sans Webfont.ttf");
        head = (TextView) view.findViewById(R.id.textView2);
        head.setTypeface(cal1);
        apply = (Button) view.findViewById(R.id.applyCalories);
        apply.setTypeface(cal);
        editCalories = (EditText) view.findViewById(R.id.editCalories);
        editCalories.setTypeface(cal);
        editCalories.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Context context = view.getContext();
                InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editCalories.getWindowToken(), 0);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        apply.setOnClickListener(this);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.applyCalories) {
            staticString.addCaloricContent = editCalories.getText().toString();
            FragmentManager fm = getFragmentManager();
            fm.popBackStack();
            FragmentTransaction ft = fm.beginTransaction();
            ft.commit();
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
