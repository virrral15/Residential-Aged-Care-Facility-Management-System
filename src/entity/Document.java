package entity;

public class Document {
    private String fileName;
    private String fileType;
    private double fileSize;

    public Document(String fileName, String type, double size) {
        this.fileName = fileName;
        this.fileType = type;
        this.fileSize = size;
    }

    public boolean isValid() {
        return fileSize <= 10 && 
              (fileType.equalsIgnoreCase("PDF") || 
               fileType.equalsIgnoreCase("DOCX"));
    }

    // Add getters for the new field
    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public double getFileSize() {
        return fileSize;
    }
}
