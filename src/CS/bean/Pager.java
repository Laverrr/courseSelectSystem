package CS.bean;

import java.io.Serializable;
import java.util.List;

public class Pager<T> implements Serializable {

	private static final long serialVersionUID = -8741766802354222579L;
	
	public static final int pageSize=10; // 每页显示多少条记录
	
	public final static int defaultPage=1;//默认当前页
	
	private int currentPage; //当前第几页数据
	
	private int totalRecord; // 一共多少条记录
	
	private int totalPage=1; // 一共多少页记录
	
	private List<T> dataList; //要显示的数据
	
	public Pager(int pageNum, List<T> sourceList){
		if(sourceList == null || sourceList.isEmpty()){
			return;
		}
		
		// 总记录条数
		this.totalRecord = sourceList.size();
		
		// 每页显示多少条记录
		
		//获取总页数
		this.totalPage = this.totalRecord / pageSize;
		if(this.totalRecord % pageSize !=0){
			this.totalPage = this.totalPage + 1;
		}
		
		// 当前第几页数据
		this.currentPage = this.totalPage < pageNum ?  this.totalPage : pageNum;
				
		// 起始索引
		int fromIndex	= pageSize * (this.currentPage -1);
		
		// 结束索引
		int toIndex  = pageSize * this.currentPage > this.totalRecord ? this.totalRecord : pageSize * this.currentPage;
				
		this.dataList = sourceList.subList(fromIndex, toIndex);
	}
	
	public Pager(){
		
	}

	public Pager( int currentPage, int totalRecord, int totalPage,
			List<T> dataList) {
		super();
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
		this.dataList = dataList;
	}

//	public int getPageSize() {
//		return pageSize;
//	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

}
