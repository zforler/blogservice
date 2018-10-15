package com.blog.util.result;

public enum Code {
	 SUCCESS(1,"success"),
	 FAILED(0,"failed"),
	 TOKENERROR(2,"token error");
	
	 private int code ;
	 private String msg;
	 
	 private Code(int code,String msg){
	        this.code = code ;
	        this.msg = msg;
     }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	 
	 
}
