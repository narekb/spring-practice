package am.babajanyan.car;

import am.babajanyan.engine.Engine;
import org.springframework.beans.factory.annotation.Qualifier;

public class Tesla implements Car {
    private final Engine engine;

    public Tesla(@Qualifier("electric") Engine engine) {
        this.engine = engine;
    }

    @Override
    public String drive(int distance) {
        return "Tesla driven " + distance + "km. " + engine.work(distance);
    }
}
