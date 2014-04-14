Java-Address-Book
=================

University of Phoenix class assignment


The final version of the Address Book program was to be an amalgamation of the pervious seven assignments combined with several new features added to the GUI.  Here is a compilation of all of the requirements of the program as time went on:


Version 1:

•	Create a non-GUI-based Java application that stores mailing addresses and charitable donations for individual people.  The application should display text that requests the user enter a name, street address with city, state and ZIP code, the number of donations this year, and the amount of the donation.  The application should print out the individual name and address along with a total of donations for the year, which is the amount multiplied by the number of donations.  The application should display the dollar symbol ($) to the left of the yearly donation amount and format the yearly donation amount to display currency.


Version 2:

•	Modify the Address Book application so it continues to request individual information until the user has entered 5 individuals.  The loop should be counter controlled, so using a break command to end the loop is not allowed.   In addition, program the application to check that the donation amount and number of donations are positive numbers.  If either the donation amount or the number of donations is not a positive value, the application should prompt the user to enter a positive amount.


Version 3:

•	Modify the Address Book Program so that it uses a class to store and retrieve the individual’s name and address, the donation amount, and the number of donations. Use a constructor to initialize the individual information, and a method within that class to calculate the yearly donation total.  Once 5 individuals have been entered, the application should terminate. Make sure the program maintains all the functionality required in previous assignments and your source code is readable and well documented. Use feedback you have received from the instructor to make any needed modifications.


Version 4:

•	Modify the Address Book program to use an array to store the objects created in Part 3.  The array should be of the object type created in Part 3 and only one array is allowed to be used.  The program should output the total of all the yearly donations for each person in a grand total of all donors in addition to all previous output.  Pay attention to the good programming practices in the text to ensure your source code is readable and well documented.


Version 5:

•	Modify the Address Book Program by creating a subclass of the individual class adds a unique feature to the individual class (a phone number would be a good example).  In the subclass, create a method to calculate the value of the yearly donations with the same name as the method previously created for the individual class.  The subclass method should also reduce the donation value to 80% of the amount of the total yearly donation, so, for example,  if the total donation is $100.00, then the method should change the value to $80.00.

•	Modify the program to include a method to sort the address book by highest donation total. This means the donor with the largest total donation amount will be first and then sorted in descending order.

•	Modify the output to display the additional feature you have chosen and the 80% value  decrease.  The decrease should be reflected in the output of each individual yearly donation.


Version 6:

•	Modify the Address Book Program to use a GUI.  The GUI should display the individual information one person at a time, including name, address, additional attribute, and total yearly donation.  In addition, the GUI should display the value of the entire address book’s yearly donations. The user input should  be performed with dialog boxes in the GUI.


Version 7:

•	Modify the Address Book Program by adding a button to the GUI that allows the user to move to the first item, the previous item, the next item, and the last item in the Address Book. If the first item is displayed and the user clicks on the Previous button, the last item should display.  If the last item is displayed and the user clicks on the Next button, the first item should display.

•	Add a personalized, drawn logo to the GUI using Java graphics classes. Using an imported GIF, JPG or other picture file is not allowed for a logo.


Version 8:

•	Modify the Address Book Program to include an Add button, a Delete button, and a Modify button on the GUI. These buttons should allow the user to perform the corresponding actions on the individual name and address, the number or donations, and the donation amount. 

•	Add a Save button to the GUI that saves the address book information to a C:\data\inventory.dat file.

•	Use exception handling to create the directory and file if necessary.

•	Add a search button to the GUI that allows the user to search for an individual by name. If the individual is not found, the GUI should display an appropriate message. If the person is found, the GUI should display that person’s information in the GUI.


The .java file located in this repository represents the final version, version 8.
