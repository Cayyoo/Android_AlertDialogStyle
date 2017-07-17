package com.example.dialogstyle;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/2/20.
 */
public class DialogOneStyleActivity extends AppCompatActivity implements View.OnClickListener{
    private Button tv_01,tv_02,tv_03,tv_04,tv_05,tv_06,tv_07;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_one_style);

        tv_01=(Button)this.findViewById(R.id.tv_01);
        tv_02=(Button)this.findViewById(R.id.tv_02);
        tv_03=(Button)this.findViewById(R.id.tv_03);
        tv_04=(Button)this.findViewById(R.id.tv_04);
        tv_05=(Button)this.findViewById(R.id.tv_05);
        tv_06=(Button)this.findViewById(R.id.tv_06);
        tv_07=(Button)this.findViewById(R.id.tv_07);

        tv_01.setOnClickListener(this);
        tv_02.setOnClickListener(this);
        tv_03.setOnClickListener(this);
        tv_04.setOnClickListener(this);
        tv_05.setOnClickListener(this);
        tv_06.setOnClickListener(this);
        tv_07.setOnClickListener(this);
    }


    /**
     * 1.1 按返回按钮时弹出一个提示，来确保无误操作，采用常见的对话框样式。
     */
    protected void dialog01() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("确认退出吗？");
        builder.setTitle("提示");

        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }

    /**
     * 1.2 在onKeyDown(int keyCode, KeyEvent event)方法中调用dialog01方法
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            dialog01();
        }

        return false;
    }

    /**
     * 2.改变了对话框的图表，添加了三个按钮
     */
    public void dialog02(){
        Dialog dialog = new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.btn_star)
                .setTitle("喜好调查")
                .setMessage("你喜欢李连杰的电影吗？")
                .setPositiveButton("很喜欢", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogOneStyleActivity.this, "我很喜欢他的电影。", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("不喜欢", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogOneStyleActivity.this, "我不喜欢他的电影。", Toast.LENGTH_LONG).show();
                    }
                })
                .setNeutralButton("一般", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogOneStyleActivity.this, "谈不上喜欢不喜欢。", Toast.LENGTH_LONG).show();
                    }
                })
                .create();

        dialog.show();
    }

    /**
     * 3.信息内容是一个简单的View类型
     */
    public void dialog03(){
        new AlertDialog.Builder(this).setTitle("这是一个EditText，请输入...")
                .setIcon(android.R.drawable.ic_dialog_info)
                .setView(new EditText(this))
                .setPositiveButton("确定", null)
                .setNegativeButton("取消", null)
                .show();
    }

    /**
     * 4.信息内容是一组复选框
     */
    public void dialog04(){
        new AlertDialog.Builder(this).setTitle("复选框")
                .setMultiChoiceItems(new String[]{"Item1", "Item2"}, null, null)
                .setPositiveButton("确定", null)
                .setNegativeButton("取消", null)
                .show();
    }

    /**
     * 5.信息内容是一组单选框
     */
    public void dialog05(){
        new AlertDialog.Builder(this).setTitle("单选框")
                .setIcon(android.R.drawable.ic_dialog_info)
                .setSingleChoiceItems(new String[]{"Item1", "Item2"}, 0, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("取消", null)
                .show();
    }

    /**
     * 6.信息内容是一组简单列表项
     */
    public void dialog06(){
        new AlertDialog.Builder(this).setTitle("列表框")
                .setItems(new String[]{"Item1", "Item2"}, null)
                .setNegativeButton("确定", null)
                .show();
    }

    /**
     * 7.信息内容是一个自定义的布局
     */
    public void dialog07(){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.dialog_one_custom_layout,(ViewGroup) findViewById(R.id.dialog));

        new AlertDialog.Builder(this)
                .setTitle("自定义布局")
                .setView(layout)
                .setPositiveButton("确定", null)
                .setNegativeButton("取消", null)
                .show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_01:
                dialog01();
                break;
            case R.id.tv_02:
                dialog02();
                break;
            case R.id.tv_03:
                dialog03();
                break;
            case R.id.tv_04:
                dialog04();
                break;
            case R.id.tv_05:
                dialog05();
                break;
            case R.id.tv_06:
                dialog06();
                break;
            case R.id.tv_07:
                dialog07();
                break;
            default:
                break;
        }
    }

}
