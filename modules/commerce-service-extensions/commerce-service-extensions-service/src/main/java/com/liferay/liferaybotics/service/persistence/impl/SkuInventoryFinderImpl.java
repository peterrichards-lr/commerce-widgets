package com.liferay.liferaybotics.service.persistence.impl;

import com.liferay.liferaybotics.model.SkuInventory;
import com.liferay.liferaybotics.model.impl.SkuInventoryImpl;
import com.liferay.liferaybotics.service.persistence.SkuInventoryFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = SkuInventoryFinder.class)
public class SkuInventoryFinderImpl extends SkuInventoryFinderBaseImpl implements SkuInventoryFinder {

	@Override
	public List<SkuInventory> findLowestStock(long companyId, long groupId, int start, int end) {
		Session session = null;
	    try {
	        session = openSession();

	        String sql = _customSQL.get(getClass(),
	        		FIND_LOWEST_STOCK);

	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("skuInventory", SkuInventoryImpl.class);

	        QueryPos qPos = QueryPos.getInstance(q);
	        
	        qPos.add(companyId);
	        qPos.add(groupId);
	        
	        return (List<SkuInventory>) QueryUtil.list(q, getDialect(), start, end);
	    }
	    catch (Exception e) {
	        try {
	            throw new SystemException(e);
	        }
	        catch (SystemException se) {
	            se.printStackTrace();
	        }
	    }
	    finally {
	        closeSession(session);
	    }

	    return null;
	}
	
	public static final String FIND_LOWEST_STOCK =
			SkuInventoryFinder.class.getName() +
		        ".findLowestStock";

	@Reference
	private CustomSQL _customSQL;
}
