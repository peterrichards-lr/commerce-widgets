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
 * Provides a wrapper for {@link SkuSalesLocalService}.
 *
 * @author Peter Richards
 * @see SkuSalesLocalService
 * @generated
 */
public class SkuSalesLocalServiceWrapper
	implements ServiceWrapper<SkuSalesLocalService>, SkuSalesLocalService {

	public SkuSalesLocalServiceWrapper(
		SkuSalesLocalService skuSalesLocalService) {

		_skuSalesLocalService = skuSalesLocalService;
	}

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
	@Override
	public com.liferay.liferaybotics.model.SkuSales addSkuSales(
		com.liferay.liferaybotics.model.SkuSales skuSales) {

		return _skuSalesLocalService.addSkuSales(skuSales);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _skuSalesLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sku sales with the primary key. Does not add the sku sales to the database.
	 *
	 * @param sku the primary key for the new sku sales
	 * @return the new sku sales
	 */
	@Override
	public com.liferay.liferaybotics.model.SkuSales createSkuSales(String sku) {
		return _skuSalesLocalService.createSkuSales(sku);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _skuSalesLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.liferay.liferaybotics.model.SkuSales deleteSkuSales(
		com.liferay.liferaybotics.model.SkuSales skuSales) {

		return _skuSalesLocalService.deleteSkuSales(skuSales);
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
	@Override
	public com.liferay.liferaybotics.model.SkuSales deleteSkuSales(String sku)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _skuSalesLocalService.deleteSkuSales(sku);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _skuSalesLocalService.dynamicQuery();
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

		return _skuSalesLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _skuSalesLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _skuSalesLocalService.dynamicQuery(
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

		return _skuSalesLocalService.dynamicQueryCount(dynamicQuery);
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

		return _skuSalesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.liferaybotics.model.SkuSales fetchSkuSales(String sku) {
		return _skuSalesLocalService.fetchSkuSales(sku);
	}

	@Override
	public java.util.List<com.liferay.liferaybotics.model.SkuSales>
		findProductSales(
			long companyId, long groupId, int[] orderStatuses,
			boolean lowestSales, int start, int end) {

		return _skuSalesLocalService.findProductSales(
			companyId, groupId, orderStatuses, lowestSales, start, end);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _skuSalesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _skuSalesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sku sales with the primary key.
	 *
	 * @param sku the primary key of the sku sales
	 * @return the sku sales
	 * @throws PortalException if a sku sales with the primary key could not be found
	 */
	@Override
	public com.liferay.liferaybotics.model.SkuSales getSkuSales(String sku)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _skuSalesLocalService.getSkuSales(sku);
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
	@Override
	public java.util.List<com.liferay.liferaybotics.model.SkuSales>
		getSkuSaleses(int start, int end) {

		return _skuSalesLocalService.getSkuSaleses(start, end);
	}

	/**
	 * Returns the number of sku saleses.
	 *
	 * @return the number of sku saleses
	 */
	@Override
	public int getSkuSalesesCount() {
		return _skuSalesLocalService.getSkuSalesesCount();
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
	@Override
	public com.liferay.liferaybotics.model.SkuSales updateSkuSales(
		com.liferay.liferaybotics.model.SkuSales skuSales) {

		return _skuSalesLocalService.updateSkuSales(skuSales);
	}

	@Override
	public SkuSalesLocalService getWrappedService() {
		return _skuSalesLocalService;
	}

	@Override
	public void setWrappedService(SkuSalesLocalService skuSalesLocalService) {
		_skuSalesLocalService = skuSalesLocalService;
	}

	private SkuSalesLocalService _skuSalesLocalService;

}