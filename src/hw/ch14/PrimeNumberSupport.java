package hw.ch14;

public class PrimeNumberSupport extends Support{

    public PrimeNumberSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (isPrimeNumber(trouble.getNumber())) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isPrimeNumber(int number) {
        // 0 또는 1은 소수가 아님
        if(number < 2) return false;

        // 2는 소수
        if(number == 2) return true;

        // 그외의 수
        for(int i = 2; i < number; i++){
            //num보다 아래수에서 나눠지는 수가 있으면 소수가 아님
            if(number % i == 0){
                return false;
            }
        }
        //안나왔으면 소수
        return true;
    }
    
}
