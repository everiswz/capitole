package com.capitole.ecommerce.price.rest.controller.exception.model;

public class RestError {

	private String type;
	private String title;
	private Integer status;
	private String detail;

	public RestError(String type, String title, Integer status, String detail) {
		super();
		this.type = type;
		this.title = title;
		this.status = status;
		this.detail = detail;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * @return the detail
	 */
	public String getDetail() {
		return this.detail;
	}

}
