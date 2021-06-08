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

package com.liferay.liferaybotics.model.impl;

import com.liferay.liferaybotics.model.SkuSales;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SkuSales in entity cache.
 *
 * @author Peter Richards
 * @generated
 */
public class SkuSalesCacheModel
	implements CacheModel<SkuSales>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SkuSalesCacheModel)) {
			return false;
		}

		SkuSalesCacheModel skuSalesCacheModel = (SkuSalesCacheModel)object;

		if (sku.equals(skuSalesCacheModel.sku)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, sku);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{sku=");
		sb.append(sku);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", quantitySold=");
		sb.append(quantitySold);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SkuSales toEntityModel() {
		SkuSalesImpl skuSalesImpl = new SkuSalesImpl();

		if (sku == null) {
			skuSalesImpl.setSku("");
		}
		else {
			skuSalesImpl.setSku(sku);
		}

		skuSalesImpl.setGroupId(groupId);
		skuSalesImpl.setCompanyId(companyId);
		skuSalesImpl.setQuantitySold(quantitySold);

		skuSalesImpl.resetOriginalValues();

		return skuSalesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sku = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		quantitySold = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (sku == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sku);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeInt(quantitySold);
	}

	public String sku;
	public long groupId;
	public long companyId;
	public int quantitySold;

}