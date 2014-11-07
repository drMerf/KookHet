package be.howest.nmct.android.kookhet;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import be.howest.nmct.android.kookhet.dummy.DummyContent;

// A fragment representing a list of Items.
// Large screen devices (such as tablets) are supported by replacing the ListView with a GridView.
// Activities containing this fragment MUST implement the {@link Callbacks} interface.
public class CategorieenFragment extends Fragment implements AbsListView.OnItemClickListener {
//private ArrayList<Categorie> categorieën= new ArrayList<Categorie>();
        private static final String ARG_PARAM1 = "param1";
       private int mParam1;
    private OnFragmentInteractionListener mListener;
private CursorAdapter mAdapter;
    private AbsListView mListView;


    // TODO: Rename and change types of parameters
    public static CategorieenFragment newInstance(int param1) {
        CategorieenFragment fragment = new CategorieenFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    // Mandatory empty constructor for the fragment manager to instantiate the fragment (e.g. upon screen orientation changes).
    public CategorieenFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState==null) {
        Bundle args = getArguments();
            if (getArguments() != null) {
                mParam1 = getArguments().getInt(ARG_PARAM1);
            }
            if (args != null) {
                int order = args.getInt(ARG_PARAM1, 0);
                if (order != 0)
                    mParam1 = order;
                }
            String[] columns = new String[] {DummyContent.CATEGORIEEN.toString()};
            int[] ViewIds = new int[]{R.id.textViewNaam};

            mAdapter = new SimpleCursorAdapter(getActivity(),R.id.textViewNaam,null,columns,ViewIds,0);
            //  mAdapter = new ArrayAdapter<DummyContent.Categorie>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, DummyContent.CATEGORIEEN);
//setAdapter
        }
    }

    class CategorieAdapter  extends ArrayAdapter<DummyContent.Categorie>{
        public CategorieAdapter(){
super(CategorieenFragment.this.getActivity(),R.layout.cel_categorie,R.id.textViewNaam,DummyContent.CATEGORIEEN);


        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
           View row = super.getView(position, convertView, parent);
            TextView textViewCategorieNaam = (TextView) row.findViewById(R.id.textViewNaam);


            return row;
        }
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
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
            ((MainActivity) activity).onSectionAttached(getArguments().getInt(ARG_PARAM1));
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//getLoaderManager().initLoader(0,null,this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (null != mListener) {
            // Notify the active callbacks interface (the activity, if the fragment is attached to one) that an item has been selected.
            mListener.onFragmentInteraction(DummyContent.CATEGORIEEN.get(position).id);
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
