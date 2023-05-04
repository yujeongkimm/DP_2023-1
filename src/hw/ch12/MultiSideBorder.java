package hw.ch12;

public class MultiSideBorder extends Border{
    private char borderChar;  // 장식 문자
    private int num;    // 크기

    public MultiSideBorder(Display display, char ch, int num) {
        super(display);
        this.borderChar = ch;
        this.num = num;
    }

    @Override
    public int getColumns() {
        // 문자 수는 내용물의 양쪽에 장식 문자만큼 더한 것
        return num + display.getColumns() + num;
    }

    @Override
    public int getRows() {
        // 행수는 내용물의 행수와 같다 
        return display.getRows();
    }

    @Override
    public String getRowText(int row) {
        // 지정 행의 내용은 내용물의 지정 행 양쪽에 장식 문자를 붙인 것
        String result = "";
        for(int i=0; i<num; i++) {
            result += borderChar;
        }
        result+= display.getRowText(row);
        for(int i=0; i<num; i++) {
            result += borderChar;
        }
        return result;
    }

}