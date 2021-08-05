package vn.techmaster.demoschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@EnableScheduling
@SpringBootApplication
public class DemoscheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoscheduleApplication.class, args);
	}

	/*
	 * mac dinh spring chi tao 1 thread de chay schedule, neu muon nhieu hon thi
	 * phai chi dinh
	 */
	@Bean
	public TaskScheduler taskScheduler() {
		final ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setPoolSize(10);
		return scheduler;
	}

}
