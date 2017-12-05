package com.dchip.door.smartdoorsdk.deviceControl;

import com.dchip.door.smartdoorsdk.deviceControl.interfaces.LockHandler;
import com.dchip.door.smartdoorsdk.s;
import com.dchip.door.smartdoorsdk.utils.LogUtil;

/**
 * Created by llakcs on 2017/12/5.
 */

public class DeviceImpl implements DeviceManager {
    //锁类型：1=电插锁 2=电磁力锁 3=电机锁
    private LockHandler mLockHandker;
    private static String TAG="DeviceImpl";
    private static final Object lock = new Object();
    private static volatile DeviceImpl instance;
    private DeviceImpl(){

    }

    public static void registerInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new DeviceImpl();
                }
            }
        }
        s.Ext.setDeviceManager(instance);
    }

    @Override
    public void setLock(LockHandler lock) {
        this.mLockHandker = lock;
        mLockHandker.closeLock();
    }

    @Override
    public void setLock(String config) {
        if (config!=null){
            LogUtil.e(TAG,"读取锁配置："+config);
            String arg[] = config.split("/");
            if (arg.length != 5) return;
            int lockArg = Integer.parseInt(arg[0]);
            int doorArg = Integer.parseInt(arg[1]);
            int oriLockArg = Integer.parseInt(arg[2]);
            boolean isSign = Boolean.parseBoolean(arg[3]);
            switch(arg[4]){
                case "1":setLock(new BoltLockHandler().setDefaultStatus(lockArg,doorArg,oriLockArg,isSign));break;
                case "2":setLock(new MagneticLockHandler().setDefaultStatus(lockArg,doorArg,oriLockArg,isSign));break;
                case "3":setLock(new MotorLockHandler().setDefaultStatus(lockArg,doorArg,oriLockArg,isSign));break;
            }}
    }

    @Override
    public LockHandler getLock() {
        return mLockHandker;
    }

}
