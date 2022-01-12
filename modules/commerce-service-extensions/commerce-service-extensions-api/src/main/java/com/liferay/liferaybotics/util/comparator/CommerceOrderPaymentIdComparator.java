package com.liferay.liferaybotics.util.comparator;

import com.liferay.commerce.model.CommerceOrderPayment;
import com.liferay.portal.kernel.util.OrderByComparator;

public class CommerceOrderPaymentIdComparator extends OrderByComparator<CommerceOrderPayment> {

	private static final long serialVersionUID = 1L;

	public static final String ORDER_BY_ASC =
			"CommerceOrderPayment.commerceOrderPaymentId ASC";

		public static final String ORDER_BY_DESC =
			"CommerceOrderPayment.commerceOrderPaymentId DESC";

		public static final String[] ORDER_BY_FIELDS = {"commerceOrderPaymentId"};

		public CommerceOrderPaymentIdComparator() {
			this(false);
		}

		public CommerceOrderPaymentIdComparator(boolean ascending) {
			_ascending = ascending;
		}

		@Override
		public int compare(
				CommerceOrderPayment commerceOrderPayment1, CommerceOrderPayment commerceOrderPayment2) {

			int value = Long.compare(
					commerceOrderPayment1.getCommerceOrderPaymentId(),
					commerceOrderPayment2.getCommerceOrderPaymentId());

			if (_ascending) {
				return value;
			}

			return Math.negateExact(value);
		}

		@Override
		public String getOrderBy() {
			if (_ascending) {
				return ORDER_BY_ASC;
			}

			return ORDER_BY_DESC;
		}

		@Override
		public String[] getOrderByFields() {
			return ORDER_BY_FIELDS;
		}

		@Override
		public boolean isAscending() {
			return _ascending;
		}

		private final boolean _ascending;
}
