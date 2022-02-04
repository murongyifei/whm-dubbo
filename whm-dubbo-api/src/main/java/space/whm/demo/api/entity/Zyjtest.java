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
import javax.persistence.Transient;

import com.baomidou.mybatisplus.annotation.TableField;

@Entity
@Table(name = "zyjtest")
public class Zyjtest implements Serializable {
	private static final long serialVersionUID = 1L;
	

	//columns START
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private int type;
	//columns END
	
	/*
		spring data jpa 或 hibernate
		//数据库不存在的这个字段
		@Transient
		private String test;
		mybatis-plus
		//数据库不存在这个字段
		@TableField(exist = false)
		private String test;
		在实体的字段上面加上这个注解后，此字段就不会映射数据库了。
		————————————————
		版权声明：本文为CSDN博主「Gavincoder」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
		原文链接：https://blog.csdn.net/weixin_39200308/article/details/104928858
	 */
	@TableField(exist = false)
	@Transient
	private int temp=0;
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = 0;
	}


	public Zyjtest(){
	}

	public Zyjtest(
		Long id
	){
		this.id = id;
	}

	

	public void setId(Long value) {
		this.id = value;
	}
	
	/**
		使用id自增模式=========start
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "id")
		使用id自增模式=========end
		
		使用idcenter模式=========start
		@Id
		@Column(name = "id")
		@GeneratedValue(generator = "whm_test_seq")
		@GenericGenerator(name = "whm_test_seq", strategy = "space.whm.db.dal.id.util.IdGenerator", parameters = { @Parameter(name = "sequence", value = "whm_test_seq") })
		使用idcenter模式=========end
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return this.id;
	}
	
			
	@Column(name = "name")
	public String getName() {
		return this.name;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	@Column(name = "type")
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}

