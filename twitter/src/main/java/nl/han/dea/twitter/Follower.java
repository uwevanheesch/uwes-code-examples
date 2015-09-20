package nl.han.dea.twitter;

public class Follower implements IFollower {

	String lastTweet = null;

	public void update(TwitterUser user, String tweet) {
		lastTweet = "@" + user.getId() + " tweets: " + tweet;
		System.out.println(lastTweet);
	}

}
