package bean.mine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("test")
@Lazy
public class TrickyTarget {

    IMotorCar carOne;
    IMotorCar carTwo;

    public TrickyTarget() {
        System.out.println("Tricky Target Constructor");
    }

    public TrickyTarget(IMotorCar car, IMotorCar carSecond) {
        carOne = car;
        carTwo = carSecond;
        System.out.println("Tricky Target Car called");
    }

    /*@Autowired
    public TrickyTarget(
            IMotorCar carOne,
            IMotorCar carTwo) {
        this.carOne = carOne;
        this.carTwo = carTwo;
    }*/

    @Autowired
    public void setCarOne(OliBasedMotorImpl car) {
        this.carOne = car;
    }

    @Autowired
    public void setCarTwo(GasBasedMotorImpl car) {
        this.carTwo = car;
    }

    public static void main(String args[]) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-04-1.xml");
        ctx.refresh();
        System.out.println("Tricky Target ..");

        //IMotorCar oliBasedMotor = (OliBasedMotorImpl)ctx.getBean("motorCarOne");
        //IMotorCar gasBasedMotor = (GasBasedMotorImpl)ctx.getBean("oilCarOne");

        //TrickyTarget target = new TrickyTarget(oliBasedMotor, gasBasedMotor);
        //target.carOne.feelEnergy();


        TrickyTarget target = ctx.getBean(TrickyTarget.class);
        target.carOne.feelEnergy();
        target.carTwo.feelEnergy();

        ctx.close();



    }
}
