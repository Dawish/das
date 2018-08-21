package d.as.dto;

import org.springframework.web.multipart.MultipartFile;

import d.as.bean.Ad;
/**
 * 
 * @author danxx
 * @Desc 广告传输对象，增加传输属性，跟 {@link Ad} 数据库存储对象区分
 * @Date 2018.08.21
 */
public class AdDto extends Ad{
	//图片全地址
    private String img;
    //图片流文件
    private MultipartFile imgFile;
	
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public MultipartFile getImgFile() {
        return imgFile;
    }

    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }
}
