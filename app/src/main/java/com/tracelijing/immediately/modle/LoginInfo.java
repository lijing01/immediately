package com.tracelijing.immediately.modle;

/**
 * Created by Trace (Tapatalk) on 2017/1/7.
 */

public class LoginInfo {

	/**
	 * id : 570238311b56cf11009fd626
	 * username : 7203c6f7-b16a-42f5-9905-10a412c98219
	 * userId : 1747874
	 * preferences : {"env":"prod","debugLogOn":false,"privateTopicSubscribe":false,"subscribeWeatherForecast":true,"dailyNotificationOn":false,"topicTagGuideOn":true}
	 * isBetaUser : false
	 * updatedAt : 2016-04-04T09:47:29.631Z
	 * profileImageUrl : null
	 */

	private String id;
	private String username;
	private int userId;
	/**
	 * env : prod
	 * debugLogOn : false
	 * privateTopicSubscribe : false
	 * subscribeWeatherForecast : true
	 * dailyNotificationOn : false
	 * topicTagGuideOn : true
	 */

	private PreferencesBean preferences;
	private boolean isBetaUser;
	private String updatedAt;
	private Object profileImageUrl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public PreferencesBean getPreferences() {
		return preferences;
	}

	public void setPreferences(PreferencesBean preferences) {
		this.preferences = preferences;
	}

	public boolean isIsBetaUser() {
		return isBetaUser;
	}

	public void setIsBetaUser(boolean isBetaUser) {
		this.isBetaUser = isBetaUser;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Object getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(Object profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public static class PreferencesBean {
		private String env;
		private boolean debugLogOn;
		private boolean privateTopicSubscribe;
		private boolean subscribeWeatherForecast;
		private boolean dailyNotificationOn;
		private boolean topicTagGuideOn;

		public String getEnv() {
			return env;
		}

		public void setEnv(String env) {
			this.env = env;
		}

		public boolean isDebugLogOn() {
			return debugLogOn;
		}

		public void setDebugLogOn(boolean debugLogOn) {
			this.debugLogOn = debugLogOn;
		}

		public boolean isPrivateTopicSubscribe() {
			return privateTopicSubscribe;
		}

		public void setPrivateTopicSubscribe(boolean privateTopicSubscribe) {
			this.privateTopicSubscribe = privateTopicSubscribe;
		}

		public boolean isSubscribeWeatherForecast() {
			return subscribeWeatherForecast;
		}

		public void setSubscribeWeatherForecast(boolean subscribeWeatherForecast) {
			this.subscribeWeatherForecast = subscribeWeatherForecast;
		}

		public boolean isDailyNotificationOn() {
			return dailyNotificationOn;
		}

		public void setDailyNotificationOn(boolean dailyNotificationOn) {
			this.dailyNotificationOn = dailyNotificationOn;
		}

		public boolean isTopicTagGuideOn() {
			return topicTagGuideOn;
		}

		public void setTopicTagGuideOn(boolean topicTagGuideOn) {
			this.topicTagGuideOn = topicTagGuideOn;
		}
	}
}
