/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.liferaybotics.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SkuSalesService}.
 *
 * @author Peter Richards
 * @see SkuSalesService
 * @generated
 */
public class SkuSalesServiceWrapper
	implements ServiceWrapper<SkuSalesService>, SkuSalesService {

	public SkuSalesServiceWrapper(SkuSalesService skuSalesService) {
		_skuSalesService = skuSalesService;
	}

	@Override
	public java.util.List<com.liferay.liferaybotics.model.SkuSales>
		findProductSales(
			long companyId, long groupId, int[] orderStatuses,
			boolean lowestSales, int start, int end) {

		return _skuSalesService.findProductSales(
			companyId, groupId, orderStatuses, lowestSales, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _skuSalesService.getOSGiServiceIdentifier();
	}

	@Override
	public SkuSalesService getWrappedService() {
		return _skuSalesService;
	}

	@Override
	public void setWrappedService(SkuSalesService skuSalesService) {
		_skuSalesService = skuSalesService;
	}

	private SkuSalesService _skuSalesService;

}