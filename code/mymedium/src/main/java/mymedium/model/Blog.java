package mymedium.model;

import java.time.LocalDateTime;

public class Blog {

	private static Integer ID_GENERATOR=0;

	private final Integer userId;
	private final Integer blogId;
	
	private String title;
	private String text;
	private String tag;
	private Status status;
	private LocalDateTime publishedDate;

	public Blog(Integer userId) {
		this(null, userId);
	}
	
	public Blog(String tag,Integer userID) {
		this(tag,null,userID);
	}
	
	public Blog(String tag,String title,Integer userID) {
		this(tag,title,userID,Status.TASK); // default Status task olarak keydedilir
	}
	
	public Blog(String tag,String title,Integer userID,Status status) {
		this.tag = tag;
		this.title = title;
		this.userId =  userID;

		this.publishedDate = LocalDateTime.now();
		this.status = status;		
		this.blogId = ID_GENERATOR++;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDateTime publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public Integer getBlogId() {
		return blogId;
	}

	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", title=" + title + ", tag=" + tag + ", status=" + status + "]";
	}

}
