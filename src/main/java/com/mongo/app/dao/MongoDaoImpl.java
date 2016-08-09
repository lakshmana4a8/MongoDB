package com.mongo.app.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

@Repository
public class MongoDaoImpl implements ClientDao {

	public void createCollection() {
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient("localhost", 27017);
			DB db = mongoClient.getDB("local");
			DBObject dbObject = new BasicDBObject();
			DBCollection collection = db.createCollection("documents", dbObject);
			System.out.println("Collection created successfully : "+collection);
			Set<String> collections = db.getCollectionNames();
			System.out.println(collections);
		} catch (UnknownHostException e) {
			System.err.println(e.getClass().getName() + " : " + e.getMessage());
		} finally {
			mongoClient.close();
		}
	}

	public WriteResult insertDocument(final BasicDBObject document) {
		MongoClient mongoClient = null;
		WriteResult result = null;
		try {
			mongoClient = new MongoClient("localhost", 27017);
			DB db = mongoClient.getDB("local");
			DBCollection col = db.getCollection("documents");
			result = col.insert(document);
		} catch (UnknownHostException e) {
			System.err.println(e.getClass().getName() + " : " + e.getMessage());
		} finally {
			mongoClient.close();
		}
		return result;
	}
	
	public WriteResult updateDocument(final DBObject doc, final BasicDBObject dbObject) {
		MongoClient mongoClient = null;
		WriteResult result = null;
		try {
			mongoClient = new MongoClient("localhost", 27017);
			DB db = mongoClient.getDB("local");
			DBCollection col = db.getCollection("documents");
			result = col.update(doc, dbObject);
		} catch (UnknownHostException e) {
			System.err.println(e.getClass().getName() + " : " + e.getMessage());
		} finally {
			mongoClient.close();
		}
		return result;
	}

	public DBObject retrieveDocumentById(final DBObject document) {
		MongoClient mongoClient = null;
		DBCursor cursor = null;
		DBObject result = null;
		try {
			mongoClient = new MongoClient("localhost", 27017);
			DB db = mongoClient.getDB("local");
			DBCollection col = db.getCollection("documents");
			cursor = col.find(document);
			result = cursor.one();
		} catch (UnknownHostException e) {
			System.err.println(e.getClass().getName() + " : " + e.getMessage());
		} finally {
			mongoClient.close();
		}
		return result;
	}

	public List<DBObject> retrieveAllDocuments() {
		MongoClient mongoClient = null;
		DBCursor cursor = null;
		List<DBObject> result = new ArrayList<DBObject>();
		try {
			mongoClient = new MongoClient("localhost", 27017);
			DB db = mongoClient.getDB("local");
			DBCollection col = db.getCollection("documents");
			cursor = col.find();
			while (cursor.hasNext()) { 
				result.add(cursor.next());
			}
		} catch (UnknownHostException e) {
			System.err.println(e.getClass().getName() + " : " + e.getMessage());
		} finally {
			mongoClient.close();
		}
		return result;
	}

	public WriteResult deleteDocument(final DBObject doc) {
		MongoClient mongoClient = null;
		WriteResult result = null;
		try {
			mongoClient = new MongoClient("localhost", 27017);
			DB db = mongoClient.getDB("local");
			DBCollection col = db.getCollection("documents");
			result = col.remove(doc);
		} catch (UnknownHostException e) {
			System.err.println(e.getClass().getName() + " : " + e.getMessage());
		} finally {
			mongoClient.close();
		}
		return result;
	}

}
