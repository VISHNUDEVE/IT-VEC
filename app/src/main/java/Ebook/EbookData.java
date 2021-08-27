package Ebook;

public class EbookData {
    private String pdfTitle,pdfUrl;

    public EbookData() {
    }

    public EbookData(String name, String pdfurl) {
        this.pdfTitle = name;
        this.pdfUrl = pdfurl;
    }

    public String getPdfTitle() {
        return pdfTitle;
    }

    public void setPdfTitle(String name) {
        this.pdfTitle = name;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
