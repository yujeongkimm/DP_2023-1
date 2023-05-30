package hw.ch22.command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import hw.ch22.drawer.ColorCommand;

public class MacroCommand implements Command {
    // 명령의 배열 
    private Deque<Command> commands = new ArrayDeque<>();
    // undo 시 삭제되었던 명령어들 보관하는 변수
    private Deque<Command> commandsForRedo = new ArrayDeque<>();

    // 실행 
    @Override
    public void execute() {
        Iterator <Command> itr = commands.descendingIterator();
        while (itr.hasNext()) {
            Command cmd = itr.next();
            cmd.execute();
        }
    }

    // 추가 
    public void append(Command cmd) {
        if (cmd == this) {
            throw new IllegalArgumentException("infinite loop caused by append");
        }
        commands.push(cmd);
    }

    // 수정!
    // 마지막 명령을 삭제
    public void undo() {
        if (!commands.isEmpty()) {
            Command pop = commands.pop();
            commandsForRedo.add(pop);
        }
    }

    // 추가
    public void redo() {
        if (!commandsForRedo.isEmpty()) {
            Command pop = commandsForRedo.pop();
            commands.add(pop);
        }
    }

    // 전부 삭제 
    public void clear() {
        commands.clear();
    }
}
