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

package com.liferay.liferaybotics.service.persistence;

import com.liferay.liferaybotics.model.SkuSales;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the sku sales service. This utility wraps <code>com.liferay.liferaybotics.service.persistence.impl.SkuSalesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Peter Richards
 * @see SkuSalesPersistence
 * @generated
 */
public class SkuSalesUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(SkuSales skuSales) {
		getPersistence().clearCache(skuSales);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, SkuSales> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SkuSales> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SkuSales> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SkuSales> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SkuSales> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SkuSales update(SkuSales skuSales) {
		return getPersistence().update(skuSales);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SkuSales update(
		SkuSales skuSales, ServiceContext serviceContext) {

		return getPersistence().update(skuSales, serviceContext);
	}

	/**
	 * Caches the sku sales in the entity cache if it is enabled.
	 *
	 * @param skuSales the sku sales
	 */
	public static void cacheResult(SkuSales skuSales) {
		getPersistence().cacheResult(skuSales);
	}

	/**
	 * Caches the sku saleses in the entity cache if it is enabled.
	 *
	 * @param skuSaleses the sku saleses
	 */
	public static void cacheResult(List<SkuSales> skuSaleses) {
		getPersistence().cacheResult(skuSaleses);
	}

	/**
	 * Creates a new sku sales with the primary key. Does not add the sku sales to the database.
	 *
	 * @param sku the primary key for the new sku sales
	 * @return the new sku sales
	 */
	public static SkuSales create(String sku) {
		return getPersistence().create(sku);
	}

	/**
	 * Removes the sku sales with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sku the primary key of the sku sales
	 * @return the sku sales that was removed
	 * @throws NoSuchSkuSalesException if a sku sales with the primary key could not be found
	 */
	public static SkuSales remove(String sku)
		throws com.liferay.liferaybotics.exception.NoSuchSkuSalesException {

		return getPersistence().remove(sku);
	}

	public static SkuSales updateImpl(SkuSales skuSales) {
		return getPersistence().updateImpl(skuSales);
	}

	/**
	 * Returns the sku sales with the primary key or throws a <code>NoSuchSkuSalesException</code> if it could not be found.
	 *
	 * @param sku the primary key of the sku sales
	 * @return the sku sales
	 * @throws NoSuchSkuSalesException if a sku sales with the primary key could not be found
	 */
	public static SkuSales findByPrimaryKey(String sku)
		throws com.liferay.liferaybotics.exception.NoSuchSkuSalesException {

		return getPersistence().findByPrimaryKey(sku);
	}

	/**
	 * Returns the sku sales with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sku the primary key of the sku sales
	 * @return the sku sales, or <code>null</code> if a sku sales with the primary key could not be found
	 */
	public static SkuSales fetchByPrimaryKey(String sku) {
		return getPersistence().fetchByPrimaryKey(sku);
	}

	/**
	 * Returns all the sku saleses.
	 *
	 * @return the sku saleses
	 */
	public static List<SkuSales> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the sku saleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkuSalesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sku saleses
	 * @param end the upper bound of the range of sku saleses (not inclusive)
	 * @return the range of sku saleses
	 */
	public static List<SkuSales> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the sku saleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkuSalesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sku saleses
	 * @param end the upper bound of the range of sku saleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sku saleses
	 */
	public static List<SkuSales> findAll(
		int start, int end, OrderByComparator<SkuSales> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sku saleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkuSalesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sku saleses
	 * @param end the upper bound of the range of sku saleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sku saleses
	 */
	public static List<SkuSales> findAll(
		int start, int end, OrderByComparator<SkuSales> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sku saleses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sku saleses.
	 *
	 * @return the number of sku saleses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SkuSalesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SkuSalesPersistence, SkuSalesPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SkuSalesPersistence.class);

		ServiceTracker<SkuSalesPersistence, SkuSalesPersistence>
			serviceTracker =
				new ServiceTracker<SkuSalesPersistence, SkuSalesPersistence>(
					bundle.getBundleContext(), SkuSalesPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}