package fp6;

public class hawkerBean {
	public String hname;
	String mobile;
	String alloareas;
	String doj;
	public hawkerBean() {}
	public hawkerBean(String hname,String mobile,String alloareas,String doj) {
		super();
		this.hname=hname;
		this.mobile=mobile;
		this.alloareas=alloareas;
		this.doj=doj;
		
	}
	public String getHname()
	{
		return hname;
		
	}
	public void setHname(String hname) {
		this.hname=hname;
	}
	public String getMobile()
	{
		return mobile;
		
	}
	public void setMobile(String mobile) {
		this.mobile=mobile;
	}
	public String getAlloareas()
	{
		return alloareas;
		
	}
	public void setAlloareas(String alloareas) {
		this.alloareas=alloareas;
	}
	public String getDoj()
	{
		return doj;
		

	}
}
