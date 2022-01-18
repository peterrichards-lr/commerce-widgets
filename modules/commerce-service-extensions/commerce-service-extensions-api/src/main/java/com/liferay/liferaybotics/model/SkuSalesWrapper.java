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

package com.liferay.liferaybotics.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SkuSales}.
 * </p>
 *
 * @author Peter Richards
 * @see SkuSales
 * @generated
 */
public class SkuSalesWrapper
	extends BaseModelWrapper<SkuSales>
	implements ModelWrapper<SkuSales>, SkuSales {

	public SkuSalesWrapper(SkuSales skuSales) {
		super(skuSales);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sku", getSku());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("quantitySold", getQuantitySold());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String sku = (String)attributes.get("sku");

		if (sku != null) {
			setSku(sku);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Integer quantitySold = (Integer)attributes.get("quantitySold");

		if (quantitySold != null) {
			setQuantitySold(quantitySold);
		}
	}

	@Override
	public SkuSales cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this sku sales.
	 *
	 * @return the company ID of this sku sales
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the group ID of this sku sales.
	 *
	 * @return the group ID of this sku sales
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the primary key of this sku sales.
	 *
	 * @return the primary key of this sku sales
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quantity sold of this sku sales.
	 *
	 * @return the quantity sold of this sku sales
	 */
	@Override
	public int getQuantitySold() {
		return model.getQuantitySold();
	}

	/**
	 * Returns the sku of this sku sales.
	 *
	 * @return the sku of this sku sales
	 */
	@Override
	public String getSku() {
		return model.getSku();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this sku sales.
	 *
	 * @param companyId the company ID of this sku sales
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the group ID of this sku sales.
	 *
	 * @param groupId the group ID of this sku sales
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the primary key of this sku sales.
	 *
	 * @param primaryKey the primary key of this sku sales
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quantity sold of this sku sales.
	 *
	 * @param quantitySold the quantity sold of this sku sales
	 */
	@Override
	public void setQuantitySold(int quantitySold) {
		model.setQuantitySold(quantitySold);
	}

	/**
	 * Sets the sku of this sku sales.
	 *
	 * @param sku the sku of this sku sales
	 */
	@Override
	public void setSku(String sku) {
		model.setSku(sku);
	}

	@Override
	protected SkuSalesWrapper wrap(SkuSales skuSales) {
		return new SkuSalesWrapper(skuSales);
	}

}