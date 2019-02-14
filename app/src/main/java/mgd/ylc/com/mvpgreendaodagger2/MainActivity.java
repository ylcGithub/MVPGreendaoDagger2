package mgd.ylc.com.mvpgreendaodagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import mgd.ylc.com.mvpgreendaodagger2.greendao.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText et_id, et_name, et_sex, et_age, et_height, et_weight;
    private TextView tv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = findViewById(R.id.et_id);
        et_name = findViewById(R.id.et_name);
        et_sex = findViewById(R.id.et_sex);
        et_age = findViewById(R.id.et_age);
        et_height = findViewById(R.id.et_height);
        et_weight = findViewById(R.id.et_weight);
        Button btn_add = findViewById(R.id.btn_add);
        Button btn_delete = findViewById(R.id.btn_delete);
        Button btn_update = findViewById(R.id.btn_update);
        Button btn_search = findViewById(R.id.btn_search);
        Button btn_clean = findViewById(R.id.btn_clean);
        btn_add.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_search.setOnClickListener(this);
        btn_clean.setOnClickListener(this);

        tv_show = findViewById(R.id.tv_show);
        et_id.requestFocus();

        //添加依赖关系 dagger2
//        DaggerMainComponent.create().inject(this);
//        DaggerMainComponent.builder().build().inject(this);//第二种注解方式


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                long add_id = MyApplication.getmDaoSession().insertOrReplace(getUser());
                Toast.makeText(this, String.valueOf(add_id), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_delete:
                String id = getString(et_id);
                if (!TextUtils.isEmpty(getString(et_id))) {
                    MyApplication.getmDaoSession().getUserDao().deleteByKey(Long.parseLong(id));
                } else {
                    Toast.makeText(this, "主键不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_update:
                long update_id = MyApplication.getmDaoSession().insertOrReplace(getUser());
                Toast.makeText(this, String.valueOf(update_id), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_search:
                List<User> list = MyApplication.getmDaoSession().getUserDao().loadAll();
                tv_show.setText("");
                for (User user : list) {
                    tv_show.append(user.toString());
                }
                break;
            case R.id.btn_clean:
                et_id.setText("");
                et_name.setText("");
                et_sex.setText("");
                et_age.setText("");
                et_height.setText("");
                et_weight.setText("");
                tv_show.setText("");
                break;
            default:
                break;
        }
    }

    private User getUser() {
        User user = new User(TextUtils.isEmpty(getString(et_id)) ? null : Long.parseLong(getString(et_id)), getString(et_name), getString(et_sex), getString(et_age), getString(et_height), getString(et_weight));
        user.setLike("喜欢打球");
        return user;
    }

    private String getString(EditText et) {
        return et.getText().toString();
    }
}
