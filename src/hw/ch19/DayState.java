package hw.ch19;

public class DayState implements State {
    private static DayState singleton = new DayState();

    private DayState() {
    }

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        // 야간 범위 변경 
        if ( (0 <= hour && hour < 9) || (17 <= hour && hour < 20) ) {
            context.changeState(NightState.getInstance());
        }
        else if (12 <= hour && hour < 13) {
            // 
            context.changeState(NoonState.getInstance());
        } else if (20 <= hour && hour < 24) {
             // NightMeal
             context.changeState(NightMealState.getInstance());
        }

    }

    // 추가
    @Override
    public void doCCTV(Context context) {
        context.recordLog("CCTV: 해상도 600 dpi로 변경");
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("금고 사용(주간)");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(주간)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("일반 통화(주간)");
    }

    @Override
    public String toString() {
        return "[주간]";
    }
}
