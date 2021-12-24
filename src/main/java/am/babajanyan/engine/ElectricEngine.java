package am.babajanyan.engine;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("electric")
public class ElectricEngine implements Engine {
    public String work(int distance) {
        return String.valueOf(distance) + "KWh of energy spent.";
    }
}
