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
 * Provides a wrapper for {@link SkuInventoryService}.
 *
 * @author Peter Richards
 * @see SkuInventoryService
 * @generated
 */
public class SkuInventoryServiceWrapper
	implements ServiceWrapper<SkuInventoryService>, SkuInventoryService {

	public SkuInventoryServiceWrapper(SkuInventoryService skuInventoryService) {
		_skuInventoryService = skuInventoryService;
	}

	@Override
	public java.util.List<com.liferay.liferaybotics.model.SkuInventory>
		findLowestStock(long companyId, long groupId, int start, int end) {

		return _skuInventoryService.findLowestStock(
			companyId, groupId, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _skuInventoryService.getOSGiServiceIdentifier();
	}

	@Override
	public SkuInventoryService getWrappedService() {
		return _skuInventoryService;
	}

	@Override
	public void setWrappedService(SkuInventoryService skuInventoryService) {
		_skuInventoryService = skuInventoryService;
	}

	private SkuInventoryService _skuInventoryService;

}