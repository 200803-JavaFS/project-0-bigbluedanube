package com.revature.daos;

import java.util.List;
import com.revature.models.Wizards;

public interface IWizardsDAO {
	
	public List<Wizards> findAll();
	
	public Wizards findById(int wizardId);
	
	public boolean addWizard(Wizards w);
	
	public boolean updateWizard(Wizards w); 
	
	public boolean deleteWizard(int wizardId);

	public boolean addWizardWithVault(Wizards w);

}