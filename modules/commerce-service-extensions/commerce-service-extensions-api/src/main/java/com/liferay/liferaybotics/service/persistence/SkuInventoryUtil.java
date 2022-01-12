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

import com.liferay.liferaybotics.model.SkuInventory;
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
 * The persistence utility for the sku inventory service. This utility wraps <code>com.liferay.liferaybotics.service.persistence.impl.SkuInventoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Peter Richards
 * @see SkuInventoryPersistence
 * @generated
 */
public class SkuInventoryUtil {

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
	public static void clearCache(SkuInventory skuInventory) {
		getPersistence().clearCache(skuInventory);
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
	public static Map<Serializable, SkuInventory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SkuInventory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SkuInventory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SkuInventory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SkuInventory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SkuInventory update(SkuInventory skuInventory) {
		return getPersistence().update(skuInventory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SkuInventory update(
		SkuInventory skuInventory, ServiceContext serviceContext) {

		return getPersistence().update(skuInventory, serviceContext);
	}

	/**
	 * Returns all the sku inventories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching sku inventories
	 */
	public static List<SkuInventory> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the sku inventories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkuInventoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sku inventories
	 * @param end the upper bound of the range of sku inventories (not inclusive)
	 * @return the range of matching sku inventories
	 */
	public static List<SkuInventory> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the sku inventories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkuInventoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sku inventories
	 * @param end the upper bound of the range of sku inventories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sku inventories
	 */
	public static List<SkuInventory> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SkuInventory> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sku inventories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkuInventoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sku inventories
	 * @param end the upper bound of the range of sku inventories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sku inventories
	 */
	public static List<SkuInventory> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SkuInventory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sku inventory in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sku inventory
	 * @throws NoSuchSkuInventoryException if a matching sku inventory could not be found
	 */
	public static SkuInventory findByGroupId_First(
			long groupId, OrderByComparator<SkuInventory> orderByComparator)
		throws com.liferay.liferaybotics.exception.NoSuchSkuInventoryException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first sku inventory in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sku inventory, or <code>null</code> if a matching sku inventory could not be found
	 */
	public static SkuInventory fetchByGroupId_First(
		long groupId, OrderByComparator<SkuInventory> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last sku inventory in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sku inventory
	 * @throws NoSuchSkuInventoryException if a matching sku inventory could not be found
	 */
	public static SkuInventory findByGroupId_Last(
			long groupId, OrderByComparator<SkuInventory> orderByComparator)
		throws com.liferay.liferaybotics.exception.NoSuchSkuInventoryException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last sku inventory in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sku inventory, or <code>null</code> if a matching sku inventory could not be found
	 */
	public static SkuInventory fetchByGroupId_Last(
		long groupId, OrderByComparator<SkuInventory> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the sku inventories before and after the current sku inventory in the ordered set where groupId = &#63;.
	 *
	 * @param sku the primary key of the current sku inventory
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sku inventory
	 * @throws NoSuchSkuInventoryException if a sku inventory with the primary key could not be found
	 */
	public static SkuInventory[] findByGroupId_PrevAndNext(
			String sku, long groupId,
			OrderByComparator<SkuInventory> orderByComparator)
		throws com.liferay.liferaybotics.exception.NoSuchSkuInventoryException {

		return getPersistence().findByGroupId_PrevAndNext(
			sku, groupId, orderByComparator);
	}

	/**
	 * Removes all the sku inventories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of sku inventories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching sku inventories
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the sku inventory in the entity cache if it is enabled.
	 *
	 * @param skuInventory the sku inventory
	 */
	public static void cacheResult(SkuInventory skuInventory) {
		getPersistence().cacheResult(skuInventory);
	}

	/**
	 * Caches the sku inventories in the entity cache if it is enabled.
	 *
	 * @param skuInventories the sku inventories
	 */
	public static void cacheResult(List<SkuInventory> skuInventories) {
		getPersistence().cacheResult(skuInventories);
	}

	/**
	 * Creates a new sku inventory with the primary key. Does not add the sku inventory to the database.
	 *
	 * @param sku the primary key for the new sku inventory
	 * @return the new sku inventory
	 */
	public static SkuInventory create(String sku) {
		return getPersistence().create(sku);
	}

	/**
	 * Removes the sku inventory with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sku the primary key of the sku inventory
	 * @return the sku inventory that was removed
	 * @throws NoSuchSkuInventoryException if a sku inventory with the primary key could not be found
	 */
	public static SkuInventory remove(String sku)
		throws com.liferay.liferaybotics.exception.NoSuchSkuInventoryException {

		return getPersistence().remove(sku);
	}

	public static SkuInventory updateImpl(SkuInventory skuInventory) {
		return getPersistence().updateImpl(skuInventory);
	}

	/**
	 * Returns the sku inventory with the primary key or throws a <code>NoSuchSkuInventoryException</code> if it could not be found.
	 *
	 * @param sku the primary key of the sku inventory
	 * @return the sku inventory
	 * @throws NoSuchSkuInventoryException if a sku inventory with the primary key could not be found
	 */
	public static SkuInventory findByPrimaryKey(String sku)
		throws com.liferay.liferaybotics.exception.NoSuchSkuInventoryException {

		return getPersistence().findByPrimaryKey(sku);
	}

	/**
	 * Returns the sku inventory with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sku the primary key of the sku inventory
	 * @return the sku inventory, or <code>null</code> if a sku inventory with the primary key could not be found
	 */
	public static SkuInventory fetchByPrimaryKey(String sku) {
		return getPersistence().fetchByPrimaryKey(sku);
	}

	/**
	 * Returns all the sku inventories.
	 *
	 * @return the sku inventories
	 */
	public static List<SkuInventory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the sku inventories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkuInventoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sku inventories
	 * @param end the upper bound of the range of sku inventories (not inclusive)
	 * @return the range of sku inventories
	 */
	public static List<SkuInventory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the sku inventories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkuInventoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sku inventories
	 * @param end the upper bound of the range of sku inventories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sku inventories
	 */
	public static List<SkuInventory> findAll(
		int start, int end, OrderByComparator<SkuInventory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sku inventories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkuInventoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sku inventories
	 * @param end the upper bound of the range of sku inventories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sku inventories
	 */
	public static List<SkuInventory> findAll(
		int start, int end, OrderByComparator<SkuInventory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sku inventories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sku inventories.
	 *
	 * @return the number of sku inventories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SkuInventoryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SkuInventoryPersistence, SkuInventoryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SkuInventoryPersistence.class);

		ServiceTracker<SkuInventoryPersistence, SkuInventoryPersistence>
			serviceTracker =
				new ServiceTracker
					<SkuInventoryPersistence, SkuInventoryPersistence>(
						bundle.getBundleContext(),
						SkuInventoryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}