package bean.mine;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InheritanceDemo {
    public static void main(String args[]) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-05-1.xml");
        ctx.refresh();

        Singer parent = (Singer)ctx.getBean("parent");
        Singer child = (Singer)ctx.getBean("child");
        System.out.println(parent.toString());
        System.out.println(child.toString());

    }
}
