package mgd.ylc.com.mvpgreendaodagger2.greendao;

import android.text.TextUtils;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "User")
public class User {

    //@Id：主键，通过这个注解标记的字段必须是Long类型的，这个字段在数据库中表示它就是主键，并且它默认就是自增的
    @Id(autoincrement = true)
    private Long id;

    @NotNull    // @NotNull 设置数据库表当前列不能为空
    @Unique  //唯一
    private String name;
    @Property(nameInDb = "sex") //@Property：设置一个非默认关系映射所对应的列名，默认是使用字段名，例如：@Property(nameInDb = "sex")
    private String sex;
    @Property(nameInDb = "age")
    private String age;
    @Property(nameInDb = "height")
    private String height;
    @Property(nameInDb = "weight")
    private String weight;
    @Transient//@Transient：表明这个字段不会被写入数据库，只是作为一个普通的java类字段，用来临时存储数据的，不会被持久化
    private String like;
    @Generated(hash = 1397536065)
    public User(Long id, @NotNull String name, String sex, String age, String height, String weight) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getHeight() {
        return this.height;
    }
    public void setHeight(String height) {
        this.height = height;
    }
    public String getWeight() {
        return this.weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nid:").append(id).append("\n")
                .append("姓名:").append(name).append("\n")
                .append("性别:").append(sex).append("\n")
                .append("年龄:").append(age).append("\n")
                .append("身高:").append(height).append("\n")
                .append("体重:").append(weight).append("\n");
        if(!TextUtils.isEmpty(like))sb.append("喜好:").append(like).append("\n");
        return sb.toString();
    }
}
