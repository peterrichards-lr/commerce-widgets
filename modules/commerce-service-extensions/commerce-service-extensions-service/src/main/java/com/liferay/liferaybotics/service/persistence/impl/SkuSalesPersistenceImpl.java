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

package com.liferay.liferaybotics.service.persistence.impl;

import com.liferay.liferaybotics.exception.NoSuchSkuSalesException;
import com.liferay.liferaybotics.model.SkuSales;
import com.liferay.liferaybotics.model.SkuSalesTable;
import com.liferay.liferaybotics.model.impl.SkuSalesImpl;
import com.liferay.liferaybotics.model.impl.SkuSalesModelImpl;
import com.liferay.liferaybotics.service.persistence.SkuSalesPersistence;
import com.liferay.liferaybotics.service.persistence.SkuSalesUtil;
import com.liferay.liferaybotics.service.persistence.impl.constants.LiferayboticsPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the sku sales service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Peter Richards
 * @generated
 */
@Component(service = {SkuSalesPersistence.class, BasePersistence.class})
public class SkuSalesPersistenceImpl
	extends BasePersistenceImpl<SkuSales> implements SkuSalesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SkuSalesUtil</code> to access the sku sales persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SkuSalesImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SkuSalesPersistenceImpl() {
		setModelClass(SkuSales.class);

		setModelImplClass(SkuSalesImpl.class);
		setModelPKClass(String.class);

		setTable(SkuSalesTable.INSTANCE);
	}

	/**
	 * Caches the sku sales in the entity cache if it is enabled.
	 *
	 * @param skuSales the sku sales
	 */
	@Override
	public void cacheResult(SkuSales skuSales) {
		entityCache.putResult(
			SkuSalesImpl.class, skuSales.getPrimaryKey(), skuSales);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the sku saleses in the entity cache if it is enabled.
	 *
	 * @param skuSaleses the sku saleses
	 */
	@Override
	public void cacheResult(List<SkuSales> skuSaleses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (skuSaleses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SkuSales skuSales : skuSaleses) {
			if (entityCache.getResult(
					SkuSalesImpl.class, skuSales.getPrimaryKey()) == null) {

				cacheResult(skuSales);
			}
		}
	}

	/**
	 * Clears the cache for all sku saleses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SkuSalesImpl.class);

		finderCache.clearCache(SkuSalesImpl.class);
	}

	/**
	 * Clears the cache for the sku sales.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SkuSales skuSales) {
		entityCache.removeResult(SkuSalesImpl.class, skuSales);
	}

	@Override
	public void clearCache(List<SkuSales> skuSaleses) {
		for (SkuSales skuSales : skuSaleses) {
			entityCache.removeResult(SkuSalesImpl.class, skuSales);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SkuSalesImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SkuSalesImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new sku sales with the primary key. Does not add the sku sales to the database.
	 *
	 * @param sku the primary key for the new sku sales
	 * @return the new sku sales
	 */
	@Override
	public SkuSales create(String sku) {
		SkuSales skuSales = new SkuSalesImpl();

		skuSales.setNew(true);
		skuSales.setPrimaryKey(sku);

		skuSales.setCompanyId(CompanyThreadLocal.getCompanyId());

		return skuSales;
	}

	/**
	 * Removes the sku sales with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sku the primary key of the sku sales
	 * @return the sku sales that was removed
	 * @throws NoSuchSkuSalesException if a sku sales with the primary key could not be found
	 */
	@Override
	public SkuSales remove(String sku) throws NoSuchSkuSalesException {
		return remove((Serializable)sku);
	}

	/**
	 * Removes the sku sales with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sku sales
	 * @return the sku sales that was removed
	 * @throws NoSuchSkuSalesException if a sku sales with the primary key could not be found
	 */
	@Override
	public SkuSales remove(Serializable primaryKey)
		throws NoSuchSkuSalesException {

		Session session = null;

		try {
			session = openSession();

			SkuSales skuSales = (SkuSales)session.get(
				SkuSalesImpl.class, primaryKey);

			if (skuSales == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSkuSalesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(skuSales);
		}
		catch (NoSuchSkuSalesException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SkuSales removeImpl(SkuSales skuSales) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(skuSales)) {
				skuSales = (SkuSales)session.get(
					SkuSalesImpl.class, skuSales.getPrimaryKeyObj());
			}

			if (skuSales != null) {
				session.delete(skuSales);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (skuSales != null) {
			clearCache(skuSales);
		}

		return skuSales;
	}

	@Override
	public SkuSales updateImpl(SkuSales skuSales) {
		boolean isNew = skuSales.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(skuSales);
			}
			else {
				skuSales = (SkuSales)session.merge(skuSales);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(SkuSalesImpl.class, skuSales, false, true);

		if (isNew) {
			skuSales.setNew(false);
		}

		skuSales.resetOriginalValues();

		return skuSales;
	}

	/**
	 * Returns the sku sales with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sku sales
	 * @return the sku sales
	 * @throws NoSuchSkuSalesException if a sku sales with the primary key could not be found
	 */
	@Override
	public SkuSales findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSkuSalesException {

		SkuSales skuSales = fetchByPrimaryKey(primaryKey);

		if (skuSales == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSkuSalesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return skuSales;
	}

	/**
	 * Returns the sku sales with the primary key or throws a <code>NoSuchSkuSalesException</code> if it could not be found.
	 *
	 * @param sku the primary key of the sku sales
	 * @return the sku sales
	 * @throws NoSuchSkuSalesException if a sku sales with the primary key could not be found
	 */
	@Override
	public SkuSales findByPrimaryKey(String sku)
		throws NoSuchSkuSalesException {

		return findByPrimaryKey((Serializable)sku);
	}

	/**
	 * Returns the sku sales with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sku the primary key of the sku sales
	 * @return the sku sales, or <code>null</code> if a sku sales with the primary key could not be found
	 */
	@Override
	public SkuSales fetchByPrimaryKey(String sku) {
		return fetchByPrimaryKey((Serializable)sku);
	}

	/**
	 * Returns all the sku saleses.
	 *
	 * @return the sku saleses
	 */
	@Override
	public List<SkuSales> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sku saleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkuSalesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sku saleses
	 * @param end the upper bound of the range of sku saleses (not inclusive)
	 * @return the range of sku saleses
	 */
	@Override
	public List<SkuSales> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sku saleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkuSalesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sku saleses
	 * @param end the upper bound of the range of sku saleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sku saleses
	 */
	@Override
	public List<SkuSales> findAll(
		int start, int end, OrderByComparator<SkuSales> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sku saleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkuSalesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sku saleses
	 * @param end the upper bound of the range of sku saleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sku saleses
	 */
	@Override
	public List<SkuSales> findAll(
		int start, int end, OrderByComparator<SkuSales> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<SkuSales> list = null;

		if (useFinderCache) {
			list = (List<SkuSales>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SKUSALES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SKUSALES;

				sql = sql.concat(SkuSalesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SkuSales>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sku saleses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SkuSales skuSales : findAll()) {
			remove(skuSales);
		}
	}

	/**
	 * Returns the number of sku saleses.
	 *
	 * @return the number of sku saleses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SKUSALES);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "sku";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SKUSALES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SkuSalesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sku sales persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_setSkuSalesUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSkuSalesUtilPersistence(null);

		entityCache.removeCache(SkuSalesImpl.class.getName());
	}

	private void _setSkuSalesUtilPersistence(
		SkuSalesPersistence skuSalesPersistence) {

		try {
			Field field = SkuSalesUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, skuSalesPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = LiferayboticsPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = LiferayboticsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = LiferayboticsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SKUSALES =
		"SELECT skuSales FROM SkuSales skuSales";

	private static final String _SQL_COUNT_SKUSALES =
		"SELECT COUNT(skuSales) FROM SkuSales skuSales";

	private static final String _ORDER_BY_ENTITY_ALIAS = "skuSales.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SkuSales exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SkuSalesPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private SkuSalesModelArgumentsResolver _skuSalesModelArgumentsResolver;

}