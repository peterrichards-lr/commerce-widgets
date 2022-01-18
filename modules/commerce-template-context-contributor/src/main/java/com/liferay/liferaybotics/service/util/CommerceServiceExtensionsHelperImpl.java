package com.liferay.liferaybotics.service.util;

import com.liferay.liferaybotics.model.SkuInventory;
import com.liferay.liferaybotics.model.SkuSales;
import com.liferay.liferaybotics.service.SkuInventoryService;
import com.liferay.liferaybotics.service.SkuSalesService;
import com.liferay.liferaybotics.service.util.api.CommerceServiceExtensionsHelper;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Peter Richards
 */
@Component(service = CommerceServiceExtensionsHelper.class)
public class CommerceServiceExtensionsHelperImpl implements CommerceServiceExtensionsHelper {

	@Override
	public List<SkuInventory> findLowestStock(long companyId, long groupId, int start, int end) {
		return _skuInventoryService.findLowestStock(companyId, groupId, start, end);
	}

	@Override
	public List<SkuSales> findProductSales(long companyId, long groupId, int[] orderStatuses, boolean lowestSales,
			int start, int end) {
		return _skuSalesService.findProductSales(companyId, groupId, orderStatuses, lowestSales, start, end);
	}

	@Reference
	private SkuInventoryService _skuInventoryService;

	@Reference
	private SkuSalesService _skuSalesService;
}
