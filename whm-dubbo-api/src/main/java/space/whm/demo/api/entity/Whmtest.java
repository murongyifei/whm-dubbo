/*
 * Powered By murongyifei
 */

package space.whm.demo.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "whmtest")
public class Whmtest implements Serializable {

	//columns START
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private java.lang.Long id;
	
	@Column(name = "name")
	private java.lang.String name;
	
	@Column(name = "type")
	private java.lang.Integer type;
	
	@Column(name = "mydate")
	private java.util.Date mydate;
	//columns END

	public void setId(java.lang.Long value) {
		this.id = value;
	}
	public java.lang.Long getId() {
		return this.id;
	}
	
			
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
			
	
	public java.lang.Integer getType() {
		return this.type;
	}
	
	public void setType(java.lang.Integer value) {
		this.type = value;
	}
	
			
	public java.util.Date getMydate() {
		return this.mydate;
	}
	
	public void setMydate(java.util.Date value) {
		this.mydate = value;
	}
	
}

