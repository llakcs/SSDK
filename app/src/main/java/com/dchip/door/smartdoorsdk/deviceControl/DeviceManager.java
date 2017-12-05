package com.dchip.door.smartdoorsdk.deviceControl;

import com.dchip.door.smartdoorsdk.deviceControl.interfaces.LockHandler;

/**
 * Created by llakcs on 2017/12/5.
 */

public interface DeviceManager {

    void setLock(LockHandler lock);
    void setLock(String config);
    LockHandler getLock();

}
