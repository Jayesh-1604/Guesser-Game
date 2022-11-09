import java.util.*;

class QuesData
{
	
	private String ques;
	private String options[] = new String[4];
	private String ans;
	
	
	
	
	public String getQues() {
		return ques;
	}



	public void setQues(String ques) {
		this.ques = ques;
	}

	public String getAns() {
		return ans;
	}



	public void setAns(String ans) {
		this.ans = ans;
	}


	public String[] getOptions() {
		return options;
	}



	public void setOptions(String[] options) {
		
		for(int i=0; i<4; i++)
		{
			this.options[i] = options[i];
		}
	}
}

public class First{

	public static Scanner sc = new Scanner(System.in);
	
	public static void mainMenu(QuesData qd)
	{
		while(true)
		{
			
			System.out.println("<<<<<<<<<<<<<<<<<<Menu>>>>>>>>>>>>>>>>>>\n");
			System.out.println("1  Create a new Game");
			System.out.println("2. Play The Game");
			System.out.println("3. Quite");
			System.out.print("\n\nEnter your choice Number :\t");
			int ch = sc.nextInt();
			
			switch(ch)
			{
				case(1): createNewGame(qd); break;
				case(2): playTheGame(qd); break;
				case(3): break;
				default: System.out.println("Enter Proper Choice..");
				
			}
			
			
			if(ch == 3)
			{
				System.out.println("Thank You & Visit Again ...\n");
				break;
			}
			
		}
	}
	
	
	
	public static void createNewGame(QuesData qd)
	{
		System.out.print("Enter Question for Guesser Game -> ");
		
		Scanner sc1 = new Scanner(System.in);
		
		String q = sc1.nextLine();
		qd.setQues(q);
		
		String options[] = new String[4];
		
		System.out.println("PLease Enter Options..\n");
		for(int i=0; i<4; i++)
		{
			System.out.print("Option "+(i+1)+" ->");
			options[i] = sc1.nextLine();	
		}
		
		qd.setOptions(options);
		
		System.out.print("Set Answer ->");
		String ans = sc1.nextLine();
		qd.setAns(ans);
		
		System.out.println("Your Question is set..\n");
		
		
	}
	
	public static void playTheGame(QuesData qd)
	{
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("QUESTION :-> \n"+qd.getQues());
		String op[] = new String[0];
		op = qd.getOptions();
		
		for(int i=0; i<4; i++)
		{
			System.out.println((i+1)+"\t"+op[i]);
		}
		
		int count = 3;
		for(int i=0; i<3; i++)
		{
			count--;
			System.out.print("Choose Options->");
			
			int ch = sc2.nextInt();
			
			
			
			if(op[ch-1].equals(qd.getAns()))
			{
				System.out.println("Your Ans is Correct..");
				break;
			}
			else
				System.out.println("Incorrect..Please try Again "+(i+1)+"/3 Attempts Left");
			
			if(count == 0)
				System.out.println("Game Over");
		}
		
	}
	
	
	public static void main(String[] args)
	{
		// Calling mainMenu
		QuesData qd = new QuesData();
		mainMenu(qd);
	}
}