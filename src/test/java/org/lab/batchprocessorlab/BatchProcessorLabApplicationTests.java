package org.lab.batchprocessorlab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

@SpringBootTest
@ExtendWith(OutputCaptureExtension.class)
class BatchProcessorLabApplicationTests {
    @Autowired
    private Job job;

    @Autowired
    private JobLauncher jobLauncher;

    @Test
    void testJobExecution(CapturedOutput output) throws Exception {
        String inputFile = "billing-2023-01.csv";
        // given
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("input.file", inputFile)
                .toJobParameters();
        // when
        JobExecution jobExecution = this.jobLauncher.run(this.job, jobParameters);
        // then
        Assertions.assertTrue(output.getOut().contains("processing billing information from file " + inputFile));
        Assertions.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
    }

}
