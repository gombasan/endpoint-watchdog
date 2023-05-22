package com.clover.monitor.domain.monitor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import org.springframework.stereotype.Service;

import com.clover.monitor.domain.monitor.entity.Monitor;
import com.clover.monitor.global.util.MonitorTask;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MonitorServiceImpl implements MonitoringService {
	private Timer timer = new Timer();


	@Override
	public void startMonitoring() {
		List<Monitor> monitorList = new ArrayList<>();
		monitorList.add(Monitor.builder().endPoint("https://www.naver.com").build());
		monitorList.add(Monitor.builder().endPoint("https://www.google.com").build());
		monitorList.add(Monitor.builder().endPoint("https://www.youtube.com").build());
		for (Monitor monitor : monitorList) {
			timer.scheduleAtFixedRate(new MonitorTask(monitor),0, 1000);
		}
	}

	@Override
	public void stopMonitoring() {
		timer.cancel();
		this.timer = new Timer();
	}
}
