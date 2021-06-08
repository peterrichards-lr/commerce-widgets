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

package com.liferay.liferaybotics.service.impl;

import com.liferay.liferaybotics.model.SkuInventory;
import com.liferay.liferaybotics.service.base.SkuInventoryServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the sku inventory remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.liferaybotics.service.SkuInventoryService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Peter Richards
 * @see SkuInventoryServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=liferaybotics",
		"json.web.service.context.path=SkuInventory"
	},
	service = AopService.class
)
public class SkuInventoryServiceImpl extends SkuInventoryServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.liferaybotics.service.SkuInventoryServiceUtil</code> to access the sku inventory remote service.
	 */
	
	public List<SkuInventory> findLowestStock(long companyId, long groupId, int start, int end) {
		return skuInventoryLocalService.findLowestStock(companyId, groupId, start, end);
	}
}