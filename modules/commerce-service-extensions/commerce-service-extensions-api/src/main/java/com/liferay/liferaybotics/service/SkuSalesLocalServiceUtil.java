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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for SkuSales. This utility wraps
 * <code>com.liferay.liferaybotics.service.impl.SkuSalesLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Peter Richards
 * @see SkuSalesLocalService
 * @generated
 */
public class SkuSalesLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.liferaybotics.service.impl.SkuSalesLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the sku sales to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SkuSalesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param skuSales the sku sales
	 * @return the sku sales that was added
	 */
	public static com.liferay.liferaybotics.model.SkuSales addSkuSales(
		com.liferay.liferaybotics.model.SkuSales skuSales) {

		return getService().addSkuSales(skuSales);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sku sales with the primary key. Does not add the sku sales to the database.
	 *
	 * @param sku the primary key for the new sku sales
	 * @return the new sku sales
	 */
	public static com.liferay.liferaybotics.model.SkuSales createSkuSales(
		String sku) {

		return getService().createSkuSales(sku);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sku sales from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SkuSalesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param skuSales the sku sales
	 * @return the sku sales that was removed
	 */
	public static com.liferay.liferaybotics.model.SkuSales deleteSkuSales(
		com.liferay.liferaybotics.model.SkuSales skuSales) {

		return getService().deleteSkuSales(skuSales);
	}

	/**
	 * Deletes the sku sales with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SkuSalesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sku the primary key of the sku sales
	 * @return the sku sales that was removed
	 * @throws PortalException if a sku sales with the primary key could not be found
	 */
	public static com.liferay.liferaybotics.model.SkuSales deleteSkuSales(
			String sku)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteSkuSales(sku);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.liferaybotics.model.impl.SkuSalesModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.liferaybotics.model.impl.SkuSalesModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.liferaybotics.model.SkuSales fetchSkuSales(
		String sku) {

		return getService().fetchSkuSales(sku);
	}

	public static java.util.List<com.liferay.liferaybotics.model.SkuSales>
		findProductSales(
			long companyId, long groupId, int[] orderStatuses,
			boolean lowestSales, int start, int end) {

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

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sku sales with the primary key.
	 *
	 * @param sku the primary key of the sku sales
	 * @return the sku sales
	 * @throws PortalException if a sku sales with the primary key could not be found
	 */
	public static com.liferay.liferaybotics.model.SkuSales getSkuSales(
			String sku)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getSkuSales(sku);
	}

	/**
	 * Returns a range of all the sku saleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.liferaybotics.model.impl.SkuSalesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sku saleses
	 * @param end the upper bound of the range of sku saleses (not inclusive)
	 * @return the range of sku saleses
	 */
	public static java.util.List<com.liferay.liferaybotics.model.SkuSales>
		getSkuSaleses(int start, int end) {

		return getService().getSkuSaleses(start, end);
	}

	/**
	 * Returns the number of sku saleses.
	 *
	 * @return the number of sku saleses
	 */
	public static int getSkuSalesesCount() {
		return getService().getSkuSalesesCount();
	}

	/**
	 * Updates the sku sales in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SkuSalesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param skuSales the sku sales
	 * @return the sku sales that was updated
	 */
	public static com.liferay.liferaybotics.model.SkuSales updateSkuSales(
		com.liferay.liferaybotics.model.SkuSales skuSales) {

		return getService().updateSkuSales(skuSales);
	}

	public static SkuSalesLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SkuSalesLocalService, SkuSalesLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SkuSalesLocalService.class);

		ServiceTracker<SkuSalesLocalService, SkuSalesLocalService>
			serviceTracker =
				new ServiceTracker<SkuSalesLocalService, SkuSalesLocalService>(
					bundle.getBundleContext(), SkuSalesLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}