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

package com.liferay.liferaybotics.service.persistence.impl;

import com.liferay.liferaybotics.model.SkuSales;
import com.liferay.liferaybotics.service.persistence.SkuSalesPersistence;
import com.liferay.liferaybotics.service.persistence.impl.constants.LiferayboticsPersistenceConstants;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Peter Richards
 * @generated
 */
public abstract class SkuSalesFinderBaseImpl
	extends BasePersistenceImpl<SkuSales> {

	public SkuSalesFinderBaseImpl() {
		setModelClass(SkuSales.class);
	}

	@Override
	@Reference(
		target = LiferayboticsPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = LiferayboticsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = LiferayboticsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected SkuSalesPersistence skuSalesPersistence;

	static {
		try {
			Class.forName(LiferayboticsPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}