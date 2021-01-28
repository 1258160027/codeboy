package com.yang.codeboy.aqs;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-17
 */
public class LeLock {

    private static class Sync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg){
            return compareAndSetState(0,1);
        }
        @Override
        protected boolean tryRelease(int arg){
            setState(0);
            return true;
        }
        @Override
        protected boolean isHeldExclusively(){
            return getState() == 1;
        }
    }

    private Sync sync = new Sync();

    public void lock(){
        sync.acquire(1);
    }

    public void  unlock(){
        sync.release(1);
    }
}
