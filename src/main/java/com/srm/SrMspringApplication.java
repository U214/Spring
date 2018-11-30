package com.srm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @Configuration, @componentScan, @EnableAutoConfiguration
// XML 설정과 함께 사용해도 되지만 @Configuration클래스 사용 권장 -> 자바기반구성 선호
// 일단 @Configuration클래스를 사용한뒤 @ImportResource로 XML 파일 로드 할것
// 컴포넌트 검색과 자동 구성 활성화
@SpringBootApplication
public class SrMspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrMspringApplication.class, args);
		// JAR 파일로 애플리케이션을 실행시킨다
		// 부트스트랩하고 톰캣 내장서버 시작
	}
}
