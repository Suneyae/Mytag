package com.wyl.ajax;

public class BeanService {

	public BeanService() {
		
	}
	
	private String serviceId;
	private String method;
	private String parameters;
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getParameters() {
		return parameters;
	}
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	@Override
	public String toString() {
		return "BeanService [serviceId=" + serviceId + ", method=" + method + ", parameters=" + parameters + "]";
	}
	
	
	
	
}
