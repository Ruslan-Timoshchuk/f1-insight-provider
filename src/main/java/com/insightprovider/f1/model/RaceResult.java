package com.insightprovider.f1.model;

import java.time.Duration;
import java.util.Objects;

public class RaceResult {

	private final Duration lapTime;
	private final String fullName;
	private final String team;

	public RaceResult(Duration lapTime, String fullName, String team) {
		this.lapTime = lapTime;
		this.fullName = fullName;
		this.team = team;
	}

	public Duration getLapTime() {
		return lapTime;
	}

	public String getFullName() {
		return fullName;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fullName, lapTime, team);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RaceResult other = (RaceResult) obj;
		return Objects.equals(fullName, other.fullName) && Objects.equals(lapTime, other.lapTime)
				&& Objects.equals(team, other.team);
	}
	
}