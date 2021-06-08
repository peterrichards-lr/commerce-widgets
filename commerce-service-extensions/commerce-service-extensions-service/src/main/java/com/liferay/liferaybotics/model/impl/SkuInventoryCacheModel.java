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

import com.liferay.liferaybotics.model.SkuInventory;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SkuInventory in entity cache.
 *
 * @author Peter Richards
 * @generated
 */
public class SkuInventoryCacheModel
	implements CacheModel<SkuInventory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SkuInventoryCacheModel)) {
			return false;
		}

		SkuInventoryCacheModel skuInventoryCacheModel =
			(SkuInventoryCacheModel)object;

		if (sku.equals(skuInventoryCacheModel.sku)) {
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
		StringBundler sb = new StringBundler(15);

		sb.append("{sku=");
		sb.append(sku);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append(", bookedQuantity=");
		sb.append(bookedQuantity);
		sb.append(", reservedQuantity=");
		sb.append(reservedQuantity);
		sb.append(", availableQuantity=");
		sb.append(availableQuantity);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SkuInventory toEntityModel() {
		SkuInventoryImpl skuInventoryImpl = new SkuInventoryImpl();

		if (sku == null) {
			skuInventoryImpl.setSku("");
		}
		else {
			skuInventoryImpl.setSku(sku);
		}

		skuInventoryImpl.setGroupId(groupId);
		skuInventoryImpl.setCompanyId(companyId);
		skuInventoryImpl.setQuantity(quantity);
		skuInventoryImpl.setBookedQuantity(bookedQuantity);
		skuInventoryImpl.setReservedQuantity(reservedQuantity);
		skuInventoryImpl.setAvailableQuantity(availableQuantity);

		skuInventoryImpl.resetOriginalValues();

		return skuInventoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sku = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		quantity = objectInput.readInt();

		bookedQuantity = objectInput.readInt();

		reservedQuantity = objectInput.readInt();

		availableQuantity = objectInput.readInt();
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

		objectOutput.writeInt(quantity);

		objectOutput.writeInt(bookedQuantity);

		objectOutput.writeInt(reservedQuantity);

		objectOutput.writeInt(availableQuantity);
	}

	public String sku;
	public long groupId;
	public long companyId;
	public int quantity;
	public int bookedQuantity;
	public int reservedQuantity;
	public int availableQuantity;

}