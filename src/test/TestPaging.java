package test;

import model.Paging;

public class TestPaging {
	public static void main(String[] args) {
		
		
		System.out.println("HELLO");
		/*
		 * Paging Bean ��� ����
		 */
		Paging p = new Paging(3432); // ���ڿ� ����Ʈ�� �� �� ���� �־ ��ü�� ���ϸ� �����ϰ� ����¡ ó���� �˴ϴ�.
		
		
		// �� ȭ�鿡 ������ ���� ������ setter �޼ҵ带 ���� ���� �� �� �ֽ��ϴ�. (�̼����� �⺻�� 10) 
		p.setPageSize(8);
		
		
		// �� ������ �׷쿡 ������ �������� ������ setter �޼ҵ带 ���� ���� �� �� �ֽ��ϴ�. (�̼�����  �⺻�� 5)
		p.setPageGroupSize(3);
		
		
		// setter �޼ҵ�� �������� �̵��� �� �ֽ��ϴ�. (�̼�����  �⺻�� 1)
		p.setCurrentPage(13);
		
		
		//toString() �������̵� �� ���ҽ��ϴ�.
		System.out.println(p);
		
		
		//����¡ ó�� �� ����� �̸� �� �� �ֽ��ϴ�.
		System.out.println(p.preview());
		
		
		/*
		 *  ������ ���� ���ڷ� �ѹ� ��� ������ �� ���� �ֽ��ϴ�.
		 *  �ڼ��� ������ Paging Ŭ������ �������ּ���.�ּ� ������ �޾Ƴ��ҽ��ϴ�.
		 */
		
//		Paging p = new Paging(27, 10, 7, 2424);
		
	}
}
