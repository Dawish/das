package d.as.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import d.as.dto.AdDto;
import d.as.dto.BusinessDto;
import d.as.dto.BusinessListDto;
import d.as.service.AdService;
import d.as.service.BusinessService;

@RestController
@RequestMapping(value="/api")
public class ApiController {

	@Value("${ad.number}")
	private int adNumber;
	
	@Value("${businessSearch.number}")
	private int businessSearchNumber;
	
	@Value("${businessHome.number}")
	private int businessHomeNumber;
	
	@Autowired
	AdService adService;
	
	@Resource
	private BusinessService businessService;
	
	/**
	 * 首页广告api接口
	 * @return
	 */
	@RequestMapping(value="/homead", method=RequestMethod.GET)
	public List<AdDto> homead() {
		AdDto adDto = new AdDto();
		adDto.getPage().setPageNumber(adNumber);
		return adService.searchByPage(adDto);
	}
	
	/**
	 * 首页 —— 推荐列表（猜你喜欢）
	 */
	@RequestMapping(value = "/homelist/{city}/{page.currentPage}", method = RequestMethod.GET)
	public BusinessListDto homelist(BusinessDto businessDto) {
		businessDto.getPage().setPageNumber(businessHomeNumber);
		return businessService.searchByPageForApi(businessDto);
	}

	/**
	 * 搜索结果页 - 搜索结果 - 三个参数
	 */
	@RequestMapping(value = "/search/{page.currentPage}/{city}/{category}/{keyword}", method = RequestMethod.GET)
	public BusinessListDto searchByKeyword(BusinessDto businessDto) {
		businessDto.getPage().setPageNumber(businessSearchNumber);
		return businessService.searchByPageForApi(businessDto);
	}

	/**
	 * 搜索结果页 - 搜索结果 - 两个参数
	 */
	@RequestMapping(value = "/search/{page.currentPage}/{city}/{category}", method = RequestMethod.GET)
	public BusinessListDto search(BusinessDto businessDto) {
		businessDto.getPage().setPageNumber(businessSearchNumber);
		return businessService.searchByPageForApi(businessDto);
	}
	
	/**
	 * 详情页 - 商户信息
	 */
	@RequestMapping(value = "/allbusiness", method = RequestMethod.GET)
	public List<BusinessDto> detail() {
		BusinessDto businessDto = new BusinessDto();
		businessDto.getPage().setPageNumber(businessSearchNumber);
		return businessService.searchByPage(businessDto);
	}
	
	/**
	 * 详情页 - 商户信息
	 */
	@RequestMapping(value = "/detail/info/{id}", method = RequestMethod.GET)
	public BusinessDto detail(@PathVariable("id") Long id) {
		return businessService.getById(id);
	}
	
}
