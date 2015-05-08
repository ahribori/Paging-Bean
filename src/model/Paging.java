package model;

/**
 * Paging Bean
 * 2015/05/08
 * 
 * @author ������
 *
 */
public class Paging {
	
	
	private int totalListSize; // ����¡ ó���� ����Ʈ�� ��ü �� ����
	
	private int pageSize = 10; // �� �������� ������ ���� ���� (�⺻��:10)

	private int pageGroupSize = 5; // �� ������ �׷쿡 �� �������� ���� (�⺻��:5)

	private int pageCount; // ������ ����

	private int pageGroupCount; // ������ �׷� ����

	private int currentPage; // ���� ������ ��ȣ

	private int currentPageGroup; // ���� ������ �׷� ��ȣ
	
	private int beginRow; // ��� ���� �� ��ȣ

	private int endRow; // ��� �� �� ��ȣ
	
	private int beginPage; // �������׷� ���� ������ ��ȣ
	
	private int endPage; // �������׷� �� ������ ��ȣ
	
	
	/*
	 * ���� �������� �������� ���� �����߽��ϴ�.
	 * isFirstPage�� ���� �������� 1�������� true�� ��ȯ������
	 * currentPage==1 ���� isFirstPage�� �������� �� ���� ���� �ֱ� �����Դϴ�.
	 */
	private boolean isFirstPage;
	
	private boolean isLastPage;
	
	private boolean isFirstPageGroup;
	
	private boolean isLastPageGroup;
	
	private boolean isEmpty;
	
	
	/*
	 * << ������ >>
	 * 
	 * ����¡ ó���ϱ����� �ݵ�� �ʿ��� ������ ����¡ ó���� ����Ʈ�� ��ü �� ����(totalListSize) �Դϴ�. 
	 * �� ������ ������ ����¡ ������ �Ұ����ϱ� ������ ����Ʈ �����ڸ� ������ �������μ�
	 * Paging ��ü ������ tatalListSize�� �ݵ�� �ʱ�ȭ �ϵ��� �����߽��ϴ�.
	 * 
	 * ���� ������(currentPage), �� �������� ������ ���� ����(pageSize), 
	 * �� ������ �׷쿡 �� �������� ����(pageGroupSize)�� 
	 * setter �޼ҵ�� �����ڷ� ���� �� �� �ְ� �����߽��ϴ�.
	 * 
	 */
	
	/**
	 * ����¡ ó���� ����Ʈ�� ��ü �� ���� �ƱԸ�Ʈ�� �Ѱ��ָ�
	 * ����¡ ó���� �Ϸ�˴ϴ�.
	 * ���� �������� 1�� �ʱ�ȭ�˴ϴ�.
	 * �� �������� ������ ���� ������ �⺻�� 10���� �ʱ�ȭ�˴ϴ�.
	 * �� ������ �׷쿡 �� �������� ������ �⺻�� 5�� �ʱ�ȭ�˴�.
	 * 
	 * @param totalListSize
	 */
	public Paging(int totalListSize) {
		this.totalListSize = totalListSize;
		this.calculate();
	}
	
	/**
	 * ���� �������� 
	 * ����¡ ó���� ����Ʈ�� ��ü �� ���� �ƱԸ�Ʈ�� �Ѱ��ָ�
	 * ����¡ ó���� �Ϸ�˴ϴ�.
	 * �� �������� ������ ���� ������ �⺻�� 10���� ���õ˴ϴ�.
	 * �� ������ �׷쿡 �� �������� ������ �⺻�� 5�� ���õ˴ϴ�.
	 * @param currentPage
	 * @param totalListSize
	 */
	public Paging(int currentPage, int totalListSize) {
		this.currentPage = currentPage;
		this.totalListSize = totalListSize;
		this.calculate();
	}
	
	/**
	 * 
	 * ���� ������, ��ü �� ��, �� �������� ������ �� ��, �� ������ �׷쿡 ������ ������ ����
	 * �ƱԸ�Ʈ�� �Ѱ��ָ� ����¡ ó���� �Ϸ�˴ϴ�.
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @param pageGroupSize
	 * @param totalListSize
	 */
	public Paging(int currentPage, int pageSize, int pageGroupSize, int totalListSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.pageGroupSize = pageGroupSize;
		this.totalListSize = totalListSize;
		this.calculate();
	}
	
	/**
	 * setter �޼ҵ�, �����ڸ� ���� �ʱ�ȭ�� �������� �������� ���������� ����¡ ó�� ������ �ϴ� �޼ҵ� �Դϴ�.
	 * 
	 */
	private void calculate() {
		
		if(totalListSize==0) this.isEmpty = true;
		
		this.pageCount = (totalListSize/pageSize) + (totalListSize % pageSize == 0 ? 0 : 1);
		
		if(currentPage<=0) currentPage=1; //���� �������� 0 �����϶� 1�� �ʱ�ȭ
		
		if(currentPage>pageCount) currentPage=pageCount; //���� �������� ������ ������ �ʰ��Ҷ� ������ �������� �Ҵ�

		this.pageGroupCount = (pageCount/pageGroupSize) + (pageCount % pageGroupSize == 0 ? 0 : 1);
		
		this.currentPageGroup = (currentPage/pageGroupSize) + (currentPage % pageGroupSize == 0 ? 0 : 1);
		
		this.beginRow = !isEmpty ? pageSize * (currentPage-1) + 1 : 0;
	
		this.endRow = (currentPage==pageCount) ? totalListSize : (pageSize*currentPage);
		
		this.beginPage = !isEmpty ? (pageGroupSize * currentPageGroup) - (pageGroupSize - 1) : 0;
				
		this.endPage = (beginPage + (pageGroupSize -1)) < pageCount ? (beginPage + (pageGroupSize -1)) : pageCount;
				
		this.isFirstPage = (currentPage == 1) ? true : false;
		
		this.isLastPage = (currentPage == pageCount) ? true : false;
		
		this.isFirstPageGroup = (currentPageGroup) == 1 ? true : false;
		
		this.isLastPageGroup = (currentPageGroup == pageGroupCount) ? true : false;
	
	}
	
	public int getTotalListSize() {
		return totalListSize;
	}

	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		calculate();
	}

	public int getPageGroupSize() {
		return pageGroupSize;
	}

	public void setPageGroupSize(int pageGroupSize) {
		this.pageGroupSize = pageGroupSize;
		calculate();
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		calculate();
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getPageGroupCount() {
		return pageGroupCount;
	}

	public int getCurrentPageGroup() {
		return currentPageGroup;
	}

	public int getBeginRow() {
		return beginRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isFirstPage() {
		return isFirstPage;
	}

	public boolean isLastPage() {
		return isLastPage;
	}

	public boolean isFirstPageGroup() {
		return isFirstPageGroup;
	}

	public boolean isLastPageGroup() {
		return isLastPageGroup;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	@Override
	public String toString() {
		return "\n\nPaging [totalListSize=" + totalListSize + ", pageSize="
				+ pageSize + ", pageGroupSize=" + pageGroupSize
				+ ", pageCount=" + pageCount + ", pageGroupCount="
				+ pageGroupCount + "\n ,currentPage=" + currentPage
				+ ", currentPageGroup=" + currentPageGroup + ", beginRow="
				+ beginRow + ", endRow=" + endRow + ", beginPage=" + beginPage
				+ ", endPage=" + endPage + "\n" + ", isFirstPage=" + isFirstPage
				+ ", isLastPage=" + isLastPage + ", isFirstPageGroup=" + isFirstPageGroup
				+ ", isLastPageGroup=" + isLastPageGroup + "]";
	}
	
	/**
	 * �̸�����
	 * @return str
	 */
	public StringBuilder preview() {
		StringBuilder str = new StringBuilder();
		str.append("\n");
		str.append(" -------------------\n");
		str.append(" |     Preview     |\n");
		str.append(" -------------------\n");

		if (!isEmpty) {
			for (int i = beginRow; i <= endRow; i++) {
				str.append(" ROWNUM = " + i + " �Դϴ�.\n");
			}

			str.append("\n");
			str.append(" << ");

			if (!isFirstPageGroup) {
				str.append("1 ... ");
			}

			for (int i = beginPage; i <= endPage; i++) {
				if (i == currentPage) {
					str.append("(" + i + ") ");
				} else {
					str.append(i + " ");
				}
			}
			if (!isLastPageGroup) {
				str.append("... " + pageCount);
			}
			str.append(" >>");
		} else {
			str.append("	Empty!");
		}
		return str;
	}

}
