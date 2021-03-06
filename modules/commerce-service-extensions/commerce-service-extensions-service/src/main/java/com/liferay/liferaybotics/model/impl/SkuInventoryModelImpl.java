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
import com.liferay.liferaybotics.model.SkuInventoryModel;
import com.liferay.liferaybotics.model.SkuInventorySoap;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the SkuInventory service. Represents a row in the &quot;Liferaybotics_SkuInventory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>SkuInventoryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SkuInventoryImpl}.
 * </p>
 *
 * @author Peter Richards
 * @see SkuInventoryImpl
 * @generated
 */
@JSON(strict = true)
public class SkuInventoryModelImpl
	extends BaseModelImpl<SkuInventory> implements SkuInventoryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a sku inventory model instance should use the <code>SkuInventory</code> interface instead.
	 */
	public static final String TABLE_NAME = "Liferaybotics_SkuInventory";

	public static final Object[][] TABLE_COLUMNS = {
		{"sku", Types.VARCHAR}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"quantity", Types.INTEGER},
		{"bookedQuantity", Types.INTEGER}, {"reservedQuantity", Types.INTEGER},
		{"availableQuantity", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("sku", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("quantity", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("bookedQuantity", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("reservedQuantity", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("availableQuantity", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Liferaybotics_SkuInventory (sku VARCHAR(75) not null primary key,groupId LONG,companyId LONG,quantity INTEGER,bookedQuantity INTEGER,reservedQuantity INTEGER,availableQuantity INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table Liferaybotics_SkuInventory";

	public static final String ORDER_BY_JPQL = " ORDER BY skuInventory.sku ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Liferaybotics_SkuInventory.sku ASC";

	public static final String DATA_SOURCE = "noDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long SKU_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static SkuInventory toModel(SkuInventorySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		SkuInventory model = new SkuInventoryImpl();

		model.setSku(soapModel.getSku());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setQuantity(soapModel.getQuantity());
		model.setBookedQuantity(soapModel.getBookedQuantity());
		model.setReservedQuantity(soapModel.getReservedQuantity());
		model.setAvailableQuantity(soapModel.getAvailableQuantity());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<SkuInventory> toModels(SkuInventorySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<SkuInventory> models = new ArrayList<SkuInventory>(
			soapModels.length);

		for (SkuInventorySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public SkuInventoryModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _sku;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setSku(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sku;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return SkuInventory.class;
	}

	@Override
	public String getModelClassName() {
		return SkuInventory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<SkuInventory, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<SkuInventory, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SkuInventory, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((SkuInventory)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<SkuInventory, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<SkuInventory, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(SkuInventory)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<SkuInventory, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<SkuInventory, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, SkuInventory>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			SkuInventory.class.getClassLoader(), SkuInventory.class,
			ModelWrapper.class);

		try {
			Constructor<SkuInventory> constructor =
				(Constructor<SkuInventory>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<SkuInventory, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<SkuInventory, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<SkuInventory, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<SkuInventory, Object>>();
		Map<String, BiConsumer<SkuInventory, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<SkuInventory, ?>>();

		attributeGetterFunctions.put("sku", SkuInventory::getSku);
		attributeSetterBiConsumers.put(
			"sku", (BiConsumer<SkuInventory, String>)SkuInventory::setSku);
		attributeGetterFunctions.put("groupId", SkuInventory::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<SkuInventory, Long>)SkuInventory::setGroupId);
		attributeGetterFunctions.put("companyId", SkuInventory::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<SkuInventory, Long>)SkuInventory::setCompanyId);
		attributeGetterFunctions.put("quantity", SkuInventory::getQuantity);
		attributeSetterBiConsumers.put(
			"quantity",
			(BiConsumer<SkuInventory, Integer>)SkuInventory::setQuantity);
		attributeGetterFunctions.put(
			"bookedQuantity", SkuInventory::getBookedQuantity);
		attributeSetterBiConsumers.put(
			"bookedQuantity",
			(BiConsumer<SkuInventory, Integer>)SkuInventory::setBookedQuantity);
		attributeGetterFunctions.put(
			"reservedQuantity", SkuInventory::getReservedQuantity);
		attributeSetterBiConsumers.put(
			"reservedQuantity",
			(BiConsumer<SkuInventory, Integer>)
				SkuInventory::setReservedQuantity);
		attributeGetterFunctions.put(
			"availableQuantity", SkuInventory::getAvailableQuantity);
		attributeSetterBiConsumers.put(
			"availableQuantity",
			(BiConsumer<SkuInventory, Integer>)
				SkuInventory::setAvailableQuantity);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getSku() {
		if (_sku == null) {
			return "";
		}
		else {
			return _sku;
		}
	}

	@Override
	public void setSku(String sku) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_sku = sku;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	@JSON
	@Override
	public int getQuantity() {
		return _quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_quantity = quantity;
	}

	@JSON
	@Override
	public int getBookedQuantity() {
		return _bookedQuantity;
	}

	@Override
	public void setBookedQuantity(int bookedQuantity) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_bookedQuantity = bookedQuantity;
	}

	@JSON
	@Override
	public int getReservedQuantity() {
		return _reservedQuantity;
	}

	@Override
	public void setReservedQuantity(int reservedQuantity) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_reservedQuantity = reservedQuantity;
	}

	@JSON
	@Override
	public int getAvailableQuantity() {
		return _availableQuantity;
	}

	@Override
	public void setAvailableQuantity(int availableQuantity) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_availableQuantity = availableQuantity;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public SkuInventory toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, SkuInventory>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SkuInventoryImpl skuInventoryImpl = new SkuInventoryImpl();

		skuInventoryImpl.setSku(getSku());
		skuInventoryImpl.setGroupId(getGroupId());
		skuInventoryImpl.setCompanyId(getCompanyId());
		skuInventoryImpl.setQuantity(getQuantity());
		skuInventoryImpl.setBookedQuantity(getBookedQuantity());
		skuInventoryImpl.setReservedQuantity(getReservedQuantity());
		skuInventoryImpl.setAvailableQuantity(getAvailableQuantity());

		skuInventoryImpl.resetOriginalValues();

		return skuInventoryImpl;
	}

	@Override
	public SkuInventory cloneWithOriginalValues() {
		SkuInventoryImpl skuInventoryImpl = new SkuInventoryImpl();

		skuInventoryImpl.setSku(this.<String>getColumnOriginalValue("sku"));
		skuInventoryImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		skuInventoryImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		skuInventoryImpl.setQuantity(
			this.<Integer>getColumnOriginalValue("quantity"));
		skuInventoryImpl.setBookedQuantity(
			this.<Integer>getColumnOriginalValue("bookedQuantity"));
		skuInventoryImpl.setReservedQuantity(
			this.<Integer>getColumnOriginalValue("reservedQuantity"));
		skuInventoryImpl.setAvailableQuantity(
			this.<Integer>getColumnOriginalValue("availableQuantity"));

		return skuInventoryImpl;
	}

	@Override
	public int compareTo(SkuInventory skuInventory) {
		int value = 0;

		value = getSku().compareTo(skuInventory.getSku());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SkuInventory)) {
			return false;
		}

		SkuInventory skuInventory = (SkuInventory)object;

		String primaryKey = skuInventory.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<SkuInventory> toCacheModel() {
		SkuInventoryCacheModel skuInventoryCacheModel =
			new SkuInventoryCacheModel();

		skuInventoryCacheModel.sku = getSku();

		String sku = skuInventoryCacheModel.sku;

		if ((sku != null) && (sku.length() == 0)) {
			skuInventoryCacheModel.sku = null;
		}

		skuInventoryCacheModel.groupId = getGroupId();

		skuInventoryCacheModel.companyId = getCompanyId();

		skuInventoryCacheModel.quantity = getQuantity();

		skuInventoryCacheModel.bookedQuantity = getBookedQuantity();

		skuInventoryCacheModel.reservedQuantity = getReservedQuantity();

		skuInventoryCacheModel.availableQuantity = getAvailableQuantity();

		return skuInventoryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<SkuInventory, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<SkuInventory, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SkuInventory, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((SkuInventory)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<SkuInventory, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<SkuInventory, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SkuInventory, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((SkuInventory)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, SkuInventory>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _sku;
	private long _groupId;
	private long _companyId;
	private int _quantity;
	private int _bookedQuantity;
	private int _reservedQuantity;
	private int _availableQuantity;

	public <T> T getColumnValue(String columnName) {
		Function<SkuInventory, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((SkuInventory)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("sku", _sku);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("quantity", _quantity);
		_columnOriginalValues.put("bookedQuantity", _bookedQuantity);
		_columnOriginalValues.put("reservedQuantity", _reservedQuantity);
		_columnOriginalValues.put("availableQuantity", _availableQuantity);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("sku", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("quantity", 8L);

		columnBitmasks.put("bookedQuantity", 16L);

		columnBitmasks.put("reservedQuantity", 32L);

		columnBitmasks.put("availableQuantity", 64L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private SkuInventory _escapedModel;

}