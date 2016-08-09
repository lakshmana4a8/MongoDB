package com.mongo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.app.dao.ClientDao;
import com.mongo.app.util.Document;
import com.mongo.app.util.MongoUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

@Service
public class MongoDBClient implements ClientService{
	
	@Autowired
	private ClientDao clientDao;
	
	public void createCollection() {
		clientDao.createCollection();
	}

	public void insertDocument(final List<Document> document) {
		BasicDBObject doc = MongoUtils.createDBObject(document.get(0));
		clientDao.insertDocument(doc);
	}
	
	public void updateDocument(final Document document) {
		DBObject doc = BasicDBObjectBuilder.start().add("_id", document.getId()).get();
		BasicDBObject dbObject = MongoUtils.createDBObject(document);
		clientDao.updateDocument(doc, dbObject);
	}

	public Document retrieveDocumentById(final Document document) {
		DBObject doc = BasicDBObjectBuilder.start().add("_id", document.getId()).get();
		DBObject dbObject = clientDao.retrieveDocumentById(doc);
		Document result = MongoUtils.convertToDocument(dbObject);
		return result;
	}

	public List<Document> retrieveAllDocuments() {
		List<DBObject> dbObject = clientDao.retrieveAllDocuments();
		List<Document> result = MongoUtils.convertToDocuments(dbObject);
		return result;
	}

	public void deleteDocument(final Document document) {
		DBObject doc = BasicDBObjectBuilder.start().add("_id", document.getId()).get();
		clientDao.deleteDocument(doc);
	}
}
