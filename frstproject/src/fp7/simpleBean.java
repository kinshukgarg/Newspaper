package fp7;

public class simpleBean {
	public String mobile;
    String cname;
   
    String spapers;
    String area;
	String hawker;
    String email;
    String address;
    String dos;
    public simpleBean() {}
	public simpleBean(String mobile, String cname, String spapers,String area,String hawker,String email,String address,String dos) {
		super();
		
		this.cname = cname;
		this.mobile = mobile;
		
		this.spapers=spapers;
		this.area=area;
		this.hawker=hawker;
		this.email=email;
		this.address=address;
		this.dos=dos;
		
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	 public String getSpapers() {
			return spapers;
		}
		public void setSpapers(String spapers) {
			this.spapers = spapers;
		}
	public String getHawker() {
		return hawker;
	}
	public void setHawker(String hawker) {
		this.hawker = hawker;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDos() {
		return dos;
	}
	public void setDos(String dos) {
		this.dos = dos;
	}
   

}
