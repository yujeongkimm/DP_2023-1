package ch14.Sample;

public abstract class Support {
    private String name;    // 이 트러블 해결자 이름
    private Support next;   // 떠넘길 곳 (부모타입으로 선언됨)

    public Support(String name) {
        this.name = name;
        this.next = null;
    }

    // 떠넘길 곳을 설정한다
    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    // 트러블 해결 절차를 결정한다
    // 템플릿 메소드 
    public void support(Trouble trouble) {
        if (resolve(trouble)) { // 내가 해결할 수 있으면...
            done(trouble);
        } else if (next != null) {  // 뒷사람이 있으면..
            next.support(trouble);  // 뒷사람에게 넘긴다 
        } else {    // 뒷사람이 없으면.. 내가 마지막이다 
            fail(trouble);  // 해결 못했다
        }
    }

    // 트러블 해결자의 문자열 표현
    @Override
    public String toString() {
        return "[" + name + "]";
    }

    // 해결하려고 한다
    /**
     * 구현해야되는 메서드
     * 각 해결자들이 자기방식으로 해결하도록 함 
     * @param trouble
     * @return
     */
    protected abstract boolean resolve(Trouble trouble);

    // 해결했다 
    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    // 해결되지 않았다 
    protected void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }
}
