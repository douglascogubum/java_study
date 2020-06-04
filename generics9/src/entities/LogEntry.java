package entities;

import java.util.Date;

public class LogEntry {
	
	private String userDate;
	private Date moment;
	
	public LogEntry(String userDate, Date moment) {
		this.userDate = userDate;
		this.moment = moment;
	}
	
	public String getUserDate() {
		return userDate;
	}
	public void setUserDate(String userDate) {
		this.userDate = userDate;
	}
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userDate == null) ? 0 : userDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogEntry other = (LogEntry) obj;
		if (userDate == null) {
			if (other.userDate != null)
				return false;
		} else if (!userDate.equals(other.userDate))
			return false;
		return true;
	}	
}
