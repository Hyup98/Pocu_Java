package academy.pocu.comp2500.lab8;

public class Schedule {
    private int start;
    private int operateTime;

    public Schedule(int start, int operateTime) {
        this.start = start;
        this.operateTime = operateTime;
    }

    public int getOperateTime() {
        return operateTime;
    }

    public int getStart() {
        return start;
    }
}
