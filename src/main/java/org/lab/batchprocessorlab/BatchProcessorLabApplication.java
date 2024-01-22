package org.lab.batchprocessorlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class BatchProcessorLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchProcessorLabApplication.class, args);
    }

}
