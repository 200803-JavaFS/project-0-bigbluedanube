package com.revature.utils;

import java.util.List;
import java.util.Scanner;

import com.revature.daos.VaultDAO;
import com.revature.models.Wizards;
import com.revature.models.Vault;
import com.revature.services.WizardService;

public class GringottsConsole {

	private static final Scanner scan = new Scanner(System.in);
	private WizardService ws = new WizardService();
	private VaultDAO vd = new VaultDAO(); 
	
	public void beginApp() {
		System.out.println("Welcome to Gringotts.  %n"
				+ "What would you like to do: \n"
				+ "See [all] Wizards? \n"
				+ "See [one] Wizard? \n"
				+ "[Add] new Wizard? \n"
				+ "[Update] existing Wizard \n"
				+ "[Delete] existing Wizard \n"
				+ "[Exit]");
		String answer = scan.nextLine(); 
		answerSwitch(answer);
	}

	private void answerSwitch(String answer) {
		answer = answer.toLowerCase();
		
		switch(answer){
			case "all": 
				getAllWizards();
				break;
			case "exit":
				System.out.println("Your business is appreciated. Please exit through the silver doors.");
				break;
			case "one":
				getOneWizard();
				break;
			case "add":
				addWizard();
				break;
			default:
				System.out.println("We have no vault-holders by that name. Start again.");
				beginApp();
				break;
		}
	}

	private void addWizard() {
		System.out.println("What is the first name of the Wizard you would like to register?");
		String firstName = scan.nextLine();
		System.out.println("What is the last name of the wizard?");
		String lastName = scan.nextLine();
		System.out.println("With which type of wood was their wand made?");
		String wandWood= scan.nextLine();
		System.out.println("And the core?");
		String wandCore= scan.nextLine();
		System.out.println("Now, produce a corporeal Patronus and tell us its form. Note, no Dementors will be present.");
		String patronus = scan.nextLine();
		scan.nextLine();
		System.out.println("Does the wizard already have a vault?");
		Vault v = null;
		if(scan.nextLine().toLowerCase().equals("yes")) {
			v = findVault();
		}
		Wizards w = new Wizards();
		
		if(ws.insertWizard(w)) {
			System.out.println("The wizard was added to the registry.");
			beginApp();
		} else {
			System.out.println("It appears that your spell has backfired. See to your wounds and start again.");
			beginApp(); 
		}
		
			
	}

	private Vault findVault() {
		System.out.println("Does this wizard's already have a vault? \n"
				+ "if so, enter the vault number. \n"
				+ "if not, enter the number zero (0).");
		int res = scan.nextInt();
		Vault v = null;
		if(res == 0) {
			v = buildVault();
		} else {
			v = vd.findByNumber(res);
		}
		return v;
	}

	private Vault buildVault() {
		System.out.println("Does this wizard already have an account with us?");
		boolean acctActive = scan.nextBoolean();
		System.out.println("What is the new vault number?");
		int vaultNumber = scan.nextInt();
		System.out.println("Is the prospective vault-holder a Gringotts employee?");
		boolean isEmployee = scan.nextBoolean();
		System.out.println("Is the prospective vault-holder a Gringotts administrator?");
		boolean isAdmin = scan.nextBoolean();
		Vault v = new Vault();
		return v;
	}

	private void getOneWizard() {
		System.out.println("We assign IDs to each of our vault-holders. Please enter yours.");
		int i = scan.nextInt();
		scan.nextLine();
		Wizards w = ws.findById(i);
		System.out.println("The name of the wizard who holds this account is: " + w);
		beginApp();
	}
	
	private void getAllWizards() {
		List<Wizards> list = ws.findAllWizards();
		
		System.out.println("Here are all the Avengers in the database:");
		for(Wizards w:list) {
			System.out.println(w);
		}
		beginApp();
	}
	
	

}

