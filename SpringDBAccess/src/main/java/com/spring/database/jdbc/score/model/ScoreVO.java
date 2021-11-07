package com.spring.database.jdbc.score.model;

public class ScoreVO {
	
	private Integer stuId;
	private String stuName;
	private Integer kor;
	private Integer eng;
	private Integer math;
	private Integer total;
	private Double average;
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public Integer getKor() {
		return kor;
	}
	public void setKor(Integer kor) {
		this.kor = kor;
	}
	public Integer getEng() {
		return eng;
	}
	public void setEng(Integer eng) {
		this.eng = eng;
	}
	public Integer getMath() {
		return math;
	}
	public void setMath(Integer math) {
		this.math = math;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer totla) {
		this.total = totla;
	}
	public Double getAverage() {
		return average;
	}
	public void setAverage(Double average) {
		this.average = average;
	}
	
	public void calcData() {
		this.total = this.kor + this.eng + this.math;
		this.average = Math.round((this.total / 3.0) * 100) / 100.0;
	}
	
	@Override
	public String toString() {
		return "ScoreVO [stuId=" + stuId + ", stuName=" + stuName + ", kor=" + kor + ", eng=" + eng + ", math=" + math
				+ ", total=" + total + ", average=" + average + "]";
	}
	
}
