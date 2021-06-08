<%@ include file="/init.jsp"%>
<div class="commerce-inventory-web">

<div class="card card-horizontal">
	<div class="card-body">
		<h1 class="alignleft"><liferay-ui:message key="sku-inventories"/></h1>
		<div style="clear: both;"></div>
	</div>
	<div style="clear: both;"></div>
</div>

<table class="table table-hover">
    <thead>
    <tr>
      <th scope="col"><liferay-ui:message key="sku"/></th>
      <th scope="col"><liferay-ui:message key="quantity"/></th>
      <th scope="col"><liferay-ui:message key="bookedQuantity"/></th>
      <th scope="col"><liferay-ui:message key="reservedQuantity"/></th>
      <th scope="col"><liferay-ui:message key="availableQuantity"/></th>
    </tr>
  </thead>
<tbody>

<c:forEach var="entry" items="${skuInventories}">
<tr>
<td><c:out value="${entry.getSku()}" /></td>
<td><fmt:formatNumber value="${entry.getQuantity()}" type="number" pattern="###0" /></td>
<td><fmt:formatNumber value="${entry.getBookedQuantity()}" type="number" pattern="###0" /></td>
<td><fmt:formatNumber value="${entry.getReservedQuantity()}" type="number" pattern="###0" /></td>
<td><fmt:formatNumber value="${entry.getAvailableQuantity()}" type="number" pattern="###0" /></td>
</tr>
</c:forEach>

</tbody>
</table>
</div>