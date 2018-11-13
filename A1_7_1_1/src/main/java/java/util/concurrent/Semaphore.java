package java.util.concurrent;

import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:546)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:221)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:121)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
    	at jadx.core.ProcessClass.process(ProcessClass.java:32)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
    */
public class Semaphore implements Serializable {
    private static final long serialVersionUID = -3222578661600680210L;
    private final Sync sync;

    static abstract class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = 1192457210091910933L;

        Sync(int permits) {
            setState(permits);
        }

        final int getPermits() {
            return getState();
        }

        final int nonfairTryAcquireShared(int acquires) {
            int remaining;
            int available;
            do {
                available = getState();
                remaining = available - acquires;
                if (remaining < 0) {
                    break;
                }
            } while (!compareAndSetState(available, remaining));
            return remaining;
        }

        protected final boolean tryReleaseShared(int releases) {
            int current;
            int next;
            do {
                current = getState();
                next = current + releases;
                if (next < current) {
                    throw new Error("Maximum permit count exceeded");
                }
            } while (!compareAndSetState(current, next));
            return true;
        }

        final void reducePermits(int reductions) {
            int current;
            int next;
            do {
                current = getState();
                next = current - reductions;
                if (next > current) {
                    throw new Error("Permit count underflow");
                }
            } while (!compareAndSetState(current, next));
        }

        final int drainPermits() {
            int current;
            do {
                current = getState();
                if (current == 0) {
                    break;
                }
            } while (!compareAndSetState(current, 0));
            return current;
        }
    }

    static final class FairSync extends Sync {
        private static final long serialVersionUID = 2014338818796000944L;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: java.util.concurrent.Semaphore.FairSync.<init>(int):void, dex: 
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:118)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:248)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:254)
            	at jadx.core.ProcessClass.process(ProcessClass.java:29)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:581)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:74)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:104)
            	... 6 more
            */
        FairSync(int r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: java.util.concurrent.Semaphore.FairSync.<init>(int):void, dex: 
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.Semaphore.FairSync.<init>(int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: java.util.concurrent.Semaphore.FairSync.tryAcquireShared(int):int, dex: 
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:118)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:248)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:254)
            	at jadx.core.ProcessClass.process(ProcessClass.java:29)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:581)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:74)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:104)
            	... 6 more
            */
        protected int tryAcquireShared(int r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: java.util.concurrent.Semaphore.FairSync.tryAcquireShared(int):int, dex: 
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.Semaphore.FairSync.tryAcquireShared(int):int");
        }
    }

    static final class NonfairSync extends Sync {
        private static final long serialVersionUID = -2694183684443567898L;

        NonfairSync(int permits) {
            super(permits);
        }

        protected int tryAcquireShared(int acquires) {
            return nonfairTryAcquireShared(acquires);
        }
    }

    public Semaphore(int permits) {
        this.sync = new NonfairSync(permits);
    }

    public Semaphore(int permits, boolean fair) {
        this.sync = fair ? new FairSync(permits) : new NonfairSync(permits);
    }

    public void acquire() throws InterruptedException {
        this.sync.acquireSharedInterruptibly(1);
    }

    public void acquireUninterruptibly() {
        this.sync.acquireShared(1);
    }

    public boolean tryAcquire() {
        return this.sync.nonfairTryAcquireShared(1) >= 0;
    }

    public boolean tryAcquire(long timeout, TimeUnit unit) throws InterruptedException {
        return this.sync.tryAcquireSharedNanos(1, unit.toNanos(timeout));
    }

    public void release() {
        this.sync.releaseShared(1);
    }

    public void acquire(int permits) throws InterruptedException {
        if (permits < 0) {
            throw new IllegalArgumentException();
        }
        this.sync.acquireSharedInterruptibly(permits);
    }

    public void acquireUninterruptibly(int permits) {
        if (permits < 0) {
            throw new IllegalArgumentException();
        }
        this.sync.acquireShared(permits);
    }

    public boolean tryAcquire(int permits) {
        if (permits < 0) {
            throw new IllegalArgumentException();
        } else if (this.sync.nonfairTryAcquireShared(permits) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean tryAcquire(int permits, long timeout, TimeUnit unit) throws InterruptedException {
        if (permits >= 0) {
            return this.sync.tryAcquireSharedNanos(permits, unit.toNanos(timeout));
        }
        throw new IllegalArgumentException();
    }

    public void release(int permits) {
        if (permits < 0) {
            throw new IllegalArgumentException();
        }
        this.sync.releaseShared(permits);
    }

    public int availablePermits() {
        return this.sync.getPermits();
    }

    public int drainPermits() {
        return this.sync.drainPermits();
    }

    protected void reducePermits(int reduction) {
        if (reduction < 0) {
            throw new IllegalArgumentException();
        }
        this.sync.reducePermits(reduction);
    }

    public boolean isFair() {
        return this.sync instanceof FairSync;
    }

    public final boolean hasQueuedThreads() {
        return this.sync.hasQueuedThreads();
    }

    public final int getQueueLength() {
        return this.sync.getQueueLength();
    }

    protected Collection<Thread> getQueuedThreads() {
        return this.sync.getQueuedThreads();
    }

    public String toString() {
        return super.toString() + "[Permits = " + this.sync.getPermits() + "]";
    }
}