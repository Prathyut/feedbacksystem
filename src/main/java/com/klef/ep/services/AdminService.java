package com.klef.ep.services;

import com.klef.ep.models.Admin;

public interface AdminService 
{

	Admin checkadminlogin(String username, String password);

}
