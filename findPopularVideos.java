
public class findPopularVideos 
{
	private String viewCount;
	
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
	public boolean isPopular(double result)
	{
		return result > 1000000;
	}
	public int avgViewCount(int[] viewCount, Video v)
	{
		//add all viewCounts from each v in the table, then divide by the amount of videos(length of table?)
		int total = 0;
		for(Video v : Youtube)
		{
			total = total + v.viewCount();
		}
		int length = total.length();
		return total/length;
	}
	
	
}
