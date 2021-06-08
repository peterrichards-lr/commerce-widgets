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
 * This class is used by SOAP remote services, specifically {@link com.liferay.liferaybotics.service.http.SkuSalesServiceSoap}.
 *
 * @author Peter Richards
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SkuSalesSoap implements Serializable {

	public static SkuSalesSoap toSoapModel(SkuSales model) {
		SkuSalesSoap soapModel = new SkuSalesSoap();

		soapModel.setSku(model.getSku());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setQuantitySold(model.getQuantitySold());

		return soapModel;
	}

	public static SkuSalesSoap[] toSoapModels(SkuSales[] models) {
		SkuSalesSoap[] soapModels = new SkuSalesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SkuSalesSoap[][] toSoapModels(SkuSales[][] models) {
		SkuSalesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SkuSalesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SkuSalesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SkuSalesSoap[] toSoapModels(List<SkuSales> models) {
		List<SkuSalesSoap> soapModels = new ArrayList<SkuSalesSoap>(
			models.size());

		for (SkuSales model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SkuSalesSoap[soapModels.size()]);
	}

	public SkuSalesSoap() {
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

	public int getQuantitySold() {
		return _quantitySold;
	}

	public void setQuantitySold(int quantitySold) {
		_quantitySold = quantitySold;
	}

	private String _sku;
	private long _groupId;
	private long _companyId;
	private int _quantitySold;

}