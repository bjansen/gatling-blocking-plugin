package com.github.bjansen.gatling.blocking;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;

import java.time.Duration;

import static com.github.bjansen.gatling.blocking.javaapi.BlockingCodeDsl.blocking;
import static io.gatling.javaapi.core.CoreDsl.rampUsersPerSec;
import static io.gatling.javaapi.core.CoreDsl.scenario;

public class JavaDemo extends Simulation {
	
	private final ScenarioBuilder scenario = scenario("Blocking code")
			.exec(
					blocking("my blocking code")
							.run(this::myBlockingCode)
			);

	public JavaDemo() {
		setUp(
				scenario.injectOpen(
						rampUsersPerSec(1).to(100).during(Duration.ofMinutes(2))
				)
		);
	}

	private void myBlockingCode() {
		// Simulate blocking code
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
