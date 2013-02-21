package org.hanfeng.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer SId;
	private String SName;
	private String SAddress;
	private double gpa;
	private String SGender;
	private Set reserves = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(String SName, String SAddress, double gpa, String SGender,
			Set reserves) {
		this.SName = SName;
		this.SAddress = SAddress;
		this.gpa = gpa;
		this.SGender = SGender;
		this.reserves = reserves;
	}

	// Property accessors

	public Integer getSId() {
		return this.SId;
	}

	public void setSId(Integer SId) {
		this.SId = SId;
	}

	public String getSName() {
		return this.SName;
	}

	public void setSName(String SName) {
		this.SName = SName;
	}

	public String getSAddress() {
		return this.SAddress;
	}

	public void setSAddress(String SAddress) {
		this.SAddress = SAddress;
	}

	public double getGpa() {
		return this.gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getSGender() {
		return this.SGender;
	}

	public void setSGender(String SGender) {
		this.SGender = SGender;
	}

	public Set getReserves() {
		return this.reserves;
	}

	public void setReserves(Set reserves) {
		this.reserves = reserves;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((SAddress == null) ? 0 : SAddress.hashCode());
		result = prime * result + ((SGender == null) ? 0 : SGender.hashCode());
		result = prime * result + ((SId == null) ? 0 : SId.hashCode());
		result = prime * result + ((SName == null) ? 0 : SName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(gpa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((reserves == null) ? 0 : reserves.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (SAddress == null) {
			if (other.SAddress != null)
				return false;
		} else if (!SAddress.equals(other.SAddress))
			return false;
		if (SGender == null) {
			if (other.SGender != null)
				return false;
		} else if (!SGender.equals(other.SGender))
			return false;
		if (SId == null) {
			if (other.SId != null)
				return false;
		} else if (!SId.equals(other.SId))
			return false;
		if (SName == null) {
			if (other.SName != null)
				return false;
		} else if (!SName.equals(other.SName))
			return false;
		if (Double.doubleToLongBits(gpa) != Double.doubleToLongBits(other.gpa))
			return false;
		if (reserves == null) {
			if (other.reserves != null)
				return false;
		} else if (!reserves.equals(other.reserves))
			return false;
		return true;
	}

}