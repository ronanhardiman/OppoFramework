package java.util;

import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;

final /* synthetic */ class -$Lambda$aUGKT4ItCOku5-JSG-x8Aqj2pJw implements IntConsumer {
    private final /* synthetic */ byte $id;
    /* renamed from: -$f0 */
    private final /* synthetic */ Object f139-$f0;
    /* renamed from: -$f1 */
    private final /* synthetic */ Object f140-$f1;

    private final /* synthetic */ void $m$0(int arg0) {
        ((double[]) this.f139-$f0)[arg0] = ((IntToDoubleFunction) this.f140-$f1).applyAsDouble(arg0);
    }

    private final /* synthetic */ void $m$1(int arg0) {
        ((int[]) this.f139-$f0)[arg0] = ((IntUnaryOperator) this.f140-$f1).applyAsInt(arg0);
    }

    private final /* synthetic */ void $m$2(int arg0) {
        ((long[]) this.f139-$f0)[arg0] = ((IntToLongFunction) this.f140-$f1).applyAsLong(arg0);
    }

    private final /* synthetic */ void $m$3(int arg0) {
        ((Object[]) this.f139-$f0)[arg0] = ((IntFunction) this.f140-$f1).apply(arg0);
    }

    public /* synthetic */ -$Lambda$aUGKT4ItCOku5-JSG-x8Aqj2pJw(byte b, Object obj, Object obj2) {
        this.$id = b;
        this.f139-$f0 = obj;
        this.f140-$f1 = obj2;
    }

    public final void accept(int i) {
        switch (this.$id) {
            case (byte) 0:
                $m$0(i);
                return;
            case (byte) 1:
                $m$1(i);
                return;
            case (byte) 2:
                $m$2(i);
                return;
            case (byte) 3:
                $m$3(i);
                return;
            default:
                throw new AssertionError();
        }
    }
}
