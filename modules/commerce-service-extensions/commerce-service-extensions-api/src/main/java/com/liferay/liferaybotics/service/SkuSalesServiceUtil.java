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

import com.liferay.liferaybotics.model.SkuSales;

import java.util.List;

/**
 * Provides the remote service utility for SkuSales. This utility wraps
 * <code>com.liferay.liferaybotics.service.impl.SkuSalesServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Peter Richards
 * @see SkuSalesService
 * @generated
 */
public class SkuSalesServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.liferaybotics.service.impl.SkuSalesServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static List<SkuSales> findProductSales(
		long companyId, long groupId, int[] orderStatuses, boolean lowestSales,
		int start, int end) {

		return getService().findProductSales(
			companyId, groupId, orderStatuses, lowestSales, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static SkuSalesService getService() {
		return _service;
	}

	private static volatile SkuSalesService _service;

}