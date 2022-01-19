package com.liferay.liferayobtics.service.proxy.impl;

import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.service.CommerceOrderLocalService;
import com.liferay.commerce.util.comparator.CommerceOrderIdComparator;
import com.liferay.liferayobtics.service.proxy.CommerceOrderServiceFacade;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Peter Richards
 */
@Component(immediate = true, service = CommerceOrderServiceFacade.class)
public class CommerceOrderServiceFacadeImpl implements CommerceOrderServiceFacade {

	@Override
	public List<CommerceOrder> getCommerceOrdersByCommerceAccountId(long commerceAccountId, int start, int end,
			boolean asc) {
		final CommerceOrderIdComparator orderByComparator = new CommerceOrderIdComparator(asc);
		return commerceOrderLocalService.getCommerceOrdersByCommerceAccountId(commerceAccountId, start, end,
				orderByComparator);
	}

	@Override
	public List<CommerceOrder> getCommerceOrdersByCommerceChannelId(long channelId, int start, int end, boolean asc) {
		final CommerceOrderIdComparator orderByComparator = new CommerceOrderIdComparator(asc);
		return commerceOrderLocalService.getCommerceOrders(channelId, start, end, orderByComparator);
	}

	@Reference
	private CommerceOrderLocalService commerceOrderLocalService;
	
}
