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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;Liferaybotics_SkuInventory&quot; database table.
 *
 * @author Peter Richards
 * @see SkuInventory
 * @generated
 */
public class SkuInventoryTable extends BaseTable<SkuInventoryTable> {

	public static final SkuInventoryTable INSTANCE = new SkuInventoryTable();

	public final Column<SkuInventoryTable, String> sku = createColumn(
		"sku", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<SkuInventoryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SkuInventoryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SkuInventoryTable, Integer> quantity = createColumn(
		"quantity", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<SkuInventoryTable, Integer> bookedQuantity =
		createColumn(
			"bookedQuantity", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<SkuInventoryTable, Integer> reservedQuantity =
		createColumn(
			"reservedQuantity", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<SkuInventoryTable, Integer> availableQuantity =
		createColumn(
			"availableQuantity", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);

	private SkuInventoryTable() {
		super("Liferaybotics_SkuInventory", SkuInventoryTable::new);
	}

}