package com.liferay.liferaybotics.service.persistence.impl;

import com.liferay.liferaybotics.model.SkuSales;
import com.liferay.liferaybotics.model.impl.SkuSalesImpl;
import com.liferay.liferaybotics.service.persistence.SkuSalesFinder;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = SkuSalesFinder.class)
public class SkuSalesFinderImpl extends SkuSalesFinderBaseImpl implements SkuSalesFinder {
	
	@Override
	public List<SkuSales> findProductSales(long companyId, long groupId, int[] orderStatuses,
			boolean lowestSales, int start, int end) {
	Session session = null;
	    try {
	        session = openSession();

	        String sql = _customSQL.get(getClass(),
	        		FIND_PRODUCT_SALES);
	        
	        sql = replaceOrderStatus(sql, orderStatuses);

	        sql = sql.replace("[$ORDER_MODIFIER$]", lowestSales ? "ASC" : "DESC");
	        
	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("skuSales", SkuSalesImpl.class);

	        QueryPos qPos = QueryPos.getInstance(q);
	        
	        qPos.add(companyId);
	        qPos.add(groupId);
	        
	        return (List<SkuSales>) QueryUtil.list(q, getDialect(), start, end);
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
	
	protected String replaceOrderStatus(String sql, int[] orderStatuses) {
		StringBundler sb = new StringBundler(orderStatuses.length);

		for (int i = 0; i < orderStatuses.length; i++) {
			sb.append(orderStatuses[i]);

			if (i != (orderStatuses.length - 1)) {
				sb.append(", ");
			}
		}

		return StringUtil.replace(sql, "[$ORDER_STATUS$]", sb.toString());
	}
	
	public static final String FIND_PRODUCT_SALES =
			SkuSalesFinder.class.getName() +
		        ".findProductSales";

	@Reference
	private CustomSQL _customSQL;
}
