package hw.ch22.drawer;

import hw.ch22.command.Command;
import java.awt.Color;

public class ColorCommand implements Command {
    // 그리기 대상 
    protected Drawable drawable;
    // 그리기 색 
    private Color color;

    // 생성자 
    public ColorCommand(Drawable drawable, Color color) {
        this.drawable = drawable;
        this.color = color;
    }

    // 실행 
    /*
     * 색깔 변경될 때 실행되는 코드
     */
    @Override
    public void execute() {
        drawable.setColor(color);
    }
}
