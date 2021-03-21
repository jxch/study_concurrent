package org.jxch.study.concurrent.jit;

/**
 * 验证 JIT 的锁消除优化
 *
 * @author jxch
 * @since 1.8
 */
public class LockElimination {
    private static int I = 0;

    public void justIPlus() {
        I++;
    }

    public void syncLocalLockIPlus() {
        Object o = new Object();
        synchronized (o) {
            I++;
        }
    }

    private static final Object LOCK = new Object();
    public void syncStaticLockIPlus() {
        synchronized (LOCK) {
            I++;
        }
    }
}
