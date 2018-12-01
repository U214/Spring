package com.srm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
	@Configuration : 원하는 빈을 컨텍스트에 추가.
					XML 설정과 함께 사용해도 되지만 @Configuration클래스 사용 권장
					=> 스프링부트가 자바 기반 구성을 선호하기 때문
					=> 일단 @Configuration클래스를 사용한뒤 @ImportResource로 XML 파일 로드 할 것 
	@ComponentScan : @Component 검사 활성화
	@EnableAutoConfiguration : 스프링 부트의 자동 구성 활성화
*/
@SpringBootApplication(scanBasePackages= {"com.srm.dao", "com.srm.service.impl"})
public class SrMspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrMspringApplication.class, args);
		// JAR 파일로 애플리케이션을 실행시킨다
		// 부트스트랩하고 톰캣 내장서버 시작
	}
}
