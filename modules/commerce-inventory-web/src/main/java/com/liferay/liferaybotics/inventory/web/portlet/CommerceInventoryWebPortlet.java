package com.liferay.liferaybotics.inventory.web.portlet;

import com.liferay.liferaybotics.inventory.web.constants.CommerceInventoryWebPortletKeys;
import com.liferay.liferaybotics.inventory.web.constants.MVCCommandNames;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author prich
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.customcommerce",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=" + MVCCommandNames.ROOT,
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CommerceInventoryWebPortletKeys.COMMERCEINVENTORYWEB,
		"javax.portlet.version=3.0",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CommerceInventoryWebPortlet extends MVCPortlet {
}