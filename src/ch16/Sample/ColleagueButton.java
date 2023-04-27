package ch16.Sample;

import java.awt.Button;

public class ColleagueButton extends Button implements Colleague {
    private Mediator mediator;  // 보고 하기 위해서

    public ColleagueButton(String caption) {
        super(caption);
    }

    // Mediator를 설정한다 
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator에서 활성/비활성을 지시한다
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);    // Button으로 상속받은 메소드
    }
}
