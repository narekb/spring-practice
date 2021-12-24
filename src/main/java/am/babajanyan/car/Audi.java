package am.babajanyan.car;

import am.babajanyan.engine.Engine;
import org.springframework.beans.factory.annotation.Qualifier;

public class Audi implements Car {
    private final Engine engine;

    public Audi(@Qualifier("combustion") Engine engine) {
        this.engine = engine;
    }

    @Override
    public String drive(int distance) {
        return "Audi driven " + distance + "km. " + engine.work(distance);
    }
}
