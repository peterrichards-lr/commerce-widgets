## Commerce Widgets

Contains a collection of Liferay Commerce widgets and their supporting services.

### commerce-inventory-web

Provides a view of the top 5 SKUs with the lowest stock

### commerce-sales-web

Provides a view of the top 5 and bottom 5 selling SKUs

## Page Fragments

### Inventory

This page fragment makes use of the service used by commerce-inventory-web to provide a custom view

### Product Performance

This page fragment makes use of the service used by commerce-sales-web to provide a custom view

### Dashboard Header

This page fragment is simply a standardised dashboard header for other fragements.

### Recent Orders

This page fragment makes use of the service façade to display recent orders in the context of the account in descending order, i.e., most recent first.

### Recent Invoices

This page fragment displays a list of recent invoices.

### Recent Shipments

This page fragment displays a list of recent shipments.

## Utility Classes

### Commerce Service Helper

This helper class is in fact a service façade which simply exposes the methods needed by the Inventory and Product Performance page fragments.

### Commerce Service Façade

Contains a service façade which allows the wrapped methods to be called from Recent Orders page fragment using Freemarker.

This supersedes the original repository, which has now been deprecated.

### Commerce Template Context Contributor

This removes the need for some of the page fragments to use serviceLocator. It does this by exposing the above classes via the template context.

Commerce Service Helper - commerceServiceExtensionsHelper
Commerce Service Façade = commerceOrderServiceFacade

## Troubleshooting

### No Commerce Channel

If the fragments are used in a site which does not have a Commerce channel assigned to it then you will get the following error in either the log files or the fragment preview window if you try to edit it.

```console
Java method "com.liferay.commerce.internal.context.CommerceContextHttpImpl.getCommerceChannelGroupId()" threw an exception when invoked on com.liferay.commerce.internal.context.CommerceContextHttpImpl object "com.liferay.commerce.internal.context.CommerceContextHttpImpl@b01a1c0"; see cause exception in the Java stack trace.
```

Simply configure a Commerce channel for the site you want to use the fragments.

### Null or missing serviceLocator

The following error is seen if the serviceLocator restriction has not been removed for Freemarker templates.

```console
The following has evaluated to null or missing:
==> serviceLocator  [in template "template_id" at line 17, column 9]
```

This is resolved by navigating to Control Panel -> System Settings -> Template Engines -> Freemarker Engine and removing the Restricted Variables entry for the serviceLocator.

