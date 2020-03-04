package com.example.navigationdemo_2;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // 获取按钮并设置点击事件
        getView().findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取输入框
                EditText editText = getView().findViewById(R.id.editText);
                // 获取输入内容
                String string = editText.getText().toString();
                // 判断输入内容是否为空
                if (TextUtils.isEmpty(string)){
                    // 为空提示
                    Toast.makeText(getContext(),"请输入名字！",Toast.LENGTH_SHORT).show();
                    return;
                }
                // 使用Bundle绑定数据
                Bundle bundle = new Bundle();
                bundle.putString("my_name",string);
                // 创建navigation动作
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_homeFragment_to_detailFragment,bundle);
            }
        });
    }
}
