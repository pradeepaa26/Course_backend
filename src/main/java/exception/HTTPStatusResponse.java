package exception;

public class HTTPStatusResponse {
	private int statusCode;
	private String description;
	private Object data;
	 public HTTPStatusResponse(int statusCode,String desc,Object data)
	 {
		 //super();
		 this.statusCode=statusCode;
		 this.description=desc;
		 this.data=data;
	 }
	 public HTTPStatusResponse(int statusCode,String desc) {
		 this.statusCode=statusCode;
		 this.description=desc;
	 }
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
