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

import com.liferay.liferaybotics.exception.NoSuchSkuInventoryException;
import com.liferay.liferaybotics.model.SkuInventory;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sku inventory service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Peter Richards
 * @see SkuInventoryUtil
 * @generated
 */
@ProviderType
public interface SkuInventoryPersistence extends BasePersistence<SkuInventory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SkuInventoryUtil} to access the sku inventory persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the sku inventories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching sku inventories
	 */
	public java.util.List<SkuInventory> findByGroupId(long groupId);

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
	public java.util.List<SkuInventory> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<SkuInventory> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SkuInventory>
			orderByComparator);

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
	public java.util.List<SkuInventory> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SkuInventory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sku inventory in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sku inventory
	 * @throws NoSuchSkuInventoryException if a matching sku inventory could not be found
	 */
	public SkuInventory findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SkuInventory>
				orderByComparator)
		throws NoSuchSkuInventoryException;

	/**
	 * Returns the first sku inventory in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sku inventory, or <code>null</code> if a matching sku inventory could not be found
	 */
	public SkuInventory fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SkuInventory>
			orderByComparator);

	/**
	 * Returns the last sku inventory in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sku inventory
	 * @throws NoSuchSkuInventoryException if a matching sku inventory could not be found
	 */
	public SkuInventory findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SkuInventory>
				orderByComparator)
		throws NoSuchSkuInventoryException;

	/**
	 * Returns the last sku inventory in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sku inventory, or <code>null</code> if a matching sku inventory could not be found
	 */
	public SkuInventory fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<SkuInventory>
			orderByComparator);

	/**
	 * Returns the sku inventories before and after the current sku inventory in the ordered set where groupId = &#63;.
	 *
	 * @param sku the primary key of the current sku inventory
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sku inventory
	 * @throws NoSuchSkuInventoryException if a sku inventory with the primary key could not be found
	 */
	public SkuInventory[] findByGroupId_PrevAndNext(
			String sku, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<SkuInventory>
				orderByComparator)
		throws NoSuchSkuInventoryException;

	/**
	 * Removes all the sku inventories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of sku inventories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching sku inventories
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the sku inventory in the entity cache if it is enabled.
	 *
	 * @param skuInventory the sku inventory
	 */
	public void cacheResult(SkuInventory skuInventory);

	/**
	 * Caches the sku inventories in the entity cache if it is enabled.
	 *
	 * @param skuInventories the sku inventories
	 */
	public void cacheResult(java.util.List<SkuInventory> skuInventories);

	/**
	 * Creates a new sku inventory with the primary key. Does not add the sku inventory to the database.
	 *
	 * @param sku the primary key for the new sku inventory
	 * @return the new sku inventory
	 */
	public SkuInventory create(String sku);

	/**
	 * Removes the sku inventory with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sku the primary key of the sku inventory
	 * @return the sku inventory that was removed
	 * @throws NoSuchSkuInventoryException if a sku inventory with the primary key could not be found
	 */
	public SkuInventory remove(String sku) throws NoSuchSkuInventoryException;

	public SkuInventory updateImpl(SkuInventory skuInventory);

	/**
	 * Returns the sku inventory with the primary key or throws a <code>NoSuchSkuInventoryException</code> if it could not be found.
	 *
	 * @param sku the primary key of the sku inventory
	 * @return the sku inventory
	 * @throws NoSuchSkuInventoryException if a sku inventory with the primary key could not be found
	 */
	public SkuInventory findByPrimaryKey(String sku)
		throws NoSuchSkuInventoryException;

	/**
	 * Returns the sku inventory with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sku the primary key of the sku inventory
	 * @return the sku inventory, or <code>null</code> if a sku inventory with the primary key could not be found
	 */
	public SkuInventory fetchByPrimaryKey(String sku);

	/**
	 * Returns all the sku inventories.
	 *
	 * @return the sku inventories
	 */
	public java.util.List<SkuInventory> findAll();

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
	public java.util.List<SkuInventory> findAll(int start, int end);

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
	public java.util.List<SkuInventory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SkuInventory>
			orderByComparator);

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
	public java.util.List<SkuInventory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SkuInventory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sku inventories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sku inventories.
	 *
	 * @return the number of sku inventories
	 */
	public int countAll();

}