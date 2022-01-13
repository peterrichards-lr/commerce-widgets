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
