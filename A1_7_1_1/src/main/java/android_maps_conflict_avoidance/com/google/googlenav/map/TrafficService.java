package android_maps_conflict_avoidance.com.google.googlenav.map;

import android_maps_conflict_avoidance.com.google.common.Clock;
import android_maps_conflict_avoidance.com.google.common.Config;
import android_maps_conflict_avoidance.com.google.common.Log;
import android_maps_conflict_avoidance.com.google.common.OutOfMemoryHandler;
import android_maps_conflict_avoidance.com.google.common.StaticUtil;
import android_maps_conflict_avoidance.com.google.common.task.TaskRunner;
import android_maps_conflict_avoidance.com.google.common.task.TimerTask;
import android_maps_conflict_avoidance.com.google.googlenav.android.TaskRunnerManager;
import android_maps_conflict_avoidance.com.google.googlenav.datarequest.DataRequestDispatcher;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/*  JADX ERROR: NullPointerException in pass: ReSugarCode
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ReSugarCode.initClsEnumMap(ReSugarCode.java:159)
    	at jadx.core.dex.visitors.ReSugarCode.visit(ReSugarCode.java:44)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
    	at jadx.core.ProcessClass.process(ProcessClass.java:32)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ExtractFieldInit.checkStaticFieldsInit(ExtractFieldInit.java:58)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:44)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
    	at jadx.core.ProcessClass.process(ProcessClass.java:32)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
    */
public class TrafficService implements OutOfMemoryHandler, Runnable {
    private static final TrafficRoad[] EMPTY_TRAFFICROAD_ARRAY = null;
    private final Hashtable cache;
    private long nextRefreshTime;
    private final long refreshMillis;
    private volatile TrafficTileRequest request;
    private final Hashtable requestedTiles;
    private volatile boolean stopCleanCache;
    private final TimerTask timerTask;

    private class TrafficTileRequest extends BaseTileRequest {
        private final Vector tiles = new Vector();

        public TrafficTileRequest() {
            super(26, (byte) 4);
        }

        public void writeRequestData(DataOutput dos) throws IOException {
            Tile[] tileList = new Tile[this.tiles.size()];
            for (int i = 0; i < this.tiles.size(); i++) {
                tileList[i] = ((TrafficTile) this.tiles.elementAt(i)).getLocation();
            }
            writeRequestForTiles(tileList, dos);
        }

        protected boolean processDownloadedTile(int tileIndex, Tile tile, byte[] data) throws IOException {
            TrafficTile tt = (TrafficTile) TrafficService.this.requestedTiles.get(tile);
            if (tt == null) {
                tt = new TrafficTile(tile);
            } else if (tt.isComplete()) {
                tt = new TrafficTile(tile);
            }
            if (data.length == 0) {
                tt.setData(Config.getInstance().getClock().relativeTimeMillis(), TrafficService.EMPTY_TRAFFICROAD_ARRAY);
            } else {
                tt.readData(data);
            }
            synchronized (this) {
                TrafficService.this.cache.put(tile, tt);
                TrafficService.this.requestedTiles.remove(tile);
            }
            TrafficService.this.notifyDownloadedTile();
            return false;
        }

        protected void setTileEditionAndTextSize(int tileEdition, int textSize) {
        }

        protected void handleEndOfResponse(int tileIndex) {
        }

        public void addTile(TrafficTile trafficTile) {
            this.tiles.addElement(trafficTile);
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: android_maps_conflict_avoidance.com.google.googlenav.map.TrafficService.<clinit>():void, dex: 
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:118)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:248)
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
        	... 5 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: android_maps_conflict_avoidance.com.google.googlenav.map.TrafficService.<clinit>():void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: android_maps_conflict_avoidance.com.google.googlenav.map.TrafficService.<clinit>():void");
    }

    public TrafficService(long refreshMillis, TaskRunner taskRunner) {
        this.stopCleanCache = true;
        this.refreshMillis = refreshMillis;
        this.nextRefreshTime = Long.MIN_VALUE;
        this.cache = new Hashtable();
        this.requestedTiles = new Hashtable();
        StaticUtil.registerOutOfMemoryHandler(this);
        this.timerTask = new TimerTask(taskRunner, this);
        this.timerTask.setDelay(20113);
        start();
    }

    public void close() {
        StaticUtil.removeOutOfMemoryHandler(this);
        stop();
    }

    public synchronized TrafficTile getTile(Tile tile, boolean fetch) {
        TrafficTile trafficTile;
        if (tile.getZoom().getZoomLevel() > 20) {
            trafficTile = null;
        } else {
            trafficTile = (TrafficTile) this.cache.get(tile);
            TrafficTile queuedTile = (TrafficTile) this.requestedTiles.get(tile);
            if (trafficTile != null) {
                Clock clock = Config.getInstance().getClock();
                long tileDataTime = trafficTile.getDataTime();
                long dataAge = clock.relativeTimeMillis() - tileDataTime;
                if (fetch && queuedTile == null && tileDataTime != Long.MIN_VALUE && dataAge > this.refreshMillis / 2 && (clock.relativeTimeMillis() > this.nextRefreshTime || this.request != null)) {
                    requestTile(tile, trafficTile);
                }
            } else if (queuedTile != null) {
                trafficTile = queuedTile;
            } else {
                trafficTile = new TrafficTile(tile);
                if (fetch) {
                    requestTile(tile, trafficTile);
                }
            }
        }
        return trafficTile;
    }

    private synchronized void requestTile(Tile tile, TrafficTile trafficTile) {
        if (this.request == null) {
            this.request = new TrafficTileRequest();
        }
        this.request.addTile(trafficTile);
        this.requestedTiles.put(tile, trafficTile);
    }

    public synchronized void requestTiles() {
        if (this.request != null) {
            DataRequestDispatcher.getInstance().addDataRequest(this.request);
            this.request = null;
            this.nextRefreshTime = Config.getInstance().getClock().relativeTimeMillis() + this.refreshMillis;
        }
    }

    private void notifyDownloadedTile() {
        if (!this.stopCleanCache && this.timerTask.isUnscheduled()) {
            this.timerTask.schedule();
        }
    }

    synchronized void cleanCache(long maxAge) {
        Enumeration tiles = this.cache.keys();
        while (tiles.hasMoreElements()) {
            Tile tile = (Tile) tiles.nextElement();
            if (Config.getInstance().getClock().relativeTimeMillis() - ((TrafficTile) this.cache.get(tile)).getLastAccess() > maxAge) {
                this.cache.remove(tile);
            }
        }
    }

    public void run() {
        try {
            cleanCache(60000);
        } catch (Exception e) {
            Log.logQuietThrowable("TrafficService BG", e);
        } catch (OutOfMemoryError e2) {
            StaticUtil.handleOutOfMemory();
        }
    }

    public void handleOutOfMemory(boolean warning) {
        this.cache.clear();
    }

    public synchronized void start() {
        this.stopCleanCache = false;
    }

    public synchronized void stop() {
        this.stopCleanCache = true;
        TaskRunnerManager.getTaskRunner().cancelTask(this.timerTask);
    }
}