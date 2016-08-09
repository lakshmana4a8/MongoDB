package com.mongo.app.service;

import java.util.List;

import com.mongo.app.util.Document;

public interface ClientService {
	
	void createCollection();
	
	void insertDocument(final List<Document> document);

	void updateDocument(final Document document);
	
	Document retrieveDocumentById(final Document document);

	List<Document> retrieveAllDocuments();
	
	void deleteDocument(final Document document);
}
