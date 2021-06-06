package edu.neu.cs5520.numad21su_shuweiwang;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialog extends AppCompatDialogFragment {
    private EditText editTextWebsiteName;
    private EditText editTextURL;
    private DialogListener listener;

    @Override
    public AlertDialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        // binds Dialog with its layout. The data of Dialog binds with the view components
        editTextWebsiteName = view.findViewById(R.id.editWebName);
        editTextURL = view.findViewById(R.id.editPassword);

        builder.setView(view)
                .setTitle("Add or Edit")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Cancel then do nothing
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // get info from dialog's components
                        String webName = editTextWebsiteName.getText().toString();
                        String URL = editTextURL.getText().toString();
                        listener.transferInfo(webName, URL);
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
        void transferInfo(String webName, String URL);
    }
}
