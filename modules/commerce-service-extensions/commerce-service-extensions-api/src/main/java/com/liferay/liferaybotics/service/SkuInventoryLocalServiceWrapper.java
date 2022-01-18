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
 * Provides a wrapper for {@link SkuInventoryLocalService}.
 *
 * @author Peter Richards
 * @see SkuInventoryLocalService
 * @generated
 */
public class SkuInventoryLocalServiceWrapper
	implements ServiceWrapper<SkuInventoryLocalService>,
			   SkuInventoryLocalService {

	public SkuInventoryLocalServiceWrapper(
		SkuInventoryLocalService skuInventoryLocalService) {

		_skuInventoryLocalService = skuInventoryLocalService;
	}

	/**
	 * Adds the sku inventory to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SkuInventoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param skuInventory the sku inventory
	 * @return the sku inventory that was added
	 */
	@Override
	public com.liferay.liferaybotics.model.SkuInventory addSkuInventory(
		com.liferay.liferaybotics.model.SkuInventory skuInventory) {

		return _skuInventoryLocalService.addSkuInventory(skuInventory);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _skuInventoryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sku inventory with the primary key. Does not add the sku inventory to the database.
	 *
	 * @param sku the primary key for the new sku inventory
	 * @return the new sku inventory
	 */
	@Override
	public com.liferay.liferaybotics.model.SkuInventory createSkuInventory(
		String sku) {

		return _skuInventoryLocalService.createSkuInventory(sku);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _skuInventoryLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sku inventory from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SkuInventoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param skuInventory the sku inventory
	 * @return the sku inventory that was removed
	 */
	@Override
	public com.liferay.liferaybotics.model.SkuInventory deleteSkuInventory(
		com.liferay.liferaybotics.model.SkuInventory skuInventory) {

		return _skuInventoryLocalService.deleteSkuInventory(skuInventory);
	}

	/**
	 * Deletes the sku inventory with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SkuInventoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sku the primary key of the sku inventory
	 * @return the sku inventory that was removed
	 * @throws PortalException if a sku inventory with the primary key could not be found
	 */
	@Override
	public com.liferay.liferaybotics.model.SkuInventory deleteSkuInventory(
			String sku)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _skuInventoryLocalService.deleteSkuInventory(sku);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _skuInventoryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _skuInventoryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _skuInventoryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _skuInventoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.liferaybotics.model.impl.SkuInventoryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _skuInventoryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.liferaybotics.model.impl.SkuInventoryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _skuInventoryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _skuInventoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _skuInventoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.liferaybotics.model.SkuInventory fetchSkuInventory(
		String sku) {

		return _skuInventoryLocalService.fetchSkuInventory(sku);
	}

	@Override
	public java.util.List<com.liferay.liferaybotics.model.SkuInventory>
		findLowestStock(long companyId, long groupId, int start, int end) {

		return _skuInventoryLocalService.findLowestStock(
			companyId, groupId, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _skuInventoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _skuInventoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the sku inventories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.liferaybotics.model.impl.SkuInventoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sku inventories
	 * @param end the upper bound of the range of sku inventories (not inclusive)
	 * @return the range of sku inventories
	 */
	@Override
	public java.util.List<com.liferay.liferaybotics.model.SkuInventory>
		getSkuInventories(int start, int end) {

		return _skuInventoryLocalService.getSkuInventories(start, end);
	}

	/**
	 * Returns the number of sku inventories.
	 *
	 * @return the number of sku inventories
	 */
	@Override
	public int getSkuInventoriesCount() {
		return _skuInventoryLocalService.getSkuInventoriesCount();
	}

	/**
	 * Returns the sku inventory with the primary key.
	 *
	 * @param sku the primary key of the sku inventory
	 * @return the sku inventory
	 * @throws PortalException if a sku inventory with the primary key could not be found
	 */
	@Override
	public com.liferay.liferaybotics.model.SkuInventory getSkuInventory(
			String sku)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _skuInventoryLocalService.getSkuInventory(sku);
	}

	/**
	 * Updates the sku inventory in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SkuInventoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param skuInventory the sku inventory
	 * @return the sku inventory that was updated
	 */
	@Override
	public com.liferay.liferaybotics.model.SkuInventory updateSkuInventory(
		com.liferay.liferaybotics.model.SkuInventory skuInventory) {

		return _skuInventoryLocalService.updateSkuInventory(skuInventory);
	}

	@Override
	public SkuInventoryLocalService getWrappedService() {
		return _skuInventoryLocalService;
	}

	@Override
	public void setWrappedService(
		SkuInventoryLocalService skuInventoryLocalService) {

		_skuInventoryLocalService = skuInventoryLocalService;
	}

	private SkuInventoryLocalService _skuInventoryLocalService;

}