package bean.mine;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public BeanApplication(
            IMotorCar carOne,
            IMotorCar carTwo) {
        System.out.println("Target(Car) 호출");
        this.carOne = carOne;
        this.carTwo = carTwo;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-04.xml");
        ctx.refresh();

        // 타입에 의한 Bean 주입
        BeanApplication t = (BeanApplication)ctx.getBean("targetByType");
        System.out.println("Using by Type");
        t.carOne.feelEnergy();

        // 생성자에 의한 Bean 주입
        BeanApplication constructorApp = (BeanApplication)ctx.getBean("targetConstructor");
        System.out.println("make car one..");
        constructorApp.carOne.feelEnergy();
        System.out.println("make car two..");
        constructorApp.carTwo.feelEnergy();


        // Bean name 에 의한 Bean 주입
        System.out.println("make car one by bean name ..");
        IMotorCar oliBasedMotor = (OliBasedMotorImpl)ctx.getBean("oilCarOne");
        oliBasedMotor.feelEnergy();

        // Bean name 에 의한 Bean 주입
        System.out.println("make car one by bean name ..");
        IMotorCar gasBasedMotor = (GasBasedMotorImpl)ctx.getBean("gasCarOne");
        gasBasedMotor.feelEnergy();
        ctx.close();
    }
}
