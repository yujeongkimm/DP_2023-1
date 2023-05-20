package hw.ch19;

// 야식시간
public class NightMealState implements State{
    private static NightMealState singleton = new NightMealState();

    private NightMealState() {
    }

    public static State getInstance() {
        return singleton;
    }

    // 시각 설정하는 메소드 
    @Override
    public void doClock(Context context, int hour) {
        // night
        if ( (0 <= hour && hour < 9) || (17 <= hour && hour < 20) ) {
            context.changeState(NightState.getInstance());
        } else if ( 9 <= hour && hour < 12 || 13 <= hour && hour < 17 ) {
            // day 
            context.changeState(DayState.getInstance());
        } else if ( 12 <= hour && hour < 13 ) {
            // noon
            context.changeState(NoonState.getInstance());
        }
    }

    // 금고 사용했음을 기록 
    @Override
    public void doUse(Context context) {
        context.recordLog("금고 사용(야식)");   // (1) 기록 
        context.callSecurityCenter("비상：야식시간 금고 사용！");   // (2) 통보 
    }

    // 비상벨로 경비센터를 호출함 
    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(야식 시간)");
    }

    // 경비센터에 자동응답기 호출
    @Override
    public void doPhone(Context context) {
        context.recordLog("야식 시간 통화 녹음");
    }

    // 추가
    @Override
    public void doCCTV(Context context) {
        context.recordLog("CCTV: Off");
    }
    
    @Override
    public String toString() {
        return "[야식시간]";
    }
}
