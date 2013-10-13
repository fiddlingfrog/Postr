package com.postr.DataTypes;

import java.util.List;
import java.util.Vector;

import com.postr.DAO;
import com.postr.DataTypes.Inputs.BaseInput;
import com.postr.DataTypes.Outputs.BaseOutput;
import com.postr.DataTypes.Outputs.BasePost;


public class UserData {

	public UserData(String persona, Long userID){
		this.persona = persona;
		List<BaseSaveable> saveables = DAO.LoadThings(BaseSaveable.class, userID);
		for (BaseSaveable baseSaveable : saveables) {
			if (baseSaveable instanceof BaseOutput) {
				BaseOutput output =(BaseOutput) baseSaveable;
				output.password = null;
				outputs.add(output);
			}
			if (baseSaveable instanceof BaseInput) {
				inputs.add((BaseInput) baseSaveable);
			}
			if (baseSaveable instanceof BasePost) {
				posts.add((BasePost) baseSaveable);
			}
		}
	}
	
	public String persona;
	

	public List<BaseInput> inputs = new Vector<BaseInput>();
	
	public List<BaseOutput> outputs = new Vector<BaseOutput>();
	
	public List<BasePost> posts = new Vector<BasePost>();
}
