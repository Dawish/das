package d.as.service.impl;

import java.util.List;
import javax.annotation.Resource;
import d.as.bean.Dic;
import d.as.dao.DicDao;
import d.as.service.DicService;
import org.springframework.stereotype.Service;

@Service
public class DicServiceImpl implements DicService {
    
    @Resource
    private DicDao dicDao;
    
    @Override
    public List<Dic> getListByType(String type) {
	Dic dic = new Dic();
	dic.setType(type);
	return dicDao.select(dic);
    }
}
