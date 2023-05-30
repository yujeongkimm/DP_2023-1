package hw.ch22;

import hw.ch22.command.*;
import hw.ch22.drawer.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements MouseMotionListener, WindowListener {
    /**
     * 
     */
    // 그리기 이력 
    private MacroCommand history = new MacroCommand();
    // 그리는 영역 
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 삭제 버튼
    private JButton clearButton  = new JButton("clear");
    // 실행 취소 버튼(undo)
    private JButton undoButton  = new JButton("undo");
    // redo 버튼
    private JButton redoButton  = new JButton("redo");

    // 빨간 버튼 
    private JButton redButton  = new JButton("red");
    // 초록 버튼
    private JButton greenButton  = new JButton("green");
    // 파란 버튼
    private JButton blueButton  = new JButton("blue");

    // 생성자 
    public Main(String title) {
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);

        // 색깔 초기화
        history.append(new ColorCommand(canvas, Color.red));


        /**
         * 
         */
        clearButton.addActionListener(e -> {
            history.clear();
            canvas.repaint();
            // 색깔 초기화
            history.append(new ColorCommand(canvas, Color.red));
        });
        
        // 
        undoButton.addActionListener(e -> {
            history.undo();
            canvas.repaint();   // paint() 호출 
        });

        //
        redoButton.addActionListener(e -> {
            history.redo();
            canvas.repaint();
        });

        // 색깔 버튼
        redButton.addActionListener(e -> {
            Command cmd = new ColorCommand(canvas, Color.red);  // Color 인자 추가
            history.append(cmd);
            cmd.execute();  // color 지정
        });
        greenButton.addActionListener(e -> {
            Command cmd = new ColorCommand(canvas, Color.green);
            history.append(cmd);
            cmd.execute();
        });
        blueButton.addActionListener(e -> {
            Command cmd = new ColorCommand(canvas, Color.blue);
            history.append(cmd);
            cmd.execute();
        });


        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(undoButton);  //

        buttonBox.add(redoButton);  //

        buttonBox.add(redButton);
        buttonBox.add(greenButton);
        buttonBox.add(blueButton);

        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    // MouseMotionListener용 
    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }

    // WindowListener용
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowOpened(WindowEvent e) {}

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
