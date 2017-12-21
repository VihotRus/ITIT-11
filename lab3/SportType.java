package com.company;

/**
 * Created by Andrii on 27.10.2017.
 */
public enum SportType {
	Football(1),
	Basketball(2),
	Volleyball(3),
	Tenis(4),
	Unknown(-1);

	private int mId;

	SportType(int id) {
		mId = id;
	}

	public int getId() {
		return mId;
	}

	public static SportType fromId(int id) {
		for (SportType type : values()) {
			if (type.getId() == id) {
				return type;
			}
		}
		return Unknown;
	}
}
