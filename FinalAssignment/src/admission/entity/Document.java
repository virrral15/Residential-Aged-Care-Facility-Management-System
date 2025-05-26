package admission.entity;

import java.util.Date;

public class Document {
    private final String documentID;
    private final String title;
    private final Date creationDate;
    private final String content;
    private final String authorID;

    public Document(String title, String content, String authorID) {
        this.documentID = java.util.UUID.randomUUID().toString();
        this.title = title;
        this.creationDate = new Date();
        this.content = content;
        this.authorID = authorID;
    }

    public String getDocumentID() {
        return documentID;
    }

    public String getTitle() {
        return title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getContent() {
        return content;
    }

    public String getAuthorID() {
        return authorID;
    }
} 