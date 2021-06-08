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

import com.liferay.liferaybotics.exception.NoSuchSkuSalesException;
import com.liferay.liferaybotics.model.SkuSales;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sku sales service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Peter Richards
 * @see SkuSalesUtil
 * @generated
 */
@ProviderType
public interface SkuSalesPersistence extends BasePersistence<SkuSales> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SkuSalesUtil} to access the sku sales persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the sku sales in the entity cache if it is enabled.
	 *
	 * @param skuSales the sku sales
	 */
	public void cacheResult(SkuSales skuSales);

	/**
	 * Caches the sku saleses in the entity cache if it is enabled.
	 *
	 * @param skuSaleses the sku saleses
	 */
	public void cacheResult(java.util.List<SkuSales> skuSaleses);

	/**
	 * Creates a new sku sales with the primary key. Does not add the sku sales to the database.
	 *
	 * @param sku the primary key for the new sku sales
	 * @return the new sku sales
	 */
	public SkuSales create(String sku);

	/**
	 * Removes the sku sales with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sku the primary key of the sku sales
	 * @return the sku sales that was removed
	 * @throws NoSuchSkuSalesException if a sku sales with the primary key could not be found
	 */
	public SkuSales remove(String sku) throws NoSuchSkuSalesException;

	public SkuSales updateImpl(SkuSales skuSales);

	/**
	 * Returns the sku sales with the primary key or throws a <code>NoSuchSkuSalesException</code> if it could not be found.
	 *
	 * @param sku the primary key of the sku sales
	 * @return the sku sales
	 * @throws NoSuchSkuSalesException if a sku sales with the primary key could not be found
	 */
	public SkuSales findByPrimaryKey(String sku) throws NoSuchSkuSalesException;

	/**
	 * Returns the sku sales with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sku the primary key of the sku sales
	 * @return the sku sales, or <code>null</code> if a sku sales with the primary key could not be found
	 */
	public SkuSales fetchByPrimaryKey(String sku);

	/**
	 * Returns all the sku saleses.
	 *
	 * @return the sku saleses
	 */
	public java.util.List<SkuSales> findAll();

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
	public java.util.List<SkuSales> findAll(int start, int end);

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
	public java.util.List<SkuSales> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SkuSales>
			orderByComparator);

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
	public java.util.List<SkuSales> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SkuSales>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sku saleses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sku saleses.
	 *
	 * @return the number of sku saleses
	 */
	public int countAll();

}