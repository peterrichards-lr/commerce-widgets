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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.liferaybotics.service.http.SkuInventoryServiceSoap}.
 *
 * @author Peter Richards
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SkuInventorySoap implements Serializable {

	public static SkuInventorySoap toSoapModel(SkuInventory model) {
		SkuInventorySoap soapModel = new SkuInventorySoap();

		soapModel.setSku(model.getSku());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setQuantity(model.getQuantity());
		soapModel.setBookedQuantity(model.getBookedQuantity());
		soapModel.setReservedQuantity(model.getReservedQuantity());
		soapModel.setAvailableQuantity(model.getAvailableQuantity());

		return soapModel;
	}

	public static SkuInventorySoap[] toSoapModels(SkuInventory[] models) {
		SkuInventorySoap[] soapModels = new SkuInventorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SkuInventorySoap[][] toSoapModels(SkuInventory[][] models) {
		SkuInventorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SkuInventorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new SkuInventorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SkuInventorySoap[] toSoapModels(List<SkuInventory> models) {
		List<SkuInventorySoap> soapModels = new ArrayList<SkuInventorySoap>(
			models.size());

		for (SkuInventory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SkuInventorySoap[soapModels.size()]);
	}

	public SkuInventorySoap() {
	}

	public String getPrimaryKey() {
		return _sku;
	}

	public void setPrimaryKey(String pk) {
		setSku(pk);
	}

	public String getSku() {
		return _sku;
	}

	public void setSku(String sku) {
		_sku = sku;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public int getQuantity() {
		return _quantity;
	}

	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	public int getBookedQuantity() {
		return _bookedQuantity;
	}

	public void setBookedQuantity(int bookedQuantity) {
		_bookedQuantity = bookedQuantity;
	}

	public int getReservedQuantity() {
		return _reservedQuantity;
	}

	public void setReservedQuantity(int reservedQuantity) {
		_reservedQuantity = reservedQuantity;
	}

	public int getAvailableQuantity() {
		return _availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		_availableQuantity = availableQuantity;
	}

	private String _sku;
	private long _groupId;
	private long _companyId;
	private int _quantity;
	private int _bookedQuantity;
	private int _reservedQuantity;
	private int _availableQuantity;

}