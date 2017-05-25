package org.glqdlt.okky;

public class PersonVO {

	private String name;
	private String job;
	private int old;

	public boolean jobCheck(String job) {

		return this.job.equals(job);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getOld() {
		return old;
	}

	public void setOld(int old) {
		this.old = old;
	}

}
