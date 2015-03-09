package stat;

public class RedirectRequestRecord {
    private long id;
    private String redirectUrl;
    private long redirectCount;

    public RedirectRequestRecord() {

    }

    public RedirectRequestRecord(String redirectUrl) {
	this.redirectUrl = redirectUrl;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getRedirectUrl() {
	return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
	this.redirectUrl = redirectUrl;
    }

    public long getRedirectCount() {
	return redirectCount;
    }

    public void setRedirectCount(long redirectCount) {
	this.redirectCount = redirectCount;
    }
}