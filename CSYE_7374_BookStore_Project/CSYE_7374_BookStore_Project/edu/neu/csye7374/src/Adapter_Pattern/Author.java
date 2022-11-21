package neu.csye7374.src.Adapter_Pattern;

import neu.csye7374.src.Factory_Pattern.EmployeeFactory;

public class Author implements Cloneable{
	
	private String authorName;
	private int age;
	private int noOfBooksPublished;
	private static Author instance;
	
	public Author() {
		super();
	}
	
	public static synchronized Author getInstance() {
		if (instance == null) {
			instance = new Author();
		}
		return instance;
	}

	private Author(String authorName, int age, int noOfBooksPublished) {
		super();
		this.authorName = authorName;
		this.age = age;
		this.noOfBooksPublished = noOfBooksPublished;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	public Author setAuthorName(String authorName) {
		this.authorName = authorName;
		return this;
	}
	public int getAge() {
		return age;
	}
	public Author setAge(int age) {
		this.age = age;
		return this;
	}
	public int getNoOfBooksPublished() {
		return noOfBooksPublished;
	}
	public Author setNoOfBooksPublished(int noOfBooksPublished) {
		this.noOfBooksPublished = noOfBooksPublished;
		return this;
	}
	@Override
	public String toString() {
		return "Author [authorName=" + authorName + ", age=" + age + ", noOfBooksPublished=" + noOfBooksPublished + "]";
	}

	
	@Override
	public Author clone() {
		// TODO Auto-generated method stub
		Author clone = null;
	      
		try {
			clone = (Author)super.clone();   
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
	
	
}
