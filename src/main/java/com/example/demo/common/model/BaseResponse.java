package com.example.demo.common.model;

import com.example.demo.common.util.CommonConstant;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class BaseResponse<T> {

	private int code;
	private T result;
	
	public static <T> BaseResponse<T> success(T result){
		return BaseResponse.<T>builder()
				.code(CommonConstant.SUCCESS)
				.result(result)
				.build();
	}
}
