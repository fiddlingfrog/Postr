package com.postr;

import com.postr.DataTypes.Json;

@SuppressWarnings("serial")
public class PersonaLogoutServlet extends BaseJSONServlet {
	
	@Override
	protected Result ProcessRequest(Json parameters) throws Exception {
			SetPersona(null);
			return Result.Success("Logged out");
	}
}
