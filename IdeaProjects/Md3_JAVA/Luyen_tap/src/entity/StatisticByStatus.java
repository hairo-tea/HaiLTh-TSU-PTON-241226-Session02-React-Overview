package entity;

public class StatisticByStatus {
    private Boolean status;
    private int cntStatus;

    public StatisticByStatus() {
    }
    public StatisticByStatus(Boolean status, int cntStatus) {
        this.status = status;
        this.cntStatus = cntStatus;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public int getCntStatus() {
        return cntStatus;
    }
    public void setCntStatus(int cntStatus) {
        this.cntStatus = cntStatus;
    }
    @Override
    public String toString() {
        return String.format("status: %s, cntStatus: %s", status, cntStatus);
    }
}
