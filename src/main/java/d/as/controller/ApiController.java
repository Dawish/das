package d.as.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import d.as.dto.AdDto;
import d.as.service.AdService;

@RestController
@RequestMapping(value="/api")
public class ApiController {

	@Value("${ad.number}")
	private int adNumber;
	
	@Autowired
	AdService adService;
	
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
	
}
