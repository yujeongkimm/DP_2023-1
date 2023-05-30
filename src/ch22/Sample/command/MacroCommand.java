package ch22.Sample.command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

// 여러개의 명렁을 한 데 모인 명령
public class MacroCommand implements Command {
    // 명령의 배열 
    private Deque<Command> commands = new ArrayDeque<>();   // 컬렉션 , 양쪽에서 뺄 수 있음

    // 실행 
    @Override
    public void execute() {
        //Iterator<Command> itr = commands.descendingIterator();
         
        for (Command cmd: commands) {
            cmd.execute();  // 내부적으로 iterator() 메소드를 호출해서 작동함 => 스택 top부터 꺼내옴 
        }
    }

    // 추가 
    public void append(Command cmd) {
        if (cmd == this) {
            throw new IllegalArgumentException("infinite loop caused by append");
        }
        commands.push(cmd);
    }

    // 마지막 명령을 삭제
    public void undo() {
        if (!commands.isEmpty()) {
            commands.pop();
        }
    }

    // 전부 삭제 
    public void clear() {
        commands.clear();
    }
}
