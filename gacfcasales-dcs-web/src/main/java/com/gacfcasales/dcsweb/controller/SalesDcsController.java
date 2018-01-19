package com.gacfcasales.dcsweb.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gacfcasales.common.Assist;
import com.gacfcasales.common.Result;
import com.gacfcasales.common.dto.DealerDto;
import com.gacfcasales.dcsweb.service.CommonNoService;

@Controller
@RequestMapping("/dcsSales")
public class SalesDcsController {
	private static Logger logger = LoggerFactory.getLogger(SalesDcsController.class);

	@Autowired
	CommonNoService commonNoService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String toProductListPage() {
		System.out.println("========进入页面=========");
		return "sysPage/dcsSales/list";
	}

	// 大区查询
	@RequestMapping(value = "/ajax/getBigOrgList", method = RequestMethod.GET)
	@ResponseBody
	public List<Map> getBigOrgList() {
		List<Map> list = commonNoService.selectMaxDistrict();
		return list;
	}

	// 小区区查询
	@RequestMapping(value = "/ajax/getSmallOrgList", method = RequestMethod.GET)
	@ResponseBody
	public List<Map> getSmallOrgList(@RequestParam String bigOrg) {
		List<Map> list = commonNoService.selectMinDistrict(bigOrg);
		return list;
	}

	@RequestMapping(value = "/ajax/getDealerAll", method = RequestMethod.POST)
	@ResponseBody
	public Result<DealerDto> getDealerAll(DealerDto dealerDto, @RequestParam(required = false) Integer limit,
			@RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer pageindex,
			@RequestParam(required = false) Integer pageSize) {

		Result<DealerDto> result = new Result<DealerDto>();
		Assist assist = new Assist();
		if (null != pageindex && null != pageSize) {
			assist.setStartRow((pageindex - 1) * pageSize);
			assist.setRowSize(pageSize);
		}

		if (dealerDto.getDealerCode() != null && !"".equals(dealerDto.getDealerCode())) {
			assist.setRequires(Assist.andIn("bsm.DEALER_CODE", dealerDto.getDealerCode()));
		}
		if (dealerDto.getDealerShortname() != null && !"".equals(dealerDto.getDealerShortname())) {
			assist.setRequires(Assist.andLike("bsm.DEALER_SHORTNAME", "%" + dealerDto.getDealerShortname() + "%"));
		}
		if (dealerDto.getDealerName() != null && !"".equals(dealerDto.getDealerName())) {
			assist.setRequires(Assist.andLike("bsm.DEALER_NAME", "%" + dealerDto.getDealerName() + "%"));
		}

		if (dealerDto.getBigOrg() != null && !"0".equals(dealerDto.getBigOrg()) && !"".equals(dealerDto.getBigOrg())) {
			assist.setRequires(Assist.andIn("bsm.BIG_ORG_ID", dealerDto.getBigOrg()));
		}

		if (dealerDto.getSmallOrg() != null && !"0".equals(dealerDto.getSmallOrg())
				&& !"".equals(dealerDto.getSmallOrg())) {
			assist.setRequires(Assist.andIn("bsm.SMALL_ORG_ID", dealerDto.getSmallOrg()));
		}

		long count = commonNoService.selectDealerArrRowCount(assist);
		List<Map> list = commonNoService.selectDealerAll(assist);
		result.setTotalCount(count);
		result.setDataListMap(list);
		return result;
	}

	@RequestMapping(value = "/ajax/toDealerPage", method = RequestMethod.GET)
	public ModelAndView toDealerPage() {
		ModelAndView mav = new ModelAndView("sysPage/dcsSales/dealerList");
		return mav;
	}

}
