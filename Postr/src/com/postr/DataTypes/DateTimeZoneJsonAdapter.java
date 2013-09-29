package com.postr.DataTypes;

import java.io.IOException;
import org.joda.time.DateTimeZone;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class DateTimeZoneJsonAdapter extends TypeAdapter<DateTimeZone> {

	@Override
	public DateTimeZone read(JsonReader arg0) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void write(JsonWriter writer, DateTimeZone zone) throws IOException {
		writer.value(zone.getID());
	}
	
}