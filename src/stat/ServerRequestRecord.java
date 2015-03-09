package stat;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * This class is the representation of record of server request.
 */

public class ServerRequestRecord {
    private long id;
    private String sourceIp;
    private Timestamp lastRequest;
    private long requestCount;

    public ServerRequestRecord(String sourceIp) {
	super();
	this.sourceIp = sourceIp;
	this.lastRequest = new Timestamp(Calendar.getInstance()
		.getTimeInMillis());
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getSourceIp() {
	return sourceIp;
    }

    public void setSourceIp(String sourceIp) {
	this.sourceIp = sourceIp;
    }

    public Timestamp getLastRequest() {
	return lastRequest;
    }

    public void setLastRequest(Timestamp lastRequest) {
	this.lastRequest = lastRequest;
    }

    public long getRequestCount() {
	return requestCount;
    }

    public void setRequestCount(long requestCount) {
	this.requestCount = requestCount;
    }

}