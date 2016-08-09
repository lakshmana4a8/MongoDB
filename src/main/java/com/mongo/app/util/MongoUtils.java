package com.mongo.app.util;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class MongoUtils {
	
	public static DBObject createDBObjects(List<Document> documents){
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		for (Document document : documents) {
			
		}
		return docBuilder.get();
	}
	
	public static BasicDBObject  createDBObject(Document document){
		BasicDBObject  docBuilder = new BasicDBObject("_id", document.getId()).
		append("title", document.getTitle()).
        append("description", document.getDescription()).
        append("author", document.getAuthor());
		return docBuilder;
	}

	public static Document convertToDocument(DBObject dbObject) {
		Document document = new Document();
		document.setId((String)dbObject.get("_id"));
		document.setTitle((String)dbObject.get("title"));
		document.setDescription((String)dbObject.get("description"));
		document.setAuthor((String)dbObject.get("author"));
		return document;
	}

	public static List<Document> convertToDocuments(List<DBObject> dbObject) {
		List<Document> documents = new ArrayList<Document>();
		for (DBObject obj : dbObject) {
			Document document = convertToDocument(obj);
			documents.add(document);
		}
		return documents;
	}
}
