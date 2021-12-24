package am.babajanyan;

import am.babajanyan.car.Car;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class App
{
    private static final String CONFIG_FILE = "application-config.xml";
    public static void main( String[] args )
    {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(CONFIG_FILE);
        // 1) Create multiple engine beans (combustion, electric)
        // 2) Create multiple possible car beans (a car has an engine dependency)
        // 3) Inject a car, drive it.

        Car audi = ctx.getBean("audi", Car.class);
        System.out.println(audi.drive(13));

        Car tesla = ctx.getBean("tesla", Car.class);
        System.out.println(tesla.drive(13));

        ctx.close();
    }
}
