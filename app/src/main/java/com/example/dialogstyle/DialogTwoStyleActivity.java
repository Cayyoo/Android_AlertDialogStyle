package com.example.dialogstyle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogTwoStyleActivity extends AppCompatActivity {

    private Button changebtn;
    private Button contentbtn;
    private Button listbtn;
    private Button mutlistbtn;
    private Button radiolistbtn;
    private Button diybtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_two_style);

        changebtn = (Button) findViewById(R.id.changebtn);
        contentbtn = (Button) findViewById(R.id.contentbtn);
        listbtn = (Button) findViewById(R.id.listbtn);
        radiolistbtn = (Button) findViewById(R.id.radiolistbtn);
        mutlistbtn = (Button) findViewById(R.id.mutlistbtn);
        diybtn = (Button) findViewById(R.id.diybtn);

        //提示对话框
        changebtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DialogTwoStyleActivity.this)
                        .setIcon(android.R.drawable.btn_star)
                        .setTitle("调查")
                        .setMessage("你喜欢海贼王吗？")
                        .setPositiveButton("喜欢",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,int which) {
                                Toast.makeText(DialogTwoStyleActivity.this,"我很喜欢海贼王", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("一般",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,int which) {
                                Toast.makeText(DialogTwoStyleActivity.this, "我对海贼王不怎么感兴趣", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("不喜欢",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,int which) {
                                Toast.makeText(DialogTwoStyleActivity.this, "我一点也不喜欢海贼王", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();// show很关键
            }
        });

        /**
         * 文本框对话框
         *
         * 在对话框中添加一个文本框，点击确定后获取文本框里的内容
         */
        contentbtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText = new EditText(DialogTwoStyleActivity.this);

                new AlertDialog.Builder(DialogTwoStyleActivity.this)
                        .setTitle("请输入")
                        .setView(editText)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogTwoStyleActivity.this, "您输入的内容是：" + editText.getText(), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
            }
        });

        /**
         * 简单列表对话框
         *
         * 在对话框中列出数组，让用户选择。
         */
        listbtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[]{"北京","上海","深圳"};

                new AlertDialog.Builder(DialogTwoStyleActivity.this)
                        .setTitle("城市列表")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        Toast.makeText(DialogTwoStyleActivity.this, "您选中了：" + items[0], Toast.LENGTH_SHORT).show();
                                        break;
                                    case 1:
                                        Toast.makeText(DialogTwoStyleActivity.this, "您选中了：" + items[1], Toast.LENGTH_SHORT).show();
                                        break;
                                    case 2:
                                        Toast.makeText(DialogTwoStyleActivity.this, "您选中了：" + items[2], Toast.LENGTH_SHORT).show();
                                        break;
                                }
                            }
                        })
                        .show();
            }
        });

        /**
         * 单选项列表对话框
         *
         * 在对话框中列出单选按钮，让用户选择。
         */
        radiolistbtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[]{"苹果","香蕉","梨子"};

                new AlertDialog.Builder(DialogTwoStyleActivity.this)
                        .setTitle("单选框")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        Toast.makeText(DialogTwoStyleActivity.this, "您选中了：" + items[0], Toast.LENGTH_SHORT).show();
                                        break;
                                    case 1:
                                        Toast.makeText(DialogTwoStyleActivity.this, "您选中了：" + items[1], Toast.LENGTH_SHORT).show();
                                        break;
                                    case 2:
                                        Toast.makeText(DialogTwoStyleActivity.this, "您选中了：" + items[2], Toast.LENGTH_SHORT).show();
                                        break;
                                }
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
            }
        });

        /**
         * 多选选列表对话框
         *
         * 在对话框中列出复选框，让用户选择
         */
        mutlistbtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = new String[]{"音乐","电影","书籍"};
                final boolean[] selected = new boolean[]{true,false,true};

                new AlertDialog.Builder(DialogTwoStyleActivity.this)
                        .setTitle("复选框")
                        .setMultiChoiceItems(items,selected, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                selected[which] = isChecked;
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                StringBuffer str = new StringBuffer("您选中了：");

                                for(int i=0;i<3;i++){
                                    if(selected[i]){
                                        str.append(items[i]+",");
                                    }
                                }

                                str.deleteCharAt(str.length()-1);
                                Toast.makeText(DialogTwoStyleActivity.this, str, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
            }
        });

        /**
         * 自定义对话框内容
         */
        diybtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(DialogTwoStyleActivity.this); // 创建视图容器并设置上下文
                final View view = layoutInflater.inflate(R.layout.dialog_two_custom_layout,null); // 获取list_item布局文件的视图

                new AlertDialog.Builder(DialogTwoStyleActivity.this)
                        .setTitle("自定义布局")
                        .setView(view)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText editText = (EditText) view.findViewById(R.id.likeText);
                                Toast.makeText(DialogTwoStyleActivity.this, "您的爱好是：" + editText.getText(), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
            }
        });
    }

    /**
     * 按返回键退出，弹出对话框
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            new AlertDialog.Builder(DialogTwoStyleActivity.this)
                    .setIcon(android.R.drawable.btn_dialog)
                    .setTitle("提示")
                    .setMessage("确定退出么？")
                    .setPositiveButton("确定",new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    DialogTwoStyleActivity.this.finish();
                                }
                            })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                    .show();// show很关键
        }

        return super.onKeyDown(keyCode, event);
    }

}
