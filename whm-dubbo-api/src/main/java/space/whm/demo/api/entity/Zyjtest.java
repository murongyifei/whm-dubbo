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
	private Long id;
	
	@Column(name = "name")
	private String name;

	/*
		WARN t.m.m.m.r.DefaultEntityResolve - MYBATIS 通用 Mapper 警告信息: <[EntityColumn{table=zyjtest, property='type', column='type', javaType=int, jdbcType=null, typeHandler=null, id=false, identity=false, blob=false, generator='null', orderBy='null', orderPriority='0', insertable=true, updatable=true, order=DEFAULT}]> 使用了基本类型，基本类型在动态 SQL 中由于存在默认值，因此任何时候都不等于 null，建议修改基本类型为对应的包装类型!
	 	把类型定义为封装类型
	 */
	@Column(name = "type")
	private Integer type;
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
	public Long getId() {
		return this.id;
	}
	
			
	public String getName() {
		return this.name;
	}
	public void setName(String value) {
		this.name = value;
	}
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}

