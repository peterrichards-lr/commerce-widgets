package com.liferay.liferayobtics.service.proxy;

import com.liferay.commerce.model.CommerceOrder;

import java.util.List;

/**
 * @author Peter Richards
 */
public interface CommerceOrderServiceFacade {

	public List<CommerceOrder> getCommerceOrdersByCommerceAccountId(long commerceAccountId, int start, int end,
			boolean asc);

	public List<CommerceOrder> getCommerceOrdersByCommerceChannelId(long channelId, int start, int end, boolean asc);
}