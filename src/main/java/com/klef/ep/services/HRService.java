package com.klef.ep.services;

import java.util.List;

import com.klef.ep.models.EmpGrievance;
import com.klef.ep.models.HRSE;

public interface HRService
{
	public String addGrievance(EmpGrievance gre);
	public List<EmpGrievance> viewallgre();

	  public List<EmpGrievance> mygre();
	  
	  public String deletegre(int ticket_id);

	  public String updategrestatus(EmpGrievance gre);
	  
	  public EmpGrievance viewgrebyid(int ticket_id);
	  
	  HRSE checkhrlogin(String username, String password);
}
