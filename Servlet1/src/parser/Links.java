package parser;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Links {
	
	@JsonProperty("sign")
	private String sign;
	
	@JsonProperty("maya")
	private String maya;
	
	@JsonProperty("chinese")
	private String chinese;
	
	public Links(String sign, String maya, String chinese) {
		this.sign = sign;
		this.maya = maya;
		this.chinese = chinese;
	}
	
	public Links() {
		
	}
	
	public String getSign() {
		return sign;
	}
	
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	public String getMaya() {
		return maya;
	}
	
	public void setMaya(String maya) {
		this.maya = maya;
	}
	
	public String getChinese() {
		return chinese;
	}
	
	public void setChinese(String chinese) {
		this.chinese = chinese;
	}
	
	@Override
	public String toString() {
		return "\nsign - " + sign + "\nmaya - " + maya + "\nchinese - " + chinese;
	}
}
