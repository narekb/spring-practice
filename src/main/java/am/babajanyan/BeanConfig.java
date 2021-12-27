package am.babajanyan;

import am.babajanyan.postprocessors.AutoplugPostProcessor;
import am.babajanyan.postprocessors.LoggerPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public LoggerPostProcessor loggerPostProcessor() {
        return new LoggerPostProcessor();
    }

    @Bean
    public AutoplugPostProcessor autoplugPostProcessor() {
        return new AutoplugPostProcessor();
    }

    @Bean
    public SimpleBean simpleBean() {
        return new SimpleBean();
    }

    @Bean
    public String customStringBean() {
        return "Successfully injected string";
    }

    @Bean
    public Integer customIntegerBean() {
        return 13;
    }
}
