package com.liferay.liferaybotics.template.context.contributor;

import com.liferay.liferaybotics.template.context.helper.CommerceServiceExtensionsHelper;
import com.liferay.liferayobtics.service.proxy.CommerceOrderServiceFacade;
import com.liferay.portal.kernel.template.TemplateContextContributor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Peter Richards
 */
@Component(
	immediate = true,
	property = {"type=" + TemplateContextContributor.TYPE_GLOBAL},
	service = TemplateContextContributor.class
)
public class CommerceTemplateContextContributor
	implements TemplateContextContributor {

	@Override
	public void prepare(
		Map<String, Object> contextObjects, HttpServletRequest request) {

		contextObjects.put("commerceServiceExtensionsHelper", _commerceServiceExtensionsHelper);
		contextObjects.put("commerceOrderServiceFacade", _commerceOrderServiceFacade);
	}
	
	@Reference
	protected CommerceServiceExtensionsHelper _commerceServiceExtensionsHelper;
	
	@Reference
	private CommerceOrderServiceFacade _commerceOrderServiceFacade;
}