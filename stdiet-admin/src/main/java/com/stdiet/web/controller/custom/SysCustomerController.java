package com.stdiet.web.controller.custom;

import java.util.ArrayList;
import java.util.List;

import com.stdiet.common.utils.StringUtils;
import com.stdiet.custom.domain.SysPhysicalSigns;

import com.stdiet.common.utils.bean.ObjectUtils;
import com.stdiet.custom.domain.SysRecipesPlan;
import com.stdiet.custom.dto.request.CustomerInvestigateRequest;
import com.stdiet.custom.dto.response.CustomerListResponse;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.stdiet.common.annotation.Log;
import com.stdiet.common.core.controller.BaseController;
import com.stdiet.common.core.domain.AjaxResult;
import com.stdiet.common.enums.BusinessType;
import com.stdiet.custom.domain.SysCustomer;
import com.stdiet.custom.service.ISysCustomerService;
import com.stdiet.common.utils.poi.ExcelUtil;
import com.stdiet.common.core.page.TableDataInfo;

/**
 * 客户体征信息Controller
 *
 * @author xzj
 * @date 2021-01-03
 */
@RestController
@RequestMapping("/custom/customer")
public class SysCustomerController extends BaseController
{
    @Autowired
    private ISysCustomerService sysCustomerService;

    /**
     * 查询客户信息列表
     */
    @PreAuthorize("@ss.hasPermi('custom:customer:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysCustomer sysCustomer)
    {
        startPage();
        List<SysCustomer> list = sysCustomerService.selectSysCustomerAndSignList(sysCustomer);
        if(list != null && list.size() > 0){
            for(SysCustomer sysCus : list){
                if(StringUtils.isNotEmpty(sysCus.getPhone())){
                    sysCus.setPhone(StringUtils.hiddenPhoneNumber(sysCus.getPhone()));
                }
            }
        }
        return getDataTable(list);
    }

    /**
     * 导出客户信息列表
     */
    @PreAuthorize("@ss.hasPermi('custom:customer:export')")
    @Log(title = "客户体征", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysCustomer sysCustomer) throws Exception
    {
        List<SysCustomer> list = sysCustomerService.selectSysCustomerAndSignList(sysCustomer);
        List<CustomerListResponse> responsesList = new ArrayList<>();
        CustomerListResponse customerListResponse = null;
        for (SysCustomer customer : list) {
            customerListResponse = ObjectUtils.getObjectByObject(customer.getSign(), CustomerListResponse.class);
            customerListResponse.setCreateTime(customer.getCreateTime());
            customerListResponse.setName(customer.getName());
            if(StringUtils.isNotEmpty(customer.getPhone())){
                customerListResponse.setPhone(StringUtils.hiddenPhoneNumber(customer.getPhone()));
            }
            StringBuilder signStr = new StringBuilder();
            if(customer.getSign().getSignList() != null && customer.getSign().getSignList().size() > 0){
                int i = 0;
                for (SysPhysicalSigns s : customer.getSign().getSignList()) {
                    signStr.append((i != 0 ? "，" : "") + s.getName());
                    i++;
                }
            }
            customerListResponse.setPhysicalSignsId(signStr.toString());
            responsesList.add(customerListResponse);
        }
        ExcelUtil<CustomerListResponse> util = new ExcelUtil<CustomerListResponse>(CustomerListResponse.class);
        return util.exportExcel(responsesList, "客户体征数据");
    }

    /**
     * 获取客户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('custom:customer:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysCustomerService.getCustomerAndSignById(id));
    }

    /**
     * 新增客户信息
     */
    @PreAuthorize("@ss.hasPermi('custom:customer:add')")
    @Log(title = "客户体征", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CustomerInvestigateRequest customerInvestigateRequest) throws Exception
    {
        //验证是否已存在该手机号
        SysCustomer phoneCustomer = sysCustomerService.getCustomerByPhone(customerInvestigateRequest.getPhone());
        if(phoneCustomer != null){
            return AjaxResult.error("该手机号已存在");
        }
        return toAjax(sysCustomerService.addOrupdateCustomerAndSign(customerInvestigateRequest));
    }

    /**
     * 修改客户信息
     */
    @PreAuthorize("@ss.hasPermi('custom:customer:edit')")
    @Log(title = "客户体征", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CustomerInvestigateRequest customerInvestigateRequest) throws Exception
    {
        SysCustomer oldCustomer = sysCustomerService.selectSysCustomerById(customerInvestigateRequest.getId());
        if(oldCustomer != null && !oldCustomer.getPhone().equals(customerInvestigateRequest.getPhone())){
            //验证是否已存在该手机号
            SysCustomer phoneCustomer = sysCustomerService.getCustomerByPhone(customerInvestigateRequest.getPhone());
            if(phoneCustomer != null){
                return AjaxResult.error("该手机号已存在");
            }
        }
        return toAjax(sysCustomerService.addOrupdateCustomerAndSign(customerInvestigateRequest));
    }

    /**
     * 删除客户信息
     */
    @PreAuthorize("@ss.hasPermi('custom:customer:remove')")
    @Log(title = "客户体征", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysCustomerService.delCustomerAndSignById(ids));
    }


    /**
     * 根据手机号查看用户体征
     */
    @GetMapping("/getCustomerAndSignByPhone")
    @PreAuthorize("@ss.hasPermi('custom:customer:query')")
    public AjaxResult getCustomerAndSignByPhone(@RequestParam("phone")String phone)
    {
        SysCustomer sysCustomer = null;
        if(StringUtils.isNotEmpty(phone)){
           sysCustomer = sysCustomerService.selectSysCustomerAndSignByPhone(phone);
        }
        return AjaxResult.success(sysCustomer);
    }
}