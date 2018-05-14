public class TextFile {
    private String javaFileName;
    private long lineNumber;
    private String message;
    private String moduleName;
    private String subModuleName;

    public String getJavaFileName() {
        return javaFileName;
    }

    public void setJavaFileName(String javaFileName) {
        this.javaFileName = javaFileName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getSubModuleName() {
        return subModuleName;
    }

    public void setSubModuleName(String subModuleName) {
        this.subModuleName = subModuleName;
    }

    public long getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
