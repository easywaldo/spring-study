package bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BeanApplication {
    IMotorCar carOne;
    IMotorCar carTwo;

    public BeanApplication() {
        System.out.println("Target Constructor()");
    }

    public BeanApplication(IMotorCar car) {
        System.out.println("Target(Car) 호출");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-04.xml");
        ctx.refresh();
        System.out.println("Using by Type");
        BeanApplication t = (BeanApplication)ctx.getBean("targetByType");

        IMotorCar oliBasedMotor = (OliBasedMotorImpl)ctx.getBean("motorCarOne");
        oliBasedMotor.feelEnergy();

        IMotorCar gasBasedMotor = (GasBasedMotorImpl)ctx.getBean("oilCarOne");
        gasBasedMotor.feelEnergy();
        ctx.close();
    }
}
