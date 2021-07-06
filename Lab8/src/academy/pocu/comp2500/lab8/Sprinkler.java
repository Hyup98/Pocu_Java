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
                schedules.add(schedule);
            }
        }
    }

    public void spray(Planter planter) {
        if (planter != null) {
            planter.addWater();
        }
    }

    @Override
    public boolean isOn() {
        if (schedules.size() == 0) {
            return false;
        }
        if (isOn == false && schedules.get(flag).getStart() == getTictak()) {
            isOn = true;
            if (planter != null) {
                spray(planter);
            }
            setOnTime(getTictak());
            return isOn;
        } else if (isOn == true && (schedules.get(flag).getStart() + schedules.get(flag).getOperateTime()) > getTictak()) {
            spray(planter);
            return isOn;
        } else if (isOn == true && (schedules.get(flag).getStart() + schedules.get(flag).getOperateTime()) == getTictak()) {
            isOn = false;
            setOnTime(getTictak());
            for (int i = flag + 1; i < schedules.size(); i++) {
                if (schedules.get(i).getStart() > getTictak()) {
                    flag = i;
                    break;
                }
            }
            return isOn;
        } else if (isOn == false && schedules.get(flag).getStart() < getTictak()) {
            return isOn;
        } else {
            return isOn;
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
