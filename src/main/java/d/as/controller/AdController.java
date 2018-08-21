package d.as.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import d.as.constant.PageCodeEnum;
import d.as.dto.AdDto;
import d.as.service.AdService;

@Controller
@RequestMapping("/ad")
public class AdController {
	
	@Autowired
	AdService adService;
	
	/**
	 * 新增
	 */
	@RequestMapping("/add")
	public String add(AdDto adDto, Model model) {
		if (adService.add(adDto)) {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_SUCCESS);
		} else {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_FAIL);
		}
		return "/content/adAdd";
	}
	
	
}
