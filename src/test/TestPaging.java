package test;

import model.Paging;

public class TestPaging {
	public static void main(String[] args) {
		
		/*
		 * Paging Bean 사용 예제
		 */
		Paging p = new Paging(3432); // 생성자에 리스트의 총 행 수를 넣어서 객체를 생성하면 간편하게 페이징 처리가 됩니다.
		
		
		// 한 화면에 보여줄 행의 갯수를 setter 메소드를 통해 설정 할 수 있습니다. (미설정시 기본값 10) 
		//p.setPageSize(5);
		
		
		// 한 페이지 그룹에 보여줄 페이지의 갯수를 setter 메소드를 통해 설정 할 수 있습니다. (미설정시  기본값 5)
		//p.setPageGroupSize(3);
		
		
		// setter 메소드로 페이지를 이동할 수 있습니다. (미설정시  기본값 1)
		p.setCurrentPage(12);
		
		
		//toString() 오버라이딩 해 놓았습니다.
		System.out.println(p);
		
		
		//페이징 처리 된 모습을 미리 볼 수 있습니다.
		System.out.println(p.preview());
		
		
		/*
		 *  다음과 같이 생성자로 한번에 모든 설정을 할 수도 있습니다.
		 *  자세한 설명은 Paging 클래스를 참조해주세요.주석 열심히 달아놓았습니다.
		 */
		
//		Paging p = new Paging(27, 10, 7, 2424);
		
	}
}
