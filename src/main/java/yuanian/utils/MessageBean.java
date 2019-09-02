package yuanian.utils;

import java.util.List;




public class MessageBean<T> { 
	private String code;
	private String msg;
	private List<T> dataList;
	public MessageBean(){
		
	}
	
	public MessageBean(String code,String msg,List<T> dataList,T data){
		this.code = code;
		this.msg = msg;
		this.dataList = dataList;
	}
		
	public MessageBean(String code,String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public MessageBean(String code,String msg,T data){
		this.code = code;
		this.msg = msg;
	}

	public MessageBean(String code,String msg,List<T> dataList){
		this.code = code;
		this.msg = msg;
		this.dataList = dataList;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}


	@Override
	public String toString() {
		return "MessageBean [code=" + code + ", msg=" + msg + ", dataList=" + dataList + "]";
	}
	
}
