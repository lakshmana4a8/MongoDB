package com.mongo.app.dao;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public interface ClientDao {
	
	void createCollection();

	WriteResult insertDocument(final BasicDBObject document);
	
	WriteResult updateDocument(final DBObject doc, final BasicDBObject dbObject);

	DBObject retrieveDocumentById(final DBObject document);

	List<DBObject> retrieveAllDocuments(); 

	WriteResult deleteDocument(final DBObject doc);
}
