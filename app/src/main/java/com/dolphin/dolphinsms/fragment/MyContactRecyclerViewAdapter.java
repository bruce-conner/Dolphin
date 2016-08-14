package com.dolphin.dolphinsms.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dolphin.dolphinsms.R;
import com.dolphin.dolphinsms.domain.Contact;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Contact} and makes a call to the
 * specified {@link ContactListFragment.OnListFragmentInteractionListener}.
 */
public class MyContactRecyclerViewAdapter extends RecyclerView.Adapter<MyContactRecyclerViewAdapter.ViewHolder> {

    private final List<Contact> contactList;
    private final ContactListFragment.OnListFragmentInteractionListener mListener;

    public MyContactRecyclerViewAdapter(List<Contact> contactList, ContactListFragment.OnListFragmentInteractionListener listener) {
        this.contactList = contactList;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = contactList.get(position);
        holder.contactName.setText(contactList.get(position).getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView contactName;
        public Contact mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            contactName = (TextView) view.findViewById(R.id.contact_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + contactName.getText() + "'";
        }
    }
}
