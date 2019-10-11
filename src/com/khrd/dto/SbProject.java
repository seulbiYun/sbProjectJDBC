package com.khrd.dto;

import java.util.Date;

public class SbProject {
	private int sbNo;
	private String sbName;
	private String sbContent;
	private Date sbStart;
	private Date sbStop;
	private String sbProgress;

	public SbProject() {
		super();
	}

	public SbProject(int sbNo, String sbName, String sbContent, Date sbStart, Date sbStop, String sbProgress) {
		super();
		this.sbNo = sbNo;
		this.sbName = sbName;
		this.sbContent = sbContent;
		this.sbStart = sbStart;
		this.sbStop = sbStop;
		this.sbProgress = sbProgress;
	}

	public int getSbNo() {
		return sbNo;
	}

	public void setSbNo(int sbNo) {
		this.sbNo = sbNo;
	}

	public String getSbName() {
		return sbName;
	}

	public void setSbName(String sbName) {
		this.sbName = sbName;
	}

	public String getSbContent() {
		return sbContent;
	}

	public void setSbContent(String sbContent) {
		this.sbContent = sbContent;
	}

	public Date getSbStart() {
		return sbStart;
	}

	public void setSbStart(Date sbStart) {
		this.sbStart = sbStart;
	}

	public Date getSbStop() {
		return sbStop;
	}

	public void setSbStop(Date sbStop) {
		this.sbStop = sbStop;
	}

	public String getSbProgress() {
		return sbProgress;
	}

	public void setSbProgress(String sbProgress) {
		this.sbProgress = sbProgress;
	}

	@Override
	public String toString() {
		return "SbProject [sbNo=" + sbNo + ", sbName=" + sbName + ", sbContent=" + sbContent + ", sbStart=" + sbStart
				+ ", sbStop=" + sbStop + ", sbProgress=" + sbProgress + "]";
	}

}
