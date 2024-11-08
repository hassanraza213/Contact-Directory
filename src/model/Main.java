package model;

import model.Contact;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Contact contact = new Contact();
		ArrayList<Contact> addContact = new ArrayList<>();
		
		 boolean isRunning = true;
		String addMore;
		do {
			
			Scanner inputName = new Scanner(System.in);
			System.out.println(" Enter Contact Name ");
			contact.setName(inputName.nextLine());
			
			Scanner inputPhoneNumber = new Scanner(System.in);
			System.out.println(" Enter Phone Number ");
			contact.setPhoneNumber(inputPhoneNumber.nextLine());
			
			addContact.add(contact);
			
			Scanner continueAdding = new Scanner(System.in);
			System.out.println(" Do you want to add more contacts ? Yes | No ");
			addMore = continueAdding.nextLine();
		} while(addMore.equalsIgnoreCase("Yes"));
		
		
		
		String continueMenu;
		do {
			
			System.out.println(" Choose an option ");
			System.out.println(" 1. Update Contact ");
			System.out.println(" 2. Delete Contact ");
			System.out.println(" 3. View Contact ");
			System.out.println(" 4. Exit ");
			
			
			
			Scanner chooseOption = new Scanner(System.in);
			int option = chooseOption.nextInt();

			
			switch(option){
			
			case 1:
			{
				boolean isFound = false;
				Scanner updatedContact = new Scanner(System.in);
				System.out.println(" Enter Contact name you want to update ");
				String searchName = updatedContact.nextLine(); 
				for(int i = 0; i < addContact.size(); i++) {
					
					if(searchName.equalsIgnoreCase(addContact.get(i).getName())) {
						
						Scanner chooseInput = new Scanner(System.in);
						System.out.println(" what do you want to update ");
						System.out.println(" 1. Contact Name ");
						System.out.println(" 2. Contact Number ");
						
						int updatedInput = chooseInput.nextInt();
						chooseInput.nextLine();
						if(updatedInput == 1) {
							
							System.out.println(" Enter updated name ");
							addContact.get(i).setName(chooseInput.nextLine());
							
						} else {
							
							System.out.println(" Enter the updated phone number ");
							addContact.get(i).setPhoneNumber(chooseInput.nextLine());
						}
						
						isFound = true;
						
					} 
				}
				
				if(isFound == false ) {
					System.out.println(searchName+" contact does not exist ");
				}
				
				break;
			}
			
			case 2 : 
			{
				
				boolean contactFound = false;
				Scanner deleteContact = new Scanner(System.in);
				System.out.println(" Enter the contact name you want to delete ");
				String contactToDelete = deleteContact.nextLine();
				
				for(int i = 0; i < addContact.size() ; i++) {
					
					if(addContact.get(i).getName().equalsIgnoreCase(contactToDelete)) {
						contactFound = true;
						addContact.remove(i);
						break;
					}
				}
				
				if(contactFound == false) {
					System.out.println(" Contact not found !");
				}
				
				break;
			}
			
			case 3 :
			{
				if(addContact.isEmpty()) {
					System.out.println(" There are no contacts in the list ");
				} else {
					
					System.out.println("Name\t\tPhone Number");
					for(int i = 0 ; i < addContact.size(); i++) {
						
						for (Contact contactDisplay : addContact) {
						    System.out.println(contactDisplay.getName() + "\t\t" + contactDisplay.getPhoneNumber());
						}

					}
				}
				
				break;
			}
			
			case 4 : 
			{
				isRunning = false;
				break;
			}
				
				default : {
					System.out.println(" Enter a valid option");
				}
			}
		
				if (!isRunning) {
				break;
				}
			Scanner menu = new Scanner(System.in);
			System.out.println(" Do you want to check other options ? Yes | No");
			continueMenu = menu.nextLine();
		} while(continueMenu.equalsIgnoreCase("Yes"));
		
		System.out.println("Thank you for using our services!");
	}

}
