
public class SubscriptionFeed 
{
	//https://developers.google.com/youtube/v3/docs/subscriptions
	//method:is safe for work, filter by genre, averge view count
	//sub feed = pt
	private Video[] subFeed;
	
	public double calculateViews(String viewCount)
	{
		for(int k = 0; k < viewCount.length(); k++)
		{
			if(viewCount.charAt(k) == 'M')
			{
				/*String number = "10";
				int result = Integer.parseInt(number);
				System.out.println(result);*/
				String number = viewCount.substring(0, viewCount.length() - 1);
				double result = Integer.parseInt(number);
				return result*1000000;
			}
			if(viewCount.charAt(k) == 'k')
			{
				String number = viewCount.substring(0, viewCount.length() - 1);
				double result = Integer.parseInt(number);
				return result*1000;
			}
		}
		return 900.0; //if video views are too small to have 'k'
	}
	
	public SubscriptionFeed (int numOfVideos) 
	{
		subFeed = new Video[numOfVideos];
	}
	
	public void setVideo(int i, Video e)
	{
		subFeed[i] = e;
	}
	
	public String toString()
	{
		String output = "";
		for (Video e : subFeed)
			output += e.toString() + "\n ";
		return output;
	}
	
	public void sortByTitle()
	{
		for (int i = 1; i < subFeed.length; i++)
		{
			Video temp = subFeed[i];
			int possibleIndex = i;
			while (possibleIndex >0 && temp.vidTitle().compareTo(subFeed[possibleIndex - 1].vidTitle()) < 0) //for ascending sort
			{
				subFeed[possibleIndex] = subFeed[possibleIndex-1];
				possibleIndex--;
			}
		}
	}
	
	public void sortByPopularity()
	{
		for (int i = 1; i < subFeed.length; i++)
		{
			Video temp = subFeed[i];
			int possibleIndex = i;
			double tempViewCount = calculateViews(temp.viewCount());
			double otherViewCount = calculateViews(subFeed[possibleIndex-1].viewCount());
			while (possibleIndex >0 && tempViewCount - otherViewCount < 0) //for ascending sort: other video is more popular than temp video
			{
				subFeed[possibleIndex] = subFeed[possibleIndex-1];
				possibleIndex--;
			}
		}
	}
	
	public void createSubscriptionFeed()
	{
		for (int i = 1; i < subFeed.length; i++)
		{
			Video temp = subFeed[i];
			if (!temp.isSubbed())
			{
				subFeed.remove(temp);
			}
		}
		
	}
}
