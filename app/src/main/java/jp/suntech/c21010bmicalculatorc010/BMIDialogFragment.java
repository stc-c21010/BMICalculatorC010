package jp.suntech.c21010bmicalculatorc010;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class BMIDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dtitle);
        builder.setMessage(R.string.dmessege);
        builder.setPositiveButton(R.string.dpositiveb,new ButtonClickListener());
        AlertDialog dialog=builder.create();
        return dialog;
    }
    public class ButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog,int which){
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    break;
            }
        }

    }
}
