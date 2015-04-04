package com.example.shimaazu;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;

/**
 * Adapter to bind a ToDoItem List to a view
 */
public class ToDoItemAdapter extends ArrayAdapter<ToDoItem> {

    /**
     * Adapter context
     */
    Context mContext;

    /**
     * Adapter View layout
     */
    int mLayoutResourceId;

    public ToDoItemAdapter(Context context, int layoutResourceId) {
        super(context, layoutResourceId);

        mContext = context;
        mLayoutResourceId = layoutResourceId;
    }

    /**
     * Returns the view for a specific item on the list
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        final ToDoItem currentItem = getItem(position);

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
        }

        row.setTag(currentItem);
        final TextView checkBox = (TextView) row.findViewById(R.id.checkToDoItem);
        checkBox.setText(currentItem.getText());

        final TextView name = (TextView) row.findViewById(R.id.speakerName);
        name.setText(currentItem.getName());

        final TextView saidTime = (TextView) row.findViewById(R.id.saidTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        saidTime.setText(simpleDateFormat.format(currentItem.getDate()));

        return row;
    }

}