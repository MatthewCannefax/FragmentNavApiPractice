package com.matthewcannefax.fragmentandapipractice.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.matthewcannefax.fragmentandapipractice.ImageItem;
import com.matthewcannefax.fragmentandapipractice.R;
import com.matthewcannefax.fragmentandapipractice.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ViewPager2 viewPager2;

    private MainViewModel viewModel;

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
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

        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        viewModel.setCurrentFragment(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager2 = requireActivity().findViewById(R.id.viewPager2);
        ViewPagerAdapter adapter = new ViewPagerAdapter();
        viewPager2.setAdapter(adapter);
        List<ImageItem> items = new ArrayList<>();
        items.add(new ImageItem(requireContext().getDrawable(R.drawable.hedgehog), 1));
        items.add(new ImageItem(requireContext().getDrawable(R.drawable.kitty), 2));
        items.add(new ImageItem(requireContext().getDrawable(R.drawable.puppy), 3));

        adapter.submitList(items);

        List<ImageItem> modifiedImages = new ArrayList<>();
        modifiedImages.add(items.get(items.size() - 1));
        modifiedImages.addAll(items);
        modifiedImages.add(items.get(0));

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                if (adapter.getCurrentList().size() != items.size()) {
                    if (position == 0) {
                        viewPager2.postDelayed(() -> viewPager2.setCurrentItem(adapter.getCurrentList().size() - 2, false), 200);
                    } else if (position == adapter.getCurrentList().size() - 1) {
                        viewPager2.postDelayed(() -> viewPager2.setCurrentItem(1, false), 200);
                    }
                }
            }
        });

        viewPager2.post(() -> adapter.submitList(modifiedImages));
    }
}