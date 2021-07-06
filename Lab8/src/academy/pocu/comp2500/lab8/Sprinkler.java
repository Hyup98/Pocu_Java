package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Sprinkler extends SmartDevice implements ISprayable {
    private ArrayList<Schedule> schedules = new ArrayList<>();
    private Planter planter;
    private boolean isOn;
    private int flag;

    public Sprinkler() {
        super(1);
        this.flag = 0;
        this.isOn = false;
    }

    public void addSchedule(Schedule schedule) {
        if (schedule != null) {
            if (schedule.getStart() != 0) {
                if (schedule.getOperateTime() != 0) {
                    schedules.add(schedule);
                }
            }
        }
    }

    public int getSchedulesSize() {
        return schedules.size();
    }

    public void spray(Planter planter) {
        if (planter != null) {
            planter.addWater();
        }
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    public void run() {
        if (schedules.size() == 0) {
            return;
        }
        if (isOn == false && schedules.get(flag).getStart() == getTictak()) {
            isOn = true;
            if (planter != null) {
                spray(planter);
            }
            setOnTime(getTictak());

        } else if (isOn == true && (schedules.get(flag).getStart() + schedules.get(flag).getOperateTime()) > getTictak()) {
            spray(planter);

        } else if (isOn == true && (schedules.get(flag).getStart() + schedules.get(flag).getOperateTime()) == getTictak()) {
            isOn = false;
            setOnTime(getTictak());
            for (int i = flag + 1; i < schedules.size(); i++) {
                if (schedules.get(i).getStart() + schedules.get(i).getOperateTime() > getTictak()) {
                    flag = i;
                    break;
                }
            }

        } else {
            return;
        }
    }

    public void setPlanter(Planter planter) {
        this.planter = planter;
    }

    @Override
    public int getTicksSinceLastUpdate() {
        return getTictak() - getOnTime();
    }


}
