
package com.postr;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.postr.DataTypes.Json;
import com.postr.DataTypes.Outputs.BasePost;

@SuppressWarnings("serial")
public abstract class BaseOutputServlet extends BaseJSONServlet {


	@Override
	protected Json ProcessRequest(Json parameters) throws Exception
	{
		String method = parameters.getString("method");

		MethodTypes methodType = MethodTypes.valueOf(method);
		switch (methodType) {
		case VerifyPassword:
			return VerifyPassword(parameters);
		case SaveData:
			return SaveData(parameters);
		case UpdateData:
			return UpdateData(parameters);
		case MakePost:
			return MakePost(parameters);
		case SavePost:
			return SavePost(parameters);
		default:
			throw new Exception("No such method found: "+method);
		}

	}
	
	private Json MakePost(Json parameters){
		BasePost post = CreatePost(parameters, GetUserID());
		post.MakePost();
		post.postingTime = DateTime.now(DateTimeZone.UTC);
		DAO.SaveThing(post, GetUserID());
		Json result = Json.Result(post.result);
		result.setData("postingTime", post.postingTime.getMillis());
		return result;
	}
	
	protected abstract Json UpdateData	(Json parameters) throws Exception;

	protected abstract Json VerifyPassword(Json parameters) throws Exception;
	
	protected abstract Json SaveData(Json parameters) throws Exception;
	
	protected abstract BasePost CreatePost(Json parameters, long userID);

	protected abstract Json SavePost(Json parameters) throws Exception;
}