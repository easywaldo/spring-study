package bean.mine;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

public class TargetDemo {
    @Configuration
    static class TargetConfig {

        @Bean
        public IMotorCar oilBasedMotorImpl() {
            return new OliBasedMotorImpl();
        }

        @Bean
        public IMotorCar gasBasedMotorImpl() {
            return new GasBasedMotorImpl();
        }
    }

    public static void main(String args[]) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(TargetConfig.class);
        TrickyTarget trickyTarget = ctx.getBean(TrickyTarget.class);
        ctx.close();


    }

}
