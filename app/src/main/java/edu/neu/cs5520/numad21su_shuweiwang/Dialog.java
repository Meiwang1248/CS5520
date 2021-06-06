package edu.neu.cs5520.numad21su_shuweiwang;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.RecyclerView;

public class Dialog extends AppCompatDialogFragment {
    private EditText editTextWebsiteName;
    private EditText editTextURL;
    private DialogListener listener;

    private ItemCard curItem; // this determines whether the dialog is to add or to edit
    private int position; // if edit, we need to get the position of the given item

    // Constructor
    public Dialog(ItemCard item, int position) {
        this.curItem = item;
        this.position = position;
    }
    @Override
    public AlertDialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        // binds Dialog with its layout. The data of Dialog binds with the view components
        editTextWebsiteName = view.findViewById(R.id.editWebName);
        editTextURL = view.findViewById(R.id.editPassword);

        String addOrEdit;
        if (curItem == null) {
            addOrEdit = "Add an entry";
        } else {
            addOrEdit ="Edit this entry";
            // 原来的info放在dialog的输入框里
            editTextWebsiteName.setText(curItem.getName());
            editTextURL.setText(curItem.getURL());
        }

        builder.setView(view)
                .setTitle(addOrEdit)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // If Cancel, do nothing
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // get info from dialog's components
                        String webName = editTextWebsiteName.getText().toString();
                        String URL = editTextURL.getText().toString();
                        listener.transferInfo(position, webName, URL);

                    }


                });


        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (DialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement DialogListener");
        }
    }
    public interface DialogListener {
        void transferInfo(int position, String webName, String URL);
    }
}
