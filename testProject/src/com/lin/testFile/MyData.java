package com.lin.testFile;

public class MyData {
	private String taskName ;
	private String remark ;
	private String ruleType ;
	private String key ;
	private String password ;
	private String state ;
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRuleType() {
		return ruleType;
	}
	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "MyData [taskName=" + taskName + ", remark=" + remark
				+ ", ruleType=" + ruleType + ", key=" + key + ", password="
				+ password + ", state=" + state + "]";
	}
	public MyData(String taskName, String remark, String ruleType, String key,
			String password, String state) {
		super();
		this.taskName = taskName;
		this.remark = remark;
		this.ruleType = ruleType;
		this.key = key;
		this.password = password;
		this.state = state;
	}
	
}
