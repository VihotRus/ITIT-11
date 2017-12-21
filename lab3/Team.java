package com.company;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrii on 27.10.2017.
 */
public class Team implements Comparable<Team>{

	private int mId;
	private String mName;
	private SportType mType;
	private List<Sportsman> mMembers = new ArrayList<>();

	public Team() {
	}

	public Team(int id, String name, SportType type) {
		mId = id;
		mName = name;
		mType = type;
	}

	public int getId() {
		return mId;
	}

	public void setId(int id) {
		mId = id;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		mName = name;
	}

	public SportType getType() {
		return mType;
	}

	public void setType(SportType type) {
		mType = type;
	}

	public boolean isMember(Sportsman sportsman) {
		return mMembers.indexOf(sportsman) != -1;
	}

	public List<Sportsman> getMembers() {
		return mMembers;
	}

	public void setMembers(@NotNull List<Sportsman> members) {
		mMembers = members;
	}

	public void addMember(Sportsman sportsman) {
		mMembers.add(sportsman);
	}

	public void removeMember(Sportsman sportsman) {
		mMembers.remove(sportsman);
	}

	@Override
	public int compareTo(Team o) {
		return mName.compareTo(o.getName());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		mMembers.forEach(sportsman -> builder.append(sportsman.toString()).append("\n"));
		return "Team{" +
			"mId: " + mId +
			", mName: '" + mName + '\'' +
			", mType: " + mType +
			", mMembers:\n" + builder.toString() +
			'}';
	}
}
