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

import com.liferay.liferaybotics.exception.NoSuchSkuInventoryException;
import com.liferay.liferaybotics.model.SkuInventory;
import com.liferay.liferaybotics.model.impl.SkuInventoryImpl;
import com.liferay.liferaybotics.model.impl.SkuInventoryModelImpl;
import com.liferay.liferaybotics.service.persistence.SkuInventoryPersistence;
import com.liferay.liferaybotics.service.persistence.impl.constants.LiferayboticsPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the sku inventory service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Peter Richards
 * @generated
 */
@Component(service = SkuInventoryPersistence.class)
public class SkuInventoryPersistenceImpl
	extends BasePersistenceImpl<SkuInventory>
	implements SkuInventoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SkuInventoryUtil</code> to access the sku inventory persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SkuInventoryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the sku inventories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching sku inventories
	 */
	@Override
	public List<SkuInventory> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sku inventories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkuInventoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sku inventories
	 * @param end the upper bound of the range of sku inventories (not inclusive)
	 * @return the range of matching sku inventories
	 */
	@Override
	public List<SkuInventory> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sku inventories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkuInventoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sku inventories
	 * @param end the upper bound of the range of sku inventories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sku inventories
	 */
	@Override
	public List<SkuInventory> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SkuInventory> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sku inventories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkuInventoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of sku inventories
	 * @param end the upper bound of the range of sku inventories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sku inventories
	 */
	@Override
	public List<SkuInventory> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SkuInventory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<SkuInventory> list = null;

		if (useFinderCache) {
			list = (List<SkuInventory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SkuInventory skuInventory : list) {
					if (groupId != skuInventory.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SKUINVENTORY_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SkuInventoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<SkuInventory>)QueryUtil.list(
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
	 * Returns the first sku inventory in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sku inventory
	 * @throws NoSuchSkuInventoryException if a matching sku inventory could not be found
	 */
	@Override
	public SkuInventory findByGroupId_First(
			long groupId, OrderByComparator<SkuInventory> orderByComparator)
		throws NoSuchSkuInventoryException {

		SkuInventory skuInventory = fetchByGroupId_First(
			groupId, orderByComparator);

		if (skuInventory != null) {
			return skuInventory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSkuInventoryException(sb.toString());
	}

	/**
	 * Returns the first sku inventory in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sku inventory, or <code>null</code> if a matching sku inventory could not be found
	 */
	@Override
	public SkuInventory fetchByGroupId_First(
		long groupId, OrderByComparator<SkuInventory> orderByComparator) {

		List<SkuInventory> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sku inventory in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sku inventory
	 * @throws NoSuchSkuInventoryException if a matching sku inventory could not be found
	 */
	@Override
	public SkuInventory findByGroupId_Last(
			long groupId, OrderByComparator<SkuInventory> orderByComparator)
		throws NoSuchSkuInventoryException {

		SkuInventory skuInventory = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (skuInventory != null) {
			return skuInventory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSkuInventoryException(sb.toString());
	}

	/**
	 * Returns the last sku inventory in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sku inventory, or <code>null</code> if a matching sku inventory could not be found
	 */
	@Override
	public SkuInventory fetchByGroupId_Last(
		long groupId, OrderByComparator<SkuInventory> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<SkuInventory> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sku inventories before and after the current sku inventory in the ordered set where groupId = &#63;.
	 *
	 * @param sku the primary key of the current sku inventory
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sku inventory
	 * @throws NoSuchSkuInventoryException if a sku inventory with the primary key could not be found
	 */
	@Override
	public SkuInventory[] findByGroupId_PrevAndNext(
			String sku, long groupId,
			OrderByComparator<SkuInventory> orderByComparator)
		throws NoSuchSkuInventoryException {

		SkuInventory skuInventory = findByPrimaryKey(sku);

		Session session = null;

		try {
			session = openSession();

			SkuInventory[] array = new SkuInventoryImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, skuInventory, groupId, orderByComparator, true);

			array[1] = skuInventory;

			array[2] = getByGroupId_PrevAndNext(
				session, skuInventory, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SkuInventory getByGroupId_PrevAndNext(
		Session session, SkuInventory skuInventory, long groupId,
		OrderByComparator<SkuInventory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SKUINVENTORY_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SkuInventoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(skuInventory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SkuInventory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sku inventories where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (SkuInventory skuInventory :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(skuInventory);
		}
	}

	/**
	 * Returns the number of sku inventories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching sku inventories
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SKUINVENTORY_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"skuInventory.groupId = ?";

	public SkuInventoryPersistenceImpl() {
		setModelClass(SkuInventory.class);

		setModelImplClass(SkuInventoryImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the sku inventory in the entity cache if it is enabled.
	 *
	 * @param skuInventory the sku inventory
	 */
	@Override
	public void cacheResult(SkuInventory skuInventory) {
		entityCache.putResult(
			SkuInventoryImpl.class, skuInventory.getPrimaryKey(), skuInventory);
	}

	/**
	 * Caches the sku inventories in the entity cache if it is enabled.
	 *
	 * @param skuInventories the sku inventories
	 */
	@Override
	public void cacheResult(List<SkuInventory> skuInventories) {
		for (SkuInventory skuInventory : skuInventories) {
			if (entityCache.getResult(
					SkuInventoryImpl.class, skuInventory.getPrimaryKey()) ==
						null) {

				cacheResult(skuInventory);
			}
		}
	}

	/**
	 * Clears the cache for all sku inventories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SkuInventoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sku inventory.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SkuInventory skuInventory) {
		entityCache.removeResult(SkuInventoryImpl.class, skuInventory);
	}

	@Override
	public void clearCache(List<SkuInventory> skuInventories) {
		for (SkuInventory skuInventory : skuInventories) {
			entityCache.removeResult(SkuInventoryImpl.class, skuInventory);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SkuInventoryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new sku inventory with the primary key. Does not add the sku inventory to the database.
	 *
	 * @param sku the primary key for the new sku inventory
	 * @return the new sku inventory
	 */
	@Override
	public SkuInventory create(String sku) {
		SkuInventory skuInventory = new SkuInventoryImpl();

		skuInventory.setNew(true);
		skuInventory.setPrimaryKey(sku);

		skuInventory.setCompanyId(CompanyThreadLocal.getCompanyId());

		return skuInventory;
	}

	/**
	 * Removes the sku inventory with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sku the primary key of the sku inventory
	 * @return the sku inventory that was removed
	 * @throws NoSuchSkuInventoryException if a sku inventory with the primary key could not be found
	 */
	@Override
	public SkuInventory remove(String sku) throws NoSuchSkuInventoryException {
		return remove((Serializable)sku);
	}

	/**
	 * Removes the sku inventory with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sku inventory
	 * @return the sku inventory that was removed
	 * @throws NoSuchSkuInventoryException if a sku inventory with the primary key could not be found
	 */
	@Override
	public SkuInventory remove(Serializable primaryKey)
		throws NoSuchSkuInventoryException {

		Session session = null;

		try {
			session = openSession();

			SkuInventory skuInventory = (SkuInventory)session.get(
				SkuInventoryImpl.class, primaryKey);

			if (skuInventory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSkuInventoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(skuInventory);
		}
		catch (NoSuchSkuInventoryException noSuchEntityException) {
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
	protected SkuInventory removeImpl(SkuInventory skuInventory) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(skuInventory)) {
				skuInventory = (SkuInventory)session.get(
					SkuInventoryImpl.class, skuInventory.getPrimaryKeyObj());
			}

			if (skuInventory != null) {
				session.delete(skuInventory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (skuInventory != null) {
			clearCache(skuInventory);
		}

		return skuInventory;
	}

	@Override
	public SkuInventory updateImpl(SkuInventory skuInventory) {
		boolean isNew = skuInventory.isNew();

		if (!(skuInventory instanceof SkuInventoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(skuInventory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					skuInventory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in skuInventory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SkuInventory implementation " +
					skuInventory.getClass());
		}

		SkuInventoryModelImpl skuInventoryModelImpl =
			(SkuInventoryModelImpl)skuInventory;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(skuInventory);
			}
			else {
				skuInventory = (SkuInventory)session.merge(skuInventory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SkuInventoryImpl.class, skuInventoryModelImpl, false, true);

		if (isNew) {
			skuInventory.setNew(false);
		}

		skuInventory.resetOriginalValues();

		return skuInventory;
	}

	/**
	 * Returns the sku inventory with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sku inventory
	 * @return the sku inventory
	 * @throws NoSuchSkuInventoryException if a sku inventory with the primary key could not be found
	 */
	@Override
	public SkuInventory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSkuInventoryException {

		SkuInventory skuInventory = fetchByPrimaryKey(primaryKey);

		if (skuInventory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSkuInventoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return skuInventory;
	}

	/**
	 * Returns the sku inventory with the primary key or throws a <code>NoSuchSkuInventoryException</code> if it could not be found.
	 *
	 * @param sku the primary key of the sku inventory
	 * @return the sku inventory
	 * @throws NoSuchSkuInventoryException if a sku inventory with the primary key could not be found
	 */
	@Override
	public SkuInventory findByPrimaryKey(String sku)
		throws NoSuchSkuInventoryException {

		return findByPrimaryKey((Serializable)sku);
	}

	/**
	 * Returns the sku inventory with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sku the primary key of the sku inventory
	 * @return the sku inventory, or <code>null</code> if a sku inventory with the primary key could not be found
	 */
	@Override
	public SkuInventory fetchByPrimaryKey(String sku) {
		return fetchByPrimaryKey((Serializable)sku);
	}

	/**
	 * Returns all the sku inventories.
	 *
	 * @return the sku inventories
	 */
	@Override
	public List<SkuInventory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sku inventories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkuInventoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sku inventories
	 * @param end the upper bound of the range of sku inventories (not inclusive)
	 * @return the range of sku inventories
	 */
	@Override
	public List<SkuInventory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sku inventories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkuInventoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sku inventories
	 * @param end the upper bound of the range of sku inventories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sku inventories
	 */
	@Override
	public List<SkuInventory> findAll(
		int start, int end, OrderByComparator<SkuInventory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sku inventories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkuInventoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sku inventories
	 * @param end the upper bound of the range of sku inventories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sku inventories
	 */
	@Override
	public List<SkuInventory> findAll(
		int start, int end, OrderByComparator<SkuInventory> orderByComparator,
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

		List<SkuInventory> list = null;

		if (useFinderCache) {
			list = (List<SkuInventory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SKUINVENTORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SKUINVENTORY;

				sql = sql.concat(SkuInventoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SkuInventory>)QueryUtil.list(
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
	 * Removes all the sku inventories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SkuInventory skuInventory : findAll()) {
			remove(skuInventory);
		}
	}

	/**
	 * Returns the number of sku inventories.
	 *
	 * @return the number of sku inventories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SKUINVENTORY);

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
		return _SQL_SELECT_SKUINVENTORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SkuInventoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sku inventory persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new SkuInventoryModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SkuInventory.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(SkuInventoryImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
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

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SKUINVENTORY =
		"SELECT skuInventory FROM SkuInventory skuInventory";

	private static final String _SQL_SELECT_SKUINVENTORY_WHERE =
		"SELECT skuInventory FROM SkuInventory skuInventory WHERE ";

	private static final String _SQL_COUNT_SKUINVENTORY =
		"SELECT COUNT(skuInventory) FROM SkuInventory skuInventory";

	private static final String _SQL_COUNT_SKUINVENTORY_WHERE =
		"SELECT COUNT(skuInventory) FROM SkuInventory skuInventory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "skuInventory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SkuInventory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SkuInventory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SkuInventoryPersistenceImpl.class);

	static {
		try {
			Class.forName(LiferayboticsPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class SkuInventoryModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			SkuInventoryModelImpl skuInventoryModelImpl =
				(SkuInventoryModelImpl)baseModel;

			long columnBitmask = skuInventoryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(skuInventoryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						skuInventoryModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(skuInventoryModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			SkuInventoryModelImpl skuInventoryModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = skuInventoryModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = skuInventoryModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}