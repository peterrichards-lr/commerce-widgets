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
 * This class is a wrapper for {@link SkuInventory}.
 * </p>
 *
 * @author Peter Richards
 * @see SkuInventory
 * @generated
 */
public class SkuInventoryWrapper
	extends BaseModelWrapper<SkuInventory>
	implements ModelWrapper<SkuInventory>, SkuInventory {

	public SkuInventoryWrapper(SkuInventory skuInventory) {
		super(skuInventory);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sku", getSku());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("quantity", getQuantity());
		attributes.put("bookedQuantity", getBookedQuantity());
		attributes.put("reservedQuantity", getReservedQuantity());
		attributes.put("availableQuantity", getAvailableQuantity());

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

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		Integer bookedQuantity = (Integer)attributes.get("bookedQuantity");

		if (bookedQuantity != null) {
			setBookedQuantity(bookedQuantity);
		}

		Integer reservedQuantity = (Integer)attributes.get("reservedQuantity");

		if (reservedQuantity != null) {
			setReservedQuantity(reservedQuantity);
		}

		Integer availableQuantity = (Integer)attributes.get(
			"availableQuantity");

		if (availableQuantity != null) {
			setAvailableQuantity(availableQuantity);
		}
	}

	/**
	 * Returns the available quantity of this sku inventory.
	 *
	 * @return the available quantity of this sku inventory
	 */
	@Override
	public int getAvailableQuantity() {
		return model.getAvailableQuantity();
	}

	/**
	 * Returns the booked quantity of this sku inventory.
	 *
	 * @return the booked quantity of this sku inventory
	 */
	@Override
	public int getBookedQuantity() {
		return model.getBookedQuantity();
	}

	/**
	 * Returns the company ID of this sku inventory.
	 *
	 * @return the company ID of this sku inventory
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the group ID of this sku inventory.
	 *
	 * @return the group ID of this sku inventory
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the primary key of this sku inventory.
	 *
	 * @return the primary key of this sku inventory
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quantity of this sku inventory.
	 *
	 * @return the quantity of this sku inventory
	 */
	@Override
	public int getQuantity() {
		return model.getQuantity();
	}

	/**
	 * Returns the reserved quantity of this sku inventory.
	 *
	 * @return the reserved quantity of this sku inventory
	 */
	@Override
	public int getReservedQuantity() {
		return model.getReservedQuantity();
	}

	/**
	 * Returns the sku of this sku inventory.
	 *
	 * @return the sku of this sku inventory
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
	 * Sets the available quantity of this sku inventory.
	 *
	 * @param availableQuantity the available quantity of this sku inventory
	 */
	@Override
	public void setAvailableQuantity(int availableQuantity) {
		model.setAvailableQuantity(availableQuantity);
	}

	/**
	 * Sets the booked quantity of this sku inventory.
	 *
	 * @param bookedQuantity the booked quantity of this sku inventory
	 */
	@Override
	public void setBookedQuantity(int bookedQuantity) {
		model.setBookedQuantity(bookedQuantity);
	}

	/**
	 * Sets the company ID of this sku inventory.
	 *
	 * @param companyId the company ID of this sku inventory
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the group ID of this sku inventory.
	 *
	 * @param groupId the group ID of this sku inventory
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the primary key of this sku inventory.
	 *
	 * @param primaryKey the primary key of this sku inventory
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quantity of this sku inventory.
	 *
	 * @param quantity the quantity of this sku inventory
	 */
	@Override
	public void setQuantity(int quantity) {
		model.setQuantity(quantity);
	}

	/**
	 * Sets the reserved quantity of this sku inventory.
	 *
	 * @param reservedQuantity the reserved quantity of this sku inventory
	 */
	@Override
	public void setReservedQuantity(int reservedQuantity) {
		model.setReservedQuantity(reservedQuantity);
	}

	/**
	 * Sets the sku of this sku inventory.
	 *
	 * @param sku the sku of this sku inventory
	 */
	@Override
	public void setSku(String sku) {
		model.setSku(sku);
	}

	@Override
	protected SkuInventoryWrapper wrap(SkuInventory skuInventory) {
		return new SkuInventoryWrapper(skuInventory);
	}

}