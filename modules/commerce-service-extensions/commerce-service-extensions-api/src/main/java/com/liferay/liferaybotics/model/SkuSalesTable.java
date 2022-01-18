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
 * The table class for the &quot;Liferaybotics_SkuSales&quot; database table.
 *
 * @author Peter Richards
 * @see SkuSales
 * @generated
 */
public class SkuSalesTable extends BaseTable<SkuSalesTable> {

	public static final SkuSalesTable INSTANCE = new SkuSalesTable();

	public final Column<SkuSalesTable, String> sku = createColumn(
		"sku", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<SkuSalesTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SkuSalesTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SkuSalesTable, Integer> quantitySold = createColumn(
		"quantitySold", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private SkuSalesTable() {
		super("Liferaybotics_SkuSales", SkuSalesTable::new);
	}

}