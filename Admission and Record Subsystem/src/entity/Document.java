package entity;

public class Document {


    private String fileType;
    private double fileSize;

    public Document(String fileName, String type, double size) {
        this.fileType = type;
        this.fileSize = size;
    }

    public boolean isValid() {
        return fileSize <= 10 && 
              (fileType.equalsIgnoreCase("PDF") || 
               fileType.equalsIgnoreCase("DOCX"));
    }
	
}
