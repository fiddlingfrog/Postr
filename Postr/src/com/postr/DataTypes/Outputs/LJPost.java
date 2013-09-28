package com.postr.DataTypes.Outputs;

import com.googlecode.objectify.annotation.EntitySubclass;
import com.postr.DAO;
import com.postr.MessageLogger;
import com.postr.Result;
import com.postr.Translators.LJTranslator;

@EntitySubclass(index=true)
public class LJPost extends BasePost {

	private String subject;
	private String contents;
	private String[] tags;
	
	protected String getSubject() {
		return subject;
	}

	protected String getContents() {
		return contents;
	}

	protected String[] getTags() {
		return tags;
	}

	public LJPost(String subject, String contents, String tags, long output){
		super(output);
		this.subject = subject;
		this.contents = contents;
		this.tags = tags.split(",");
	}

	protected LJPost(){}
	
	public LJPost(LJPost originalPost, String subject, String contents,
			String tags) {
		super(originalPost);
		this.subject = subject;
		this.contents = contents;
		this.tags = tags.split(",");
	}


	@Override
	public void MakePost() {
		LJData ljData;
		try {
			ljData = DAO.LoadThing(LJData.class, getOutput(), getParent());
		} catch (Exception e) {
			MessageLogger.Severe(this,e.getMessage());
			setResult(Result.Failure("Failed to load Output data"));
			return;
		}
		
		LJTranslator translator = new LJTranslator();
		setResult(translator.MakePost(ljData, contents, subject, tags));
	}

	@Override
	protected String getSiteName() {
		return "Livejournal";
	}

}
