//Address Book Part 8- GUI
//IT215
//George Williams

import java.awt.*; //Import all AWT classes
import java.awt.event.*; //Import all AWT Event Classes
import java.awt.geom.*; //Import classes for Quadratic Curves
import javax.swing.*; //Import all Swing Classes
import java.io.*; //Import all in/out classes for file writing


/*
=====================================
=Class Name: donatorInformation     =
=Purpose: contains all variables and=
=methods relating to donator info   =
=====================================
*/

class donatorInformation
{

	//Setup private variables
	String fName,lName,address,city,state,phone;
	int zip,donation,times,tYDonation;
	boolean empty;

	/*
	=====================================
	=Method Name: donatorInformation    =
	=Purpose: apply user input to array =
	=====================================
    */
    public donatorInformation()
    {
		this.empty = true;
	}


	/*
	=====================================
	=Method Name: newDonator            =
	=Purpose: apply user input to array =
	=====================================
    */
	public void newDonator(String fname, String lname, String dAddress, String dCity, String dState, int dZip, int dDonation, int dDonationAT,String dPhone, boolean status)
	{
		//Save passed information to array
		fName = fname;
		lName = lname;
		address = dAddress;
		city = dCity;
		state = dState;
		zip = dZip;
		donation = dDonation;
		times = dDonationAT;
		phone = dPhone;
		empty = status;
	}

	//Create get methods to return donator entry data
	public String getFirstName()
	{
		return fName;
	}

	public void setFirstName(String firstName)
	{
		fName = firstName;
	}

	public String getLastName()
	{
		return lName;
	}

	public void setLastName(String lastName)
	{
		lName = lastName;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String newAddress)
	{
		address = newAddress;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String newCity)
	{
		city = newCity;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String newState)
	{
		state = newState;
	}

	public int getZip()
	{
		return zip;
	}

	public void setZip(int newZip)
	{
		zip = newZip;
	}

	public int getDonation()
	{
		return donation;
	}

	public void setDonation(int newDonation)
	{
		donation = newDonation;
	}

	public int getdPT()
	{
		return times;
	}

	public void setdPT(int newTimes)
	{
		times = newTimes;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String newPhone)
	{
		phone = newPhone;
	}

	public boolean isEmpty()
	{
		return empty;
	}

	public void setStatus(boolean newStatus)
	{
		empty = newStatus;
	}
} //End donatorInformation




/*
================================
=Class Name: LabelFrame        =
=Description: Creates main prog=
=GUI window, buttons, and icons=
================================
*/
class LabelFrame extends JFrame
{
	//Initilize following variables as JButton's
	JButton newDonator;
	JButton modEntry;
	JButton delEntry;
	JButton aDStats;
	JButton search;
	JButton disAll;
	JButton cyclDonators;
	JButton saveEAB;
	JButton aboutProg;
	JButton quit;

	JFrame cFrame;

	public LabelFrame()
	{
		super("Electronic Address Book Version 1.8"); //Set Window Title
		setLayout(new FlowLayout()); //Indicate no specific layout method

		cFrame = this;

		//Define and add buttons to GUI
		newDonator = new JButton("Add a New Donator",null);
		add(newDonator);

		modEntry = new JButton("Modify an Entry",null);
		add(modEntry);

		delEntry = new JButton("Delete an Entry",null);
		add(delEntry);

		aDStats = new JButton("Annual Donation Statistics",null);
		add(aDStats);

		search = new JButton("Search",null);
		add(search);

		disAll = new JButton("Display All Donators",null);
		add(disAll);

		cyclDonators = new JButton("Cycle Through Donators",null);
		add(cyclDonators);

		saveEAB = new JButton("Save Address Book");
		add(saveEAB);

		aboutProg = new JButton("About Program",null);
		add(aboutProg);

		quit = new JButton("Quit",null);
		add(quit);



		//Create new handler variable for event dissemination
		ButtonHandler handler = new ButtonHandler();

		//Create new action listeners for the buttons in order to send events when used
		newDonator.addActionListener(handler);
		modEntry.addActionListener(handler);
		delEntry.addActionListener(handler);
		aDStats.addActionListener(handler);
		search.addActionListener(handler);
		disAll.addActionListener(handler);
		cyclDonators.addActionListener(handler);
		saveEAB.addActionListener(handler);
		aboutProg.addActionListener(handler);
		quit.addActionListener(handler);
	}


	//Creates inter-class which detects events as they are sent and inacts the proper methods associated with those events.
	private class ButtonHandler implements ActionListener
	{
		extOps eO = new extOps(); //Reference for extra custom events class, which extends custEvents, so we can call the requested methods

		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			if (event.getSource() == newDonator)
			{
				eO.addDonator();
			}

			else if (event.getSource() == modEntry)
			{
				eO.modifyEntry();
			}

			else if (event.getSource() == delEntry)
			{
				eO.deleteEntry();
			}

			else if (event.getSource() == aDStats)
			{
				eO.annualDonationStats();
			}

			else if (event.getSource() == search)
			{
				eO.search();
			}

			else if (event.getSource() == disAll)
			{
				eO.displayAllDonators();
			}

			else if (event.getSource() == cyclDonators)
			{
				eO.cyclDonators();
			}

			else if (event.getSource() == saveEAB)
			{
				eO.saveEAB();
			}

			else if (event.getSource() == aboutProg)
			{
				eO.aboutProg();
			}

			else if (event.getSource() ==  quit)
			{
				eO.quit(cFrame);
			}

			else
			{
				eO.error(event.getActionCommand()); //In the event that the event name does not match a listed method, throw an error dialog.
			}
		}
	}
}

//class to crete logo for about program window
class logoPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		this.setBackground(Color.WHITE);

		g.setColor(Color.RED);
		g.drawLine(5,10,30,10);
		g.drawLine(5,40,30,40);
		g.drawLine(5,70,30,70);
		g.drawLine(30,10,30,70);

		g.setColor(Color.BLUE);
		g.drawLine(31,10,31,70);
		g.drawLine(31,10,61,70);
		g.drawLine(32,40,45,40);

		g.setColor(Color.GREEN);
		g.drawLine(32,10,62,70);
		QuadCurve2D b1 = new QuadCurve2D.Float();
		QuadCurve2D b2 = new QuadCurve2D.Float();

		b1.setCurve(32,10,88,18,46,40);
		b2.setCurve(46,40,108,50,62,70);
		g2.draw(b1);
		g2.draw(b2);
	}
}


/*
================================
=Class Name: custEvents        =
=Description: When an event is =
=fired, goes through a check   =
=against known methods.  When  =
=found it triggers a method    =
=listed here.                  =
================================
*/
class custEvents
{

	donatorInformation[] dInfo = new donatorInformation[5];
	boolean valid = false,bDone = false,setup = false;
	int validityCheck,total,aveDonation,aveDT,i = 0,i3 = 0,i4 = 0,choice,entry = 0;
	String uInput1,uInput6,uInput7,uInput8,uInput9;

	JButton donNext;
	JButton donPrev;
	JButton donFirst;
	JButton donLast;
	JButton fName;
	JButton lName;
	JButton address;
	JButton city;
	JButton state;
	JButton zip;
	JButton donation;
	JButton pledge;
	JButton phone;
	JButton close;
	JButton done;
	JFrame nFrame2;
	JFrame nFrame3;
	JFrame nFrame4;
	JList jList1;
	JList donator;

    //Method to change a donators donation information
	public void modifyEntry()
	{
		uInput1 = JOptionPane.showInputDialog("Please enter in the first name of the individual whose donation you wish to modify");

		for (i = 0; i < dInfo.length; i++)
		{
			if ((uInput1) .equals (dInfo[i].getFirstName()))
			{
				JOptionPane.showMessageDialog(null,"Donator Found: " + dInfo[i].getFirstName() + ", " + dInfo[i].getLastName() + ", " + dInfo[i].getAddress() + ", " + dInfo[i].getCity() + ", " + dInfo[i].getState() + ", " + dInfo[i].getZip() + ", " + dInfo[i].getDonation() + ", " + dInfo[i].getdPT() + ", " + dInfo[i].getPhone(),"Donator Information",JOptionPane.PLAIN_MESSAGE);

				nFrame4 = new JFrame("Modify Donator Entry For" + dInfo[i].getFirstName() + " " + dInfo[i].getLastName());
				nFrame4.setSize(250,250);
				nFrame4.setVisible(true);
				nFrame4.setLayout(new FlowLayout());

				JOptionPane.showMessageDialog(null,i,null,JOptionPane.PLAIN_MESSAGE);

				fName = new JButton("Modify First Name");
				nFrame4.add(fName);

				lName = new JButton("Modify Last Name");
				nFrame4.add(lName);

				address = new JButton("Modify Address");
				nFrame4.add(address);

				city = new JButton("Modify City");
				nFrame4.add(city);

				state = new JButton("Modify State");
				nFrame4.add(state);

				zip = new JButton("Modify Zip");
				nFrame4.add(zip);

				donation = new JButton("Modify Donation Amount");
				nFrame4.add(donation);

				pledge = new JButton("Modify Yearly Donation Pledge");
				nFrame4.add(pledge);

				phone = new JButton("Modify Phone Number");
				nFrame4.add(phone);

				done = new JButton("Done");
				nFrame4.add(done);

				ButtonHandler handler = new ButtonHandler();

				fName.addActionListener(handler);
				lName.addActionListener(handler);
				address.addActionListener(handler);
				city.addActionListener(handler);
				state.addActionListener(handler);
				zip.addActionListener(handler);
				donation.addActionListener(handler);
				pledge.addActionListener(handler);
				phone.addActionListener(handler);
				done.addActionListener(handler);

				i3 = i;

				if (i == dInfo.length - 1)
				{
					JOptionPane.showMessageDialog(null,"The name was not found!","ERROR CODE 4",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

    //Now depriciated for method in extOps.  Print the total yearly donation, the average single donation, and average yearly donation pledges
	public void annualDonationStats()
	{
		total = 0;
		aveDonation = 0;
		aveDT = 0;

		for (i = 0; i < dInfo.length; i++)
		{
			total += (dInfo[i].getDonation() * dInfo[i].getdPT());
			aveDonation += dInfo[i].getDonation();
			aveDT += dInfo[i].getdPT();
		}

		aveDonation = aveDonation / dInfo.length;
		aveDT = aveDT / dInfo.length;

		JOptionPane.showMessageDialog(null,"The total sum of all donations is " + total + "\n" + "The average donation is " + aveDonation + "\n" + "The average number of donation pledges is " + aveDT,"Donation Totals and Other Information",JOptionPane.PLAIN_MESSAGE);

		total = 0;
		aveDonation = 0;
		aveDT = 0;
	}

    //Method to close the main program frame once Quit is pressed
	public void quit(JFrame cFrame)
	{
		cFrame.dispose();
	}

    //Search for a specific donator via address
	public void search()
	{

		uInput1 = JOptionPane.showInputDialog("Please enter in the first name of the individual you are looking for");

		for (i = 0; i < dInfo.length; i++)
		{
			if ((uInput1) .equals (dInfo[i].getFirstName()))
			{
				JOptionPane.showMessageDialog(null,"Donator Found: " + dInfo[i].getFirstName() + ", " + dInfo[i].getLastName() + ", " + dInfo[i].getAddress() + ", " + dInfo[i].getCity() + ", " + dInfo[i].getState() + ", " + dInfo[i].getZip() + ", " + dInfo[i].getDonation() + ", " + dInfo[i].getdPT() + ", " + dInfo[i].getPhone(),"Donator Information",JOptionPane.PLAIN_MESSAGE);
				i = 5;
			}

			if (i == dInfo.length -1)
			{
				JOptionPane.showMessageDialog(null,"The name was not found!!!","ERROR CODE 7",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

    //Depriciated by extOps method.  Sorts donators in acsending order based on donation amount them prints a list of them to a new window
	public void displayAllDonators()
	{
		donatorInformation temp = new donatorInformation();

		for (int i2 = 0;i2 < dInfo.length -1;i2++)
		{
			if (dInfo[i2].getDonation() > dInfo[i2+1].getDonation())
			{
				temp = dInfo[i2];
				dInfo[i2] = dInfo[i2+1];
				dInfo[i2+1] = temp;
				i2 = -1;
			}
		}


		String[] dInfo2 = new String[5];

		for (int i = 0;i < dInfo2.length;i++)
		{
			dInfo2[i] = dInfo[i].getFirstName() + ", " + dInfo[i].getLastName() + ", " + dInfo[i].getAddress() + ", " + dInfo[i].getCity() + ", " + dInfo[i].getState() + ", " + dInfo[i].getZip() + ", " + dInfo[i].getDonation() + ", " + dInfo[i].getdPT() + ", " + dInfo[i].getPhone();
		}

		jList1 = new JList(dInfo2);
		jList1.setVisibleRowCount(5);

		JFrame newJFrame = new JFrame("Full list of Donators");
		JPanel newJPanel = new JPanel();
		newJPanel.add(jList1);
		newJFrame.add(newJPanel);
		newJFrame.setSize(400, 400);
    	newJFrame.setVisible(true);
	}

	//display new dialog window with buttons to scan through donator database.
	public void cyclDonators()
	{
		nFrame2 = new JFrame("Donators");
		nFrame2.setSize(400,400);
		nFrame2.setVisible(true);
		nFrame2.setLayout(new FlowLayout()); //Indicate no specific layout method


		donFirst = new JButton("First Entry",null);
		nFrame2.add(donFirst);


		donPrev = new JButton("Previous Donator",null);
		nFrame2.add(donPrev);


		donNext = new JButton("Next Donator",null);
		nFrame2.add(donNext);


		donLast = new JButton("Last Donator",null);
		nFrame2.add(donLast);


		close = new JButton("Close");
		nFrame2.add(close);


		ButtonHandler handler = new ButtonHandler();

		donNext.addActionListener(handler);
		donPrev.addActionListener(handler);
		donFirst.addActionListener(handler);
		donLast.addActionListener(handler);
		close.addActionListener(handler);
	}

	//allow user to delete a donator's entry.
	public void deleteEntry()
	{
		String uInput1 = JOptionPane.showInputDialog("Please etner the first name of the donator you want to delete");

		for (i = 0; i < dInfo.length -1; i++)
		{
			if ((uInput1) .equals (dInfo[i].getFirstName()))
			{
				JOptionPane.showMessageDialog(null,"Donator Found: " + dInfo[i].getFirstName() + ", " + dInfo[i].getLastName() + ", " + dInfo[i].getAddress() + ", " + dInfo[i].getCity() + ", " + dInfo[i].getState() + ", " + dInfo[i].getZip() + ", " + dInfo[i].getDonation() + ", " + dInfo[i].getdPT() + ", " + dInfo[i].getPhone(),"Donator Information",JOptionPane.PLAIN_MESSAGE);
				choice = JOptionPane.showConfirmDialog(null,"Is this the entry you were looking for?","Confirm Entry",JOptionPane.YES_NO_OPTION);

				if (choice == 0)
				{
					choice = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this entry?","Confirm Deletion",JOptionPane.YES_NO_OPTION);

					if (choice == 0)
					{
						String sDefault = " ";
						int iDefault = 0;
						boolean status = true;

						dInfo[i].setFirstName(sDefault);
						dInfo[i].setLastName(sDefault);
						dInfo[i].setAddress(sDefault);
						dInfo[i].setCity(sDefault);
						dInfo[i].setState(sDefault);
						dInfo[i].setZip(iDefault);
						dInfo[i].setDonation(iDefault);
						dInfo[i].setdPT(iDefault);
						dInfo[i].setPhone(sDefault);
						dInfo[i].setStatus(status);
					}
				}
			}
		}
	}

	//class to handel button events
	class ButtonHandler implements ActionListener
	{
		String dInfo2;

		public void actionPerformed(java.awt.event.ActionEvent event)
		{

			if (event.getSource() == donNext)
			{
				i += 1;

				if (i < 0 || i > dInfo.length - 1)
				{
					i = 0;
				}

				dInfo2 = dInfo[i].getFirstName() + ", " + dInfo[i].getLastName() + ", " + dInfo[i].getAddress() + ", " + dInfo[i].getCity() + ", " + dInfo[i].getState() + ", " + dInfo[i].getZip() + ", " + dInfo[i].getDonation() + ", " + dInfo[i].getdPT() + ", " + dInfo[i].getPhone();
				JOptionPane.showMessageDialog(null,dInfo2,"Donator Entry" + i,JOptionPane.PLAIN_MESSAGE);

			}

			else if (event.getSource() == donPrev)
			{
				i -= 1;

				if (i < 0 || i > dInfo.length - 1)
				{
					i = dInfo.length - 1;
				}

				dInfo2 = dInfo[i].getFirstName() + ", " + dInfo[i].getLastName() + ", " + dInfo[i].getAddress() + ", " + dInfo[i].getCity() + ", " + dInfo[i].getState() + ", " + dInfo[i].getZip() + ", " + dInfo[i].getDonation() + ", " + dInfo[i].getdPT() + ", " + dInfo[i].getPhone();
				JOptionPane.showMessageDialog(null,dInfo2,"Donator Entry" + i,JOptionPane.PLAIN_MESSAGE);

			}

			else if (event.getSource() == donFirst)
			{
				i = 0;
				dInfo2 = dInfo[i].getFirstName() + ", " + dInfo[i].getLastName() + ", " + dInfo[i].getAddress() + ", " + dInfo[i].getCity() + ", " + dInfo[i].getState() + ", " + dInfo[i].getZip() + ", " + dInfo[i].getDonation() + ", " + dInfo[i].getdPT() + ", " + dInfo[i].getPhone();
				JOptionPane.showMessageDialog(null,dInfo2,"Donator Entry" + i,JOptionPane.PLAIN_MESSAGE);
			}

			else if (event.getSource() == donLast)
			{
				i = dInfo.length - 1;
				dInfo2 = dInfo[i].getFirstName() + ", " + dInfo[i].getLastName() + ", " + dInfo[i].getAddress() + ", " + dInfo[i].getCity() + ", " + dInfo[i].getState() + ", " + dInfo[i].getZip() + ", " + dInfo[i].getDonation() + ", " + dInfo[i].getdPT() + ", " + dInfo[i].getPhone();
				JOptionPane.showMessageDialog(null,dInfo2,"Donator Entry" + i,JOptionPane.PLAIN_MESSAGE);
			}

			else if (event.getSource() == fName)
			{
				JOptionPane.showMessageDialog(null,i3,"testing i3",JOptionPane.PLAIN_MESSAGE);

				String uInput1 = JOptionPane.showInputDialog("Please enter the donator's first name");
				dInfo[i3].setFirstName(uInput1);
			}

			else if (event.getSource() == lName)
			{
				String uInput1 = JOptionPane.showInputDialog("Please enter the donator's last name");
				dInfo[i3].setLastName(uInput1);
			}

			else if (event.getSource() == address)
			{
				String uInput1 = JOptionPane.showInputDialog("Please enter the donator's address");
				dInfo[i3].setAddress(uInput1);
			}

			else if (event.getSource() == city)
			{
				String uInput1 = JOptionPane.showInputDialog("Please enter the donator's city");
				dInfo[i3].setCity(uInput1);
			}

			else if (event.getSource() == state)
			{
				String uInput1 = JOptionPane.showInputDialog("Please enter the donator's state");
				dInfo[i3].setState(uInput1);
			}

			else if (event.getSource() == zip)
			{
				while (!valid)
				{
					String uInput1 = JOptionPane.showInputDialog("Please enter the donator's zip code");

					if (uInput1.length() < 5)
					{
						JOptionPane.showMessageDialog(null,"Zip code can not be less then 5 numbers.","ERROR CODE 1",JOptionPane.ERROR_MESSAGE);
					}

					else
					{
						valid = true;
					}
				}
				valid = false;

				int uInput1_2 = Integer.parseInt(uInput1);

				dInfo[i3].setZip(uInput1_2);
			}

			else if (event.getSource() == donation)
			{
				while (!valid)
				{
					String uInput1 = JOptionPane.showInputDialog("Please enter the donator's donation amount");

					validityCheck = Integer.parseInt(uInput1);

					if (validityCheck < 0)
					{
						JOptionPane.showMessageDialog(null,"Donation can not be less then 1 USD.","ERROR CODE 2",JOptionPane.ERROR_MESSAGE);
					}

					else
					{
						valid = true;
					}
				}
				valid = false;

				dInfo[i3].setDonation(validityCheck);
			}

			else if (event.getSource() == pledge)
			{
				while (!valid)
				{
					String uInput1 = JOptionPane.showInputDialog("Please enter the donator's yearly donation pledge amount");

					validityCheck = Integer.parseInt(uInput1);

					if (validityCheck < 0)
					{
						JOptionPane.showMessageDialog(null,"Pledge can not be less then zero.", "ERROR CODE 3",JOptionPane.ERROR_MESSAGE);
					}

					else
					{
						valid = true;
					}
				}
				valid = false;

				dInfo[i3].setdPT(validityCheck);

			}

			else if (event.getSource() == phone)
			{
				while (!valid)
				{
					uInput9 = JOptionPane.showInputDialog("Please enter the donator's phone number (format: (xxx)xxx-xxxx)");

					if (uInput9.length() < 13)
					{
						JOptionPane.showMessageDialog(null,"Donator phone number must be 13 characters long!","ERROR CODE 6",JOptionPane.ERROR_MESSAGE);
					}

					else
					{
						valid = true;
					}

				}
				valid = false;

				dInfo[i3].setPhone(uInput1);
			}

			else if (event.getSource() == done)
			{
				nFrame4.dispose();
			}

			else if (event.getSource() == close)
			{
				nFrame3.dispose();
			}

			else
			{
				JOptionPane.showMessageDialog(null,"An error has occured: Message, " + event.getActionCommand() + ", has no trigger.", "ERROR CODE 8",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	//saves the current entries to a file
	public void saveEAB()
	{
		File dTest = new File("C:/Data");

		boolean eCheck = dTest.exists();

		if (!eCheck)
		{
			JOptionPane.showMessageDialog(null,"Data folder not found on C Drive!  Creating Data folder...","LOCATION NO FOUND",JOptionPane.WARNING_MESSAGE);
			try
			{
				boolean created = dTest.mkdir();
				if (created)
				{
					JOptionPane.showMessageDialog(null,"Folder created successfully!","Notice",JOptionPane.PLAIN_MESSAGE);
				}

				else
				{
					JOptionPane.showMessageDialog(null,"Folder was unable to be created!!  Saving Failed!!","CRITICAL ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}

			catch (Exception e)
			{
				JOptionPane.showMessageDialog(null,"An error has occurred: " + e.getMessage(),"ERROR CODE 9",JOptionPane.ERROR_MESSAGE);
			}
		}

		try
		{

			FileWriter fStream = new FileWriter("C:/Data/EAB_entry_data.txt");

			BufferedWriter out = new BufferedWriter(fStream);

			for (i = 0; i < dInfo.length - 1; i++)
			{
				out.write("Entry Number: " + i);
				out.newLine(); //for formatting
				out.write("First Name: " + dInfo[i].getFirstName());
				out.newLine(); //for formatting
				out.write("Last Name: " + dInfo[i].getLastName());
				out.newLine(); //for formatting
				out.write("Address: " + dInfo[i].getAddress());
				out.newLine(); //for formatting
				out.write("City: " + dInfo[i].getCity());
				out.newLine(); //for formatting
				out.write("State: " + dInfo[i].getState());
				out.newLine(); //for formatting
				out.write("Zip Code: " + dInfo[i].getZip());
				out.newLine(); //for formatting
				out.write("Donation Amount: " + dInfo[i].getDonation());
				out.newLine(); //for formatting
				out.write("Peldge Times: " + dInfo[i].getdPT());
				out.newLine(); //for formatting
				out.write("Phone Number: " + dInfo[i].getPhone());
				out.newLine(); //for formatting
				out.write("Entry Status: " + dInfo[i].isEmpty());
				out.newLine(); //for formatting
				out.newLine(); //for formatting
				out.newLine(); //for formatting
			}

			out.close(); //close output stream
		}

		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,"An error has occurred: " + e.getMessage(),"ERROR CODE 9",JOptionPane.ERROR_MESSAGE);
		}
		JOptionPane.showMessageDialog(null,"File has been saved successfully!","Save Complete",JOptionPane.PLAIN_MESSAGE);
	}

	//loads about program window
	public void aboutProg()
	{
		nFrame3 = new JFrame("About Program");
		nFrame3.setSize(200,200);
		nFrame3.setVisible(true);

		logoPanel lp = new logoPanel();
		lp.setBackground(Color.WHITE);
		lp.setSize(110,110);
		nFrame3.add(lp);
	}

	//If, by change, a button name sent through the listener is now found, it will trip this method and also print out what event name was sent.
	public void error(String event)
	{
		JOptionPane.showMessageDialog(null,"Message not detected or not sent!!!  Recevied " + event,"ERROR CODE 5",JOptionPane.ERROR_MESSAGE);
	}
}


/*
=====================================
=Class Name:  extOps                =
=Purpose: Includes secondary menu   =
=operations that are extended from  =
=MenuOperations                     =
=====================================
*/

class extOps extends custEvents
{
	public void addDonator()
		{
			if (!setup)
			{

				for (int j = 0;j < dInfo.length;j++)
				{
					dInfo[j] = new donatorInformation();
				}
				setup = true;
			}

			if ((dInfo[entry].isEmpty()) && (entry < dInfo.length -1))
			{
				String uInput1 = JOptionPane.showInputDialog("Please enter the donator's first name");
				String uInput2 = JOptionPane.showInputDialog("Please enter the donator's last name");
				String uInput3 = JOptionPane.showInputDialog("Please enter the donator's address");
				String uInput4 = JOptionPane.showInputDialog("Please enter the donator's city");
				String uInput5 = JOptionPane.showInputDialog("Please enter the donator's state");

				while (!valid)
				{
					uInput6 = JOptionPane.showInputDialog("Please enter the doantor's zip code");

					if (uInput6.length() < 5)
					{
						JOptionPane.showMessageDialog(null,"Zip code can not be less then 5 numbers.", "ERROR CODE 1",JOptionPane.ERROR_MESSAGE);
					}

					else
					{
						valid = true;
					}
				}
				valid = false;



				while (!valid)
				{
					uInput7 = JOptionPane.showInputDialog("Please enter the donator's donation amount");

					validityCheck = Integer.parseInt(uInput7);

					if (validityCheck < 1)
					{
							JOptionPane.showMessageDialog(null,"Donation can not be less then 1 USD.", "ERROR CODE 2",JOptionPane.ERROR_MESSAGE);
					}

					else
					{
						valid = true;
					}
				}
				valid = false;


				while (!valid)
				{
					uInput8 = JOptionPane.showInputDialog("Please enter the donator's yearly donation pledge amount");

					validityCheck = Integer.parseInt(uInput8);

					if (validityCheck < 0)
					{
						JOptionPane.showMessageDialog(null,"Pledge can not be less then zero.", "ERROR CODE 3",JOptionPane.ERROR_MESSAGE);
					}

					else
					{
						valid = true;
					}
				}
				valid = false;

				while (!valid)
				{
					uInput9 = JOptionPane.showInputDialog("Please enter the donator's phone number (format: (xxx)xxx-xxxx)");

					if (uInput9.length() < 13)
					{
						JOptionPane.showMessageDialog(null,"Donator phone number must be 13 characters long!","ERROR CODE 6",JOptionPane.ERROR_MESSAGE);
					}

					else
					{
						valid = true;
					}
				}
				valid = false;

				int uInput6_2 = Integer.parseInt(uInput6);
				int uInput7_2 = Integer.parseInt(uInput7);
				int uInput8_2 = Integer.parseInt(uInput8);

				boolean status = false;

				dInfo[entry].newDonator(uInput1,uInput2,uInput3,uInput4,uInput5,uInput6_2,uInput7_2,uInput8_2,uInput9,status);
				entry += 1;
			}

			else
			{
				JOptionPane.showMessageDialog(null,"The address book is full! (5)", "Warning!",JOptionPane.WARNING_MESSAGE);
			}
	}


    /*
    =====================================
    =Method Name: totalYearDonation     =
    =Purpose: scan all objects for      =
    =donations then calculate total     =
    =donations and then average yearly  =
    =donation total minus the 20% fee   =
    =====================================
    */
		public void totalYearDonation()
		{
			total = 0;
			aveDonation = 0;
			aveDT = 0;

			for (int i = 0; i < dInfo.length; i++)
			{
				total += (dInfo[i].getDonation() * dInfo[i].getdPT());
				aveDonation += dInfo[i].getDonation();
				aveDT += dInfo[i].getdPT();
			}

			aveDonation = aveDonation / dInfo.length;
			aveDT = aveDT / dInfo.length;
			total *= 0.20;

			JOptionPane.showMessageDialog(null,"The total sum of all donations is " + total + "\n" + "The average donation is " + aveDonation + "\n" + "The average number of donation pledges is " + aveDT,"Donation Totals and Other Information",JOptionPane.PLAIN_MESSAGE);

			total = 0;
			aveDonation = 0;
			aveDT = 0;
		}

		//sort the donators in ascending order based on donation amount then print out a list of all of the donators, taking the 20% processing fee on donations into account
		public void dispAllDonators()
		{
			donatorInformation temp = new donatorInformation();

			for (int i2 = 0;i2 < dInfo.length -1;i2++)
			{
				if (dInfo[i2].getDonation() > dInfo[i2+1].getDonation())
				{
					temp = dInfo[i2];
					dInfo[i2] = dInfo[i2+1];
					dInfo[i2+1] = temp;
					i2 = -1;
				}
			}


			String[] dInfo2 = new String[5];

			for (int i = 0;i < dInfo2.length;i++)
			{
				dInfo2[i] = dInfo[i].getFirstName() + ", " + dInfo[i].getLastName() + ", " + dInfo[i].getAddress() + ", " + dInfo[i].getCity() + ", " + dInfo[i].getState() + ", " + dInfo[i].getZip() + ", " + dInfo[i].getDonation() * .20 + ", " + dInfo[i].getdPT() + ", " + dInfo[i].getPhone();
			}

			jList1 = new JList(dInfo2);
			jList1.setVisibleRowCount(5);

			JFrame newJFrame = new JFrame("Full list of Donators");
			JPanel newJPanel = new JPanel();
			newJPanel.add(jList1);
			newJFrame.add(newJPanel);
			newJFrame.setSize(400, 400);
		    newJFrame.setVisible(true);
		}

}


public class it215_w9_Final
{
	public static void main (String args[])
	{
		LabelFrame newFrame = new LabelFrame();
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newFrame.setSize(450,200);
		newFrame.setVisible(true);
    }
}