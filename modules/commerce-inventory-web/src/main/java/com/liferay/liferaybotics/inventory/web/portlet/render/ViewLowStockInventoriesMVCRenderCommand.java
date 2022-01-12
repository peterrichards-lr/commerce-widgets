package com.liferay.liferaybotics.inventory.web.portlet.render;

import com.liferay.commerce.constants.CommerceWebKeys;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.liferaybotics.inventory.web.constants.CommerceInventoryWebPortletKeys;
import com.liferay.liferaybotics.inventory.web.constants.MVCCommandNames;
import com.liferay.liferaybotics.model.SkuInventory;
import com.liferay.liferaybotics.service.SkuInventoryService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, property = { "javax.portlet.name=" +  CommerceInventoryWebPortletKeys.COMMERCEINVENTORYWEB,
		"mvc.command.name=" + MVCCommandNames.ROOT,
		"mvc.command.name=" + MVCCommandNames.VIEW_LOW_STOCK_INVENTORIES }, service = MVCRenderCommand.class)
public class ViewLowStockInventoriesMVCRenderCommand implements MVCRenderCommand {

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

		_log.debug("companyId {}", companyId);
		_log.debug("channelGroupId {}", channelGroupId);
		_log.debug("start {}", start);
		_log.debug("end {}", end);

		List<SkuInventory> skuInventories = skuInventoryService.findLowestStock(companyId, channelGroupId, start, end);
		
		final int skuInventoriesCount = skuInventories.size();
		
		_log.warn("skuInventoriesCount {}", skuInventoriesCount);
			
		renderRequest.setAttribute("skuInventories", skuInventories);
		renderRequest.setAttribute("skuInventoriesCount", skuInventoriesCount);		
	}
	
	@Reference
	protected SkuInventoryService skuInventoryService;

	private static final Logger _log = LoggerFactory.getLogger(ViewLowStockInventoriesMVCRenderCommand.class);
}
