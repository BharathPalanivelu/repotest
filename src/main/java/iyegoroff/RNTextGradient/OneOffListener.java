package iyegoroff.RNTextGradient;

class OneOffListener {
    private Runnable mRemoval;
    private Runnable mUpdate;

    OneOffListener(Runnable runnable) {
        this.mUpdate = runnable;
    }

    /* access modifiers changed from: package-private */
    public void addRemoval(Runnable runnable) {
        this.mRemoval = runnable;
    }

    /* access modifiers changed from: package-private */
    public void trigger() {
        Runnable runnable = this.mUpdate;
        if (runnable != null) {
            runnable.run();
        }
        Runnable runnable2 = this.mRemoval;
        if (runnable2 != null) {
            runnable2.run();
        }
    }
}
