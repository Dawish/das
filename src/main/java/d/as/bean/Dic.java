package d.as.bean;

/**
 * 
 * @author danxx
 * @Date 2018.08.25
 * @Desc 属性描述 城市/类型/...
 *  可与商户一起 唯一确定一个城市的一种类型的一家商户
 */
public class Dic {
	//category/city/httpMethod
    private String type;
    //ktv/jiehun/上海/北京/GET/POST
    private String code;
    private String name;
    private Integer weight;
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getWeight() {
        return weight;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}