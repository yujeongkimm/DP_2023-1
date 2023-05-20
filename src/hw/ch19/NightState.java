package hw.ch19;

public class NightState implements State {
    private static NightState singleton = new NightState();

    private NightState() {
    }

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (12 <= hour && hour < 13) {  // noon
            context.changeState(NoonState.getInstance());
        } else if (9 <= hour && hour < 17) { // day
            //
            context.changeState(DayState.getInstance());
        } else if (20 <= hour && hour < 24) {
            // NightMeal
            context.changeState(NightMealState.getInstance());
       }
    }

    // 추가
    @Override
    public void doCCTV(Context context) {
        context.recordLog("CCTV: 해상도 1200 dpi로 변경");
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("비상：야간 금고 사용！");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(야간)");
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("야간 통화 녹음");
    }

    @Override
    public String toString() {
        return "[야간]";
    }
}
