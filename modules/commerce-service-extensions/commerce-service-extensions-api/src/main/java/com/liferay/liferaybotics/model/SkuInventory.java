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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the SkuInventory service. Represents a row in the &quot;Liferaybotics_SkuInventory&quot; database table, with each column mapped to a property of this class.
 *
 * @author Peter Richards
 * @see SkuInventoryModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.liferaybotics.model.impl.SkuInventoryImpl"
)
@ProviderType
public interface SkuInventory extends PersistedModel, SkuInventoryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.liferaybotics.model.impl.SkuInventoryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SkuInventory, String> SKU_ACCESSOR =
		new Accessor<SkuInventory, String>() {

			@Override
			public String get(SkuInventory skuInventory) {
				return skuInventory.getSku();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<SkuInventory> getTypeClass() {
				return SkuInventory.class;
			}

		};

}