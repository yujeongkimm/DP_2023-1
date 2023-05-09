package ch19.Sample;

public class NightState implements State {
    private static NightState singleton = new NightState();

    private NightState() {
    }

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (9 <= hour && hour < 17) {   // 주간에 해당하면 
            context.changeState(DayState.getInstance());    // 주간으로 상태를 바꿔라
        }
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
