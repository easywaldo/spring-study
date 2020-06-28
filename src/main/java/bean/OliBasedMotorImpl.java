package bean;

public class OliBasedMotorImpl implements IMotorCar {
    @Override
    public void feelEnergy() {
        System.out.println("기름을 채웁니다.");
    }

    @Override
    public void forward() {
        System.out.println("차가 앞으로 전진합니다.");
    }

    @Override
    public void backward() {
        System.out.println("차가 뒤로 후진합니다.");
    }

    @Override
    public void left() {
        System.out.println("차가 좌회전 합니다.");
    }

    @Override
    public void right() {
        System.out.println("차가 우회전 합니다.");
    }
}
