package com.example.demo.utils;

/**
 * 结果集对象
 * @author zhouhao
 *
 * @param <T>
 */
public class Result<T> {
	private Integer code;
	
	private String msg;
	
	private T data;

	public Result(){}
	
	public Result(T t){
		this.data = t;
	}

	/**
	 * 参数对象
	 */
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * 状态码
	 * 1	success
	 * 0	error
	 */
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * 返回消息
	 */
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 操作成功
	 */
	public static <T> Result<T> ok(T t, String msg) {
		Result result = new Result();
		result.setCode(1);
		result.setMsg(msg);
		result.setData(t);
		return result;
	}

	/**
	 * 操作成功
	 */
	public static <T> Result<T> ok(T t) {
		return ok(t, "success");
	}

	/**
	 * 操作成功
	 */
	public static <T> Result<T> ok() {
		return ok(null, "success");
	}

	/**
	 * 操作成功
	 */
	public static <T> Result<T> ok(String msg) {
		return ok(null, msg);
	}

	/**
	 * 操作失败
	 */
	public static <T> Result<T> fail(T t, String msg) {
		Result result = new Result();
		result.setCode(0);
		result.setMsg(msg);
		result.setData(t);
		return result;
	}

	/**
	 * 操作失败
	 */
	public static <T> Result<T> fail(T t) {
		return fail(t, "fail");
	}

	/**
	 * 操作失败
	 */
	public static <T> Result<T> fail(String msg) {
		return fail(null, msg);
	}



	
}