package hw.ch12;

import java.util.ArrayList;
import java.util.List;

public class MultiStringDisplay extends Display {
    // 표시 문자열 저장 장소
    private List<String> body = new ArrayList<>();
    // 표시 문자열 최대 문자 수 
    private int columns = 0;

    // 추가 
    public int getByteLength(String str) {
        int bytes = 0;
        if (str == null) {
            return bytes;
        } else {
            char[] strChar = str.toCharArray();
            char ch; int code;
            for (int i = 0; i < strChar.length; i++) {
                ch = strChar[i];
                code = (int) ch;
    
                // 2bytes
                if ((ch < '0' || ch > '9') && (ch < 'A' || ch > 'Z') && code > 255) bytes += 2;
                // 1bytes
                else bytes +=1;
            }
            return bytes;
        }
    }

    // 문자열 추가 
    public void add(String msg) {
        body.add(msg);
        int bytes = getByteLength(msg);
        // 더 긴 문자열을 넣는다면...
        if (columns < bytes) {
            // 최대 문자 수 갱신
            columns = bytes;
        }
        updatePadding();
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public int getRows() {
        return body.size(); // 문자열의 개수 
    }

    @Override
    public String getRowText(int row) {
        return body.get(row);
    }

    // 표시 문자열 오른쪽 끝에 채울 공백을 필요에 따라 늘린다
    private void updatePadding() {
        for (int row = 0; row < body.size(); row++) {
            String line = body.get(row);
            // 
            int padding = columns - getByteLength(line);  // 채워야 할 빈 칸 개수
            if (padding > 0) {  // 빈 칸을 채워야 하면...
                body.set(row, line + spaces(padding));
            }
        }
    }

    // count 수만큼의 공백을 만든다 
    private String spaces(int count) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < count; i++) {
            spaces.append(' ');
        }
        return spaces.toString();
    }
}
