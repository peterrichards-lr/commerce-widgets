package com.liferay.liferaybotics.sales.web.portlet.render;

import com.liferay.commerce.constants.CommerceOrderConstants;
import com.liferay.commerce.constants.CommerceWebKeys;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.liferaybotics.model.SkuSales;
import com.liferay.liferaybotics.sales.web.constants.CommerceSalesWebPortletKeys;
import com.liferay.liferaybotics.sales.web.constants.MVCCommandNames;
import com.liferay.liferaybotics.service.SkuSalesService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, property = { "javax.portlet.name=" +  CommerceSalesWebPortletKeys.COMMERCESALESWEB,
		"mvc.command.name=" + MVCCommandNames.ROOT,
		"mvc.command.name=" + MVCCommandNames.VIEW_SALES_INVENTORIES }, service = MVCRenderCommand.class)
public class ViewSalesMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		addSkuInventoryListAttributes(renderRequest);
		
		return "/view.jsp";
	}
	
	private void addSkuInventoryListAttributes(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		final long companyId = themeDisplay.getCompanyId();

		long channelGroupId;
		try {
			CommerceContext commerceContext = (CommerceContext)renderRequest.getAttribute(CommerceWebKeys.COMMERCE_CONTEXT);
			channelGroupId = commerceContext.getCommerceChannelGroupId();
		} catch (PortalException e) {
			_log.warn("Unable to retrieve commerce channel id", e);
			return;
		}

		final int start = 0;
		final int end = 5;
		final int[] orderStatuses = {  CommerceOrderConstants.ORDER_STATUS_SHIPPED };

		_log.debug("companyId {}", companyId);
		_log.debug("channelGroupId {}", channelGroupId);
		_log.debug("start {}", start);
		_log.debug("end {}", end);
		
		String[] orderStatusList = Arrays.stream(orderStatuses).mapToObj(String::valueOf).toArray(String[]::new);	
		_log.debug("orderStatuses {}", String.join(" - ", orderStatusList));
		
		// Top
		List<SkuSales> skuTopSales = skuSalesService.findProductSales(companyId, channelGroupId, orderStatuses, false, start, end);
		
		final int skuTopSalesCount = skuTopSales.size();
		_log.warn("skuTopSalesCount {}", skuTopSalesCount);
					
		renderRequest.setAttribute("skuTopSales", skuTopSales);
		renderRequest.setAttribute("skuTopSalesCount", skuTopSalesCount);		

		// Bottom
		List<SkuSales> skuBottomSales = skuSalesService.findProductSales(companyId, channelGroupId, orderStatuses, true, start, end);
		
		final int skuBottomSalesCount = skuBottomSales.size();
		_log.warn("skuBottomSalesCount {}", skuBottomSalesCount);

		renderRequest.setAttribute("skuBottomSales", skuBottomSales);
		renderRequest.setAttribute("skuBottomSalesCount", skuBottomSalesCount);		

	}
	
	@Reference
	protected SkuSalesService skuSalesService;

	private static final Logger _log = LoggerFactory.getLogger(ViewSalesMVCRenderCommand.class);
}
