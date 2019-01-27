import java.util.Scanner;
import java.util.ArrayList;
public class Subscribe
{
	Scanner userInput = new Scanner(System.in);
	String userAnswer = userInput.next();
	System.out.println("Enter the name of a channel to ensure its videos appear in your subscription feed.");
	Subscribe(userAnswer);
	private String vidTitle; private boolean isSubbed;
		
	public Subscribe(String channel)
	{
		List<Video> SubList = new ArrayList<Video>();
		for(int i = 0; i < Youtube.size(); i++)
		{
			if(!channel.isSubbed())
			{
				//retrieve all videos who have the same channel name
				//add all those videos to the subFeed
				for(int j = 0; j < yt.size(); j++)
				{
					List<Video> channelList = new ArrayList<Video>();
					String vidChannel = yt(j).channelName();
					if(vidChannel.equals(channel))
					{
						channelList.add(yt(j));
					}
				}
				for(int e = 0; e < channelList.size(); e++)
				{
					subList(e) = channelList(e);
				}
				return subList;
			}
			else
				System.out.println("You are already subscribed to this channel.");
		}
	}
	public isSubbed(Youtube yt)
	{
		this.yt = yt;
		runSubscription();
	}
	public void runSubscription()
	{
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("SanSerif", Font.BOLD, 20)));
		UIManager.put("OptionPane.messageForeground");
	}

	public String getTitle()
	{
		return vidTitle;
	}
	
		
	

	
}
