package com.revature.utils;

import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.revature.daos.VaultDAO;
import com.revature.models.Wizards;
import com.revature.models.Vault;
import com.revature.services.WizardService;

public class GringottsConsole {

	private static final Scanner scan = new Scanner(System.in);
	private WizardService ws = new WizardService();
	private VaultDAO vd = new VaultDAO(); 
	private static final Logger log = LogManager.getLogger(GringottsConsole.class);
	
	public void beginApp() {
		System.out.println("Welcome to Gringotts.\n"
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
				System.out.println("Are you a Gringotts Employee or Head Goblin? "
						+ "A simple [YES] or [NO] will suffice.");	//Goblins are rude. Deal with it.
				if(scan.nextLine().toLowerCase().equals("yes")) {
					getAllWizards();
				} else if(scan.nextLine().toLowerCase().equals("no")) {
					System.out.println("We have cast a rather powerful Fidelius Charm over our customer lists "
							+ "so you cannot see them. Start again.");
				}else {
					System.out.println("Your spell has backfired. See to your wounds and start again.");
				}
				break;
			case "one":
				getOneWizard();
				break;
			case "add":
				addWizard();
				break;
			case "update":
				System.out.println("Are you Head Goblin? "
						+ "Please provide the Head Goblin's Master Key.");
				scan.nextLine();
				if (scan.nextLine().equals("Griphook")){
					ws.updateWizard(null);
				}
				beginApp();
				break;
			case "delete":
				System.out.println("Are you Head Goblin? "
						+ "Please provide the Head Goblin's Master Key.");
				if(scan.nextLine().equals("Griphook")) {	// The Master Key is "Griphook", btw.
					ws.removeWizard(0);
				} else {
					System.out.println("It appears your spell has backfired. "
							+ "See to your wounds and try again.");
				}
				beginApp();
				break;
			case "exit":
				System.out.println("Your business is appreciated. Please exit through the silver doors.");
				break;
			default:
				System.out.println("We have no vault-holders by that name. Start again.");
				beginApp();
				break;
		}
	}

	private void addWizard() {
		// I put all the fancy footwork here.
		System.out.println("What is the first name of the Wizard you would like to register?");
		String firstName = scan.nextLine();
		System.out.println("What is the last name of the wizard?");
		String lastName = scan.nextLine();
		Wizards w = new Wizards(firstName, lastName, null);
		log.info("Adding Wizard " + w);

		// checking if you're eligible to build the vault yourself or if you must have an employee do it for you.
		System.out.println("Are you a Gringotts Employee or Head Goblin? A simple [YES] or [NO] will suffice.");
		if(scan.nextLine().toLowerCase().equals("yes")) {
			Vault v = buildVault();
			log.info("Opening Vault " + v);
			beginApp();
			
		}else if(scan.nextLine().toLowerCase().equals("no")) {
			System.out.println("The Gringotts Goblins will sort out your vault. Look for our owl within the fortnight.");
			beginApp();
		} else {
			System.out.println("It appears that your spell has backfired. See to your wounds and start again.");
			beginApp(); 
		}	
	}

	
	
	private Vault findVault() {
		System.out.println("Does this wizard already have a vault? \n"
				+ "if so, enter the vault number. \n"
				+ "if not, enter the number -1.");
		int res = scan.nextInt();	// changed to an int that would never be used. Still breakable.
		Vault v = null;
		if(res == -1) {
			v = buildVault();
		} else {
			v = vd.findByNumber(res);
		}
		return v;
	}

	private Vault buildVault() {
		// we already know that only eligible wizards can get this far. Just build the vault.				
		Vault v = new Vault();
		return v;
	}

	private void getOneWizard() {
		// I'll just let anyone do this for now. It's not a secure bank in this iteration.
		System.out.println("We assign IDs to each of our vault-holders. Please enter yours.");
		int i = scan.nextInt();
		scan.nextLine();
		Wizards w = ws.findById(i);
		System.out.println("The name of the wizard who holds this account is: " + w);
		beginApp();
	}
	
	private void getAllWizards() {
		List<Wizards> list = ws.findAll();
		//only Employees and Admins/Head Goblin go beyond this point.
		for(Wizards w:list) {
			System.out.println(w);
		}
	}
	
	

}

