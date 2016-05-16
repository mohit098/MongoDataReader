package org.fetchData;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


public class PersonDAOImpl implements PersonDAO{

	private static final String PERSON_COLLECTION = "PERSON";
	private static final String DATABASE_NAME = "test";
	
	MongoClient mongo = new MongoClient("localhost",27017);
	
	@SuppressWarnings("deprecation")
	DB db = mongo.getDB(DATABASE_NAME);
	
	DBCollection dbCollection = db.getCollection(PERSON_COLLECTION);
	
	@Override
	public List<Person> readById(String name) {
		//BasicDBObject query = new BasicDBObject("name",name);
		DBCursor cursor = dbCollection.find(new BasicDBObject("name", name)); 
		List<Person> list = new ArrayList<Person>();
		try {
			while (cursor.hasNext()) {
				DBObject obj = cursor.next();
				Person person = new Person();
				ObjectId id = new ObjectId();
				id = (ObjectId) obj.get("_id");
				person.setId(id.toString());
				person.setName((String)obj.get("name"));
				person.setAddress((String)obj.get("address"));
				list.add(person);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			cursor.close();
		}
		return list;
	}

	@Override
	public List<Person> getAll() {
		DBCursor cursor = dbCollection.find().sort(new BasicDBObject("by", 1)); 
		List<Person> list = new ArrayList<Person>();
		try {
			while (cursor.hasNext()) {
				DBObject obj = cursor.next();
				Person person = new Person();
				ObjectId id = new ObjectId();
				id = (ObjectId) obj.get("_id");
				person.setId(id.toString());
				person.setName((String)obj.get("name"));
				person.setAddress((String)obj.get("address"));
				list.add(person);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			cursor.close();
		}
		return list;
	}

}
