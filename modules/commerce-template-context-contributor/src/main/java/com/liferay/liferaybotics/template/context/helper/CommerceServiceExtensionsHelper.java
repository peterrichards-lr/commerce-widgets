package com.liferay.liferaybotics.template.context.helper;

import com.liferay.liferaybotics.model.SkuInventory;
import com.liferay.liferaybotics.model.SkuSales;

import java.util.List;

/**
 * @author Peter Richards
 */
public interface CommerceServiceExtensionsHelper {
	public List<SkuInventory> findLowestStock(long companyId, long groupId, int start, int end);

	public List<SkuSales> findProductSales(long companyId, long groupId, int[] orderStatuses, boolean lowestSales,
			int start, int end);
}
