package com.example.dialogstyle;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


/**
 * AlertDialog的布局文件使用自定义布局
 * 其余业务逻辑均可在布局中自定义
 */
public class CustomPromptDialog extends Dialog{
    private AlertDialog dialog;

    public CustomPromptDialog(Context context) {
        super(context);
    }

    public CustomPromptDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomPromptDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    /**
     * 自定义业务逻辑
     */
    public void showPromptDialog(final Context mContext){
        View view=LayoutInflater.from(mContext).inflate(R.layout.custom_alert_dialog_,null);

        dialog = new AlertDialog.Builder(mContext).setView(view).create();
        dialog.show();


        TextView textView= (TextView) view.findViewById(R.id.tv_ok);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != dialog){
                    dialog.dismiss();
                    Toast.makeText(getContext(),"Dialog已隐藏",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(),"Dialog为空",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
