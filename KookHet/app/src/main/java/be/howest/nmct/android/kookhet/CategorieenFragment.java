package be.howest.nmct.android.kookhet;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import be.howest.nmct.android.kookhet.dummy.DummyContent;

// A fragment representing a list of Items.
// Large screen devices (such as tablets) are supported by replacing the ListView with a GridView.
// Activities containing this fragment MUST implement the {@link Callbacks} interface.
public class CategorieenFragment extends Fragment implements AbsListView.OnItemClickListener {

    // The fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_NavigatieId = "NavigatieId";

    private static final String KEY_NavigatieId = "NavigatieId";

    private int mNavigatieId;

    private OnFragmentInteractionListener mListener;

    // The fragment's ListView/GridView.
    private AbsListView mListView;

    // The Adapter which will be used to populate the ListView/GridView with Views.
    private ListAdapter mAdapter;

    // Use this factory method to create a new instance of this fragment using the provided parameters.
    public static CategorieenFragment newInstance(int NavigatieId) {
        CategorieenFragment fragment = new CategorieenFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_NavigatieId, NavigatieId);
        fragment.setArguments(args);
        return fragment;
    }

    // Mandatory empty constructor for the fragment manager to instantiate the fragment (e.g. upon screen orientation changes).
    public CategorieenFragment() {}

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;

            // Categorienfragment kan maar op 1 manier gestart worden:
            // - Vanuit de navigationdrawer, met een waarde als id. De titel is hetzelfde als het aangeklikte item in de naviagtiondrawer.
            ((MainActivity) activity).onSectionAttached(getArguments().getInt(ARG_NavigatieId), null);

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            mNavigatieId = savedInstanceState.getInt(KEY_NavigatieId);
        }
        else {
            if (getArguments() != null) {
                mNavigatieId = getArguments().getInt(ARG_NavigatieId);
            }
        }

        // TODO: Change Adapter to display your content
        mAdapter = new ArrayAdapter<DummyContent.Categorie>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, DummyContent.CATEGORIEEN);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categorieen, container, false);

        // Set the adapter
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        ((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);

        // Set OnItemClickListener so we can be notified on item clicks
        mListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_NavigatieId, mNavigatieId);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (null != mListener) {
            // Notify the active callbacks interface (the activity, if the fragment is attached to one) that an item has been selected.
            mListener.onFragmentInteraction(DummyContent.CATEGORIEEN.get(position).id);

            // Bij klikken op categorie, lijst recepten in categorie ophalen
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, ReceptenFragment.newInstance(
                    getArguments().getInt(ARG_NavigatieId),
                    parent.getItemAtPosition(position).toString()
            )).commit();
        }
    }

    // The default content for this Fragment has a TextView that is shown when the list is empty. If you would like to change the text, call this method to supply the text it should use.
    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyText instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

    // This interface must be implemented by activities that contain this fragment to allow an interaction in this fragment to be communicated to the activity and potentially other fragments contained in that activity.
    // See the Android Training lesson <a href="http://developer.android.com/training/basics/fragments/communicating.html">Communicating with Other Fragments</a> for more information.
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(String id);
    }
}
