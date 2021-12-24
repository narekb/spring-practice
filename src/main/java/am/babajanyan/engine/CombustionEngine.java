package am.babajanyan.engine;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("combustion")
public class CombustionEngine implements Engine {
    @Override
    public String work(int distance) {
        return String.valueOf(distance) + "L of fuel burned.";
    }
}
