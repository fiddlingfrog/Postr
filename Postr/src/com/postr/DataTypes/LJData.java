package com.postr.DataTypes;

import java.util.TimeZone;

import com.googlecode.objectify.annotation.EntitySubclass;

@EntitySubclass(index=true)
public class LJData extends BaseOutput {
	private TimeZone timeZone;

	public TimeZone getTimeZone() {
		return timeZone;
	}
	public LJData(String userName, String password, TimeZone timeZone) throws Exception{
		super(userName,PasswordEncryptor.MD5Hex(password));
		this.timeZone = timeZone;
	}
	
	protected LJData(){}
	
	@Override
	public String getSiteName() {
		return "Livejournal";
	}

}
