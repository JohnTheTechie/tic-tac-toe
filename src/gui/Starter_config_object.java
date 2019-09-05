package gui;

public class Starter_config_object {
    private boolean playFirst;
    private boolean vsComp;
    private boolean remote;

    public Starter_config_object() {
    }

    public Starter_config_object(boolean playFirst, boolean vsComp, boolean remote) {
        this.playFirst = playFirst;
        this.vsComp = vsComp;
        this.remote = remote;
    }

    public boolean isPlayFirst() {
        return playFirst;
    }

    public void setPlayFirst(boolean playFirst) {
        this.playFirst = playFirst;
    }

    public boolean isVsComp() {
        return vsComp;
    }

    public void setVsComp(boolean vsComp) {
        this.vsComp = vsComp;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }
}
