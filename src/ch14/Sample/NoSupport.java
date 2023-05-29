package ch14.Sample;

public class NoSupport extends Support {
    public NoSupport(String name) {
        super(name);    // 부모생성자 호출 
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return false; // 자신은 아무것도 해결하지 않는다
    }
}
