<%@ include file="/init.jsp"%>
<div class="commerce-sales-web">

<div class="card card-horizontal">
	<div class="card-body">
		<h1 class="alignleft"><liferay-ui:message key="sku-sales"/></h1>
		<div style="clear: both;"></div>
	</div>
	<div style="clear: both;"></div>
</div>

<div class="card card-horizontal">
	<div class="card-body">
		<h2 class="alignleft">Top 5</h2>
		<div style="clear: both;"></div>
	</div>
	<div style="clear: both;"></div>
</div>

<table class="table table-hover">
    <thead>
    <tr>
      <th scope="col"><liferay-ui:message key="sku"/></th>
      <th scope="col"><liferay-ui:message key="quantitySold"/></th>
    </tr>
  </thead>
<tbody>

<c:forEach var="entry" items="${skuTopSales}">
<tr>
<td><c:out value="${entry.getSku()}" /></td>
<td><fmt:formatNumber value="${entry.getQuantitySold()}" type="number" pattern="###0" /></td>
</tr>
</c:forEach>

</tbody>
</table>

<div class="card card-horizontal">
	<div class="card-body">
		<h2 class="alignleft">Bottom 5</h2>
		<div style="clear: both;"></div>
	</div>
	<div style="clear: both;"></div>
</div>

<table class="table table-hover">
    <thead>
    <tr>
      <th scope="col"><liferay-ui:message key="sku"/></th>
      <th scope="col"><liferay-ui:message key="quantitySold"/></th>
    </tr>
  </thead>
<tbody>

<c:forEach var="entry" items="${skuBottomSales}">
<tr>
<td><c:out value="${entry.getSku()}" /></td>
<td><fmt:formatNumber value="${entry.getQuantitySold()}" type="number" pattern="###0" /></td>
</tr>
</c:forEach>

</tbody>
</table>
</div>