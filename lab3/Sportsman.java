package com.company;

/**
 * Created by Andrii on 27.10.2017.
 */
public class Sportsman implements Comparable<Sportsman>{

	private int mFinePoints;
	private int mResult;
	private String mName;
	private String mSurname;
	private Team mTeam;
	private SportType mSportType;

	public Sportsman() {
	}

	public Sportsman(int finePoints, int result, String name, String surname, SportType sportType) {
		this.mFinePoints = finePoints;
		this.mResult = result;
		this.mName = name;
		this.mSurname = surname;
		this.mSportType = sportType;
	}

	public int getFinePoints() {
		return mFinePoints;
	}

	public void setFinePoints(int finePoints) {
		this.mFinePoints = finePoints;
	}

	public int getResult() {
		return mResult;
	}

	public void setResult(int result) {
		this.mResult = result;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		this.mName = name;
	}

	public String getSurname() {
		return mSurname;
	}

	public void setSurname(String surname) {
		this.mSurname = surname;
	}

	public Team getTeam() {
		return mTeam;
	}

	public void setTeam(Team team) {
		this.mTeam = team;
	}

	public SportType getSportType() {
		return mSportType;
	}

	public void setSportType(SportType sportType) {
		this.mSportType = sportType;
	}

	@Override
	public int compareTo(Sportsman o) {
		return mName.compareTo(o.getName());
	}

	@Override
	public String toString() {
		return "Sportsman{" +
			"mFinePoints=" + mFinePoints +
			", mResult=" + mResult +
			", mName='" + mName + '\'' +
			", mSurname='" + mSurname + '\'' +
			", mSportType=" + mSportType +
			'}';
	}
}
