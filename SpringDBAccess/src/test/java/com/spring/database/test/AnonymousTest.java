package com.spring.database.test;

public class AnonymousTest {

	public static void main(String[] args) {
		
		Car s = new Sonata();
		s.run();
		
		Car ferrari = new Car() {
			@Override
			public void run() {
				System.out.println("페라리가 달립니다.");			
			}			
		};
		ferrari.run();
		
		//lambda식 적용 조건은 인터페이스의 추상메소드가 1개일 경우 사용 => 함수형 인터페이스
		//왜냐하면 메소드가 여러개일경우 ()함수 호출할때 뭘 호출해야하는지 모르니깐
		//1개의 메소드만 있을때 성립
		Car tucson = () -> {System.out.println("투싼이 달립니다.");};
		
		
		//계산기 인터페이스와 람다식
		Calculator sharp = new Calculator() {
			
			@Override
			public int add(int n1, int n2) {
				System.out.println("샤프 계산기의 덧셈");
				return n1 + n2;
			}
		};
		
		System.out.println("===========================");
		System.out.println(sharp.add(10, 30));
		
		
		Calculator sharp1 = (n1,n2) -> {
			System.out.println("카시오 계산기의 덧셈");
			return n1 + n2;
		}; System.out.println(sharp1.add(30, 40));

	}

}
