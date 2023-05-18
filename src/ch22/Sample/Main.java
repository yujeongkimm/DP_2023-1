package ch22.Sample;

import ch22.Sample.command.*;
import ch22.Sample.drawer.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements MouseMotionListener, WindowListener {
// 이미 다른 것 상속 받으니깐 WindowAdapter 적용 안된다!
//public class Main extends JFrame, windowAdapter implements MouseMotionListener {  
    private MacroCommand history = new MacroCommand();
    // 그리는 영역 
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 삭제 버튼
    private JButton clearButton  = new JButton("clear");

    // 생성자 
    // GUI 구성
    public Main(String title) {
        super(title);

        // 리스너 등록
        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        
        // ActionListener는 function interface(actionPerformed 하나만 선언되어 있기 때문)
        // functional Interface가 들어갈 자리에는 람다식을 넣을 수 있다. 
        clearButton.addActionListener(e -> {
            history.clear();
            canvas.repaint();   // (1) 내용이 지워짐  (2)paint() 자동으로 호출됨 
        });

        // GUI 컴포넌트 추가 
        Box buttonBox = new Box(BoxLayout.X_AXIS);  // 가로로 배치하겠다.
        buttonBox.add(clearButton);
        
        Box mainBox = new Box(BoxLayout.Y_AXIS);    // 세로로 배치하겠다. 
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    // 1. MouseMotionListener용
    @Override   
    public void mouseMoved(MouseEvent e) {
        // 마우스 누르지 않은 상태로 움직임
    }

    // 우리가 필요한 것
    @Override
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());    // 어느 좌표에 빨간점이 그려졌다는 명령어
        
        System.out.println("드래그이벤트 발생: X좌표: " + e.getPoint().getX());
        System.out.println("드래그이벤트 발생: Y좌표: " + e.getPoint().getY());
        
        history.append(cmd);
        cmd.execute();
    }

    // 2. WindowListener용 
    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("윈도우가 닫힙니다.");
        System.exit(0);
    }

    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {
        System.out.println("윈도우가 미니마이즈됩니다.");
    }
    @Override public void windowOpened(WindowEvent e) {}

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
