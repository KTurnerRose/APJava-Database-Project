import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class SubFeedDataReader 
{
	public static void main(String[] args) throws Exception //if unanticipated error, gathers and stores this error
	{
		String filename = "Youtube.csv";
		File inputFile = new File(filename);
		if (!inputFile.exists())
			System.out.println(filename + " cannot be found");
		else
		{
			Scanner input = new Scanner(inputFile);
			int lineCount = 0;
			while (input.hasNextLine())
			{
				input.nextLine();
				lineCount++;
			}

			SubscriptionFeed Youtube = new SubscriptionFeed(lineCount);//calling constructor of Youtube, which builds a table according to how many videos there are
			input.close();
			input = new Scanner(inputFile);
			
			String currentLine; //will keep track of entire line
			String[] vidData; //will be the array of strings the currentLine will be spit into
			Video e;
			
			//creating temporary variables
			String vidTitle, channelName, vidGenre, viewCount;
			boolean isSubbed, isChannelAmerican, isSFW;
			

			//splitting strings on comma to create an array of strings which will be manipulated
			lineCount = 0;
			while (input.hasNextLine())
			{
				currentLine = input.nextLine();
				
				vidData = currentLine.split(",");
				
				vidTitle = vidData[0];
				channelName = vidData[1];
				vidGenre = vidData[2];
				viewCount = vidData[3];
		
				if (vidData[4].equals("Yes"))
					isSubbed = true;
				else
					isSubbed = false;
				if (vidData[5].equals("Yes"))
					isChannelAmerican = true;
				else
					isChannelAmerican = false;
				if (vidData[6].equals("Yes"))
					isSFW = true;
				else
					isSFW = false;
				
				//creating new video with the info
				e = new Video(channelName, vidTitle, vidGenre, viewCount, isSubbed, isChannelAmerican, isSFW);
				//then using setVideo to pass line number and setting the built video there
				Youtube.setVideo(lineCount, e);
				//incrementing line and repeating
				lineCount++;
		}
		
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a video title: ");
		String n = reader.next();
		
		System.out.println("The average view count for your subscription list is: " + Youtube.avgViewCount() + " views.");
		
		System.out.println("Your subscription list sorted by popularity: " + Youtube.sortByPopularity());
		
		System.out.println("Your subscription list alphabetized: " + Youtube.sortByTitle());
		
		
			//close scanner, print out the table
			input.close();
			System.out.println(Youtube);
			System.out.println();
			
			
			/*arrays are fixed in memory
			 making a compound class
			 bottom - up design: starting with specific class, then building compound class off of it
			 */
			}
	
	}
	
}
