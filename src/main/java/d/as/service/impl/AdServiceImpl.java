package d.as.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import d.as.bean.Ad;
import d.as.dao.AdDao;
import d.as.dto.AdDto;
import d.as.service.AdService;

@Service
public class AdServiceImpl implements AdService {
	
	@Autowired
	AdDao adDao;

	@Value("${adImage.savePath}")
	private String adImageSavePath;

	@Value("${adImage.url}")
	private String adImageUrl;
	
	@Override
	public boolean add(AdDto adDto) {
		// TODO Auto-generated method stub
		Ad ad = new Ad();
		ad.setTitle(adDto.getTitle());
		ad.setLink(adDto.getLink());
		ad.setWeight(adDto.getWeight());		
		// 把图片写入文件
		if (adDto.getImgFile() != null && adDto.getImgFile().getSize() > 0) {
			String fileName = System.currentTimeMillis() + "_" + adDto.getImgFile().getOriginalFilename();
			File file = new File(adImageSavePath + fileName);
			File fileFolder = new File(adImageSavePath);
			if (!fileFolder.exists()) {
				fileFolder.mkdirs();
			}
			try {
				//写入文件
				adDto.getImgFile().transferTo(file);
				ad.setImgFileName(fileName);
				//插入数据库
				adDao.insert(ad);
				return true;
			} catch (IllegalStateException | IOException e) {
				// TODO 需要添加日志
				return false;
			}
		}else {
			return false;
		}
	}

	@Override
	public List<AdDto> searchByPage(AdDto adDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AdDto getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modify(AdDto adDto) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
