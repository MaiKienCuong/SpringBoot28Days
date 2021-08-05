package vn.techmaster.demoschedule.schedule;

import java.util.logging.Logger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnExpression("false")
public class FixedRateTasks {

	private Logger logger = Logger.getLogger(FixedRateTasks.class.getName());

	@Scheduled(fixedRate = 1000)
	public void scheduleFixedRate() throws InterruptedException {
		logger.info("Fixed rate task - " + System.currentTimeMillis() / 1000);
		Thread.sleep(2000);
	}
}
