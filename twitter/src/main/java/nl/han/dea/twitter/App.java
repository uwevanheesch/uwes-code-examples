package nl.han.dea.twitter;

public class App {
	public static void main(String[] args) {
		TwitterUser uwe = new TwitterUser("Uwe");
		Follower hans = new Follower();
		uwe.addFollower(hans);
				
		uwe.tweet("Patterns bore #DEA class to death.");
		
	}
}
