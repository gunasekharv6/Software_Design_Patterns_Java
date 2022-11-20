import java.util.ArrayList;
import java.util.List;

public class FourDigitReceiver implements ReceiverAPI{
    List<Integer> nums = new ArrayList<>();

    public FourDigitReceiver(int a, int b, int c, int d) {
        nums.add(a);
        nums.add(b);
        nums.add(c);
        nums.add(d);
    }


    @Override
    public int add() {
        int result = 0;

        for(int num: nums){
            result+=num;
        }
        return result;
    }

    @Override
    public int subtract() {
        int result = nums.get(0);

        for(int i=1; i<nums.size(); i++){
            result-=nums.get(i);
        }
        return result;
    }

    @Override
    public int multiply() {
        int result = 1;

        for(int num: nums){
            result*=num;
        }
        return result;
    }

    @Override
    public double divide() {
        int result = nums.get(0);

        for(int i=1; i<nums.size(); i++){
            result /= nums.get(i);
        }
        return result;
    }

    @Override
    public int sum() {
        int result = 0;

        for(int num: nums){
            result+=num;
        }
        return result;
    }
}
