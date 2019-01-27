
public class Video 
{
	//instance variables
	private String viewCount;
	private String vidTitle;
	private String channelName;
	private String vidGenre;
	private boolean isSubbed;
	private boolean isChannelAmerican;
	private boolean isSFW;

	
	//constructors
	public Video (String viewCount, String vidTitle, String vidGenre, boolean isSFW, boolean isSubbed, boolean isChannelAmerican, String channelName)
	{
		this.viewCount = viewCount; this.vidTitle = vidTitle; this.isSubbed = isSubbed;
		this.isChannelAmerican = isChannelAmerican; this.channelName = channelName; this.vidGenre = vidGenre;
		this.isSFW = isSFW;
	}
	//accessors
	public String viewCount() {return viewCount;}
	public String vidTitle() {return vidTitle;}
	public String channelName() {return channelName;}
	public String vidGenre() {return vidGenre;}
	public boolean isSubbed() {return isSubbed;}
	public boolean isChannelAmerican() {return isChannelAmerican;}
	public boolean isSFW() {return isSFW;}
	
	//toString
	public String toString()
	{
		return vidTitle + ", Channel name " + channelName + ", viewCount "+ viewCount + ", Genre:" + vidGenre + ", Subscribed: " + isSubbed + ", is safe for work:" + isSFW + ", American Channel: " + isChannelAmerican;
	}
	
}
