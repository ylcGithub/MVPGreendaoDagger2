package mgd.ylc.com.mvpgreendaodagger2;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.ylc.test.db.gen.DaoMaster;
import com.ylc.test.db.gen.DaoSession;

public class MyApplication extends Application {
    public static final String DB_NAME = "ylcStudyApp.db";
    private static DaoSession mDaoSession;
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        initGreenDao();
        mContext = this;
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, DB_NAME);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();
    }

    public static DaoSession getmDaoSession() {
        return mDaoSession;
    }

    public static Context getContext(){
        return mContext;
    }
}
