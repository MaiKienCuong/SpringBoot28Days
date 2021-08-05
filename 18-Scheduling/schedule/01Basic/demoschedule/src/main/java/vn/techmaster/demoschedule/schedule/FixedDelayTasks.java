package vn.techmaster.demoschedule.schedule;

import java.util.Random;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnExpression("true")
public class FixedDelayTasks {

	private long timeOfLastTask = System.currentTimeMillis();

	@Scheduled(fixedDelay = 1000)
	/*
	 * sau khi hàm thực hiện xong, đợi 1 giây thì gọi, cho dù hàm thực hiện hết bao
	 * nhiêu thời gian thì phải thực hiện xong, sau đó đợi 1 giây mới thực hiện lần
	 * tiếp theo
	 */
	public void scheduleFixedDelayTask() throws InterruptedException {
		long delay = System.currentTimeMillis() - timeOfLastTask;
		System.out.println("Fixed delay task - " + delay);

		Random random = new Random();
		int sleepTime = random.nextInt(5) * 1000;
		System.out.println("--------- " + sleepTime);
		Thread.sleep(sleepTime); // Giả lập thời gian thực hiện task khác nhau

		timeOfLastTask = System.currentTimeMillis();
	}
}
