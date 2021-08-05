package vn.techmaster.demoschedule.schedule;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
@ConditionalOnExpression("false")
/*
 * spring sẽ tạo bean nếu biểu thức trong @ConditionalOnExpression là true, nếu
 * là false thì sẽ không tạo bean <br>
 * 
 * @EnableAsync cho phép chạy đồng thời trên nhiều thread khác nhau, mặc định
 * spring chỉ tạo 1 thread
 */
public class AsyncTasks {

	@Async
	@Scheduled(fixedRate = 1000)
	/*
	 * fixedRate: cứ sau 1000 mili giây thì thực hiện lại hàm này, cho dù hàm này
	 * thực hiện hết bao nhiêu thời gian, cứ sau 1 giây là gọi hàm
	 */
	public void scheduleFixedRateTaskAsync() {
		System.out.println("Fixed rate task async - " + System.currentTimeMillis() / 1000);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException exc) {
			exc.printStackTrace();
		}
	}

}
